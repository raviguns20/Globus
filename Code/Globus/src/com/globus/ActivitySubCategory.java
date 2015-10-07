package com.globus;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.globus.adapter.AdapterProductGrid;
import com.globus.base.BaseClass;
import com.globus.fontutil.TextView_FUTURAM;
import com.globus.model.ModelProduct;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.EndlessGridAndHideFooterRecyclerScrollChangeListener;
import com.globus.util.IOUtils;
import com.globus.util.SpaceItemDecoration;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivitySubCategory extends BaseClass implements OnClickListener {

	private Context mContext;
	private RecyclerView recyclerViewProducts;
	private GridLayoutManager mLayoutManager;
	private AdapterProductGrid mAdapter;
	private ArrayList<ModelProduct> products;
	private RelativeLayout rootView;
	private ImageView imgProductListTop;
	private TextView_FUTURAM btnSort;
	private TextView_FUTURAM btnFilter;
	private LinearLayout llProductListBottom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_sub_category);

		init();
	}

	private void init() {
		mContext= ActivitySubCategory.this;
		
		products= new ArrayList<ModelProduct>();
		products.add(new ModelProduct(1, "EYECARE 5", 100, "http://adcstg.iksulalive.com/media/mobileapp/banners/Shipping-Website.jpg?", false));
		products.add(new ModelProduct(2, "Free Shipping", 101, "http://adcstg.iksulalive.com/media/catalog/product/resized/400x400/sku_362_1.jpg?", false));
		products.add(new ModelProduct(3, "Tiova Rotacaps  - 18 mcg", 102, "http://adcstg.iksulalive.com/media/catalog/product/resized/400x400/sku_1123_1.jpg?", false));
		products.add(new ModelProduct(4, "Valzaar  - 80 mg", 103, "http://adcstg.iksulalive.com/media/catalog/product/resized/400x400/sku_1169_1.jpg?", false));
		products.add(new ModelProduct(5, "Efavir  - 600  mg", 104, "http://adcstg.iksulalive.com/media/catalog/product/resized/400x400/sku_362_1.jpg?", false));

		rootView= (RelativeLayout)findViewById(R.id.rootView);

		recyclerViewProducts= (RecyclerView)findViewById(R.id.recyclerViewProducts);
		recyclerViewProducts.setHasFixedSize(true);
		int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.s0px);
		recyclerViewProducts.addItemDecoration(new SpaceItemDecoration(mContext, spacingInPixels, LinearLayoutManager.VERTICAL));
		
		//set grid layout manager to recyclerview 
		mLayoutManager= new GridLayoutManager(mContext, 2);
		recyclerViewProducts.setLayoutManager(mLayoutManager);
		
		mAdapter= new AdapterProductGrid(products, mContext);
		recyclerViewProducts.setAdapter(mAdapter);
		
		//set scroll listener on recyclerview to manage visibility of footer view
		recyclerViewProducts.setOnScrollListener(new EndlessGridAndHideFooterRecyclerScrollChangeListener(mLayoutManager){
			@Override
			public void onHideFooterView() {
				super.onHideFooterView();
				llProductListBottom.setVisibility(View.GONE);
			}
			
			@Override
			public void onShowFooterView() {
				super.onShowFooterView();
				llProductListBottom.setVisibility(View.VISIBLE);
			}
			
			@Override
			public void onLoadMore(int current_page) {
				super.onLoadMore(current_page);
			}
		});

		//set span size of gridlayoutmanager to 1 for header and 2 for below items
		mLayoutManager.setSpanSizeLookup(new SpanSizeLookup() {
			
			@Override
			public int getSpanSize(int position) {
				return mAdapter.isPositionHeader(position)?mLayoutManager.getSpanCount():1;
			}
		}); 

		llProductListBottom= (LinearLayout)findViewById(R.id.llProductListBottom);

		btnSort= (TextView_FUTURAM)findViewById(R.id.btnSort);
		btnFilter= (TextView_FUTURAM)findViewById(R.id.btnFilter);

		btnFilter.setOnClickListener(this);
		btnSort.setOnClickListener(this);

		try {
			JSONObject obj= new JSONObject();
			obj.put(Constant.USER_EMAIL, "satyendraiksula@gmail.com");
			obj.put(Constant.USER_ID, 25562);
			obj.put(Constant.API_KEY, "aazfcsdzfcvsdazgvsagdvsfdgvsfdgvfds");
			obj.put(Constant.API_USERNAME, "test");
			obj.put(Constant.CURRENCY, "US");
			obj.put(Constant.LANGUAGE, "INR");
			obj.put(Constant.WEBSITE_ID, 1);
			obj.put(Constant.CAT_CATEGORY_ID, 1);
			
			if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
				HttpVolleyRequest request= new HttpVolleyRequest(mContext, obj, Constant.URL_CATALOG_CATEGORY, categoryListener);
			} else {
				IOUtils.mySnackBarInternet(BASE_CONTEXT, rootView);
			}
			
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
	}

	MyListener categoryListener= new MyListener() {

		@Override
		public void success(Object obj) {
			Log.e("response", "Success: "+ obj.toString());
		}

		@Override
		public void failure(Object obj) {
			Log.e("response", "Failure: "+ obj.toString());
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSort:
			onButtonSortClick();
		break;

		case R.id.btnFilter:
			onButtonFilterClick();
		break;

		default:
			break;
		}
	}

	private void onButtonSortClick() {
		
	}

	private void onButtonFilterClick() {
		
	}
}
