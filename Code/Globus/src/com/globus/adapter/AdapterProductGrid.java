package com.globus.adapter;

import java.util.ArrayList;

import com.android.volley.toolbox.ImageLoader;
import com.globus.R;
import com.globus.app.GlobusApp;
import com.globus.model.ModelProduct;
import com.globus.model.ProductGridHolder;
import com.globus.model.ProductHeaderHolder;
import com.globus.util.IOUtils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.view.ViewGroup;

public class AdapterProductGrid extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    
	private ArrayList<ModelProduct> products;
	private Context context;
	private ImageLoader mImageLoader= GlobusApp.getInstance().getImageLoader();
	private boolean isVisible;
	
	public AdapterProductGrid(ArrayList<ModelProduct> products, Context context) {
		super();
		Log.e("AdapterProductGrid", "AdapterProductGrid");
		this.products= products;
		this.context= context;
		/*for (int i = 0; i < products.size(); i++) {
			Log.e("AdapterProductGrid", i+" "+ products.get(i).toString());
		}*/
	}
	
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		Log.e("AdapterProductGrid", "onCreateViewHolder");
		if(viewType == TYPE_HEADER){
			View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_product_list_header, null);
			ProductHeaderHolder viewHolder= new ProductHeaderHolder(v, this.context);
			return viewHolder;
		}else if(viewType == TYPE_ITEM){
			View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_sub_category_gridview, null);
			ProductGridHolder viewHolder= new ProductGridHolder(v, this.context);
			return viewHolder;
		}
		return null;
	}

	@Override
	public int getItemCount() {
		Log.e("AdapterProductGrid", "getItemCount");
		return products.size()+1;
	}
	
	@Override
    public int getItemViewType(int position) {
		return isPositionHeader(position) ? TYPE_HEADER : TYPE_ITEM;
    }
	
	public boolean isPositionHeader(int position) {
        return position == 0;
    }
	
	@Override
	public void onBindViewHolder(final ViewHolder viewHolder, int position) {
		Log.e("AdapterProductGrid", "onBindViewHolder "+ (position-1));
		
		if(viewHolder instanceof ProductGridHolder){
			((ProductGridHolder) viewHolder).tag= position-1;
			ModelProduct product= this.products.get(position-1);
			IOUtils.setImageToNetworkImageView(((ProductGridHolder) viewHolder).imgProductImage, product.getImageUrl());
			/*if(!TextUtils.isEmpty(String.valueOf(product.getImageUrl()))){
				Log.e("AdapterProductGrid", position+":"+ String.valueOf(product.getImageUrl()));
				viewHolder.imgProductImage.setDefaultImageResId(R.drawable.ic_launcher);
				viewHolder.imgProductImage.setErrorImageResId(R.drawable.ic_launcher);
				viewHolder.imgProductImage.setAdjustViewBounds(true);
				viewHolder.imgProductImage.setImageUrl(String.valueOf(product.getImageUrl()), GlobusApp.getInstance().getImageLoader());
			}else{
				viewHolder.imgProductImage.setDefaultImageResId(R.drawable.ic_launcher);
			}*/
	
			if(!TextUtils.isEmpty(product.getProductName())){
				((ProductGridHolder) viewHolder).txtProductTitle.setText(product.getProductName());
			}
			if(!TextUtils.isEmpty(String.valueOf(product.getPrice()))){
				((ProductGridHolder) viewHolder).txtProductSellingPrice.setText(String.valueOf(product.getPrice()));
			}
			if(!TextUtils.isEmpty(String.valueOf(product.getPrice()))){
				((ProductGridHolder) viewHolder).txtProductActualPrice.setText(String.valueOf(product.getPrice()));
			}
	
			if(product.getIsViewVisible() == false){
				if(isVisible){
					slideToDown(((ProductGridHolder) viewHolder));
				}else{
					((ProductGridHolder) viewHolder).llProductOverlap.setVisibility(View.GONE);
					isVisible= false;
				}
			}else{
				((ProductGridHolder) viewHolder).llProductOverlap.setVisibility(View.VISIBLE);
				slideToAbove(((ProductGridHolder) viewHolder).rlContainerProductOverlap);
				isVisible= true;
			}
			
			((ProductGridHolder) viewHolder).imgProductMenu.setOnClickListener(new OnClickListener() {
	
				@Override
				public void onClick(View v) {
					onClickButtonProductMenu(((ProductGridHolder) viewHolder));
				}
			});
			((ProductGridHolder) viewHolder).imgOverlapAddToWishList.setOnClickListener(new OnClickListener() {
	
				@Override
				public void onClick(View v) {
					onClickButtonAddToWishList(((ProductGridHolder) viewHolder));
				}
			});
			((ProductGridHolder) viewHolder).imgOverlapSimilar.setOnClickListener(new OnClickListener() {
	
				@Override
				public void onClick(View v) {
					onClickButtonOverlapSimilar(((ProductGridHolder) viewHolder));
				}
			});
		}else if(viewHolder instanceof ProductHeaderHolder){
			((ProductHeaderHolder) viewHolder).imgProductListTop.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//code for header click
					IOUtils.myToast("header clicked", context);
				}
			});
			return;
		}
	}

	
	
	private void onClickButtonProductMenu(ProductGridHolder viewHolder) {
		for (int i = 0; i < this.products.size(); i++) {
			if(i != viewHolder.tag){
				this.products.get(i).setViewVisible(false);
			}else{
				if(this.products.get(i).getIsViewVisible() ==false){
					this.products.get(i).setViewVisible(true);
				}else{
					this.products.get(i).setViewVisible(false);
				}
			}
		}
		notifyDataSetChanged();
	}

	private void onClickButtonAddToWishList(ProductGridHolder viewHolder) {

	}

	private void onClickButtonOverlapSimilar(ProductGridHolder viewHolder) {

	}

	public void slideToAbove(final View view) {
		Animation slide= null;
		/*slide= new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, -5.0f);*/
		slide= new TranslateAnimation(0.0f,0.0f,0.0f,-20f);
		slide.setDuration(10);
	    slide.setFillAfter(true);
	    slide.setFillBefore(false);
	    slide.setFillEnabled(true);
	    
	    view.startAnimation(slide);
	    
	    slide.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(view.getWidth(), view.getHeight());
	            //lp.bottomMargin= 10;
	            //lp.topMargin= 30;
	            //lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	            view.setLayoutParams(lp);
	            //view.clearAnimation();
			}
		});
	}
	
	public void slideToDown(final ProductGridHolder viewHolder) {
		Animation slide= null;
		/*slide= new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 5.2f);*/
		slide= new TranslateAnimation(0.0f,0.0f,0.0f,100f);
		slide.setDuration(200);
	    slide.setFillAfter(true);
	    slide.setFillBefore(false);
	    slide.setFillEnabled(true);
	    
	    viewHolder.rlContainerProductOverlap.startAnimation(slide);
	    slide.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				/*LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(view.getWidth(), view.getHeight());
	            lp.topMargin= 70;
	            //lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	            view.setLayoutParams(lp);*/
	            //view.clearAnimation();
				viewHolder.llProductOverlap.setVisibility(View.GONE);
				isVisible= false;
				//viewHolder.llProductOverlap.clearAnimation();
			}
		});
	}

	
}
