package com.globus.model;

import android.text.TextUtils;

public class ModelWishlist {
	
	private String Name;
	private int ItemId =0;
	private String PackSize;
	private int Qty =0;
	private int ProductId=0;
	private String ProductImage;
	private int StockStatus=0;
	private String StockLabel;
	private int Status;	 	 	 
	private String Message;
	
	public ModelWishlist(String Name,int ItemId,String PackSize,int Qty,int ProductId,String ProductImage,int StockStatus,String StockLabel,int Status,String Message){
		if (!TextUtils.isEmpty(Name))
			this.Name = Name;
		else
			this.Name = "";
		
		this.ItemId = ItemId;
		
		if (!TextUtils.isEmpty(PackSize))
			this.PackSize = PackSize;
		else
			this.PackSize = "";
		
		this.ProductId = ProductId;
		this.Qty = Qty;
		
		if (!TextUtils.isEmpty(ProductImage))
			this.ProductImage = ProductImage;
		else
			this.ProductImage = "";
		
		this.StockStatus = StockStatus;

		if (!TextUtils.isEmpty(StockLabel))
			this.StockLabel = StockLabel;
		else
			this.StockLabel = "";
		
		this.Status = Status;
		
		if (!TextUtils.isEmpty(Message))
			this.Message = Message;
		else
			this.Message = "";
		
	}
	
	
	
	
	public String getName() {
		return Name;
	}

	public void setName(String Name) {

		if (!TextUtils.isEmpty(Name))
			this.Name = Name;
		else
			this.Name = "";

	}

	
	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int ItemId) {
		this.ItemId = ItemId;

	}
	
	public String getPackSize() {
		return PackSize;
	}

	public void setPackSize(String PackSize) {

		if (!TextUtils.isEmpty(PackSize))
			this.PackSize = PackSize;
		else
			this.PackSize = "";

	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int ProductId) {
		this.ProductId = ProductId;

	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int Qty) {
		this.Qty = Qty;

	}

	public String getProductImage() {
		return ProductImage;
	}

	public void setProductImage(String ProductImage) {

		if (!TextUtils.isEmpty(ProductImage))
			this.ProductImage = ProductImage;
		else
			this.ProductImage = "";

	}

	public int getStockStatus() {
		return StockStatus;
	}

	public void setStockStatus(int StockStatus) {
		this.StockStatus = StockStatus;

	}

	public String getStockLabel() {
		return StockLabel;
	}

	public void setStockLabel(String StockLabel) {
		if (!TextUtils.isEmpty(StockLabel))
			this.StockLabel = StockLabel;
		else
			this.StockLabel = "";

	}
	
	public int getStatus() {
		return Status;
	}

	public void setStatus(int Status) {
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
