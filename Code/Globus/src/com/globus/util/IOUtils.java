/**
 * 
 * @author vCleen
 *
 */

package com.globus.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.R;
import com.globus.app.GlobusApp;


public class IOUtils {

	public static final String DATE_TIME_FORMATE = "dd/MM/yyyy HH:mm";
	private static ProgressDialog proDialog = null;
	static Dialog dialogGoogleLoading=null;

	/*public static void printLocationUpdate(String msg) {
		try {
			Log.e("LocationHelper", msg);
		} catch (Exception e) {

		}
	}*/
	public static int generateRandomNumber(int length) {
		Random r = new Random();
		String number = "";
		int counter = 0;
		while (counter++ < length)
			number += r.nextInt(9);
		
		return Integer.parseInt(number);

	}
	
	
	public static void setImageToNetworkImageView(NetworkImageView imgView, String url){
		if(!TextUtils.isEmpty(String.valueOf(url))){
			imgView.setDefaultImageResId(R.drawable.ic_launcher);
			imgView.setErrorImageResId(R.drawable.ic_launcher);
			imgView.setAdjustViewBounds(true);
			imgView.setImageUrl(url, GlobusApp.getInstance().getImageLoader());
		}else{
			imgView.setDefaultImageResId(R.drawable.ic_launcher);
		}
	}

	public static int getHieghtOfScreen(Activity mContext) 
	{
		DisplayMetrics displaymetrics = new DisplayMetrics();
		(mContext).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;
		int densi=(int) mContext.getResources().getDisplayMetrics().density;
		return width*densi;
	}

	public static void printLogError(String msg) {
		try {
			Log.e("Globus", msg);
		} catch (Exception e) {

		}
	}

	public static void printLogDebug(String msg) {
		try {
			Log.d("Globus", msg);
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("deprecation")
	public static void mySnackBar(Context mContext, String message, View view) {
		Snackbar.make(view, message, Snackbar.LENGTH_LONG)
		.setActionTextColor(mContext.getResources().getColor(R.color.skyblue))
		.show();
	}

	@SuppressWarnings("deprecation")
	public static void mySnackBarInternet(Context mContext,View view) {
		Snackbar.make(view, mContext.getString(R.string.msg_internet_connection), Snackbar.LENGTH_LONG)
		.setActionTextColor(mContext.getResources().getColor(R.color.skyblue))
		.show();
	}

	public static void printLogInfo(String msg) {
		try {
			Log.i("Globus", msg);
		} catch (Exception e) {

		}
	}

	public static void startLoadingPleaseWait(Context mContext) {
		try {

			if (mContext != null) {
				if (proDialog == null)
					proDialog = ProgressDialog.show(mContext, null, mContext.getString(R.string.msg_please_Wait));
				proDialog.setCancelable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void startLoading(Context context, String message) {
		try {
			if (context != null) {
				if (proDialog == null)
					proDialog = ProgressDialog.show(context, null, message);
				proDialog.setCancelable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stopLoading() {
		try {
			if (proDialog != null)
				proDialog.dismiss();
			proDialog = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static boolean isInternetPresent(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
		}
		return false;
	}


	public static void hideKeyBoard(Context context,EditText myEditText){
		InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
	}

	public static void hideKeyBoard(Context context) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
	}

	public static boolean checkCameraHardware(Context context) {
		if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
			// this device has a camera
			return true;
		} else {
			// no camera on this device
			return false;
		}
	}




	public static void myToast(String msg, Context context) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void myToastLong(String msg, Context context) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void CopyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}

	/*public static void showAlert(final Context mContext, String msg,
			final String hint,String title) {

		AlertDialog.Builder al = new AlertDialog.Builder(mContext);
		al.setCancelable(false);

		if (!TextUtils.isEmpty(title))
			al.setTitle(title);
		else
			al.setTitle("Ekirana");

		al.setMessage(msg);
		al.setPositiveButton("OK", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (hint.equals("registered")) {
					mContext.startActivity(new Intent(mContext,AddNewAddress.class));
					AnimationUtils.AnimationNext((Activity) mContext);
					((Activity) mContext).finish();
				} else if (hint.equals("login")) {
					mContext.startActivity(new Intent(mContext,HomeScreen.class));
					AnimationUtils.AnimationNext((Activity) mContext);
				} else if (hint.equals("updated")) {
					mContext.startActivity(new Intent(mContext,MyAccount.class));
					AnimationUtils.AnimationNext((Activity) mContext);
				} else if (hint.equals("cart_emty")) {
					mContext.startActivity(new Intent(mContext,HomeScreen.class));
					AnimationUtils.AnimationNext((Activity) mContext);
				}


			}
		});

		al.show();

	}*/

	/*public static void showDialogGoogle(String msg, Context mContext) {
		try {
			if (mContext != null) {
				if (dialogGoogleLoading == null) {

					dialogGoogleLoading = new Dialog(mContext);
					dialogGoogleLoading.requestWindowFeature(Window.FEATURE_NO_TITLE);
					dialogGoogleLoading.setContentView(R.layout.dialog_google_loading);
					dialogGoogleLoading.setCancelable(false);
					dialogGoogleLoading.show();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static void cancelDialogLoading() {
		try {
			if (dialogGoogleLoading != null) {
				dialogGoogleLoading.dismiss();
				dialogGoogleLoading = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
