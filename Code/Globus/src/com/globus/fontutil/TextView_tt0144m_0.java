package com.globus.fontutil;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextView_tt0144m_0 extends TextView {

	private static final String TAG = "TextView";

	private Typeface typeface;

	public TextView_tt0144m_0(Context context) {
		super(context);
	}

	public TextView_tt0144m_0(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context, attrs);
	}

	public TextView_tt0144m_0(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomFont(context, attrs);
	}

	private void setCustomFont(Context ctx, AttributeSet attrs) {
		setCustomFont(ctx);
	}

	private boolean setCustomFont(Context ctx) {
		try {
			if (typeface == null) {
				typeface = Typeface.createFromAsset(ctx.getAssets(),"fonts/tt0144m_0.ttf");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		setTypeface(typeface);
		return true;
	}

}