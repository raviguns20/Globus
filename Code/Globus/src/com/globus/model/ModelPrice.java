package com.globus.model;

import android.text.TextUtils;

public class ModelPrice {
	private String Price;
	private String SpecialPrice;
	private String SellingPrice;
	
	public ModelPrice(String Price,String SpecialPrice){
		if (!TextUtils.isEmpty(Price))
			this.Price = Price;
		else
		this.Price = Price;
		
		if (!TextUtils.isEmpty(SpecialPrice))
			this.SpecialPrice = SpecialPrice;
		else
			this.SpecialPrice = "";
	}
	
	
	public ModelPrice() {
		// TODO Auto-generated constructor stub
	}


	public String getSellingPrice() {
		return SellingPrice;
	}

	public void setSellingPrice(String SellingPrice) {
		if (!TextUtils.isEmpty(SellingPrice))
			this.SellingPrice = SellingPrice;
		else
		this.SellingPrice = SellingPrice;

	}

	public String getSpecialPrice() {
		return SpecialPrice;
	}

	public void setSpecialPrice(String SpecialPrice) {
		if (!TextUtils.isEmpty(SpecialPrice))
			this.SpecialPrice = SpecialPrice;
		else
			this.SpecialPrice = "";

	}
	
	public String getPrice() {
		return Price;
	}

	public void setPrice(String Price) {
		if (!TextUtils.isEmpty(Price))
			this.Price = Price;
		else
		this.Price = Price;

	}
}
