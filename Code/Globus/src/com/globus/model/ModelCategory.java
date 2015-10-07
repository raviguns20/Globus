package com.globus.model;

import android.text.TextUtils;

public class ModelCategory {
	private String Id;
	private String Name;
	
	
	public ModelCategory(String Id,String Name){
		
		if (!TextUtils.isEmpty(Id))
			this.Id = Id;
		else
			this.Id = "";
		
		if (!TextUtils.isEmpty(Name))
			this.Name = Name;
		else
			this.Name = "";
	}
	
	
	public ModelCategory() {
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

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		if (!TextUtils.isEmpty(Name))
			this.Name = Name;
		else
			this.Name = "";

	}
}
