package com.eltonkola.bb10ui.app;

import com.eltonkola.bb10ui.BB10Android;
import com.eltonkola.bb10ui.BB10SuperHelper;
import com.eltonkola.bb10ui.R;
import com.eltonkola.bb10ui.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class BB10ListActivity extends Activity implements BB10SuperHelper{

	 private BB10Android mBB10;
	  
	 protected final BB10Android getBB10() {
		 if (mBB10 == null) {
			 mBB10 = new BB10Android(this);
		 }
		 return mBB10;
	 }

	//delegate everything to a single class
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getBB10().onCreate(savedInstanceState);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		getBB10().setContentView(layoutResID);
		
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		getBB10().setContentView(view, params);
	}
	
    @Override
    public void onBackPressed() {
    	getBB10().onBackPressed();
    }
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) { 
    	return getBB10().onKeyDown(keyCode,event);
	}
		
    @Override
	public MenuInflater getMenuInflater() {
    	return  getBB10().getMenuInflater();
	}
    
	public void super_onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
    }
    
    public void super_setContentView(int layoutResID){
    	super.setContentView(layoutResID);
    }
    
    public void super_setContentView(View view, LayoutParams params){
		super.setContentView(view, params);
	}
    
    public void super_onBackPressed(){
		super.onBackPressed();    	
    }

    public boolean super_onKeyDown(int keyCode, KeyEvent event){
    	return super.onKeyDown(keyCode, event);
    }

    

    ////////////////////// callbacks to user activity /////////////////
	@Override
	public void onSlideTabClickListener(int itemId) {
	}

	@Override
	public void onSlideMenuClickListener(int itemId) {
	}

	@Override
	public void onBarButton1Click() {
	}

	@Override
	public void onBarButton2Click() {
	}

	@Override
	public void onBarButton3Click() {
	}

	@Override
	public void onBarButton4Click() {
	}
	
    // real listactivity stuff
	
	    /**
	     * This field should be made private, so it is hidden from the SDK.
	     * {@hide}
	     */
	    protected ListAdapter mAdapter;
	    /**
	     * This field should be made private, so it is hidden from the SDK.
	     * {@hide}
	     */
	    protected ListView mList;

	    private Handler mHandler = new Handler();
	    private boolean mFinishedStart = false;

	    private Runnable mRequestFocus = new Runnable() {
	        public void run() {
	            mList.focusableViewAvailable(mList);
	        }
	    };

	    /**
	     * This method will be called when an item in the list is selected.
	     * Subclasses should override. Subclasses can call
	     * getListView().getItemAtPosition(position) if they need to access the
	     * data associated with the selected item.
	     *
	     * @param l The ListView where the click happened
	     * @param v The view that was clicked within the ListView
	     * @param position The position of the view in the list
	     * @param id The row id of the item that was clicked
	     */
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	    }

	    /**
	     * Ensures the list view has been created before Activity restores all
	     * of the view states.
	     *
	     *@see Activity#onRestoreInstanceState(Bundle)
	     */
	    @Override
	    protected void onRestoreInstanceState(Bundle state) {
	    	Utils.log("onRestoreInstanceState");
	        ensureList();
	        super.onRestoreInstanceState(state);
	    }

	    /**
	     * @see Activity#onDestroy()
	     */
	    @Override
	    protected void onDestroy() {
	    	Utils.log("onDestroy");
	        mHandler.removeCallbacks(mRequestFocus);
	        super.onDestroy();
	    }

	    /**
	     * Updates the screen state (current list and other views) when the
	     * content changes.
	     *
	     * @see Activity#onContentChanged()
	     */
	    @Override
	    public void onContentChanged() {
	        super.onContentChanged();
	        Utils.log("onContentChanged");
	        //View emptyView = findViewById(com.android.internal.R.id.empty);
	        
	        
	        
	        mList = (ListView)findViewById(R.id.list_act); //android.R.id.list
	        if (mList == null) {
	            throw new RuntimeException(
	                    "fuck, Your content must have a ListView whose id attribute is " +
	                    "'android.R.id.list'");
	        }
//	        if (emptyView != null) {
//	            mList.setEmptyView(emptyView);
//	        }
	        mList.setOnItemClickListener(mOnClickListener);
	        if (mFinishedStart) {
	            setListAdapter(mAdapter);
	        }
	        mHandler.post(mRequestFocus);
	        mFinishedStart = true;
	    }

	    /**
	     * Provide the cursor for the list view.
	     */
	    public void setListAdapter(ListAdapter adapter) {
	        synchronized (this) {
	            ensureList();
	            mAdapter = adapter;
	            mList.setAdapter(adapter);
	        }
	    }

	    /**
	     * Set the currently selected list item to the specified
	     * position with the adapter's data
	     *
	     * @param position
	     */
	    public void setSelection(int position) {
	        mList.setSelection(position);
	    }

	    /**
	     * Get the position of the currently selected list item.
	     */
	    public int getSelectedItemPosition() {
	        return mList.getSelectedItemPosition();
	    }

	    /**
	     * Get the cursor row ID of the currently selected list item.
	     */
	    public long getSelectedItemId() {
	        return mList.getSelectedItemId();
	    }

	    /**
	     * Get the activity's list view widget.
	     */
	    public ListView getListView() {
	        ensureList();
	        return mList;
	    }

	    /**
	     * Get the ListAdapter associated with this activity's ListView.
	     */
	    public ListAdapter getListAdapter() {
	        return mAdapter;
	    }

	    private void ensureList() {
	    	Utils.log("ensureList");
	        if (mList != null) {
	            return;
	        }
	        setContentView(R.layout.listactivity);

	    }

	    private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id)
	        {
	            onListItemClick((ListView)parent, v, position, id);
	        }
	    };
	
	
}
