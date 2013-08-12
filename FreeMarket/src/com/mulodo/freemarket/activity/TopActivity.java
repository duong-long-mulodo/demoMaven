package com.mulodo.freemarket.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.mulodo.freemarket.R;

/**
 * Top Activity
 * 
 * @author laihuythinh
 *
 */
public class TopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top, menu);
		return true;
	}

}
