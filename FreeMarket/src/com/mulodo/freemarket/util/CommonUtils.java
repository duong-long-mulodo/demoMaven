package com.mulodo.freemarket.util;

import com.mulodo.freemarket.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Common Utils
 * 
 * @author laihuythinh
 * 
 */
public class CommonUtils {

	/**
	 * Show Dialog Ok
	 * 
	 * @param context
	 * @param title
	 * @param message
	 * @param listener
	 */
	public static void showOkDialog(Context context, String title,
			String message, DialogInterface.OnClickListener listener) {
		// Init new AlertDialog with OK button
		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.create();
		ad.setPositiveButton(android.R.string.ok, listener);
		ad.setTitle(title);
		ad.setMessage(message);
		// Show dialog
		ad.show();
	}

	/**
	 * Show Dialog Yes/No
	 * 
	 * @param context
	 * @param title
	 * @param message
	 * @param yes
	 * @param no
	 */
	public static void showYesNoDialog(final Context context, String title,
			String message, DialogInterface.OnClickListener yes,
			DialogInterface.OnClickListener no) {
		// Init new Dialog
		Dialog dialog = createYesNoDialog(context, title, message, yes, no);
		// Show dialog
		dialog.show();
	}

	/**
	 * Get Dialog from params
	 * 
	 * @param context
	 * @param title
	 * @param message
	 * @param yes
	 * @param no
	 * @return
	 */
	public static Dialog createYesNoDialog(final Context context, String title,
			String message, DialogInterface.OnClickListener yes,
			DialogInterface.OnClickListener no) {
		// Init new Dialog with Yes/No button
		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.setTitle(title);
		ad.setMessage(message);
		ad.setPositiveButton(R.string.dialog_yes, yes);
		ad.setNegativeButton(R.string.dialog_no, no);
		Dialog dialog = ad.create();
		dialog.setCanceledOnTouchOutside(false);
		// Return dialog
		return dialog;
	}

	/**
	 * Check Network Connection
	 * 
	 * @param context
	 * @return
	 */
	public static boolean hasNetworkConnection(Context context) {
		// Flag to check has network connection
		boolean outcome = false;
		if (context != null) {
			ConnectivityManager cm = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
			for (NetworkInfo tempNetworkInfo : networkInfos) {
				// Is connect
				if (tempNetworkInfo.isConnected()) {
					// Set flag outcome = true
					outcome = true;
					break;
				}
			}
		}
		// Return outcome
		return outcome;
	}

}
