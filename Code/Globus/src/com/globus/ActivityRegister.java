package com.globus;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.globus.base.BaseClass;
import com.globus.fontutil.FontUtils;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.JsonParserUtil;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.IOUtils;

public class ActivityRegister extends BaseClass implements OnClickListener,OnFocusChangeListener{

	private String fullname,emailAddress, password, genger,
			mobileNo;
	
	Button btnRegister;
	LinearLayout rootView;
	Toolbar mToolbar;
	Toolbar main_toolbar;
	TextView txtShow;
	boolean isShow=false;

	//TextInputLayout etFirstName, etLastName, etEmailAddress, etMobileNo;
	CheckBox chkShowPassword;
	
	TextInputLayout tilUserName,tilEmailAddress,tilPassword,tilMobileNumber;
	EditText etUserName,etMobileNumber,etPassword,etEmailAddress;
	TextView txtUserNameError,txtEmailError,txtPasswordError,txtMobileError,txtMale,txtFemale,txtTotalProgress,txtProgress,txtTitle;
	LinearLayout rowUsername, rowEmail,rowPassword,rowMobile,LLMale,LLFeMale;
	
	String gender;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		init();
		checkInternetConnection(BASE_CONTEXT, rootView);

	}

	@SuppressLint("NewApi") private void init() {
		BASE_CONTEXT = ActivityRegister.this;
		rootView=(LinearLayout)findViewById(R.id.rootView);
		main_toolbar=(Toolbar)findViewById(R.id.main_toolbar);
		setSupportActionBar(main_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		txtTitle=(TextView)main_toolbar.findViewById(R.id.txtTitle);
		txtTitle.setText("Register");
		
		txtShow=(TextView)findViewById(R.id.txtShow);
		txtShow.setOnClickListener(this);
		FontUtils.setTypefaceFonttt144(BASE_CONTEXT, txtShow);
		
		
		tilUserName=(TextInputLayout)findViewById(R.id.tilUserName);
		tilEmailAddress=(TextInputLayout)findViewById(R.id.tilEmailAddress);
		tilPassword=(TextInputLayout)findViewById(R.id.tilPassword);
		tilMobileNumber=(TextInputLayout)findViewById(R.id.tilMobileNumber);
		
		
		etUserName = (EditText)tilUserName.findViewById(R.id.etUserName);
		etUserName.setOnFocusChangeListener(this);
		etUserName.setTypeface(FontUtils.getTypeFaceFontFutual(BASE_CONTEXT));
		
		etEmailAddress = (EditText)tilEmailAddress.findViewById(R.id.etEmailAddress);
		etEmailAddress.setOnFocusChangeListener(this);
		etEmailAddress.setTypeface(FontUtils.getTypeFaceFontFutual(BASE_CONTEXT));
		
		
		etPassword = (EditText)tilPassword.findViewById(R.id.etPassword);
		etPassword.setOnFocusChangeListener(this);
		etPassword.setTypeface(FontUtils.getTypeFaceFontFutual(BASE_CONTEXT));
		
		etMobileNumber = (EditText)tilMobileNumber.findViewById(R.id.etMobileNumber);
		etMobileNumber.setOnFocusChangeListener(this);
		etMobileNumber.setTypeface(FontUtils.getTypeFaceFontFutual(BASE_CONTEXT));
		
		rowUsername=(LinearLayout)findViewById(R.id.rowUsername);
		rowEmail=(LinearLayout)findViewById(R.id.rowEmail);
		rowPassword=(LinearLayout)findViewById(R.id.rowPassword);
		rowMobile=(LinearLayout)findViewById(R.id.rowMobile);

		txtUserNameError=(TextView)findViewById(R.id.txtUserNameError);
		txtEmailError=(TextView)findViewById(R.id.txtEmailError);
		txtPasswordError=(TextView)findViewById(R.id.txtPasswordError);
		txtMobileError=(TextView)findViewById(R.id.txtMobileError);;
		
		btnRegister=(Button)findViewById(R.id.btnRegister);
		btnRegister.setTypeface(FontUtils.getTypeFaceFontFuturam(BASE_CONTEXT));
		
		LLMale=(LinearLayout)findViewById(R.id.LLMale);
		LLFeMale=(LinearLayout)findViewById(R.id.LLFeMale);
		
		txtMale=(TextView)findViewById(R.id.txtMale);
		txtFemale=(TextView)findViewById(R.id.txtFemale);
		
		setMaleSelected();
		
		txtProgress=(TextView)findViewById(R.id.txtProgress);
		txtTotalProgress=(TextView)findViewById(R.id.txtTotalProgress);
		
		
		etUserName.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtUserNameError);
				txtProgress.setText(""+s.length());
				if (s.length() > 20) {
					txtProgress.setTextColor(getResources().getColor(R.color.red));
					txtTotalProgress.setTextColor(getResources().getColor(R.color.red));
				} else {
					txtProgress.setTextColor(getResources().getColor(R.color.black));
					txtTotalProgress.setTextColor(getResources().getColor(R.color.black));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
		etEmailAddress.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtEmailError);
				rowEmail.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});
		
		etMobileNumber.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtMobileError);
				rowMobile.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));	
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
		etPassword.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtPasswordError);
				rowPassword.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));	
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});



	}

	@SuppressLint("NewApi") private void setMaleSelected() {
		LLMale.setBackground(getResources().getDrawable(R.drawable.shape_square_black_border));
		LLFeMale.setBackground(getResources().getDrawable(R.drawable.shape_square_gray_border));
		txtMale.setTextColor(getResources().getColor(R.color.black));
		txtFemale.setTextColor(getResources().getColor(R.color.gray));
		gender="1";
	}
	@SuppressLint("NewApi") private void setFemaleSelected() {
		LLFeMale.setBackground(getResources().getDrawable(R.drawable.shape_square_black_border));
		LLMale.setBackground(getResources().getDrawable(R.drawable.shape_square_gray_border));
		txtFemale.setTextColor(getResources().getColor(R.color.black));
		txtMale.setTextColor(getResources().getColor(R.color.gray));
		gender="2";
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_registre, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id ==android.R.id.home) {
			onBackPressed();
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("NewApi") @Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnRegister:
			if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
			getDetails();
			} else {
				IOUtils.mySnackBarInternet(BASE_CONTEXT,rootView);
			}
			break;
		case R.id.LLMale:
			setMaleSelected();
			break;	
		case R.id.LLFeMale:
			setFemaleSelected();
			break;	
		case R.id.txtShow:
			if(!isShow){  
				isShow=true;
				etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				etPassword.setSelection(etPassword.getText().length());
				etPassword.setTypeface(FontUtils.getTypeFaceFontFutual(BASE_CONTEXT));
			}
			else{
				isShow=false;
				etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				etPassword.setSelection(etPassword.getText().length());
				etPassword.setTypeface(FontUtils.getTypeFaceFontFutual(BASE_CONTEXT));
			}
			
			break;	
			
		default:
			break;
		}

	}

	private void getDetails() {
		IOUtils.hideKeyBoard(BASE_CONTEXT);
		
		fullname=tilUserName.getEditText().getText().toString().trim();
		emailAddress=tilEmailAddress.getEditText().getText().toString().trim();
		password=tilPassword.getEditText().getText().toString().trim();
		mobileNo=tilMobileNumber.getEditText().getText().toString().trim();
		
		if(TextUtils.isEmpty(fullname)){
			setError(txtUserNameError, getString(R.string.register_error_username));
		}else if(fullname.length()>20){
			setError(txtUserNameError, getString(R.string.register_error_username_length));
		}else if(TextUtils.isEmpty(emailAddress)){
			setError(txtEmailError, getString(R.string.register_error_enter_email));
		}else if(!isValidEmail(emailAddress)){ 
			setError(txtEmailError, getString(R.string.register_error_enter_valid_email));
		}else if(TextUtils.isEmpty(password)){
			setError(txtPasswordError, getString(R.string.register_error_enter_password));
		}else if(password.length()<6){
			setError(txtPasswordError, getString(R.string.register_error_invalid_password));
		}else{
			
			hideAllView();
			 JSONObject jsonRequest = new JSONObject();
				try {
					jsonRequest.put(Constant.CUST_FIRST_NAME,fullname);
					jsonRequest.put(Constant.CUST_LAST_NAME,fullname);
					jsonRequest.put(Constant.CUST_USER_EMAIL,emailAddress);
					jsonRequest.put(Constant.CUST_USER_PASSWORD,password);
					jsonRequest.put(Constant.CUST_DAY,"");
					jsonRequest.put(Constant.CUST_MONTH,"");
					jsonRequest.put(Constant.CUST_YEAR,"");
					jsonRequest.put(Constant.CUST_GENDER,gender);
					jsonRequest.put(Constant.API_KEY,"");
					jsonRequest.put(Constant.API_USERNAME,"");
					jsonRequest.put(Constant.WEBSITE_ID,"");
					jsonRequest.put(Constant.CURRENCY,"");
					jsonRequest.put(Constant.LANGUAGE,"");
					jsonRequest.put(Constant.NEWS_LETTER,"");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
					IOUtils.printLogDebug("URL - "+Constant.URL_CUSTOMER_REGISTER);
					new HttpVolleyRequest(BASE_CONTEXT, jsonRequest, Constant.URL_CUSTOMER_REGISTER, listenerRegister);
				} else {
					IOUtils.mySnackBarInternet(BASE_CONTEXT, rootView);
				}
		}
	}
	
	MyListener listenerRegister=new MyListener() {
		@Override
		public void success(Object obj) {
			JSONObject joResponse=(JSONObject)obj;
			if (joResponse != null) {
				JsonParserUtil.getRegisterResponse(joResponse, BASE_CONTEXT);
			}
		}
		@Override
		public void failure(Object obj) {
			
		}
	};
	
	public void setError(TextView txtView,String message){
		txtView.setVisibility(View.VISIBLE);
		txtView.setText(message);
	}
	
	public void hideTextView(TextView txtView){
		txtView.setVisibility(View.GONE);
	}
	
	public void hideAllView(){
		txtMobileError.setVisibility(View.GONE);
		txtEmailError.setVisibility(View.GONE);
		txtPasswordError.setVisibility(View.GONE);
		txtUserNameError.setVisibility(View.GONE);
	}
	

	
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		switch (v.getId()) {
		case R.id.etUserName:

			if(hasFocus){
				rowUsername.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			}else{
				rowUsername.setBackgroundColor(getResources().getColor(R.color.gray));
			}
			break;
		case R.id.etMobileNumber:
			if(hasFocus){
				rowMobile.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			}else{
				rowMobile.setBackgroundColor(getResources().getColor(R.color.gray));
			}
			break;
		case R.id.etPassword:
			if(hasFocus){
				rowPassword.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			}else{
				rowPassword.setBackgroundColor(getResources().getColor(R.color.gray));
			}
			break;
		case R.id.etEmailAddress:
			if(hasFocus){
				rowEmail.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			}else{
				rowEmail.setBackgroundColor(getResources().getColor(R.color.gray));
			}
		default:
			break;
		}

	}
}
