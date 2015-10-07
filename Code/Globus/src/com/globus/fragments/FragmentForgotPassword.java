package com.globus.fragments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.globus.ActivityLoginContainer;
import com.globus.R;
import com.globus.base.BaseClass;
import com.globus.fontutil.FontUtils;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.JsonParserUtil;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.IOUtils;

public class FragmentForgotPassword extends Fragment implements OnClickListener{
	
	View view;
	Button btnResetPassword;
	EditText etEmailAddress;
	LinearLayout rootView,row1;
	TextView txtForgotPassError;
	BaseClass activity;
	 
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity=(BaseClass)getActivity();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		ActivityLoginContainer container=(ActivityLoginContainer)getActivity();
		container.setToolBatTitle("Forgot password?");
	}
	
	@Override   
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_forgot_password,container,false);
		init();
		return view;
	}

	private void init() {
		etEmailAddress=(EditText)view.findViewById(R.id.etEmailAddress);
		etEmailAddress.setTypeface(FontUtils.getTypeFaceFontFutual(getActivity()));
		btnResetPassword=(Button)view.findViewById(R.id.btnResetPassword);
		btnResetPassword.setTypeface(FontUtils.getTypeFaceFonttt144(getActivity()));
		rootView=(LinearLayout)view.findViewById(R.id.rootView);
		row1=(LinearLayout)view.findViewById(R.id.row1);
		btnResetPassword.setOnClickListener(this);
		txtForgotPassError=(TextView)view.findViewById(R.id.txtForgotPassError);
		
		etEmailAddress.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				hideTextView(txtForgotPassError);
				row1.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});
		
		
		etEmailAddress.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
			if(hasFocus){
				row1.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			}
			
			}
		});
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnResetPassword:
			
			if(IOUtils.isInternetPresent(getActivity()))
			{
				getDetails();
			}else{
				IOUtils.mySnackBarInternet(getActivity(), rootView);
			}
			
			break;

		default:
			break;
		}
		
	}

	private void getDetails() {
		IOUtils.hideKeyBoard(getActivity());
		String emailAddress=etEmailAddress.getText().toString().trim();
		
		if (TextUtils.isEmpty(emailAddress)) {
			row1.setBackgroundColor(getResources().getColor(R.color.red));
			txtForgotPassError.setVisibility(View.VISIBLE);
			txtForgotPassError.setText(getString(R.string.forgotpass_error_enter_email));
		} else if(!isValidEmail(emailAddress)){
			row1.setBackgroundColor(getResources().getColor(R.color.red));
			txtForgotPassError.setVisibility(View.VISIBLE);
			txtForgotPassError.setText(getString(R.string.forgotpass_error_enter_valid_email));
		}else{
			txtForgotPassError.setVisibility(View.GONE);
			row1.setBackgroundColor(getResources().getColor(R.color.color_global_yellow));
			JSONObject jsonRequest = new JSONObject(); 
			try {
				jsonRequest.put(Constant.CUST_USER_EMAIL,emailAddress);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if (IOUtils.isInternetPresent(getActivity())) {
				IOUtils.printLogDebug("URL - "+Constant.URL_CUSTOMER_FORGOT_PASSWORD);
				new HttpVolleyRequest(getActivity(), jsonRequest,Constant.URL_CUSTOMER_FORGOT_PASSWORD, listenerForgotPassword);
			} else {
				IOUtils.mySnackBar(getActivity(), getString(R.string.msg_internet_connection),rootView);
			}
		}
		
	}
	
	MyListener listenerForgotPassword=new MyListener() {
		
		@Override
		public void success(Object obj) {
			JSONObject joResponse=(JSONObject)obj;
			if(joResponse!=null)
			{
				String response=JsonParserUtil.getForgotPasswordResponse(joResponse, getActivity());
				if (TextUtils.isEmpty(response)) {
				} else {
					IOUtils.mySnackBar(getContext(), getString(R.string.forgotpass_msg_email_success), rootView);
				}
			}
		}
		
		@Override
		public void failure(Object obj) {
			String message=(String)obj;
			if(!TextUtils.isEmpty(message))
			IOUtils.mySnackBar(getActivity(), message, rootView);
		}
	};
	
	public void hideTextView(TextView txtView){
		txtView.setVisibility(View.GONE);
	}
	boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
