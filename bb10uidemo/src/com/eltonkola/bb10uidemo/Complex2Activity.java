package com.eltonkola.bb10uidemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.eltonkola.bb10ui.app.BB10Activity;
import com.eltonkola.bb10ui.slide.BB10SlideMenuItem;
import com.eltonkola.bb10ui.utils.Utils;

public class Complex2Activity extends BB10Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complex2);
		
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
				
				
				findViewById(R.id.close).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						finish();
					}
				});
				
				
				//right slide tabs from code 
				ArrayList<BB10SlideMenuItem> menuItemListx = new ArrayList<BB10SlideMenuItem>();
				
				BB10SlideMenuItem item1x = new BB10SlideMenuItem();
				item1x.setId(0);
				item1x.setName("Inbox");
				item1x.setDescription("3 New Messages");
				item1x.setIcon(R.drawable.ic_bbm);
				item1x.setNew_icon(true);
				item1x.setNew_nr(3);
				
				BB10SlideMenuItem item2x = new BB10SlideMenuItem();
				item2x.setId(1);
				item2x.setName("Elton Kola");
				item2x.setDescription("Hello BB");
				item2x.setIcon(R.drawable.ic_add_to_contacts);
				
				BB10SlideMenuItem item3x = new BB10SlideMenuItem();
				item3x.setId(2);
				item3x.setName("Title only");
				item3x.setIcon(R.drawable.ic_select_text_all);

				menuItemListx.add(item1x);
				menuItemListx.add(item2x);
				menuItemListx.add(item3x);
				
				getBB10().setLeftSlideTabs(menuItemListx, false, 2, R.drawable.ic_bbm);
				
				
				getBB10().showNav1AsTab(R.drawable.ic_add_to_contacts, true);
				getBB10().showNav2AsTab(R.drawable.ic_cancel, false);
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
            	 Toast.makeText(Complex2Activity.this, "Click on icon 1", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_2:
                 Toast.makeText(Complex2Activity.this, "Click on icon 2", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_3:
                 Toast.makeText(Complex2Activity.this, "Click on icon 3", Toast.LENGTH_SHORT).show();
                 return true;
             case R.id.icon_4:
                 Toast.makeText(Complex2Activity.this, "Click on icon 4", Toast.LENGTH_SHORT).show();
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
     }

}
