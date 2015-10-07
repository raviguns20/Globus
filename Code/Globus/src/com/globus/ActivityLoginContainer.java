package com.globus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.globus.base.BaseClass;
import com.globus.fragments.FragmentForgotPassword;
import com.globus.fragments.FragmentLogin;
  
public class ActivityLoginContainer extends BaseClass {
	
	private LinearLayout container;
	private FragmentManager fManager;
	private FragmentTransaction fTransition;
	private FragmentLogin fragmentLogin;
	private FragmentForgotPassword fragmentForgotPassword;
	private String fragmentTag="login";
	private Toolbar main_toolbar;
	private ImageView img_profile_icon,img_notification,img_profile_cart,img_main_logo;
	private TextView txtTitle;
	private LinearLayout rootView; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init(); 
		checkInternetConnection(BASE_CONTEXT, rootView);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
		int count = getSupportFragmentManager().getBackStackEntryCount();
		if(count==0) {
			finish();
        }
		
	}
	
	public void setToolBatTitle(String title){
		txtTitle.setText(title);
	}

	@SuppressLint("CommitTransaction") private void init() {
		BASE_CONTEXT = ActivityLoginContainer.this;
		container=(LinearLayout)findViewById(R.id.container);
		rootView=(LinearLayout)findViewById(R.id.rootView); 
		
		main_toolbar=(Toolbar)findViewById(R.id.main_toolbar);
		txtTitle=(TextView)main_toolbar.findViewById(R.id.txtTitle);
		setSupportActionBar(main_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		setToolBatTitle("Login");
		
		
		/*img_profile_icon=(ImageView)main_toolbar.findViewById(R.id.img_profile_icon);
		img_notification=(ImageView)main_toolbar.findViewById(R.id.img_notification);
		img_profile_cart=(ImageView)main_toolbar.findViewById(R.id.img_profile_cart);
		img_main_logo=(ImageView)main_toolbar.findViewById(R.id.img_main_logo);
		
		
		img_profile_icon.setVisibility(View.INVISIBLE);
		img_notification.setVisibility(View.INVISIBLE);
		img_profile_cart.setVisibility(View.INVISIBLE);
		img_main_logo.setVisibility(View.INVISIBLE);*/
		
		
		
		fragmentLogin=new FragmentLogin();
		fragmentForgotPassword=new FragmentForgotPassword();
		addFragment(fragmentLogin,true,"globus");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			onBackPressed();
		}
		return super.onOptionsItemSelected(item);
	}

	
}
