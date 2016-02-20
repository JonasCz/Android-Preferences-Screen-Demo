package com.example.preferences;

import android.app.*;
import android.os.*;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		//set the default values we defined in the XML
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		
		//get the values of the settings options
		boolean silentMode = preferences.getBoolean("silent_mode", false);
		boolean awesomeMode = preferences.getBoolean("awesome_mode", false);
		
		String string = preferences.getString("custom_storage", "");
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//create the action overflow menu
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
			case R.id.action_preferences:
				Intent i = new Intent(this, PreferencesActivity.class);
				startActivity(i);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
