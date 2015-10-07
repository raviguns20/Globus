package com.globus.fontutil;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.globus.R;

public class FontUtils {

	static Typeface tf;
	static Typeface tf_indian_rupees;

	private static HashMap<String, SoftReference<Typeface>> cache = new HashMap<String, SoftReference<Typeface>>();

	private static SoftReference<Typeface> stf;  
	

	/**
	 * 
	 * @param context
	 * @param view 
	 * @param name  
	 */
	
	//---------------------- FONT FUTUAL -----------------------------
	public static void setTypefaceFontFutual(Context context, TextView view) {
		
		String name = context.getString(R.string.font_fontfutul);
		synchronized (cache) {
			if (!cache.containsKey(name)) {
				tf = Typeface.createFromAsset(context.getAssets(), name);
				if (tf != null) {
					cache.put(name, new SoftReference<Typeface>(tf));
					view.setTypeface(tf);
				}
			} else {
				stf = cache.get(name);
				view.setTypeface(stf.get());
			}
		}
	}
	
	public static Typeface getTypeFaceFontFutual(Context mContext) {
		String name = mContext.getString(R.string.font_fontfutul);
		Typeface tf = Typeface.createFromAsset(mContext.getAssets(), name);
		return tf;
	}
	
	public static void setTextViewFontFutual(Context mContext, TextView... params) {
		for (TextView tv : params) {
			setTypefaceFontFutual(mContext, tv);
		}
	}
	
	//---------------------- FONT FUTUAL -----------------------------
public static void setTypefaceFontFutram(Context context, TextView view) {
		
		String name = context.getString(R.string.font_futuram);
		synchronized (cache) {
			if (!cache.containsKey(name)) {
				tf = Typeface.createFromAsset(context.getAssets(), name);
				if (tf != null) {
					cache.put(name, new SoftReference<Typeface>(tf));
					view.setTypeface(tf);
				}
			} else {
				stf = cache.get(name);
				view.setTypeface(stf.get());
			}
		}
	}

public static Typeface getTypeFaceFontFuturam(Context mContext) {
	String name = mContext.getString(R.string.font_futuram);
	Typeface tf = Typeface.createFromAsset(mContext.getAssets(), name);
	return tf;
}
public static void setTextViewFontFuturam(Context mContext, TextView... params) {
	for (TextView tv : params) {
		setTypefaceFontFutram(mContext, tv);
	}
}
//---------------------- FONT FUTUAL -----------------------------
public static void setTypefaceFonttt144(Context context, TextView view) {
	
	String name = context.getString(R.string.font_tt0144m);
	synchronized (cache) {
		if (!cache.containsKey(name)) {
			tf = Typeface.createFromAsset(context.getAssets(), name);
			if (tf != null) {
				cache.put(name, new SoftReference<Typeface>(tf));
				view.setTypeface(tf);
			}
		} else {
			stf = cache.get(name);
			view.setTypeface(stf.get());
		}
	}
	}
	
public static Typeface getTypeFaceFonttt144(Context mContext) {
	String name = mContext.getString(R.string.font_tt0144m);
	Typeface tf = Typeface.createFromAsset(mContext.getAssets(), name);
	return tf;
}
	public static void setTextViewFonttt144(Context mContext, TextView... params) {
	for (TextView tv : params) {
		setTypefaceFonttt144(mContext, tv);
	}
}
	
	/*public static Typeface getTypeFace(Context mContext) {
		String name = mContext.getString(R.string.font_calibri);
		Typeface tf = Typeface.createFromAsset(mContext.getAssets(), name);
		return tf;
	}
*/
	/**
	 * 
	 * @param mContext
	 * @param name
	 * @param params
	 */

	
	

}
