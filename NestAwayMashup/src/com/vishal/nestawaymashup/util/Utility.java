/**==============================================================================================
 * File        : Utility.java
 * Version     : 1.0
 * Author      : Vishal Ramachandran
 * Date        : 21 Sep 2013
 * Company     : VuFirst
 * Description : This class application wide utility methods
 * History     :
 * ==============================================================================================
 *  Sr.No.    Date             Name               Description
 * ==============================================================================================
 *  01.     21 Sep 2013       Vishal R   		 Initial Version
 * ==============================================================================================
 */
package com.vishal.nestawaymashup.util;

import android.app.ProgressDialog;
import android.content.Context;


public class Utility {

	/**
	 * Shows the progress bar on the screen
	 * @param context : activity context
	 * @param title : title to be displayed
	 * @param message : message to be displayed
	 * @return the progress bar instance
	 */
	public static ProgressDialog showProgressBar(Context context, String title, String message) {
		ProgressDialog progressDialog = new ProgressDialog(context);
		progressDialog.setTitle(title);
		progressDialog.setMessage(message);
		progressDialog.setCancelable(false);
		progressDialog.setIndeterminate(true);
		try {
			progressDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return progressDialog;
	}

	/**
	 * Dismiss the progress that is shown on the screen
	 * @param progressDialog : progress bar to be dismissed
	 */
	public static void dismissProgressBar(ProgressDialog progressDialog) {
		try {
			if (null != progressDialog) {
				progressDialog.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
