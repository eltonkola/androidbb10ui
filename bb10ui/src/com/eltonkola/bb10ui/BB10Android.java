package com.eltonkola.bb10ui;

import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import com.eltonkola.bb10ui.R;
import com.eltonkola.bb10ui.menu.MenuItem;
import com.eltonkola.bb10ui.slide.BB10SlideMenuItem;
import com.eltonkola.bb10ui.slide.RightSlideView;
import com.eltonkola.bb10ui.slide.SlideMenuEvents.OnSlideMenuItemClickListener;
import com.eltonkola.bb10ui.utils.Utils;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class BB10Android {

	protected Activity mActivity=null;
	private com.eltonkola.bb10ui.slide.LeftSlideView leftSlide;
	public com.eltonkola.bb10ui.menu.Menu mMenu;
    public RightSlideView rightSlide;
    

	private RelativeLayout actionbar_left;
	private ImageView actionbar_left_icon;
	private ImageView icon_new;
	private ImageView actionbar_but1;
	private ImageView actionbar_but2;
	private ImageView actionbar_but3;
	private ImageView actionbar_but4;
	private ImageView actionbar_right;
    private LinearLayout menu_container;
	
    private BB10SuperHelper superHelper;
	
	public BB10Android(Activity activity) {
		mActivity = activity;
		superHelper= (BB10SuperHelper)mActivity;
	}

	
	public void onCreate(Bundle savedInstanceState) {
		superHelper.super_onCreate(savedInstanceState);
		mActivity.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	
	public void setContentView(int layoutResID) {
		superHelper.super_setContentView(R.layout.bb10activity);
		FrameLayout content = (FrameLayout)mActivity.findViewById(R.id.content);
		View mainView = LayoutInflater.from(mActivity.getBaseContext()).inflate(layoutResID, null);
		FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
		content.addView(mainView, 0, params);
		FrameLayout superRoot = (FrameLayout)mActivity.findViewById(R.id.superRoot);
		superRoot.setBackgroundDrawable(mainView.getBackground());
		init();
	}

	public void setContentView(View view, LayoutParams params) {
		superHelper.super_setContentView(view, params);
		FrameLayout content = (FrameLayout)mActivity.findViewById(R.id.content);
		content.addView(view, 0, params);
		FrameLayout superRoot = (FrameLayout)mActivity.findViewById(R.id.superRoot);
		superRoot.setBackgroundDrawable(view.getBackground());
		init();
	}
	
	private void init(){

		menu_container = (LinearLayout)mActivity.findViewById(R.id.menu_container);
		
		actionbar_left = (RelativeLayout)mActivity.findViewById(R.id.actionbar_left);
		
		actionbar_left_icon = (ImageView)mActivity.findViewById(R.id.actionbar_left_icon);
		icon_new = (ImageView)mActivity.findViewById(R.id.icon_new);
		
		
		
        actionbar_but1 = (ImageView)mActivity.findViewById(R.id.actionbar_but1);
        actionbar_but2 = (ImageView)mActivity.findViewById(R.id.actionbar_but2);
        actionbar_but3 = (ImageView)mActivity.findViewById(R.id.actionbar_but3);
        actionbar_but4 = (ImageView)mActivity.findViewById(R.id.actionbar_but4);
	    actionbar_right = (ImageView)mActivity.findViewById(R.id.actionbar_right);
	    
	    rightSlide = (RightSlideView)mActivity.findViewById(R.id.rightSlide);
	    leftSlide = (com.eltonkola.bb10ui.slide.LeftSlideView)mActivity.findViewById(R.id.leftSlide);
	    
	    actionbar_but1.setVisibility(View.GONE);
	    actionbar_but2.setVisibility(View.GONE);
	    actionbar_but3.setVisibility(View.GONE);
	    actionbar_but4.setVisibility(View.GONE);
	    actionbar_right.setVisibility(View.GONE);
	    
	    
	    actionbar_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mActivity.finish();
			}
	    });
	    
	    actionbar_but1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				superHelper.onBarButton1Click();
				
				if(b1isTab){
					activeTab = 1;
					setTabBg();
				}
			}
		});
	    
	    actionbar_but2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				superHelper.onBarButton2Click();
				
				if(b2isTab){
					activeTab = 2;
					setTabBg();
				}
			}
		});
	    
	    actionbar_but3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				superHelper.onBarButton3Click();
				
				if(b3isTab){
					activeTab = 3;
					setTabBg();
				}
			}
		});
	    
	    actionbar_but4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				superHelper.onBarButton4Click();
				
				if(b4isTab){
					activeTab = 4;
					setTabBg();
				}
			}
		});
	}

    public void onBackPressed() {
        if (rightSlide.isShown()) {
        	rightSlide.hideMenu();
        } else {
        	superHelper.super_onBackPressed();
        }
    }
	    
    /*
    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////request left tabs/////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    */
    
    public void setLeftSlideTabs(ArrayList<BB10SlideMenuItem> tabList, boolean showNewIcon, int selectedTab, int icon){
    	leftSlide.init(mActivity, tabList, selectedTab, new OnSlideMenuItemClickListener() {
			@Override
			public void onSlideMenuItemClick(int itemId) {
				superHelper.onSlideTabClickListener(itemId);
			}
		});
    	actionbar_left.setVisibility(View.VISIBLE);
    	actionbar_left.setBackgroundResource(R.drawable.bar_bottom_left);
    	actionbar_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				leftSlide.show();
			}
		});
    	
    	actionbar_left_icon.setImageResource(icon);
    	if(showNewIcon){
    		icon_new.setVisibility(View.VISIBLE);
    	}else{
    		icon_new.setVisibility(View.GONE);
    	}
    	actionbar_left.setVisibility(View.VISIBLE);
    	
    }
    
    public void setLeftSlideTabs(int tabList, boolean showNewIcon, int selectedTab, int icon){
    	leftSlide.init(mActivity, tabList, selectedTab, new OnSlideMenuItemClickListener() {
			@Override
			public void onSlideMenuItemClick(int itemId) {
				superHelper.onSlideTabClickListener(itemId);
			}
		});
    	actionbar_left.setBackgroundResource(R.drawable.bar_bottom_left);
    	actionbar_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				leftSlide.show();
			}
		});
    	actionbar_left_icon.setImageResource(icon);
    	
    	actionbar_left_icon.setImageResource(icon);
    	if(showNewIcon){
    		icon_new.setVisibility(View.VISIBLE);
    	}else{
    		icon_new.setVisibility(View.GONE);
    	}

    }
    
    public void setRightMenu(ArrayList<BB10SlideMenuItem> menuList){
    	
    	rightSlide.setMenuItems(menuList);
	    rightSlide.setMenuClickCallback(new OnSlideMenuItemClickListener() {
        	@Override
			public void onSlideMenuItemClick(int itemId) {
        		superHelper.onSlideMenuClickListener(itemId);
			}
        });
	    actionbar_right.setVisibility(View.VISIBLE);
	    actionbar_right.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			rightSlide.showMenu();
			}
		});
	    
    }
    
    public void setRightMenu(int menuList){
    	rightSlide.setMenuItems(menuList);
	    rightSlide.setMenuClickCallback(new OnSlideMenuItemClickListener() {
        	@Override
			public void onSlideMenuItemClick(int itemId) {
        		superHelper.onSlideMenuClickListener(itemId);
			}
        });
	    actionbar_right.setVisibility(View.VISIBLE);
	    actionbar_right.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			rightSlide.showMenu();
			}
		});
    }
    
    
    public void hideNav1(){
    	actionbar_but1.setVisibility(View.GONE);
    }
    
    public void hideNav2(){
    	actionbar_but2.setVisibility(View.GONE);
    }

	public void hideNav3(){
		actionbar_but3.setVisibility(View.GONE);
	}
	
	public void hideNav4(){
		actionbar_but4.setVisibility(View.GONE);
	}
	
	public void showBackButton(){
		actionbar_left.setBackgroundResource(R.drawable.bar_bottom_back);
    	actionbar_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mActivity.finish();
			}
		});
    	actionbar_left_icon.setImageResource(R.drawable.icon_blank);
    	icon_new.setVisibility(View.GONE);
    	actionbar_left.setVisibility(View.VISIBLE);
	}
	
	public void hideLeftButton(){
		actionbar_left.setVisibility(View.GONE);
	}
	
    
	private boolean b1isTab = false;
	private boolean b2isTab = false;
	private boolean b3isTab = false;
	private boolean b4isTab = false;
	
	private int activeTab=1;
	
	public void showNav1AsButton(int icon){
		b1isTab = false;
		actionbar_but1.setImageResource(icon);
		actionbar_but1.setBackgroundResource(R.drawable.bar_bottom_simple);
		actionbar_but1.setVisibility(View.VISIBLE);
	}
	
	public void showNav2AsButton(int icon){
		b2isTab = false;
		actionbar_but2.setImageResource(icon);
		actionbar_but2.setBackgroundResource(R.drawable.bar_bottom_simple);
		actionbar_but2.setVisibility(View.VISIBLE);
	}

	public void showNav3AsButton(int icon){
		b3isTab = false;
		actionbar_but3.setImageResource(icon);
		actionbar_but3.setBackgroundResource(R.drawable.bar_bottom_simple);
		actionbar_but3.setVisibility(View.VISIBLE);
	}
	
	public void showNav4AsButton(int icon){
		b4isTab = false;
		actionbar_but4.setImageResource(icon);
		actionbar_but4.setBackgroundResource(R.drawable.bar_bottom_simple);
		actionbar_but4.setVisibility(View.VISIBLE);
	}
    
	

	public void showNav1AsTab(int icon, boolean active){
		b1isTab = true;
		if(active)activeTab=1;
		actionbar_but1.setImageResource(icon);
		actionbar_but1.setVisibility(View.VISIBLE);
		setTabBg();
	}
	
	public void showNav2AsTab(int icon, boolean active){
		b2isTab = true;
		if(active)activeTab=2;
		actionbar_but2.setImageResource(icon);
		actionbar_but2.setVisibility(View.VISIBLE);
		setTabBg();
	}

	public void showNav3AsTab(int icon, boolean active){
		b3isTab = true;
		if(active)activeTab=3;
		actionbar_but3.setImageResource(icon);
		actionbar_but3.setVisibility(View.VISIBLE);
		setTabBg();
	}
	
	public void showNav4AsTab(int icon, boolean active){
		b4isTab = true;
		if(active)activeTab=4;
		actionbar_but4.setImageResource(icon);
		actionbar_but4.setVisibility(View.VISIBLE);
		setTabBg();
	}
	
	private void setTabBg(){
		Utils.log("call setTabBg: activeTab =" + activeTab);
		Utils.log("b1isTab = " + b1isTab);
		Utils.log("b2isTab = " + b2isTab);
		Utils.log("b3isTab = " + b3isTab);
		Utils.log("b4isTab = " + b4isTab);

		switch (activeTab) {
		case 1:
			if(b1isTab)actionbar_but1.setBackgroundResource(R.drawable.bar_bottom_tab_active);
			if(b2isTab)actionbar_but2.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b3isTab)actionbar_but3.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b4isTab)actionbar_but4.setBackgroundResource(R.drawable.bar_bottom_tab);
			break;
		case 2:
			if(b1isTab)actionbar_but1.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b2isTab)actionbar_but2.setBackgroundResource(R.drawable.bar_bottom_tab_active);
			if(b3isTab)actionbar_but3.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b4isTab)actionbar_but4.setBackgroundResource(R.drawable.bar_bottom_tab);
			break;
		case 3:
			if(b1isTab)actionbar_but1.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b2isTab)actionbar_but2.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b3isTab)actionbar_but3.setBackgroundResource(R.drawable.bar_bottom_tab_active);
			if(b4isTab)actionbar_but4.setBackgroundResource(R.drawable.bar_bottom_tab);
			break;
		case 4:
			if(b1isTab)actionbar_but1.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b2isTab)actionbar_but2.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b3isTab)actionbar_but3.setBackgroundResource(R.drawable.bar_bottom_tab);
			if(b4isTab)actionbar_but4.setBackgroundResource(R.drawable.bar_bottom_tab_active);
			break;
		default:
			break;
		}
		
	}
	
	public void hideRightMenu(){
		actionbar_right.setVisibility(View.GONE);
	}
	
    
	/*
	////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////// top menu //////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	*/
    
    
	public boolean onKeyDown(int keyCode, KeyEvent event) { 
	    if (keyCode == KeyEvent.KEYCODE_MENU) {
	    	if( mMenu!=null){
	    		if (mMenu.isShowing()) {
	    			mMenu.hide();
	    		} else {
	    			mMenu.show(menu_container);
	    		}
		    	return true;
	    	}else{
	    		Utils.log("menu is null!");
	    		return superHelper.super_onKeyDown(keyCode, event);
	    	}
	    }
		return superHelper.super_onKeyDown(keyCode, event); 
	}
		
	public MenuInflater getMenuInflater() {
    	Utils.log("calld my getMenuInflater");
    	BBMenuInflater res =new BBMenuInflater();
    	return  res;
	}
	    
	class BBMenuInflater  extends MenuInflater{

		public BBMenuInflater() {
			super(mActivity);
			Utils.log("create custom BBMenuInflater");
		}

		private String resourceIdToString(String resId) {
            if (!resId.contains("@")) {
                return resId;
            } else {
                String id = resId.replace("@", "");
                return mActivity.getResources().getString(Integer.valueOf(id));
            }
		}
				  
		@Override
		public void inflate(int menuRes, Menu menu) {
			Utils.log("i have to inflate menu:" + menuRes );
		
			com.eltonkola.bb10ui.menu.Menu.OnMenuItemSelectedListener listener = new com.eltonkola.bb10ui.menu.Menu.OnMenuItemSelectedListener() {
				@Override
				public void MenuItemSelectedEvent(MenuItem selection) {
					mActivity.onOptionsItemSelected(selection);
				}
			};
					
			mMenu = new com.eltonkola.bb10ui.menu.Menu(mActivity, listener , mActivity.getLayoutInflater());
	        mMenu.setHideOnSelect(true);
	        mMenu.setItemsPerLineInPortraitOrientation(4);
	        mMenu.setItemsPerLineInLandscapeOrientation(8);
		        
	        Utils.log("menu created");
					
	        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	        try {
	            XmlResourceParser xrp = mActivity.getResources().getXml(menuRes);
	            xrp.next();
	            int eventType = xrp.getEventType();
	            while (eventType != XmlPullParser.END_DOCUMENT) {
	                if (eventType == XmlPullParser.START_TAG) {
	                    String elemName = xrp.getName();
	                    if (elemName.equals("item")) {
	                        String textId = xrp.getAttributeValue("http://schemas.android.com/apk/res/android","title");
	                        String iconId = xrp.getAttributeValue("http://schemas.android.com/apk/res/android","icon");
	                        String resId = xrp.getAttributeValue("http://schemas.android.com/apk/res/android","id");
	                        MenuItem item = new MenuItem();
	                        item.setId(Integer.valueOf(resId.replace("@", "")));
	                        item.setCaption(resourceIdToString(textId));
	                        if (iconId != null) {
	                            try {
	                                item.setImageResourceId(Integer.valueOf(iconId.replace("@", "")));
	                            } catch (NumberFormatException e) {
	                                Utils.log("Item " + item.getId() + " not have icon");
	                            }
	                        }
	                        menuItems.add(item);
	                    }
	                }
	                eventType = xrp.next();
	            }
	        } catch (Exception e) {
	            Utils.log(""+ e);
	        }
			        
	        Utils.log("menu items:" + menuItems.size() );       
	        try {
	 			mMenu.setMenuItems(menuItems);
	 		} catch (Exception e) {
	 			Toast.makeText(mActivity, "Error loading the main menu!", Toast.LENGTH_SHORT).show();
	 		}			
	      mMenu.show(menu_container);
		}
	}	    
}
