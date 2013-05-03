package com.eltonkola.bb10uidemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.eltonkola.bb10ui.app.BB10Activity;

public class MainActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SimpleActivity.class));
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ListActivity.class));
			}
		});
		
		findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ExpandableListActivity.class));
			}
		});
		
		findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, FragmentActivity.class));
			}
		});
		
		findViewById(R.id.button5).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PreferencesActivity.class));
			}
		});
		
		findViewById(R.id.button6).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, FormsActivity.class));
			}
		});
		
		findViewById(R.id.button7).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, TopMenuActivity.class));
			}
		});
		
		findViewById(R.id.button8).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, LeftTabsActivity.class));
			}
		});
		
		findViewById(R.id.button9).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, RightMenuActivity.class));
			}
		});
		
		findViewById(R.id.button10).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, NavigationButtonsActivity.class));
			}
		});
		
		findViewById(R.id.button11).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, NavigationTabsActivity.class));
			}
		});
		
		findViewById(R.id.button12).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, NavigationMixActivity.class));
			}
		});
		
		
		findViewById(R.id.button13).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Complex1Activity.class));
			}
		});
		
		findViewById(R.id.button14).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Complex2Activity.class));
			}
		});
		
		findViewById(R.id.button15).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, DynamicActivity.class));
			}
		});
		
	}
}
