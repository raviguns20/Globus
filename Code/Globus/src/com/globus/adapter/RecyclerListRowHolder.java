package com.globus.adapter;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerListRowHolder extends RecyclerView.ViewHolder {
	public NetworkImageView imgProduct;
    public TextView txtProductName;

    public RecyclerListRowHolder(View view) {
        super(view);
        this.imgProduct = (NetworkImageView) view.findViewById(R.id.imgProduct);
        this.txtProductName = (TextView) view.findViewById(R.id.txtProductName);
    }

}