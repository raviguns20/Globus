package com.globus.adapter;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerCategoryHolder extends RecyclerView.ViewHolder {
	public TextView txtCategoryName;
	public NetworkImageView imgCategory;
	public RecyclerCategoryHolder(View view) {
		super(view);
		this.imgCategory = (NetworkImageView) view.findViewById(R.id.imgCategory);
		//this.txtCategoryName = (TextView) view.findViewById(R.id.txtCategoryName);

	}

}