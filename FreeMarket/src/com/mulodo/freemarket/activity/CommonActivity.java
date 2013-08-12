package com.mulodo.freemarket.activity;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Common Activity
 * 
 * @author laihuythinh
 * 
 */
public class CommonActivity extends Activity {

	public static int THEME_FREE_MARKET = R.style.Theme_Light;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Push intent to stack manager
		CommonActivityManager.getInstance().pushIntent(getIntent());
		super.onCreate(savedInstanceState);
		setTheme(THEME_FREE_MARKET);
	}

	@Override
	public void finish() {
		// Pop intent to stack manager
		CommonActivityManager.getInstance().popIntent();
		super.finish();
	}

	/**
	 * Event key down
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
			return true;
		case KeyEvent.KEYCODE_BACK:
			// Finish current in
			finish();
			return true;
		default:
			return false;
		}
	}
}
