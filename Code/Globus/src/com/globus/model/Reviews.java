package com.globus.model;

import android.text.TextUtils;

public class Reviews {
	private int ReviewId;							
	private String CustomerName;							
	private String  ReviewTitle;							
	private String  ReviewBody;							
	private String  ReviewTime;							
	private int  RatePoint;
	
	public Reviews() {
		super();
	}
	public Reviews(int reviewId, String customerName, String reviewTitle,
			String reviewBody, String reviewTime, int ratePoint) {
		super();
		ReviewId = reviewId;
		if(!TextUtils.isEmpty(customerName)){
			CustomerName = customerName;
		}else {
			CustomerName= "";
		}
		if(!TextUtils.isEmpty(reviewTitle)){
			ReviewTitle = reviewTitle;
		}else {
			ReviewTitle = "";
		}
		if(!TextUtils.isEmpty(reviewBody)){
			ReviewBody = reviewBody;
		}else {
			ReviewBody = "";
		}
		if(!TextUtils.isEmpty(reviewTime)){
			ReviewTime = reviewTime;
		}else {
			ReviewTime= "";
		}
		RatePoint = ratePoint;
	}
	public int getReviewId() {
		return ReviewId;
	}
	public void setReviewId(int reviewId) {
		ReviewId = reviewId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		if(!TextUtils.isEmpty(customerName)){
			CustomerName = customerName;
		}else {
			CustomerName= "";
		}
	}
	public String getReviewTitle() {
		return ReviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		if(!TextUtils.isEmpty(reviewTitle)){
			ReviewTitle = reviewTitle;
		}else {
			ReviewTitle = "";
		}
	}
	public String getReviewBody() {
		return ReviewBody;
	}
	public void setReviewBody(String reviewBody) {
		if(!TextUtils.isEmpty(reviewBody)){
			ReviewBody = reviewBody;
		}else {
			ReviewBody = "";
		}
	}
	public String getReviewTime() {
		return ReviewTime;
	}
	public void setReviewTime(String reviewTime) {
		if(!TextUtils.isEmpty(reviewTime)){
			ReviewTime = reviewTime;
		}else {
			ReviewTime= "";
		}
	}
	public int getRatePoint() {
		return RatePoint;
	}
	public void setRatePoint(int ratePoint) {
		RatePoint = ratePoint;
	}
}
