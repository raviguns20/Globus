package com.globus.adapter;

import java.util.ArrayList;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.R;
import com.globus.model.ModelBanners;
import com.globus.util.IOUtils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdapterHomeViewPageAdapter extends PagerAdapter {

	private Context mContext;
	private ArrayList<ModelBanners> mResources;
	LayoutInflater Inflater;
	public AdapterHomeViewPageAdapter(Context mContext, ArrayList<ModelBanners> arrayList) {
		this.mContext = mContext;
		this.mResources = arrayList;
		Inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return mResources.size();

	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((LinearLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View itemView = Inflater.inflate(R.layout.viewpager_banner_item, container, false);
		NetworkImageView imgProductImage = (NetworkImageView) itemView.findViewById(R.id.img_pager_item);
		IOUtils.setImageToNetworkImageView(imgProductImage, mResources.get(position).getImageUrl());
		container.addView(itemView);

		return itemView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((LinearLayout) object);
	}
}