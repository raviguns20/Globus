package com.globus.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.globus.model.ModelUser;

public class PreferenceConnector {
	public static final String PREF_NAME = "globus";
	public static final int MODE = Context.MODE_PRIVATE;
	public static final String isFacebook = "facebook";
	public static  String CART_ID = "cart_id";
		
	public static void writeBoolean(Context context, String key, boolean value) {
		getEditor(context).putBoolean(key, value).commit();
	}

	public static boolean readBoolean(Context context, String key,
			boolean defValue) {
		return getPreferences(context).getBoolean(key, defValue);
	}

	public static void writeInteger(Context context, String key, int value) {
		getEditor(context).putInt(key, value).commit();
	}

	public static int readInteger(Context context, String key, int defValue) {
		return getPreferences(context).getInt(key, defValue);
	}

	public static void writeString(Context context, String key, String value) {
		getEditor(context).putString(key, value).commit();
	}

	public static String readString(Context context, String key, String defValue) {
		return getPreferences(context).getString(key, defValue);
	}

	public static void writeFloat(Context context, String key, float value) {
		getEditor(context).putFloat(key, value).commit();
	}

	public static float readFloat(Context context, String key, float defValue) {
		return getPreferences(context).getFloat(key, defValue);
	}

	public static void writeLong(Context context, String key, long value) {
		getEditor(context).putLong(key, value).commit();
	}

	public static long readLong(Context context, String key, long defValue) {
		return getPreferences(context).getLong(key, defValue);
	}

	public static SharedPreferences getPreferences(Context context) {
		return context.getSharedPreferences(PREF_NAME, MODE);
	}

	public static Editor getEditor(Context context) {
		return getPreferences(context).edit();
	}
	
	//------------------ CLEAR ALL PREFERENCES -----------------------------------------
	public static void clearAllPreference(Context context) {
		getEditor(context).clear().commit();
	}
	//--------------------------------- GET AND PUT USER IN PREFERENCE-------------------------------------------------	
	public static void saveUser(Context mContext, ModelUser user) {
		
		writeString(mContext, Constant.USER_ID,user.getUserId());
		writeString(mContext, Constant.CUST_USER_NAME,user.getUserName());
		writeString(mContext, Constant.CUST_USER_EMAIL,user.getUserEmail());
		writeString(mContext, Constant.CUST_CART_QTY,""+user.getCartQty());
	
		IOUtils.printLogDebug("SAVED USER IN PREFERENCE - "+user.getUserId()+" - "+user.getUserName()+" - "+user.getUserEmail());
	
		
	}
	
	public static ModelUser getCurrentUser(Context mContext) {
		ModelUser recordUser = new ModelUser();
		recordUser.setUserId(readString(mContext, Constant.USER_ID, null));
		recordUser.setUserEmail(readString(mContext, Constant.CUST_USER_EMAIL,null));
		recordUser.setUserName(readString(mContext, Constant.CUST_USER_NAME,null));
		
		int cartQty=Integer.valueOf(readString(mContext, Constant.CUST_CART_QTY,null));
		recordUser.setCartQty(cartQty);
		return recordUser;

	}
}
