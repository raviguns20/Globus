package com.globus.model;

import android.text.TextUtils;

public class ModelTotal {
	
	private Double Subtotal;
	private Double GrandTotal;
	private Double Discount;
	private int ShippingHand =0;
	private int Tax;
	private String CouponCode;
	
	public Double getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(Double Subtotal) {
		this.Subtotal = Subtotal;

	}
	
	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double Discount) {
		this.Discount = Discount;

	}

	public Double getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(Double GrandTotal) {
		this.GrandTotal = GrandTotal;

	}
	
	public int getShippingHand() {
		return ShippingHand;
	}

	public void setShippingHand(int ShippingHand) {
		this.ShippingHand = ShippingHand;

	}
	
	public int getTax() {
		return Tax;
	}

	public void setTax(int Tax) {
		this.Tax = Tax;

	}

	public String getCouponCode() {
		return CouponCode;
	}

	public void setCouponCode(String CouponCode) {

		if (!TextUtils.isEmpty(CouponCode))
			this.CouponCode = CouponCode;
		else
			this.CouponCode = "";
	}

}
