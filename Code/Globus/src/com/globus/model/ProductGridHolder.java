package com.globus.model;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.ActivityProductDetails;
import com.globus.R;
import com.globus.util.IOUtils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductGridHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
	public int tag;
	public NetworkImageView imgProductImage;
	public TextView txtProductTitle;
	public TextView txtProductSellingPrice;
	public TextView txtProductActualPrice;
	public TextView txtProductDiscount;
	public ImageView imgProductMenu;
	public LinearLayout llProductOverlap;
	public RelativeLayout rlContainerProductOverlap;
	public ImageView imgOverlapAddToWishList;
	public ImageView imgOverlapSimilar;
	private Context mContext;
	
	public ProductGridHolder(View itemView, Context context) {
		super(itemView);
		Log.e("adapter", "ViewHolder");
		this.mContext= context;
		imgProductImage = (NetworkImageView)itemView.findViewById(R.id.imgProductImage);
		txtProductTitle = (TextView)itemView.findViewById(R.id.txtProductTitle);
		txtProductSellingPrice = (TextView)itemView.findViewById(R.id.txtProductSellingPrice);
		txtProductActualPrice = (TextView)itemView.findViewById(R.id.txtProductActualPrice);
		txtProductDiscount = (TextView)itemView.findViewById(R.id.txtProductDiscount);
		imgProductMenu= (ImageView)itemView.findViewById(R.id.imgProductMenu);

		llProductOverlap= (LinearLayout)itemView.findViewById(R.id.llProductOverlap);
		rlContainerProductOverlap= (RelativeLayout)itemView.findViewById(R.id.rlContainerProductOverlap);
		imgOverlapAddToWishList= (ImageView)itemView.findViewById(R.id.imgOverlapAddToWishList);
		imgOverlapSimilar= (ImageView)itemView.findViewById(R.id.imgOverlapSimilar);
		
		itemView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		mContext.startActivity(new Intent(mContext, ActivityProductDetails.class));
		IOUtils.myToast("item clicked", mContext);
	}
}
