package com.eltonkola.bb10ui.app;

import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import com.eltonkola.bb10ui.R;
import com.eltonkola.bb10ui.menu.MenuItem;
import com.eltonkola.bb10ui.slide.RightSlideView;
import com.eltonkola.bb10ui.slide.SlideMenuEvents.OnSlideMenuItemClickListener;
import com.eltonkola.bb10ui.utils.Utils;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.Gravity;
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
import android.widget.Toast;

public class BB10Activity extends Activity{

	public RightSlideView sideNavigationView;
	
	
	private ImageView actionbar_left;
	
	private ImageView actionbar_but1;
	private ImageView actionbar_but2;
	private ImageView actionbar_but3;
	private ImageView actionbar_but4;

	
	private ImageView actionbar_right;
	
	
	private com.eltonkola.bb10ui.slide.LeftSlideView slidemenu;
	
	
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return super.onCreateDialog(id, args);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	

//	@Override
//	public void setContentView(View view) {
//		super.setContentView(view);
//		
//		FrameLayout content = (FrameLayout)findViewById(R.id.content);
//		View mainView = LayoutInflater.from(getBaseContext()).inflate(layoutResID, null);
//		FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//		content.addView(mainView, 0, params);
//		
//		
//		init();
//	}

	@Override
	public void setContentView(int layoutResID) {
//		super.setContentView(layoutResID);
		super.setContentView(R.layout.bb10activity);
		
		FrameLayout content = (FrameLayout)findViewById(R.id.content);
		View mainView = LayoutInflater.from(getBaseContext()).inflate(layoutResID, null);
		FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
		content.addView(mainView, 0, params);
		
		//set main root bg color
		FrameLayout superRoot = (FrameLayout)findViewById(R.id.superRoot);
		superRoot.setBackgroundDrawable(mainView.getBackground());
		
		
		
		init();
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		super.setContentView(view, params);
		
		FrameLayout content = (FrameLayout)findViewById(R.id.content);
		content.addView(view, 0, params);
		
		
		FrameLayout superRoot = (FrameLayout)findViewById(R.id.superRoot);
		superRoot.setBackgroundDrawable(view.getBackground());
		
		init();
	}
	
	private void init(){

		sideNavigationView = (RightSlideView)findViewById(R.id.side_navigation_view);
        sideNavigationView.setMenuItems(R.menu.side_navigation_menu);
        
	        sideNavigationView.setMenuClickCallback(new OnSlideMenuItemClickListener() {
			
				@Override
				public void onSlideMenuItemClick(int itemId) {
					// TODO Auto-generated method stub
					
				}
			});
	        
        
        
           actionbar_left = (ImageView)findViewById(R.id.actionbar_left);

	       actionbar_but1 = (ImageView)findViewById(R.id.actionbar_but1);
	       actionbar_but2 = (ImageView)findViewById(R.id.actionbar_but2);
	       actionbar_but3 = (ImageView)findViewById(R.id.actionbar_but3);
	       actionbar_but4 = (ImageView)findViewById(R.id.actionbar_but4);
	       
	       actionbar_right = (ImageView)findViewById(R.id.actionbar_right);
	       
	       
	       menu_container = (LinearLayout)findViewById(R.id.menu_container);

	       
	       
	       actionbar_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				slidemenu.show();
			}
	       });
    
	       actionbar_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sideNavigationView.showMenu();
				
			}
		});
        
        
        
        slidemenu = (com.eltonkola.bb10ui.slide.LeftSlideView) findViewById(R.id.slideMenu);
		slidemenu.init(this, R.menu.side_navigation_menu, new OnSlideMenuItemClickListener() {
			
			@Override
			public void onSlideMenuItemClick(int itemId) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}


	
	    @Override
	    public void onBackPressed() {
	        if (sideNavigationView.isShown()) {
	            sideNavigationView.hideMenu();
	        } else {
	            super.onBackPressed();
	        }
	    }
	    
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
		    		return super.onKeyDown(keyCode, event);
		    	}
		    }
			return super.onKeyDown(keyCode, event); 
		}
		
	    @Override
		public MenuInflater getMenuInflater() {
	    	Utils.log("calld my getMenuInflater");
	    	BBMenuInflater res =new BBMenuInflater();
	    	
	    	//mMenu = res.getmMenu();
	    	
	    	return  res;
		}
	    
	    
	    public com.eltonkola.bb10ui.menu.Menu mMenu;
	    
		private LinearLayout menu_container;
	    
	    
	    
	    
		 class BBMenuInflater  extends MenuInflater{

				
				public BBMenuInflater() {
					super(BB10Activity.this);
					Utils.log("create custom BBMenuInflater");
				}

				private String resourceIdToString(String resId) {
			            if (!resId.contains("@")) {
			                return resId;
			            } else {
			                String id = resId.replace("@", "");
			                return getResources().getString(Integer.valueOf(id));
			            }
			      }
				  
				@Override
				public void inflate(int menuRes, Menu menu) {
					// inflate the menu here..
					
					Utils.log("i have to inflate menu:" + menuRes );
					
					com.eltonkola.bb10ui.menu.Menu.OnMenuItemSelectedListener listener = new com.eltonkola.bb10ui.menu.Menu.OnMenuItemSelectedListener() {
						@Override
						public void MenuItemSelectedEvent(MenuItem selection) {
							
							onOptionsItemSelected(selection);
							
//							Toast t = Toast.makeText(BB10Activity.this, "You selected item #"+Integer.toString(selection.getId()), Toast.LENGTH_SHORT);
//							t.setGravity(Gravity.CENTER, 0, 0);
//							t.show();
							
							
						}
					};
					
					
					mMenu = new com.eltonkola.bb10ui.menu.Menu(BB10Activity.this, listener , getLayoutInflater());
			        mMenu.setHideOnSelect(true);
			        mMenu.setItemsPerLineInPortraitOrientation(4);
			        mMenu.setItemsPerLineInLandscapeOrientation(8);
			        
			        Utils.log("menu created");
					
			        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
			        try {
			            XmlResourceParser xrp = getResources().getXml(menuRes);
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
			 			Toast.makeText(BB10Activity.this, "Error loading the main menu!", Toast.LENGTH_SHORT).show();
			 		}
					
			        mMenu.show(menu_container);
					//super.inflate(menuRes, menu);
				}

				

			}
	    
	   
	    
}
