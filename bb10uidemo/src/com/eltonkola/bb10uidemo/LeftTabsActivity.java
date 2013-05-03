package com.eltonkola.bb10uidemo;

import java.util.ArrayList;
import android.os.Bundle;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.slide.BB10SlideMenuItem;

public class LeftTabsActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lefttabs);
		
		//right slide tabs from xml menu
		//getBB10().setLeftSlideTabs(R.menu.main, false, 0, R.drawable.ic_bbm);
		
		
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
	
	@Override
	public void onSlideTabClickListener(int itemId) {
		Toast.makeText(LeftTabsActivity.this,"clciked on tab:" + itemId,Toast.LENGTH_SHORT).show();
	}

	
}
