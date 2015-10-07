package com.globus.adapter;

import java.util.ArrayList;

import com.android.volley.toolbox.NetworkImageView;
import com.globus.ActivityProductDetails;
import com.globus.R;
import com.globus.model.ModelProduct;
import com.globus.util.Constant;
import com.globus.util.IOUtils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdapterProductDetailsViewPager extends PagerAdapter {
 
    private ActivityProductDetails mContext;
    ArrayList<ModelProduct> modelProductList;
    LayoutInflater Inflater;
    public AdapterProductDetailsViewPager(ActivityProductDetails mContext, ArrayList<ModelProduct> modelProductList) {
        this.mContext = mContext;
        this.modelProductList = modelProductList;
        Inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        return modelProductList.size();
        
    }
 
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }
 
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = Inflater.inflate(R.layout.viewpager_productdetails_item, container, false);
        ModelProduct modelProduct = this.modelProductList.get(position);
        NetworkImageView imgPagerItem = (NetworkImageView) itemView.findViewById(R.id.imgPagerItem);
        IOUtils.setImageToNetworkImageView(imgPagerItem, modelProduct.getImageUrl());
        container.addView(itemView);
 
        return itemView;
    }
 
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}