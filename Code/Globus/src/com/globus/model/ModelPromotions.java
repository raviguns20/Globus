package com.globus.model;

import java.util.ArrayList;

import android.text.TextUtils;

public class ModelPromotions {

	private String Id;
	private String Title;
	private String Type;
	private String Link;
	private ArrayList<ModelProduct> modelProduct;

	public ModelPromotions(String Id,String Title,String Type,String Link){

		if (!TextUtils.isEmpty(Id))
			this.Id = Id;
		else
		this.Id = Id;

		if (!TextUtils.isEmpty(Title))
			this.Title = Title;
		else
			this.Title = "";

		if (!TextUtils.isEmpty(Type))
			this.Type = Type;
		else
			this.Type = "";

		if (!TextUtils.isEmpty(Link))
			this.Link = Link;
		else
			this.Link = "";

	}


	public ModelPromotions() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		if (!TextUtils.isEmpty(Id))
			this.Id = Id;
		else
		this.Id = Id;

	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		if (!TextUtils.isEmpty(Title))
			this.Title = Title;
		else
			this.Title = "";

	}

	public String getType() {
		return Type;
	}

	public void setType(String Type) {

		if (!TextUtils.isEmpty(Type))
			this.Type = Type;
		else
			this.Type = "";
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String Link) {

		if (!TextUtils.isEmpty(Link))
			this.Link = Link;
		else
			this.Link = "";
	}
	
	public ArrayList<ModelProduct> getModelProduct() {
		return modelProduct;
	}

	public void setModelProduct(ArrayList<ModelProduct> modelProduct) {
			this.modelProduct = modelProduct;

	}

}
