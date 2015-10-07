package com.globus.model;

import java.util.ArrayList;


import android.text.TextUtils;

public class ModelHome {
	//@SerializedName("Status")
	private String Status;	 	 	 
	private String Message;
	private String CartQty;
	private String Currency;
	private ArrayList<ModelPromotions> modelPromotions;
	private ArrayList<ModelBanners> modelBanners;
	private ArrayList<ModelCategory> modelCategory;
	private ArrayList<ModelHeaderImage> modelHeaderImage;
	private ModelStores modelStores;
	private ModelHomepageBlocks modelHomepageBlocks;


	public ArrayList<ModelBanners> getModelBanners() {
		return modelBanners;
	}

	public void setModelBanners(ArrayList<ModelBanners> modelBanners) {
		this.modelBanners = modelBanners;

	}

	public ArrayList<ModelPromotions> getModelPromotions() {
		return modelPromotions;
	}

	public void setModelPromotions(ArrayList<ModelPromotions> modelPromotions) {
		this.modelPromotions = modelPromotions;

	}

	public ArrayList<ModelCategory> getModelCategory() {
		return modelCategory;
	}

	public void setModelCategory(ArrayList<ModelCategory> modelCategory) {
		this.modelCategory = modelCategory;

	}



	public ArrayList<ModelHeaderImage> getModelHeaderImage() {
		return modelHeaderImage;
	}

	public void setModelHeaderImage(ArrayList<ModelHeaderImage> modelHeaderImage) {
		this.modelHeaderImage = modelHeaderImage;

	}
	
	public ModelStores getModelStores() {
		return modelStores;
	}

	public void setModelStores(ModelStores modelStores) {
			this.modelStores = modelStores;

	}
	
	public ModelHomepageBlocks getModelHomepageBlocks() {
		return modelHomepageBlocks;
	}

	public void setModelHomepageBlocks(ModelHomepageBlocks modelHomepageBlocks) {
			this.modelHomepageBlocks = modelHomepageBlocks;

	}

	public String getCartQty() {
		return CartQty;
	}

	public void setCartQty(String CartQty) {
		if (!TextUtils.isEmpty(CartQty))
			this.CartQty = CartQty;
		else
			this.CartQty = CartQty;

	}

	//
	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String Currency) {
		if (!TextUtils.isEmpty(Currency))
			this.Currency = Currency;
		else
			this.Currency = Currency;

	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		if (!TextUtils.isEmpty(Status))
			this.Status = Status;
		else
			this.Status = Status;

	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		if (!TextUtils.isEmpty(Message))
			this.Message = Message;
		else
			this.Message = "";

	}
}
