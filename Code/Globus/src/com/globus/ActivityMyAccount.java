package com.globus;


import com.android.volley.toolbox.NetworkImageView;
import com.globus.base.BaseClass;
import com.globus.util.Constant;
import com.globus.util.IOUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityMyAccount extends BaseClass implements android.view.View.OnClickListener{

	Button btnEdit;
	LinearLayout  rootView,LLMyOrders,LLMyAddress,LLMyWishlist,LLMySubscription,LLAccountSettings;
	TextView txtUserName,txtEmailId,txtMobileNo,txtMyOrders,txtMyAddress,txtMyWishlist;
	NetworkImageView imgUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_account);

		init();

	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
		case android.R.id.home: 
			onBackPressed();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	private void init() {
		// TODO Auto-generated method stub
		BASE_CONTEXT =ActivityMyAccount.this;
		Toolbar mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		txtUserName = (TextView)findViewById(R.id.txtUserName);
		txtEmailId = (TextView)findViewById(R.id.txtEmailId);
		txtMobileNo = (TextView)findViewById(R.id.txtMobileNo);
		txtMyOrders = (TextView)findViewById(R.id.txtMyOrders);
		txtMyAddress = (TextView)findViewById(R.id.txtMyAddress);
		txtMyWishlist = (TextView)findViewById(R.id.txtMyWishlist);

		imgUser = (NetworkImageView)findViewById(R.id.imgUser);
		
		IOUtils.setImageToNetworkImageView(imgUser, Constant.BASE_URL);
		txtMyAddress.setText(getString(R.string.no_txt));
		btnEdit = (Button)findViewById(R.id.btnEdit);
		rootView = (LinearLayout)findViewById(R.id.rootView);
		LLMyOrders = (LinearLayout)findViewById(R.id.LLMyOrders);
		LLMyAddress = (LinearLayout)findViewById(R.id.LLMyAddress);
		LLMyWishlist = (LinearLayout)findViewById(R.id.LLMyWishlist);
		LLMySubscription = (LinearLayout)findViewById(R.id.LLMySubscription);
		LLAccountSettings = (LinearLayout)findViewById(R.id.LLAccountSettings);

		btnEdit.setOnClickListener(this);
		LLMyOrders.setOnClickListener(this);
		LLMyAddress.setOnClickListener(this);
		LLMyWishlist.setOnClickListener(this);
		LLMySubscription.setOnClickListener(this);
		LLAccountSettings.setOnClickListener(this);


	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btnEdit:
			Intent intent_AccountSettings = new Intent(BASE_CONTEXT,ActivityProductDetails.class);
			startActivity(intent_AccountSettings);
			break;
		case R.id.LLMyOrders:
//			Intent intent1 = new Intent(BASE_CONTEXT,ActivityAccountSettings.class);
//			startActivity(intent1);

			break;
		case R.id.LLMyAddress:
//			Intent intent2 = new Intent(BASE_CONTEXT,ActivityAccountSettings.class);
//			startActivity(intent2);

			break;
		case R.id.LLMyWishlist:
//			Intent intent3 = new Intent(BASE_CONTEXT,ActivityAccountSettings.class);
//			startActivity(intent3);

			break;
		case R.id.LLMySubscription:
//			Intent intent4 = new Intent(BASE_CONTEXT,ActivityAccountSettings.class);
//			startActivity(intent4);

			break;

		case R.id.LLAccountSettings:
//			Intent intent = new Intent(BASE_CONTEXT,ActivityAccountSettings.class);
//			startActivity(intent);

			break;
		}
	}

	

	





}
