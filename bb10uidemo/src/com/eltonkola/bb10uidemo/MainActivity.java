package com.eltonkola.bb10uidemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.utils.Utils;

public class MainActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
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
                   Toast.makeText(MainActivity.this, "ikona 1 from main app", Toast.LENGTH_SHORT).show();
                   return true;
             case R.id.icon_2:
                 Toast.makeText(MainActivity.this, "ikona 2 from main app", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_3:
                 Toast.makeText(MainActivity.this, "ikona 3 from main app", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_4:
                 Toast.makeText(MainActivity.this, "ikona 4 from main app", Toast.LENGTH_SHORT).show();
                 return true;
             default:
                   return super.onOptionsItemSelected(item);
         }
     }



}
