package com.globus;


import java.util.ArrayList;
import java.util.List;

import com.globus.adapter.AdapterRecycler;
import com.globus.adapter.AdapterProductDetailsViewPager;
import com.globus.base.BaseClass;
import com.globus.model.ModelProduct;
import com.globus.util.Constant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivityProductDetails extends BaseClass implements ViewPager.OnPageChangeListener,OnClickListener {

	RelativeLayout  rootView;
	private ViewPager viewPager;
	LinearLayout LLviewPagerIndicator,LLmore,LLdeliveryOption,LLreview,LLfeatureItem;
	private int dotsCount;
	private ImageView[] dots;
	private AdapterProductDetailsViewPager mAdapterViewPage;
	RecyclerView recyclerView ;
	private AdapterRecycler adapterRecycler;
	ImageView imgAddToWishlit;
	Button btnAddToCart,btnBuyNow;
	TextView txtProductName,txtSmallSize,txtMediumSize,txtCategoryName,txtLargeSize,txtExtraLargeSize,txtProductDescription,txtSizingHelp,txtDeliveryPinCode,txtChange,txtSellingPrice,txtProductPrice,txtProductDiscount;
	ArrayList<ModelProduct>modelProductList = new ArrayList<ModelProduct>();

	ArrayList<String>imglist = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_details);
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
		BASE_CONTEXT =ActivityProductDetails.this;
		Toolbar mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		rootView = (RelativeLayout)findViewById(R.id.rootView);
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		LLviewPagerIndicator = (LinearLayout)findViewById(R.id.LLviewPagerIndicator);
		txtProductName=(TextView)findViewById(R.id.txtProductName);
		txtProductDescription=(TextView)findViewById(R.id.txtProductDescription);
		txtCategoryName=(TextView)findViewById(R.id.txtCategoryName);
		txtChange=(TextView)findViewById(R.id.txtSizingHelp);
		txtSizingHelp=(TextView)findViewById(R.id.txtChange);
		txtDeliveryPinCode=(TextView)findViewById(R.id.txtDeliveryPinCode);
		LLmore =(LinearLayout)findViewById(R.id.LLmore);
		LLdeliveryOption=(LinearLayout)findViewById(R.id.LLdeliveryOption);
		LLreview=(LinearLayout)findViewById(R.id.LLreview);
		imgAddToWishlit =(ImageView)findViewById(R.id.imgAddToWishlit);
		txtSmallSize =(TextView)findViewById(R.id.txtSmallSize);
		txtMediumSize =(TextView)findViewById(R.id.txtMediumSize);
		txtLargeSize =(TextView)findViewById(R.id.txtLargeSize);
		txtExtraLargeSize =(TextView)findViewById(R.id.txtExtraLargeSize);
		btnAddToCart =(Button)findViewById(R.id.btnAddToCart);
		btnBuyNow =(Button)findViewById(R.id.btnBuyNow);
		LLfeatureItem =(LinearLayout)findViewById(R.id.LLfeatureItem);
		txtSellingPrice=(TextView)findViewById(R.id.txtSellingPrice);
		txtProductPrice=(TextView)findViewById(R.id.txtProductPrice);
		txtProductPrice.setPaintFlags(txtProductPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
		txtProductPrice.setText(getString(R.string.txt_rs)+"999");
		txtProductDiscount=(TextView)findViewById(R.id.txtProductDiscount);

		btnAddToCart.setOnClickListener(this);
		btnBuyNow.setOnClickListener(this);
		txtChange.setOnClickListener(this);
		txtSizingHelp.setOnClickListener(this);
		imgAddToWishlit.setOnClickListener(this);
		LLdeliveryOption.setOnClickListener(this);
		txtSmallSize.setOnClickListener(this);
		txtMediumSize.setOnClickListener(this);
		txtLargeSize.setOnClickListener(this);
		txtExtraLargeSize.setOnClickListener(this);
		LLreview.setOnClickListener(this);
		LLmore.setOnClickListener(this);


		imglist.add("http://globusstores.incomenterprise.com/media/mobileapp/banners/main_banner_01.png?");
		imglist.add("http://globusstores.incomenterprise.com/media/mobileapp/banners/main_banner_02.png?");
		imglist.add("http://globusstores.incomenterprise.com/media/mobileapp/banners/main_banner_03.png?");
		imglist.add("http://globusstores.incomenterprise.com/media/mobileapp/banners/main_banner_04.png?");

		for (int i = 0; i < imglist.size(); i++) {
			modelProductList.add(new ModelProduct(imglist.get(i),"ProductName"));
		}

		viewFeatures(LLfeatureItem);
		mAdapterViewPage = new AdapterProductDetailsViewPager(ActivityProductDetails.this, modelProductList);
		viewPager.setAdapter(mAdapterViewPage);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(this);


		LinearLayoutManager layoutManager
		= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(layoutManager);




		adapterRecycler = new AdapterRecycler(ActivityProductDetails.this, modelProductList);
		recyclerView.setAdapter(adapterRecycler);


		setUiPageViewController();

		txtProductDescription.setText(getString(R.string.no_txt));

	}

	private void viewFeatures(final LinearLayout featureItemLL2) {
		// TODO Auto-generated method stub
		ArrayList<String>list = new ArrayList<String>();
		ArrayList<String>list2 = new ArrayList<String>();
		//		list.add("Color");
		//		list.add("Fabric");
		//		list.add("Fit");
		//		list.add("Neck");
		//		list.add("Ocassion");
		//		list.add("Pattern");
		//		list.add("Sleeves");
		//		list2.add("Red");
		//		list2.add("Cotton");
		//		list2.add("Fit");
		//		list2.add("Neck");
		//		list2.add("Casual");
		//		list2.add("Solides");
		///		list2.add("Half Sleeves");

		LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
		View view = inflater.inflate(R.layout.featureitem_row, null);  
		TextView txtItemName = (TextView)view.findViewById(R.id.txtItemName);
		TextView txtItemValue = (TextView)view.findViewById(R.id.txtItemValue);

		// for (int i = 0; i < list.size(); i++) {

		txtItemName.setText(getString(R.string.no_txt));
		//txtItemValue.setText(list2.get(i));

		//			 featureItemLL2.removeAllViews();

		//}
		featureItemLL2.addView(view); 

	}

	private void setUiPageViewController() {

		dotsCount = mAdapterViewPage.getCount();
		dots = new ImageView[dotsCount];

		for (int i = 0; i < dotsCount; i++) {
			dots[i] = new ImageView(this);
			dots[i].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_nonselected));

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT
					);

			params.setMargins(4, 0, 4, 0);

			LLviewPagerIndicator.addView(dots[i], params);
		}

		dots[0].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_selected));
	}

	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int position, float arg1, int arg2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dotsCount; i++) {
			dots[i].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_nonselected));
		}

		dots[position].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_selected));
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imgAddToWishlit:
			break;
		case R.id.txtSmallSize:
			break;
		case R.id.txtMediumSize:
			break;
		case R.id.txtLargeSize:
			break;
		case R.id.txtExtraLargeSize:
			break;
		case R.id.txtChange:
			break;
		case R.id.txtSizingHelp:
			break;
		case R.id.LLdeliveryOption:
			break;
		case R.id.LLreview:
			break;
		case R.id.LLmore:
			break;
		case R.id.btnAddToCart:
			//			Intent intent = new Intent(BASE_CONTEXT,ActivityWishlist.class);
			//			startActivity(intent);
			break;
		case R.id.btnBuyNow:
			break;
		}//btnAddToCart btnBuyNow
	}

}
