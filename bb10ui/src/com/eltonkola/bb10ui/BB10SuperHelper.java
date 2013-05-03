package com.eltonkola.bb10ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public interface BB10SuperHelper {
	
	//call super methods
	public void super_onCreate(Bundle savedInstanceState);
	
	public void super_setContentView(int layoutResID);
	
	public void super_setContentView(View view, LayoutParams params);
	
	public void super_onBackPressed();
	
	public boolean super_onKeyDown(int keyCode, KeyEvent event);

	
	//click on left tab menu
	public void onSlideTabClickListener(int itemId);
	//right menu click event
	public void onSlideMenuClickListener(int itemId);
	//4 buttons tabs
	public void onBarButton1Click();
	public void onBarButton2Click();
	public void onBarButton3Click();
	public void onBarButton4Click();
	
}
