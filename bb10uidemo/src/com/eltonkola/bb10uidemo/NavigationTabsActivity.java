package com.eltonkola.bb10uidemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10Activity;

public class NavigationTabsActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navtabs);
		

		findViewById(R.id.close).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		//show navigation as button
		getBB10().showNav1AsTab(R.drawable.ic_add_to_contacts, true);
		getBB10().showNav2AsTab(R.drawable.ic_cancel, false);
		getBB10().showNav3AsTab(R.drawable.ic_collapse, true);
		getBB10().showNav4AsTab(R.drawable.ic_copy_link_image, false);
		
		getBB10().hideLeftButton();
		
//		getBB10().showBackButton();
		
		//hide buttons
//		getBB10().hideNav1();
//		getBB10().hideNav2();
//		getBB10().hideNav3();
//		getBB10().hideNav4();
		
	}
	
	@Override
	public void onBarButton1Click() {
		Toast.makeText(NavigationTabsActivity.this, "Navgation 1 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton2Click() {
		Toast.makeText(NavigationTabsActivity.this, "Navgation 2 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton3Click() {
		Toast.makeText(NavigationTabsActivity.this, "Navgation 3 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton4Click() {
		Toast.makeText(NavigationTabsActivity.this, "Navgation 4 click", Toast.LENGTH_SHORT).show();
	}
	
	
}
