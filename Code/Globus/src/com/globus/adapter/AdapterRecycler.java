package com.globus.adapter;

import java.util.ArrayList;
import java.util.List;

import com.globus.ActivityProductDetails;
import com.globus.R;
import com.globus.model.ModelProduct;
import com.globus.util.IOUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class AdapterRecycler extends RecyclerView.Adapter<RecyclerListRowHolder> {


	private List<ModelProduct> modelProductList;
	ActivityProductDetails mContext;
	LayoutInflater Inflater;
	public AdapterRecycler(ActivityProductDetails context, ArrayList<ModelProduct> modelProductList) {
		this.modelProductList = modelProductList;
		this.mContext = context;
		Inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public RecyclerListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View view = Inflater.inflate(R.layout.recyclerlist_promotion_row, null);
		RecyclerListRowHolder mh = new RecyclerListRowHolder(view);
		return mh;
	}

	@Override
	public void onBindViewHolder(RecyclerListRowHolder recyclerListRowHolder, int i) {
		ModelProduct modelProduct = this.modelProductList.get(i);
		IOUtils.setImageToNetworkImageView(recyclerListRowHolder.imgProduct, modelProduct.getImageUrl());
		recyclerListRowHolder.txtProductName.setText(modelProduct.getProductName());
		recyclerListRowHolder.imgProduct.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext,ActivityProductDetails.class);
				mContext.startActivity(intent);
			}
		});
	}

	@Override
	public int getItemCount() {
		return (null != modelProductList ? modelProductList.size() : 0);
	}
}

