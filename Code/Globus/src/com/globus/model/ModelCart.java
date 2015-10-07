package com.globus.model;

import java.io.Serializable;
import java.util.ArrayList;

import android.text.TextUtils;

public class ModelCart implements Serializable{

	private String PackSize;
	private String ManufacturerName;
	private String GenericName;
	private String Currency;
	private Double RewardPoints;
	private int Status;	 	 	 
	private String Message;
	private ModelTotal modelTotal;
	private ArrayList<ModelCartProduct> modelCartProduct;


	public ModelTotal getModelTotal() {
		return modelTotal;
	}

	public void setModelTotal(ModelTotal modelTotal) {
			this.modelTotal = modelTotal;

	}
	
	public ArrayList<ModelCartProduct> getModelCartProduct() {
		return modelCartProduct;
	}

	public void setModelCartProduct(ArrayList<ModelCartProduct> modelCartProduct) {
			this.modelCartProduct = modelCartProduct;

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

	public String getManufacturerName() {
		return ManufacturerName;
	}

	public void setManufacturerName(String ManufacturerName) {

		if (!TextUtils.isEmpty(ManufacturerName))
			this.ManufacturerName = ManufacturerName;
		else
			this.ManufacturerName = "";
	}

	public String getGenericName() {
		return GenericName;
	}

	public void setGenericName(String GenericName) {

		if (!TextUtils.isEmpty(GenericName))
			this.GenericName = GenericName;
		else
			this.GenericName = "";
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String Currency) {
		if (!TextUtils.isEmpty(Currency))
			this.Currency = Currency;
		else
			this.Currency = "";

	}

	

	public Double getRewardPoints() {
		return RewardPoints;
	}

	public void setRewardPoints(Double RewardPoints) {
		this.RewardPoints = RewardPoints;

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
