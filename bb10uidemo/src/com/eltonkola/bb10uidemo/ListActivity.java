package com.eltonkola.bb10uidemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.eltonkola.bb10ui.app.BB10ListActivity;

public class ListActivity extends BB10ListActivity {
	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_list);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile","Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X","Linux", "OS/2" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}
	
}