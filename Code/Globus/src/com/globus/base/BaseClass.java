package com.globus.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.globus.R;
import com.globus.util.IOUtils;

public class BaseClass extends AppCompatActivity {

	public Context BASE_CONTEXT = this;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	 
	public void addFragment(Fragment fragment, boolean addToBackStack,String tag) {

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction ft = manager.beginTransaction();
		ft.addToBackStack(null);
		ft.replace(R.id.container, fragment);//, "globus");
		ft.commit();
	}
	
	protected void checkInternetConnection(Context mContext,View view) {
		if (!IOUtils.isInternetPresent(mContext)) {
			IOUtils.mySnackBarInternet(mContext, view);
		}
	}
	
	public boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
