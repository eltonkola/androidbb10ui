package com.eltonkola.bb10uidemo;

import android.os.Bundle;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10Activity;

public class NavigationButtonsActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navbutons);
		

		
		//show navigation as button
		getBB10().showNav1AsButton(R.drawable.ic_add_to_contacts);
		getBB10().showNav2AsButton(R.drawable.ic_cancel);
		getBB10().showNav3AsButton(R.drawable.ic_collapse);
		getBB10().showNav4AsButton(R.drawable.ic_copy_link_image);
		
		
		//hide buttons
//		getBB10().hideNav1();
//		getBB10().hideNav2();
//		getBB10().hideNav3();
//		getBB10().hideNav4();
		
	}
	
	@Override
	public void onBarButton1Click() {
		Toast.makeText(NavigationButtonsActivity.this, "Navgation 1 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton2Click() {
		Toast.makeText(NavigationButtonsActivity.this, "Navgation 2 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton3Click() {
		Toast.makeText(NavigationButtonsActivity.this, "Navgation 3 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton4Click() {
		Toast.makeText(NavigationButtonsActivity.this, "Navgation 4 click", Toast.LENGTH_SHORT).show();
	}
	
	
}
