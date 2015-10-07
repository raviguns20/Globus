package com.globus.servercall;

import java.util.HashMap;

import org.json.JSONObject;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.globus.app.GlobusApp;
import com.globus.util.IOUtils;

public class HttpVolleyRequest {

	Context mContext;
	HashMap<String, String> map;
	MyListener listener;
	GlobusApp app;
	JSONObject jsonRequest;
	String requestUrl;

	public HttpVolleyRequest(Context mContext,JSONObject jsonRequest,String requestUrl, MyListener listener) {
		IOUtils.printLogError(jsonRequest.toString());
		this.mContext = mContext;
		this.requestUrl = requestUrl;
		this.jsonRequest = jsonRequest;
		this.listener = listener;
		app = (GlobusApp)this.mContext.getApplicationContext();
		doPostOperation();
	}
	
	//---------------------------- POST JSON OBJECT REQUEST------------------------------
	public void doPostOperation() {
		IOUtils.startLoadingPleaseWait(mContext);
		JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST,requestUrl,jsonRequest, listenerSuccess, listenerError);
		request.setRetryPolicy(new DefaultRetryPolicy(10*1000,1,1.0f));
		app.addToRequestQueue(request, "post");
	}
	
	
	//----------------------- LISTENER'S---------------------------------------------
	
	Response.Listener<JSONObject> listenerSuccess=new Listener<JSONObject>() {
		@Override
		public void onResponse(JSONObject jsonObject) {
			IOUtils.printLogError(jsonObject.toString());
			IOUtils.stopLoading();
			listener.success(jsonObject);
		}
		
	};
	
	Response.ErrorListener listenerError=new Response.ErrorListener() {
		@Override
		public void onErrorResponse(VolleyError e) {
			
			IOUtils.printLogError(e.getMessage());
			IOUtils.stopLoading();
			listener.failure(e.getMessage());
		}
	};
	
	
	
	

	/*StringRequest postRequest = new StringRequest(Request.Method.POST, "",
			new Response.Listener<String>() {
				@Override
				public void onResponse(String response) {
					try {
						JSONObject jsonResponse = new JSONObject(response)
								.getJSONObject("form");
						String site = jsonResponse.getString("site"), network = jsonResponse
								.getString("network");
						System.out.println("Site: " + site + "\nNetwork: "
								+ network);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					error.printStackTrace();
				}
			}) {
		@Override
		protected Map<String, String> getParams() {
			Map<String, String> params = new HashMap<String, String>();
			// the POST parameters:
			params.put("site", "code");
			params.put("network", "tutsplus");
			return params;
		}
	};*/
	
/*	StringRequest requestString = new StringRequest(Request.Method.POST,
			map.get("url"), new Listener<String>() {
				@Override
				public void onResponse(String response) {
					IOUtils.stopLoading();
					if (TextUtils.isEmpty(response)) {
						listener.failure("failed");
					} else {
						listener.success(response);
					}

				}
			}, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError e) {
					IOUtils.stopLoading();
					listener.failure("failed" + e.getMessage());
				}

			}) {
		@Override
		protected Map<String, String> getParams() throws AuthFailureError {
			 Map<String, String>  params = new HashMap<String, String>();
			 Set<String> strValues=params.keySet();
			 for(String key:strValues){
				 params.put(key,params.get(key));	 
			 }
			 
			return params;
		}
	};*/

}
