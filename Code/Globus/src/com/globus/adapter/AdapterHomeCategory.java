package com.globus.adapter;

import java.util.ArrayList;
import java.util.List;

import com.globus.ActivityHome;
import com.globus.R;
import com.globus.model.ModelHeaderImage;
import com.globus.model.ModelProduct;
import com.globus.model.ModelPromotions;
import com.globus.util.IOUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.view.ViewGroup;

@SuppressLint("InflateParams")
public class AdapterHomeCategory extends RecyclerView.Adapter<RecyclerCategoryHolder> {


	private ArrayList<ModelHeaderImage> ModelCategoryList;
	Activity mContext;
	LayoutInflater Inflater;
	int count=0;
	public AdapterHomeCategory(Activity context, ArrayList<ModelHeaderImage> listOfImages) {
		this.ModelCategoryList = listOfImages;
		count=listOfImages.size();
		System.out.println("ModelCategoryList--->"+listOfImages.size());

		this.mContext = context;
		Inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public RecyclerCategoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View view = Inflater.inflate(R.layout.recycler_category, null);
		RecyclerCategoryHolder mh = new RecyclerCategoryHolder(view);

		int	individualItemWidth=((IOUtils.getHieghtOfScreen(mContext)/count));
		AbsListView.LayoutParams param = new AbsListView.LayoutParams(
				individualItemWidth, (60*(int)mContext.getResources().getDisplayMetrics().density));
		view.setLayoutParams(param);

		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext,ActivityHome.class);
				mContext.startActivity(intent);
			}
		});
		return mh;
	}

	@Override
	public void onBindViewHolder(RecyclerCategoryHolder promotionViewHolder, int i) {
		IOUtils.setImageToNetworkImageView(promotionViewHolder.imgCategory, ModelCategoryList.get(i).getImageUrl());

		
	}

	@Override
	public int getItemCount() {
		return (null != ModelCategoryList ? ModelCategoryList.size() : 0);
	}
}

