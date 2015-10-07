package com.globus.model;

import android.text.TextUtils;

public class ModelStores {
	private String Header;
	private String ImageUrl;



public String getHeader() {
	return Header;
}

public void setHeader(String Header) {
	if (!TextUtils.isEmpty(Header))
		this.Header = Header;
	else
		this.Header = "";

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
}