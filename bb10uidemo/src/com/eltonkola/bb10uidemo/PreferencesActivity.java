package com.eltonkola.bb10uidemo;

import android.os.Bundle;
import com.eltonkola.bb10ui.app.BB10PreferenceActivity;

public class PreferencesActivity extends BB10PreferenceActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		
	}
}
