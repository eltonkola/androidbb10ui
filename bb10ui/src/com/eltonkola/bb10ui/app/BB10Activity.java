package com.eltonkola.bb10ui.app;

import com.eltonkola.bb10ui.actionbar.ActionbarBB10;
import com.eltonkola.bb10ui.utils.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class BB10Activity extends Activity{

	private ActionbarBB10 actionbar;
	
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return super.onCreateDialog(id, args);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	

	@Override
	public void setContentView(View view) {
		super.setContentView(view);
		actionbar =  new ActionbarBB10(this);
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		actionbar =  new ActionbarBB10(this);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		super.setContentView(view, params);
		actionbar =  new ActionbarBB10(this);
	}

	
	
	
}
