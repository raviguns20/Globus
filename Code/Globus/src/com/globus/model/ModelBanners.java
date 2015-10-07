package com.globus.model;

import android.text.TextUtils;

public class ModelBanners {
	private String Id;
	private String Title;
	private String ImageUrl;
	private String Type;
	private String ElementId;


	public ModelBanners(String Id,String Title,String ImageUrl,String Type,String ElementId){


		if (!TextUtils.isEmpty(Id))
			this.Id = Id;
		else
			this.Id = "";

		if (!TextUtils.isEmpty(Title))
			this.Title = Title;
		else
			this.Title = "";
		
		if (!TextUtils.isEmpty(ImageUrl))
			this.ImageUrl = ImageUrl;
		else
			this.ImageUrl = "";
		

		if (!TextUtils.isEmpty(Type))
			this.Type = Type;
		else
			this.Type = "";

		if (!TextUtils.isEmpty(ElementId))
			this.ElementId = ElementId;
		else
			this.ElementId = "";
		

		
		

	}


	public ModelBanners() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		if (!TextUtils.isEmpty(Id))
			this.Id = Id;
		else
			this.Id = "";

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
	
	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		if (!TextUtils.isEmpty(ImageUrl))
			this.ImageUrl = ImageUrl;
		else
			this.ImageUrl = "";

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

	public String getElementId() {
		return ElementId;
	}

	public void setElementId(String ElementId) {

		if (!TextUtils.isEmpty(ElementId))
			this.ElementId = ElementId;
		else
			this.ElementId = "";
	}

}
