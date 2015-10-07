package com.globus.adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.globus.ActivityCart;
import com.globus.R;
import com.globus.adapter.AdapterCart.CustomeViewHolder;
import com.globus.model.ModelCart;
import com.globus.model.ModelCartProduct;

public class AdapterCart extends RecyclerView.Adapter<CustomeViewHolder> {

	Context mContext;
	ModelCart recordCart;
	ArrayList<ModelCartProduct> arraListCart;
	LayoutInflater inflator;
	ActivityCart activity;
	LinearLayout LLRemove,LLPlaceOrder;

	public AdapterCart(Context mContext, ModelCart recordCart) {
		this.mContext = mContext;
		this.recordCart = recordCart;
		arraListCart = recordCart.getModelCartProduct();
		inflator=LayoutInflater.from(mContext);
		activity=(ActivityCart)mContext;
		LLRemove=(LinearLayout)activity.findViewById(R.id.LLRemove);
		LLPlaceOrder=(LinearLayout)activity.findViewById(R.id.LLPlaceOrder);
	}
	
	@Override
	public int getItemCount() {
		return arraListCart.size();
	}
	
	@Override
	public void onBindViewHolder(CustomeViewHolder holder, int position) {
		ModelCartProduct record=arraListCart.get(position);
		
		holder.txtProductName.setText(""+record.getProductName());
		holder.txtPrice.setText("Rs"+record.getProductPrice());
		//holder.txtSize.setText(""+record.getProductPrice());
		holder.txtQuantity.setText(""+record.getProductQty());
	
		holder.LLRemove.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//IOUtils.myToast("Remove", mContext);
				LLPlaceOrder.setVisibility(View.GONE);
				LLRemove.setVisibility(View.VISIBLE);
				//showRemoveDialog();
			}
		});
		
		holder.LLEdit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//IOUtils.myToast("Edit", mContext);
			}
		});
	}
	

	protected void showRemoveDialog() {
		/*Dialog dlg = new Dialog(mContext);
		dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dlg.setContentView(R.layout.dialog_remove_item);
		Window window = dlg.getWindow();
		WindowManager.LayoutParams wlp = window.getAttributes();

		wlp.gravity = Gravity.BOTTOM;
		wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		window.setAttributes(wlp);
		dlg.show();*/
		
		 final Dialog dialog = new Dialog(mContext,R.style.D1NoTitleDim);

		    // Setting dialogview
		    Window window = dialog.getWindow();
		    window.setGravity(Gravity.BOTTOM);
		    WindowManager.LayoutParams lp = window.getAttributes();
		   // lp.flags=lp.FLAG_DIM_BEHIND;
		    lp.dimAmount=0.8f; 
		    window.setAttributes(lp);
		    window.setLayout(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		    dialog.setTitle(null);
		    dialog.setContentView(R.layout.dialog_remove_item);
		    dialog.setCancelable(true);
		    dialog.show();
	}

	@Override
	public CustomeViewHolder onCreateViewHolder(ViewGroup parent, int position) {
		View view=inflator.inflate(R.layout.item_cart,parent, false);
		CustomeViewHolder holder=new CustomeViewHolder(view);
		return holder;
	}
	
	public class CustomeViewHolder extends RecyclerView.ViewHolder{ 
		
		TextView txtProductName,txtPrice,txtSize,txtQuantity;
		LinearLayout LLRemove,LLEdit;
		ImageView imgProduct;
		
		@SuppressLint("CutPasteId") public CustomeViewHolder(View view) {
			super(view);
			
			txtProductName=(TextView)view.findViewById(R.id.txtProductName);
			txtPrice=(TextView)view.findViewById(R.id.txtPrice);
			txtSize=(TextView)view.findViewById(R.id.txtSize);
			txtQuantity=(TextView)view.findViewById(R.id.txtQuantity);
			imgProduct=(ImageView)view.findViewById(R.id.imgProduct);
			
			LLRemove=(LinearLayout)view.findViewById(R.id.LLRemove);
			LLEdit=(LinearLayout)view.findViewById(R.id.LLEdit);
			
		}
	}
}
