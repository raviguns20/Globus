package com.globus.fontutil;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditText_FontFutuLt_0 extends EditText {

	private static final String TAG = "TextView";

	private Typeface typeface;

	public EditText_FontFutuLt_0(Context context) {
		super(context);
	}

	public EditText_FontFutuLt_0(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context, attrs);
	}

	public EditText_FontFutuLt_0(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomFont(context, attrs);
	}

	private void setCustomFont(Context ctx, AttributeSet attrs) {
		setCustomFont(ctx);
	}

	private boolean setCustomFont(Context ctx) {
		try {
			if (typeface == null) {
				typeface = Typeface.createFromAsset(ctx.getAssets(),"fonts/FutuLt_0.ttf");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		setTypeface(typeface);
		return true;
	}

}