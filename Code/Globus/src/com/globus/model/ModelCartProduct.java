package com.globus.model;

import java.io.Serializable;

import android.text.TextUtils;

public class ModelCartProduct implements Serializable {

	private int CartItemId = 0;
	private int ProductId = 0;
	private String ProductName;
	private Double ProductPrice;
	private String ProductImage;
	private int ProductQty = 0;
	private int ProductMaxQty = 0;
	private int Status;
	private String Message;
	ModelOptions recordOption;

	public int getCartItemId() {
		return CartItemId;
	}

	public void setCartItemId(int CartItemId) {
		this.CartItemId = CartItemId;

	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int ProductId) {
		this.ProductId = ProductId;

	}

	public Double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(Double ProductPrice) {
		this.ProductPrice = ProductPrice;

	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {

		if (!TextUtils.isEmpty(ProductName))
			this.ProductName = ProductName;
		else
			this.ProductName = "";

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

	public int getProductQty() {
		return ProductQty;
	}

	public void setProductQty(int ProductQty) {
		this.ProductQty = ProductQty;

	}

	public int getProductMaxQty() {
		return ProductMaxQty;
	}

	public void setProductMaxQty(int ProductMaxQty) {
		this.ProductMaxQty = ProductMaxQty;

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

	public ModelOptions getRecordOption() {
		return recordOption;
	}

	public void setRecordOption(ModelOptions recordOption) {
		this.recordOption = recordOption;
	}
}
