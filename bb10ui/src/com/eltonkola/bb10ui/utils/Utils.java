package com.eltonkola.bb10ui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

public class Utils {

	//current version of the library
	public static final String LIB_VERSION = "1.0";
	
	
	//if we are in developemnt mode, or not
	public static boolean development = true;


	public static long slideDuration = 300;
	
	//logging utility
	public static void log(String s) {
		if(development) Log.v("eltonkola",s);
	}
	
	public static void log(String t, String s) {
		if(development) Log.v(t,s);
	}
	

	public static boolean testNetwork(Context context) {
		boolean res = true;
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm.getActiveNetworkInfo() == null|| !cm.getActiveNetworkInfo().isConnectedOrConnecting()) {
			res = false;
		}
		return res;
	}

}
