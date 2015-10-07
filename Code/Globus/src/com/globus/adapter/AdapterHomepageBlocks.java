package com.globus.adapter;

import java.util.ArrayList;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.R;
import com.globus.model.ModelBanners;
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

public class AdapterHomepageBlocks extends BaseAdapter{

	Activity mContext;
	LayoutInflater layoutInflater;
	ArrayList<ModelBanners> modelWishlist = new ArrayList<ModelBanners>();

	public AdapterHomepageBlocks(Activity activityWishlist, ArrayList<ModelBanners> modelWishlist2) {
		// TODO Auto-generated constructor stub
		this.mContext =activityWishlist;
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
			itemView = layoutInflater.inflate(R.layout.homeblock_item, parent, false);

			holder = new ViewHolder();
			//	holder.imgProductImage = (ImageView) itemView.findViewById(R.id.imgProductImage);

			holder.imgProductImage = (NetworkImageView) itemView.findViewById(R.id.imgProductImage);
			holder.txtProductName=(TextView)itemView.findViewById(R.id.txtProductTitle);
			holder.txtDescreption=(TextView)itemView.findViewById(R.id.txtProductdescrebption);
			holder.txtShopNow=(TextView)itemView.findViewById(R.id.txtshopnow);

			int	individualItemHeight=(IOUtils.getHieghtOfScreen(mContext)/2)+(80*(int)mContext.getResources().getDisplayMetrics().density);
			AbsListView.LayoutParams param = new AbsListView.LayoutParams(
					android.view.ViewGroup.LayoutParams.MATCH_PARENT, individualItemHeight);
			itemView.setLayoutParams(param);

			itemView.setTag(holder);
		}

		holder = (ViewHolder) itemView.getTag();
		IOUtils.setImageToNetworkImageView(holder.imgProductImage, modelWishlist.get(position).getImageUrl());

		holder.txtProductName.setText(""+modelWishlist.get(position).getTitle());
		holder.txtDescreption.setText(""+modelWishlist.get(position).getType());

		return itemView;
	}
	static class ViewHolder
	{
		com.android.volley.toolbox.NetworkImageView imgProductImage;
		//	ImageView imgProductImage;
		TextView txtProductName,txtDescreption,txtShopNow;
	}

}
