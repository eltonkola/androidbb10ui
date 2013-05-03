package com.eltonkola.bb10uidemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10Activity;

public class NavigationMixActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navmix);

		
		//show navigation as button
		getBB10().showNav1AsTab(R.drawable.ic_add_to_contacts, true);
		getBB10().showNav2AsTab(R.drawable.ic_cancel, false);
		getBB10().showNav3AsButton(R.drawable.ic_collapse);
		getBB10().showNav4AsButton(R.drawable.ic_copy_link_image);
		
		//getBB10().hideLeftButton();

		
	}
	
	@Override
	public void onBarButton1Click() {
		Toast.makeText(NavigationMixActivity.this, "Navgation 1 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton2Click() {
		Toast.makeText(NavigationMixActivity.this, "Navgation 2 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton3Click() {
		Toast.makeText(NavigationMixActivity.this, "Navgation 3 click", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBarButton4Click() {
		Toast.makeText(NavigationMixActivity.this, "Navgation 4 click", Toast.LENGTH_SHORT).show();
	}
	
	
}
