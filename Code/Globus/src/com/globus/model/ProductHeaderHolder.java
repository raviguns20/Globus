package com.globus.model;

import com.globus.R;
import com.globus.util.IOUtils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ProductHeaderHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

	public ImageView imgProductListTop;
	private Context mContext;

	public ProductHeaderHolder(View itemView, Context context) {
		super(itemView);
		this.mContext= context;
		itemView.setOnClickListener(this);
		imgProductListTop = (ImageView)itemView.findViewById(R.id.imgProductListTop);
	}

	@Override
	public void onClick(View v) {
		IOUtils.myToast("**header clicked", mContext);
	}
	
	public interface OnItemClickListener {
		public void onItemClick(View view , int position);
	}
}
