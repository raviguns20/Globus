package com.globus.model;

import java.util.ArrayList;

import android.text.TextUtils;

public class ModelHomepageBlocks {
	
	private String Header;
	private ArrayList<ModelBanners> modelBanners;
	
	
	public String getHeader() {
		return Header;
	}

	public void setHeader(String Header) {
		if (!TextUtils.isEmpty(Header))
			this.Header = Header;
		else
			this.Header = "";

	}
	
	public ArrayList<ModelBanners> getModelBanners() {
		return modelBanners;
	}

	public void setModelBanners(ArrayList<ModelBanners> modelBanners) {
		this.modelBanners = modelBanners;

	}
}


