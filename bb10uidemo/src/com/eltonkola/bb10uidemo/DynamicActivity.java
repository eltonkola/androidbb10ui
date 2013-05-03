package com.eltonkola.bb10uidemo;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.slide.BB10SlideMenuItem;
import com.eltonkola.bb10ui.utils.Utils;

public class DynamicActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complex_dynamic);
		
		//////////////////////////////left//////////////////////////////
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Left Nav - Show as Back Button
				getBB10().showBackButton();
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Left Nav - Show as Tabs
				//right slide tabs from code 
				ArrayList<BB10SlideMenuItem> menuItemList = new ArrayList<BB10SlideMenuItem>();
				
				BB10SlideMenuItem item1 = new BB10SlideMenuItem();
				item1.setId(0);
				item1.setName("Inbox");
				item1.setDescription("3 New Messages");
				item1.setIcon(R.drawable.ic_bbm);
				item1.setNew_icon(true);
				item1.setNew_nr(3);
				
				BB10SlideMenuItem item2 = new BB10SlideMenuItem();
				item2.setId(1);
				item2.setName("Elton Kola");
				item2.setDescription("Hello BB");
				item2.setIcon(R.drawable.ic_add_to_contacts);
				
				BB10SlideMenuItem item3 = new BB10SlideMenuItem();
				item3.setId(2);
				item3.setName("Title only");
				item3.setIcon(R.drawable.ic_select_text_all);

				menuItemList.add(item1);
				menuItemList.add(item2);
				menuItemList.add(item3);
				
				getBB10().setLeftSlideTabs(menuItemList, false, 2, R.drawable.ic_bbm);
			}
		});
		
		findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Left Nav - Hide
				getBB10().hideLeftButton();
			}
		});
		
		///////////////////////////////////right////////////////////////////
		
		findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Right Nav - Show
				//right slide tabs from code 
				ArrayList<BB10SlideMenuItem> menuItemList = new ArrayList<BB10SlideMenuItem>();
				
				BB10SlideMenuItem item1 = new BB10SlideMenuItem();
				item1.setId(0);
				item1.setName("Cut");
				item1.setDescription("Cut some text");
				item1.setIcon(R.drawable.ic_cut);
				item1.setNew_icon(true);
				
				BB10SlideMenuItem item2 = new BB10SlideMenuItem();
				item2.setId(1);
				item2.setName("Delete");
				item2.setDescription("Delete something");
				item2.setIcon(R.drawable.ic_delete);
				
				BB10SlideMenuItem item3 = new BB10SlideMenuItem();
				item3.setId(2);
				item3.setName("Send mail");
				item3.setIcon(R.drawable.ic_email);

				menuItemList.add(item1);
				menuItemList.add(item2);
				menuItemList.add(item3);
				
				getBB10().setRightMenu(menuItemList);
			}
		});
		
		findViewById(R.id.button5).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Right Nav - Show
				getBB10().hideRightMenu();
			}
		});
		
		/////////////////////////////////////navgation buttons /////////////////////////
		
		///////////////////nav but 1
		
		findViewById(R.id.button6).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button1 - Show as button
				getBB10().showNav1AsButton(R.drawable.ic_add_to_contacts);
			}
		});
		
		findViewById(R.id.button7).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button1 - Show as tab
				getBB10().showNav1AsTab(R.drawable.ic_add_to_contacts, true);
			}
		});
		
		findViewById(R.id.button8).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button1 - Hide
				getBB10().hideNav1();
			}
		});
		
		///////////////////nav but 2
				
		findViewById(R.id.button9).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button2 - Show as button
				getBB10().showNav2AsButton(R.drawable.ic_expand);
			}
		});
		
		findViewById(R.id.button10).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button2 - Show as tab
				getBB10().showNav2AsTab(R.drawable.ic_add_to_contacts, false);
			}
		});
		
		findViewById(R.id.button11).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button2 - Hide
				getBB10().hideNav2();
			}
		});
		
		///////////////////nav but 3
				
		findViewById(R.id.button12).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button3 - Show as button
				getBB10().showNav3AsButton(R.drawable.ic_cancel);
			}
		});
		
		findViewById(R.id.button13).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button3 - Show as tab
				getBB10().showNav3AsTab(R.drawable.ic_copy, false);
			}
		});
		
		findViewById(R.id.button14).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button3 - Hide
				getBB10().hideNav3();
			}
		});
		
		///////////////////nav but 4
				
		findViewById(R.id.button15).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button4 - Show as button
				getBB10().showNav4AsButton(R.drawable.ic_deselect);
			}
		});
		
		findViewById(R.id.button16).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button4 - Show as tab
				getBB10().showNav4AsTab(R.drawable.ic_edit, false);
			}
		});
		
		findViewById(R.id.button17).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Nav Button4 - Hide
				getBB10().hideNav4();
			}
		});
		
		
		/////////////////////////////////////////TODO/////////////////////////////////////
		//1. add/remove elements on right/left/top menus
		//2. emable/disable top menu
		//3. add real data to forms
		//4. popup and other styled elements
		
		getBB10().hideLeftButton();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		Utils.log("client call onCreateOptionsMenu");
		super.getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	 @Override
     public boolean onOptionsItemSelected(MenuItem item){
         switch(item.getItemId()){
             case R.id.icon_1:
            	 Toast.makeText(DynamicActivity.this, "Click on icon 1", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_2:
                 Toast.makeText(DynamicActivity.this, "Click on icon 2", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_3:
                 Toast.makeText(DynamicActivity.this, "Click on icon 3", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_4:
                 Toast.makeText(DynamicActivity.this, "Click on icon 4", Toast.LENGTH_SHORT).show();
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
     }

		@Override
		public void onBarButton1Click() {
			Toast.makeText(DynamicActivity.this, "Navgation 1 click", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onBarButton2Click() {
			Toast.makeText(DynamicActivity.this, "Navgation 2 click", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onBarButton3Click() {
			Toast.makeText(DynamicActivity.this, "Navgation 3 click", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onBarButton4Click() {
			Toast.makeText(DynamicActivity.this, "Navgation 4 click", Toast.LENGTH_SHORT).show();
		}
}
