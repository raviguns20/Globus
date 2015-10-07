package com.globus.app;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.globus.util.LruBitmapCache;

public class GlobusApp extends Application {
	private static GlobusApp mInstance;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private static Context mContext;
	
	@Override
	public void onCreate() {
		super.onCreate();
		GlobusApp.mContext = getApplicationContext();
		getRequestQueue();
		getImageLoader();
	}

	public static synchronized GlobusApp getInstance() {
		if (mInstance == null) {
			mInstance = new GlobusApp();
		}

		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			// getApplicationContext() is key, it keeps you from leaking the
			// Activity or BroadcastReceiver if someone passes one in.
			mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
		}
		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		// set the default tag if tag is empty
		req.setTag(tag);
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		getRequestQueue().add(req);
	}

	public ImageLoader getImageLoader() {
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(getRequestQueue(), new LruBitmapCache(LruBitmapCache.getDefaultLruCacheSize()));
		}
		return mImageLoader;
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}
}

