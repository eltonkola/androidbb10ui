package com.eltonkola.bb10ui.actionbar;

import com.eltonkola.bb10ui.R;
import com.eltonkola.bb10ui.utils.Utils;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class ActionbarBB10 {

	private Activity mActivity;
	
	private FrameLayout rootV;
	
	
	private ImageButton actionbar_back;
	
	private ImageButton actionbar_but1;
	private ImageButton actionbar_but2;
	private ImageButton actionbar_but3;
	private ImageButton actionbar_but4;
	
	
	public ActionbarBB10(final Activity activity) {
		super();
		this.mActivity = activity;

	       View root = mActivity.getWindow().getDecorView().findViewById(android.R.id.content);
	       rootV = (FrameLayout)root;
	       
	       View actionbarView = LayoutInflater.from(mActivity.getBaseContext()).inflate(R.layout.actionbar, null);
	       
	       FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
	       params.gravity =  Gravity.BOTTOM;
	       
	       rootV.addView(actionbarView, 0, params);

	       
	       ViewTreeObserver viewTreeObserver = rootV.getViewTreeObserver();
	       if (viewTreeObserver.isAlive()) {
	         viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
	           @Override
	           public void onGlobalLayout() {
	        	   
	        	 rootV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
	      
	             View mainLayout = rootV.getChildAt(1);
	             
	             FrameLayout.LayoutParams paramsChild = new  FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
	             paramsChild.gravity =  Gravity.BOTTOM;
	             paramsChild.topMargin = rootV.getChildAt(0).getHeight();

	             mainLayout.setLayoutParams(paramsChild);
	             
	             Utils.log("root:" + rootV.getChildCount());
	             
	           }
	         });
	       }
	       
	       
	       
	       actionbar_back = (ImageButton)actionbarView.findViewById(R.id.actionbar_back);

	       actionbar_but1 = (ImageButton)actionbarView.findViewById(R.id.actionbar_but1);
	       actionbar_but2 = (ImageButton)actionbarView.findViewById(R.id.actionbar_but2);
	       actionbar_but3 = (ImageButton)actionbarView.findViewById(R.id.actionbar_but3);
	       actionbar_but4 = (ImageButton)actionbarView.findViewById(R.id.actionbar_but4);
	       
	       
	       
//	       actionbar_back.setVisibility(View.GONE);
	       
	       actionbar_back.setOnClickListener(new OnClickListener() {
			
				@Override
				public void onClick(View v) {
					activity.finish();
				}
			});

	       actionbar_but4.setVisibility(View.GONE);
	       actionbar_but3.setVisibility(View.GONE);
	       actionbar_but2.setVisibility(View.GONE);
	       
	       actionbar_back.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mActivity.finish();
				}
			});
	       

	}
	

	
	
	//get the 4 buttons..
	
	public ImageButton getActionbar_but1() {
		return actionbar_but1;
	}

	public ImageButton getActionbar_but2() {
		return actionbar_but2;
	}

	public ImageButton getActionbar_but3() {
		return actionbar_but3;
	}

	public ImageButton getActionbar_but4() {
		return actionbar_but4;
	}
	
	public ImageButton getActionbar_back() {
		return actionbar_back;
	}
	
	
	
	
	
}
