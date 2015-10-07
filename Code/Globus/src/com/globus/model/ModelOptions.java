package com.globus.model;

import android.text.TextUtils;

public class ModelOptions {
	private int OptionProductId;
	private int OptionId;							
	private int OptionPackSize;							
	private String OptionPharmaceuticalForm;							
	private String OptionLabel;							
	private int OptionPrice;							
	private int OptionSpecialPrice;
	public ModelOptions() {
		super();
	}
	public ModelOptions(int optionProductId, int optionId, int optionPackSize,
			String optionPharmaceuticalForm, String optionLabel,
			int optionPrice, int optionSpecialPrice) {
		super();
		OptionProductId = optionProductId;
		OptionId = optionId;
		OptionPackSize = optionPackSize;
		if(!TextUtils.isEmpty(optionPharmaceuticalForm)){
			OptionPharmaceuticalForm = optionPharmaceuticalForm;
		}else {
			OptionPharmaceuticalForm= "";
		}
		if(!TextUtils.isEmpty(optionLabel)){
			OptionLabel = optionLabel;
		}else {
			OptionLabel= "";
		}
		OptionPrice = optionPrice;
		OptionSpecialPrice = optionSpecialPrice;
	}
	public int getOptionProductId() {
		return OptionProductId;
	}
	public void setOptionProductId(int optionProductId) {
		OptionProductId = optionProductId;
	}
	public int getOptionId() {
		return OptionId;
	}
	public void setOptionId(int optionId) {
		OptionId = optionId;
	}
	public int getOptionPackSize() {
		return OptionPackSize;
	}
	public void setOptionPackSize(int optionPackSize) {
		OptionPackSize = optionPackSize;
	}
	public String getOptionPharmaceuticalForm() {
		return OptionPharmaceuticalForm;
	}
	public void setOptionPharmaceuticalForm(String optionPharmaceuticalForm) {
		if(!TextUtils.isEmpty(optionPharmaceuticalForm)){
			OptionPharmaceuticalForm = optionPharmaceuticalForm;
		}else {
			OptionPharmaceuticalForm= "";
		}
	}
	public String getOptionLabel() {
		return OptionLabel;
	}
	public void setOptionLabel(String optionLabel) {
		if(!TextUtils.isEmpty(optionLabel)){
			OptionLabel = optionLabel;
		}else {
			OptionLabel= "";
		}
	}
	public int getOptionPrice() {
		return OptionPrice;
	}
	public void setOptionPrice(int optionPrice) {
		OptionPrice = optionPrice;
	}
	public int getOptionSpecialPrice() {
		return OptionSpecialPrice;
	}
	public void setOptionSpecialPrice(int optionSpecialPrice) {
		OptionSpecialPrice = optionSpecialPrice;
	}
}
