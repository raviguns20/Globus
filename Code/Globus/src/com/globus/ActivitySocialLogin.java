/*
 * Copyright Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.globus;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.GraphJSONObjectCallback;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.globus.base.BaseClass;
import com.globus.model.ModelUser;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.JsonParserUtil;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.IOUtils;
import com.globus.util.ParamUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;


/**
 * Minimal activity demonstrating basic Google Sign-In.
 */
public class ActivitySocialLogin extends BaseClass implements
        View.OnClickListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {
		
	
	ModelUser recordUser;
	boolean isGoogleClicked=false;
	
    /* RequestCode for resolutions involving sign-in */
    private static final int RC_SIGN_IN = 9001;

    /* Keys for persisting instance variables in savedInstanceState */
    private static final String KEY_IS_RESOLVING = "is_resolving";
    private static final String KEY_SHOULD_RESOLVE = "should_resolve";

    /* Client for accessing Google APIs */
    private GoogleApiClient mGoogleApiClient;

    /* Is there a ConnectionResult resolution in progress? */
    private boolean mIsResolving = false;

    /* Should we automatically resolve ConnectionResults when possible? */
    private boolean mShouldResolve = false;

    /* FACEBOOK */
	private CallbackManager callbackManager;
	private LoginButton fbLoginButton;
	private LinearLayout rootView; 
	TextView txtLogin,txtRegister;
	Toolbar main_toolbar;
	ImageView img_profile_icon,img_profile_cart;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFacebook();
        setContentView(R.layout.activity_login_social);

        BASE_CONTEXT=ActivitySocialLogin.this;
        init();
        //getFaceBookKeyHash();
        // Restore from saved instance state 
        if (savedInstanceState != null) {
            mIsResolving = savedInstanceState.getBoolean(KEY_IS_RESOLVING);
            mShouldResolve = savedInstanceState.getBoolean(KEY_SHOULD_RESOLVE);
        }
       
        checkInternetConnection(BASE_CONTEXT, rootView);
        
    }  
    

	private void init() {
		// Set up view instances
		  
		main_toolbar=(Toolbar)findViewById(R.id.main_toolbar);
		setSupportActionBar(main_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		img_profile_icon=(ImageView)main_toolbar.findViewById(R.id.img_profile_icon);
		img_profile_icon.setVisibility(View.INVISIBLE);
		
		img_profile_cart=(ImageView)main_toolbar.findViewById(R.id.img_profile_cart);
		img_profile_cart.setOnClickListener(this);
		
        rootView=(LinearLayout)findViewById(R.id.rootView);
        txtLogin=(TextView)findViewById(R.id.txtLogin);
        txtRegister=(TextView)findViewById(R.id.txtRegister);
        txtLogin.setOnClickListener(this);
        txtRegister.setOnClickListener(this);
        
        
        // Build GoogleApiClient with access to basic profile
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API)
                .addScope(new Scope(Scopes.PROFILE))
                .build();
	}


	@SuppressWarnings("unused")
	private void updateUI(boolean isSignedIn) {
		
		if(!isGoogleClicked)
			return;
		
		if (isSignedIn) {
			 // Show signed-in user's name
             Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
			if (currentPerson != null) {
				recordUser = new ModelUser();
				String fullName = currentPerson.getDisplayName();
				String splitIt[] = fullName.split(" ");

				String firstName = splitIt[0];
				String lastName = splitIt[1];
				String email = Plus.AccountApi.getAccountName(mGoogleApiClient);

				recordUser.setFirstName(firstName);
				recordUser.setLastName(lastName);
				recordUser.setUserEmail(email);
				recordUser.setSocialId(currentPerson.getId());
				
				getDetails(recordUser);
				
				
				IOUtils.printLogDebug(firstName + "\n" + lastName + "\n"+ currentPerson.getId() + "\n" + email);
				//txtDetails.setText(getString(R.string.signed_in_fmt, fullName));
				
			} else {
			}

           
        } else {
            // Show signed-out message
        	//txtDetails.setText(R.string.signed_out);
        }
    }
 	
	
    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { 
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IS_RESOLVING, mIsResolving);
        outState.putBoolean(KEY_SHOULD_RESOLVE, mShouldResolve);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
       
        IOUtils.printLogError("onConnectionSuspended google:" + "onActivityResult:" + requestCode + ":" + resultCode + ":" + data);
        if (requestCode == RC_SIGN_IN) {
            // If the error resolution was not successful we should not resolve further errors.
            if (resultCode != RESULT_OK) {
                mShouldResolve = false;
            }
            mIsResolving = false;
            mGoogleApiClient.connect();
		} else {
			IOUtils.startLoadingPleaseWait(BASE_CONTEXT);
			callbackManager.onActivityResult(requestCode, resultCode, data);
		}
        
        
    }
    // [END on_activity_result]
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_cart, menu);
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
	

    @Override
    public void onConnected(Bundle bundle) {
        // onConnected indicates that an account was selected on the device, that the selected
        // account has granted any requested permissions to our app and that we were able to
        // establish a service connection to Google Play services.
    	IOUtils.printLogError("onConnected:" + bundle);
        updateUI(true);
    }

    @Override
    public void onConnectionSuspended(int i) {
        // The connection to Google Play services was lost. The GoogleApiClient will automatically
        // attempt to re-connect. Any UI elements that depend on connection to Google APIs should
        // be hidden or disabled until onConnected is called again.
    	IOUtils.printLogError("onConnectionSuspended:" + i);
    }

    // [START on_connection_failed]
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // Could not connect to Google Play Services.  The user needs to select an account,
        // grant permissions or resolve an error in order to sign in. Refer to the javadoc for
        // ConnectionResult to see possible error codes.
    	IOUtils.printLogError("onConnectionFailed:" + connectionResult);
       

        if (!mIsResolving && mShouldResolve) {
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this, RC_SIGN_IN);
                    mIsResolving = true;
                } catch (IntentSender.SendIntentException e) {
                	IOUtils.printLogError("Could not resolve ConnectionResult."+e.getMessage());
                    mIsResolving = false;
                    mGoogleApiClient.connect();
                }
            } else {
                // Could not resolve the connection result, show the user an
                // error dialog.
                showErrorDialog(connectionResult);
            }
        } else {
            updateUI(false);
        }
    }

    private void showErrorDialog(ConnectionResult connectionResult) {
        int errorCode = connectionResult.getErrorCode();

        if (GooglePlayServicesUtil.isUserRecoverableError(errorCode)) {
            // Show the default Google Play services error dialog which may still start an intent
            // on our behalf if the user can resolve the issue.
            GooglePlayServicesUtil.getErrorDialog(errorCode, this, RC_SIGN_IN,
                    new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            mShouldResolve = false;
                            updateUI(false);
                        }
                    }).show();
        } else {
            // No default Google Play Services error, display a message to the user.
            String errorString = getString(R.string.play_services_error_fmt, errorCode);
            Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show();

            mShouldResolve = false;
            updateUI(false);
        }
    }

    @Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnGoogle:
			// User clicked the sign-in button, so begin the sign-in process and
			// automatically
			// attempt to resolve any errors that occur.
			
			isGoogleClicked=true;
			
			if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
				//if (mGoogleApiClient.isConnected()) {
					//Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
					mGoogleApiClient.disconnect();

					mShouldResolve = true;
					mGoogleApiClient.connect();
				//}
			} else {
				IOUtils.mySnackBarInternet(BASE_CONTEXT,rootView);
			}

			break;
		case R.id.btnFacebook:
			if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
				FbLogin();
			} else {
				IOUtils.mySnackBar(BASE_CONTEXT,getString(R.string.msg_internet_connection), rootView);
			}
			break;
			
		case R.id.txtLogin:
			startActivity(new Intent(BASE_CONTEXT,ActivityLoginContainer.class));
			break;
			
		case R.id.txtRegister:
			startActivity(new Intent(BASE_CONTEXT,ActivityRegister.class));
			break;
			
		case R.id.img_profile_cart:
			startActivity(new Intent(BASE_CONTEXT,ActivityCart.class));
			break;
			
		
		}
	}

    
    //-------------------------------------- FACEBOOK INTEGRATION ------------------------------
    
    private void initFacebook() {
		 FacebookSdk.sdkInitialize(this.getApplicationContext());
	     callbackManager = CallbackManager.Factory.create();
	     createLoginCallBack();
	}
    
    private void FbLogin() {
		LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","public_profile"));
	}

	private void createLoginCallBack() {
		
		LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult result) {
				IOUtils.stopLoading();
				IOUtils.printLogDebug("AccessToken -- "+result.getAccessToken().getToken());
				IOUtils.printLogDebug("AccessToken = "+result.getAccessToken().toString());

				GraphRequest request = GraphRequest.newMeRequest(result.getAccessToken(), new GraphJSONObjectCallback() {
					@Override
					public void onCompleted(JSONObject json, GraphResponse response) {
						 if (response.getError() == null) {
							 IOUtils.printLogDebug(json.toString());
							 
							 try {
                                String jsonresult = String.valueOf(json);
                                IOUtils.printLogDebug("JSON Result"+jsonresult);
                                ModelUser record=new ModelUser();
                                
                                if(json.has("email")){
                                	record.setUserEmail(json.getString("email"));
                                }else{
                                	IOUtils.mySnackBar(BASE_CONTEXT, getString(R.string.fb_email_not_found), getCurrentFocus());
                                	//IOUtils.myToastLong(getString(R.string.fb_email_not_found), BASE_CONTEXT);
                                	return;
                                }
                                if(json.has("first_name")){
                                	record.setFirstName(json.getString("first_name"));
                                }
                                if(json.has("id")){
                                	record.setSocialId(json.getString("id"));
                                }
                                
                                if(json.has("last_name")){
                                	record.setLastName(json.getString("last_name"));
                                }
                               
                                recordUser=record;
                                getDetails(recordUser);
                                
                               // txtDetails.setText(recordUser.getFirstName());
                                
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } 
						 }
					}
				});
				
				Bundle parameters = new Bundle();
				parameters.putString("fields","id,name,email,first_name,last_name");
				request.setParameters(parameters);
				request.executeAsync();
				
			}
			
			@Override
			public void onError(FacebookException error) {
				IOUtils.stopLoading();
				IOUtils.printLogError("FACEBOOK "+error.getMessage());
			}
			
			@Override
			public void onCancel() {
				IOUtils.stopLoading();
				IOUtils.printLogError("Operation cancelled");
			}
		});
		
	}
    
	private void getFaceBookKeyHash() {
		try {
			PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				IOUtils.printLogError("KeyHash:"+ Base64.encodeToString(md.digest(), Base64.DEFAULT));
			}
		} catch (NameNotFoundException e) {
		} catch (NoSuchAlgorithmException e) {
		}

	}
	//-------------------------- PERFORM LOGIN OPERATION--------------------------------------------
	
		private void getDetails(ModelUser recordUser) {
		try {
			JSONObject param=new JSONObject();
			param.put(Constant.CUST_USER_EMAIL,recordUser.getUserEmail());
			param.put(Constant.CUST_FIRST_NAME,recordUser.getFirstName());
			param.put(Constant.CUST_LAST_NAME,recordUser.getLastName());
			param.put(Constant.CUST_USER_PASSWORD,IOUtils.generateRandomNumber(6));
			param.put(Constant.API_KEY,ParamUtil.getApiKey());
			param.put(Constant.API_USERNAME,ParamUtil.getApiUsername());
			param.put(Constant.WEBSITE_ID,ParamUtil.getWebsiteId());
			param.put(Constant.CURRENCY,ParamUtil.getCurrency());
			param.put(Constant.LANGUAGE,ParamUtil.getLanguage());
			IOUtils.printLogDebug("URL - "+Constant.URL_CUSTOMER_SOCIAL_LOGIN);
			if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
				new HttpVolleyRequest(BASE_CONTEXT, param, Constant.URL_CUSTOMER_SOCIAL_LOGIN, listenerLogin);
			} else {
				IOUtils.mySnackBarInternet(BASE_CONTEXT, rootView);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

		MyListener listenerLogin=new MyListener() {
			@Override
			public void success(Object obj) {
				isGoogleClicked=false;
				JSONObject response=(JSONObject)obj;
				String parsingResponse;
				
			if (response!=null) {
				parsingResponse = JsonParserUtil.getSocialLoginResponse(response,BASE_CONTEXT);
				if (TextUtils.isEmpty(parsingResponse)) {
					
				}
			} else
				IOUtils.myToast(getString(R.string.error_message), BASE_CONTEXT);
			}
			@Override
			public void failure(Object obj) {
				String message=(String)obj;
				if(!TextUtils.isEmpty(message))
				IOUtils.mySnackBar(BASE_CONTEXT, message, rootView);
				isGoogleClicked=false;
			}
		};
	
}
