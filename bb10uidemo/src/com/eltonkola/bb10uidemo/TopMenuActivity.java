package com.eltonkola.bb10uidemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.utils.Utils;

public class TopMenuActivity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_topmenu);
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
            	 Toast.makeText(TopMenuActivity.this, "Click on icon 1", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_2:
                 Toast.makeText(TopMenuActivity.this, "Click on icon 2", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_3:
                 Toast.makeText(TopMenuActivity.this, "Click on icon 3", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_4:
                 Toast.makeText(TopMenuActivity.this, "Click on icon 4", Toast.LENGTH_SHORT).show();
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
     }

}
