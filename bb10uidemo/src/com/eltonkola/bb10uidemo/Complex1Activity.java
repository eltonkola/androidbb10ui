package com.eltonkola.bb10uidemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.slide.BB10SlideMenuItem;
import com.eltonkola.bb10ui.utils.Utils;

public class Complex1Activity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complex1);
		

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
		
		getBB10().showNav1AsButton(R.drawable.ic_add_to_contacts);
		getBB10().showNav2AsButton(R.drawable.ic_cancel);
		getBB10().showNav3AsButton(R.drawable.ic_collapse);
		getBB10().showNav4AsButton(R.drawable.ic_copy_link_image);
		
		
		
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
            	 Toast.makeText(Complex1Activity.this, "Click on icon 1", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_2:
                 Toast.makeText(Complex1Activity.this, "Click on icon 2", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_3:
                 Toast.makeText(Complex1Activity.this, "Click on icon 3", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_4:
                 Toast.makeText(Complex1Activity.this, "Click on icon 4", Toast.LENGTH_SHORT).show();
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
     }

	 
		@Override
		public void onBarButton1Click() {
			Toast.makeText(Complex1Activity.this, "Navgation 1 click", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onBarButton2Click() {
			Toast.makeText(Complex1Activity.this, "Navgation 2 click", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onBarButton3Click() {
			Toast.makeText(Complex1Activity.this, "Navgation 3 click", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onBarButton4Click() {
			Toast.makeText(Complex1Activity.this, "Navgation 4 click", Toast.LENGTH_SHORT).show();
		}
		
}
