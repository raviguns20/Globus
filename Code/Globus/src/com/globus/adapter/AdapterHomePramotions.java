package com.globus.adapter;

import java.util.ArrayList;
import java.util.List;

import com.globus.ActivityHome;
import com.globus.ActivityProductDetails;
import com.globus.R;
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
import android.view.ViewGroup;

@SuppressLint("InflateParams")
public class AdapterHomePramotions extends RecyclerView.Adapter<RecyclerPromotionHolder> {


	private ArrayList<ModelProduct> ModelPromotionsList;
	Activity mContext;
	LayoutInflater Inflater;
	public AdapterHomePramotions(Activity context, ArrayList<ModelProduct> arrayList) {
		this.ModelPromotionsList = arrayList;
		System.out.println("ModelPromotionsList--->"+arrayList.size());

		this.mContext = context;
		Inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public RecyclerPromotionHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View view = Inflater.inflate(R.layout.recyclerlist_promotion_row, null);
		RecyclerPromotionHolder mh = new RecyclerPromotionHolder(view);
		return mh;
	}

	@Override
	public void onBindViewHolder(RecyclerPromotionHolder promotionViewHolder, int i) {
		IOUtils.setImageToNetworkImageView(promotionViewHolder.imgProduct, ModelPromotionsList.get(i).getImageUrl());
		promotionViewHolder.txtProductName.setText(ModelPromotionsList.get(i).getProductName()+"");
		promotionViewHolder.txtPrice.setText(ModelPromotionsList.get(i).getPrice()+"");
		promotionViewHolder.imgProduct.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext,ActivityProductDetails.class);
				mContext.startActivity(intent);
			}
		});
		//        Picasso.with(mContext).load(ModelPromotions.getThumbnail())
		//                .error(R.drawable.ic_launcher)
		//                .placeholder(R.drawable.ic_launcher)
		//                .into(feedListRowHolder.thumbnail);

		//feedListRowHolder.txtProductName.setText(Html.fromHtml(ModelPromotions.getTitle()));
	}

	@Override
	public int getItemCount() {
		return (null != ModelPromotionsList ? ModelPromotionsList.size() : 0);
	}
}

