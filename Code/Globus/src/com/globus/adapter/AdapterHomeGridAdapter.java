package com.globus.adapter;

import java.util.ArrayList;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.R;
import com.globus.model.ModelBanners;
import com.globus.model.ModelHeaderImage;
import com.globus.model.ModelHomepageBlocks;
import com.globus.model.ModelWishlist;
import com.globus.util.IOUtils;

import android.app.Activity;
import android.content.ClipData.Item;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterHomeGridAdapter extends BaseAdapter{

	Activity mContext;
	LayoutInflater layoutInflater;
	ArrayList<ModelHeaderImage> modelWishlist = new ArrayList<ModelHeaderImage>();
	int count=0;

	public AdapterHomeGridAdapter(Activity activityWishlist, ArrayList<ModelHeaderImage> modelWishlist2) {
		// TODO Auto-generated constructor stub
		this.mContext =activityWishlist;
		count=modelWishlist2.size();
		this.modelWishlist=modelWishlist2;
		this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		IOUtils.printLogInfo(modelWishlist.size()+"modelWishlist_SIZE");
		return modelWishlist.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View itemView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;

		if (itemView == null)
		{
			itemView = layoutInflater.inflate(R.layout.recycler_category, parent, false);

			holder = new ViewHolder();
			//	holder.imgProductImage = (ImageView) itemView.findViewById(R.id.imgProductImage);

			holder.imgProductImage = (NetworkImageView) itemView.findViewById(R.id.imgCategory);


			int	individualItemWidth=((IOUtils.getHieghtOfScreen(mContext)/count));
			AbsListView.LayoutParams param = new AbsListView.LayoutParams(
					individualItemWidth, (60*(int)mContext.getResources().getDisplayMetrics().density));
			itemView.setLayoutParams(param);

			itemView.setTag(holder);
		}

		holder = (ViewHolder) itemView.getTag();
		IOUtils.setImageToNetworkImageView(holder.imgProductImage, modelWishlist.get(position).getImageUrl());

		return itemView;
	}
	static class ViewHolder
	{
		com.android.volley.toolbox.NetworkImageView imgProductImage;
	}

}
