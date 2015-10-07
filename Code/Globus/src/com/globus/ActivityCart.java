package com.globus;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.globus.adapter.AdapterCart;
import com.globus.base.BaseClass;
import com.globus.fontutil.FontUtils;
import com.globus.model.ModelCart;
import com.globus.model.ModelCartProduct;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.JsonParserUtil;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.IOUtils;
import com.globus.util.PreferenceConnector;

public class ActivityCart extends BaseClass implements OnClickListener{

	 private RecyclerView recycler_view;
	 RelativeLayout rootView;
	 ModelCart recordCart;
	 AdapterCart mAdapter;
	 TextView txtItems,txtTotal,txtHeaderRemoveItem,txtHeaderRemoveConfirm,txtTitle;
	 Toolbar main_toolbar;
	 Button btnContinue,btnPlaceOrder,btnRemove,btnCancel;	 
	 LinearLayout LLRemove,LLPlaceOrder;
	 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		init();
		
		if(IOUtils.isInternetPresent(BASE_CONTEXT)){
			//getCartItems();
		}else
			IOUtils.mySnackBarInternet(BASE_CONTEXT, rootView);
			
	}

	private void getCartItems() {
		try {
			JSONObject jsonRequest = new JSONObject();
			
			String email=PreferenceConnector.getCurrentUser(BASE_CONTEXT).getUserEmail();
			String userId=PreferenceConnector.getCurrentUser(BASE_CONTEXT).getUserId();
			jsonRequest.put(Constant.USER_EMAIL,"salman.ms@iksula.com");
			jsonRequest.put(Constant.USER_ID, "213899");
			
			new HttpVolleyRequest(BASE_CONTEXT, jsonRequest, Constant.URL_CHECKOUT_VIEW_CART, listenerGetCartItems);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	

	MyListener listenerGetCartItems=new MyListener() {
		@Override
		public void success(Object obj) {
			JSONObject jsonResponse=(JSONObject)obj;
				recordCart=JsonParserUtil.getCheckOutCartResponse(jsonResponse, BASE_CONTEXT);
			if (recordCart != null && recordCart.getModelCartProduct() != null&& recordCart.getModelCartProduct().size() > 0) {
				setRecyclerAdapter();
			 }
		}
		@Override
		public void failure(Object obj) {
			
		}
	};

	private void init() {
		BASE_CONTEXT=ActivityCart.this;
		rootView=(RelativeLayout)findViewById(R.id.rootView);
		
		main_toolbar=(Toolbar)findViewById(R.id.main_toolbar);
		txtTitle=(TextView)main_toolbar.findViewById(R.id.txtTitle);
		setSupportActionBar(main_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		txtTitle.setText("My Cart");
		
		
		LLRemove=(LinearLayout)findViewById(R.id.LLRemove);
		LLPlaceOrder=(LinearLayout)findViewById(R.id.LLPlaceOrder);
		
		btnContinue=(Button)findViewById(R.id.btnContinue);
		btnPlaceOrder=(Button)findViewById(R.id.btnPlaceOrder);
		btnPlaceOrder.setTypeface(FontUtils.getTypeFaceFontFuturam(BASE_CONTEXT));
		btnContinue.setTypeface(FontUtils.getTypeFaceFontFuturam(BASE_CONTEXT));
		
		
		btnRemove=(Button)findViewById(R.id.btnRemove);
		btnCancel=(Button)findViewById(R.id.btnCancel);
		btnRemove.setTypeface(FontUtils.getTypeFaceFontFuturam(BASE_CONTEXT));
		btnCancel.setTypeface(FontUtils.getTypeFaceFontFuturam(BASE_CONTEXT));
		
		txtHeaderRemoveItem=(TextView)findViewById(R.id.txtHeaderRemoveItem);
		txtHeaderRemoveConfirm=(TextView)findViewById(R.id.txtHeaderRemoveConfirm);
		
		txtItems=(TextView)findViewById(R.id.txtItems);
		txtTotal=(TextView)findViewById(R.id.txtTotal);
		
		recycler_view=(RecyclerView)findViewById(R.id.recycler_view);
		recycler_view.setLayoutManager(new LinearLayoutManager(BASE_CONTEXT));
		
		
		sampleAdapter();
	}

	

	protected void setRecyclerAdapter() {
			mAdapter = new AdapterCart(BASE_CONTEXT, recordCart);
			recycler_view.setAdapter(mAdapter);
		
	}

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
	
	private void sampleAdapter() {
		ModelCart cart=new ModelCart();
		ArrayList<ModelCartProduct> list=new ArrayList<ModelCartProduct>();
		ModelCartProduct record1 = new ModelCartProduct();
		record1.setCartItemId(123);
		record1.setProductId(100);
		record1.setProductName("Levis T shirt");
		record1.setProductQty(10);
		record1.setProductPrice(150.00);
		list.add(record1);

		ModelCartProduct record2 = new ModelCartProduct();
		record2.setCartItemId(123);
		record2.setProductId(100);
		record2.setProductName("Le Cooper");
		record2.setProductQty(10);
		record2.setProductPrice(1000.00);
		list.add(record2);
		
		ModelCartProduct record3 = new ModelCartProduct();
		record3.setCartItemId(123);
		record3.setProductId(100);
		record3.setProductName("Jockey boxer");
		record3.setProductQty(10);
		record3.setProductPrice(325.00);
		list.add(record3);
		
		cart.setModelCartProduct(list);
		
		mAdapter=new AdapterCart(BASE_CONTEXT, cart);
		recycler_view.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnContinue:
			break;

		case R.id.btnPlaceOrder:
			break;
		case R.id.btnCancel:
			LLPlaceOrder.setVisibility(View.VISIBLE);
			LLRemove.setVisibility(View.GONE);
			break;
		case R.id.btnRemove:
			break;

		default:
			break;
		}

	}
}
