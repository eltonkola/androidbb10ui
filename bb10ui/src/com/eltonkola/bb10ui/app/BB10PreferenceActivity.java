package com.eltonkola.bb10ui.app;

import com.eltonkola.bb10ui.BB10Android;
import com.eltonkola.bb10ui.BB10SuperHelper;
import com.eltonkola.bb10ui.menu.MenuItem;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class BB10PreferenceActivity extends PreferenceActivity implements BB10SuperHelper{

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
    
    
    
    //super callbacks here
    
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
	
       
}
