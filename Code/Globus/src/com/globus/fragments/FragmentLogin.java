package com.globus.fragments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.globus.ActivityLoginContainer;
import com.globus.R;
import com.globus.base.BaseClass;
import com.globus.fontutil.FontUtils;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.JsonParserUtil;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.IOUtils;
import com.globus.util.ParamUtil;

import android.R.bool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FragmentLogin extends Fragment implements OnClickListener {
	View view;
	TextInputLayout tilEmailAddress, tilPassword;
	EditText etEmailAddress,etPassword;
	LinearLayout rootView,row1,row2;
	RelativeLayout RLPassword; 
	Button btnLogin;
	boolean isVisible=false;
	TextView txtForgotPassword,txtLoginError,txtPasswordError,txtShow;
	BaseClass activity;
	boolean isShow=false;
	TextView[] txtArray;
			
	@Override
	public void onStart() {
		super.onStart();
		ActivityLoginContainer container=(ActivityLoginContainer)getActivity();
		container.setToolBatTitle("Login");
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity=(BaseClass)getActivity();
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_login,container,false);
		init();
		return view;
	}
	

	private void init() {
		tilEmailAddress = (TextInputLayout)view.findViewById(R.id.tilEmailAddress);
		tilPassword = (TextInputLayout) view.findViewById(R.id.tilPassword);
		
		txtLoginError=(TextView)view.findViewById(R.id.txtLoginError);
		txtPasswordError=(TextView)view.findViewById(R.id.txtPasswordError);
		txtShow=(TextView)view.findViewById(R.id.txtShow);
		txtShow.setOnClickListener(this);
		FontUtils.setTypefaceFonttt144(activity, txtShow);
		
		etEmailAddress=(EditText)tilEmailAddress.findViewById(R.id.etEmailAddress);
		etEmailAddress.setTypeface(FontUtils.getTypeFaceFontFutual(getActivity()));
		
		etPassword=(EditText)tilPassword.findViewById(R.id.etPassword);
		etPassword.setTypeface(FontUtils.getTypeFaceFontFutual(getActivity()));
		
		btnLogin=(Button)view.findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(this);
		btnLogin.setTypeface(FontUtils.getTypeFaceFontFuturam(getActivity()));
		
		txtForgotPassword=(TextView)view.findViewById(R.id.txtForgotPassword);
		txtForgotPassword.setOnClickListener(this);
		
		rootView=(LinearLayout)view.findViewById(R.id.rootView);
		
		row1=(LinearLayout)view.findViewById(R.id.row1);
		row2=(LinearLayout)view.findViewById(R.id.row2);
		
		
		etEmailAddress.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtLoginError);
				row1.setBackgroundColor(getActivity().getResources().getColor(R.color.color_global_yellow));
			}
			   
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
		
		etEmailAddress.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					row1.setBackgroundColor(getActivity().getResources().getColor(R.color.color_global_yellow));
				}else{
					row1.setBackgroundColor(getActivity().getResources().getColor(R.color.gray_light));
				}
			}
		});
		
		etPassword.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					row2.setBackgroundColor(getActivity().getResources().getColor(R.color.color_global_yellow));
				}else{
					row2.setBackgroundColor(getActivity().getResources().getColor(R.color.gray_light));
				}
			}
		});
		
		
		etPassword.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtPasswordError);
				row2.setBackgroundColor(getActivity().getResources().getColor(R.color.color_global_yellow));
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:
			if (IOUtils.isInternetPresent(getActivity())) {
				getDetails();
			} else {
				IOUtils.mySnackBar(getActivity(),getString(R.string.msg_internet_connection),rootView);
			}
			
			break;
		case R.id.txtForgotPassword:
			if (IOUtils.isInternetPresent(getActivity())) {
				FragmentForgotPassword fragmentForgotPass = new FragmentForgotPassword();
				activity.addFragment(fragmentForgotPass, false,"globus");
				
			} else {
				IOUtils.mySnackBar(getActivity(),getString(R.string.msg_internet_connection),rootView);
			}
			
			break;
		case R.id.txtShow:
			
			if(!isShow){  
				isShow=true;
				etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				etPassword.setSelection(etPassword.getText().length());
				etPassword.setTypeface(FontUtils.getTypeFaceFontFutual(getActivity()));
			}
			else{
				isShow=false;
				etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				etPassword.setSelection(etPassword.getText().length());
				etPassword.setTypeface(FontUtils.getTypeFaceFontFutual(getActivity()));
			}
			break;
			
		default:
			break;
		} 

	}
	
	private void getDetails() {
		IOUtils.hideKeyBoard(getActivity());
		String userEmail=tilEmailAddress.getEditText().getText().toString().trim();
		String password=tilPassword.getEditText().getText().toString().trim();
  
		if (TextUtils.isEmpty(userEmail)) {
			setError(txtLoginError, getString(R.string.login_error_enter_email));
			row1.setBackgroundColor(getResources().getColor(R.color.red));
		} else if(!isValidEmail(userEmail)){
			setError(txtLoginError, getString(R.string.login_error_enter_valid_email));
			row1.setBackgroundColor(getResources().getColor(R.color.red));
		} else if (TextUtils.isEmpty(password)) {
			setError(txtPasswordError, getString(R.string.login_error_enter_password));
			row2.setBackgroundColor(getResources().getColor(R.color.red));
		} else {
			 hideBothTextView();
			 JSONObject jsonRequest = new JSONObject();
			try {
				jsonRequest.put(Constant.CUST_USER_EMAIL,userEmail);
				jsonRequest.put(Constant.CUST_USER_PASSWORD,password);
				jsonRequest.put(Constant.API_KEY,ParamUtil.getApiKey());
				jsonRequest.put(Constant.API_USERNAME,ParamUtil.getApiUsername());
				jsonRequest.put(Constant.WEBSITE_ID,ParamUtil.getWebsiteId());
				jsonRequest.put(Constant.CURRENCY,ParamUtil.getCurrency());
				jsonRequest.put(Constant.LANGUAGE,"");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if (IOUtils.isInternetPresent(getActivity())) {
				IOUtils.printLogDebug("URL - "+Constant.URL_CUSTOMER_SOCIAL_LOGIN);
				new HttpVolleyRequest(getActivity(), jsonRequest, Constant.URL_CUSTOMER_LOGIN, listenerLogin);
			} else {
				IOUtils.mySnackBarInternet(getActivity(), rootView);
			}
		}
	}
	public void setError(TextView txtView,String message){
		txtView.setVisibility(View.VISIBLE);
		txtView.setText(message);
	}
	
	public void hideTextView(TextView txtView){
		txtView.setVisibility(View.GONE);
	}
	
	public void hideBothTextView(){
		txtLoginError.setVisibility(View.GONE);
		txtPasswordError.setVisibility(View.GONE);
	}
	
	MyListener listenerLogin=new MyListener() {
		@Override
		public void success(Object obj) {
			JSONObject joResponse=(JSONObject)obj;
			if(joResponse!=null)
			{
				JsonParserUtil.getLoginResponse(joResponse, getActivity());
			}
		}
		@Override
		public void failure(Object obj) {
			String message=(String)obj;
			if(!TextUtils.isEmpty(message))
			IOUtils.mySnackBar(getActivity(), message, rootView);
			
		}
	};
	boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
}
