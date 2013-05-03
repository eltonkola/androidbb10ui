package com.eltonkola.bb10uidemo;

import java.util.ArrayList;
import android.os.Bundle;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.slide.BB10SlideMenuItem;

public class RightMenuActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rightmenu);
		
		//right slide tabs from xml menu
		//getBB10().setRightMenu(R.menu.main);
		
		
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
	
	@Override
	public void onSlideMenuClickListener(int itemId) {
		Toast.makeText(RightMenuActivity.this,"clciked on menu:" + itemId,Toast.LENGTH_SHORT).show();
	}

	
}
