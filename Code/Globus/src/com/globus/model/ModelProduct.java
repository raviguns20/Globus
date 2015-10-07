package com.globus.model;

import android.net.Uri;
import android.text.TextUtils;

public class ModelProduct {
	private int Id;
	private String ProductName;						
	private String ProductType;						
	private String Currency;						
	private double Price;				
	private int ProductRate;	 						
	private String StockStatus;	 						
	private int ProductReviewNumber;	 						
	private String ImageUrl;						
	private String ManufacturerName;						
	private boolean IsShowPrice;
	private String ProductDescription;	 	 						
	private String ProductShortDescription;
	private int MaxQty;
	private String MediaUrl;
	private boolean OneStarNumber;	 	 						
	private boolean TwoStarNumber;	 							
	private boolean ThreeStarNumber;	 							
	private boolean FourStarNumber;	 							
	private boolean FiveStarNumber;
	private ModelOptions options;
	private String Offers;	 							
	private String Specification;								
	private String SellerInfo;
	private boolean isViewVisible;
	private ModelPrice modelPrice;
	
	public ModelProduct() {
		super();
	}
	
	public ModelProduct(String imageUrl, String productName) {
		// TODO Auto-generated constructor stub
		
		if(!TextUtils.isEmpty(productName)){
			ProductName = productName;
		}else {
			ProductName= "";
		}
		
		if(!TextUtils.isEmpty(imageUrl)){
			ImageUrl = imageUrl;
		}else {
			ImageUrl= "";
		}
	}
	
	public ModelProduct(int id, String productName, double price, String imageUrl, boolean isViewVisible) {
		super();
		Id = id;
		if(!TextUtils.isEmpty(productName)){
			ProductName = productName;
		}else {
			ProductName= "";
		}
		
		Price = price;
		
		if(!TextUtils.isEmpty(imageUrl.toString())){
			ImageUrl = imageUrl;
		}
		
		this.isViewVisible= isViewVisible;
	}
	
	public ModelProduct(int id, String productName, String productType,
			String currency, double price, int productRate, String stockStatus,
			int productReviewNumber, String imageUrl, String manufacturerName,
			boolean isShowPrice, String productDescription,
			String productShortDescription, int maxQty, String mediaUrl,
			boolean oneStarNumber, boolean twoStarNumber,
			boolean threeStarNumber, boolean fourStarNumber,
			boolean fiveStarNumber, ModelOptions options, String offers,
			String specification, String sellerInfo, boolean isViewVisible) {
		super();
		Id = id;
		if(!TextUtils.isEmpty(productName)){
			ProductName = productName;
		}else {
			ProductName= "";
		}
		if(!TextUtils.isEmpty(productType)){
			ProductType = productType;
		}else {
			ProductType= "";
		}
		if(!TextUtils.isEmpty(currency)){
			Currency = currency;
		}else {
			Currency= "";
		}
		Price = price;
		ProductRate = productRate;
		if(!TextUtils.isEmpty(stockStatus)){
			StockStatus = stockStatus;
		}else {
			StockStatus= "";
		}
		ProductReviewNumber = productReviewNumber;
		if(!TextUtils.isEmpty(imageUrl.toString())){
			ImageUrl = imageUrl;
		}
		
		if(!TextUtils.isEmpty(manufacturerName)){
			ManufacturerName = manufacturerName;
		}else {
			ManufacturerName= "";
		}
		IsShowPrice = isShowPrice;
		ProductDescription = productDescription;
		ProductShortDescription = productShortDescription;
		MaxQty = maxQty;
		if(!TextUtils.isEmpty(mediaUrl)){
			MediaUrl = mediaUrl;
		}else {
			MediaUrl= "";
		}
		OneStarNumber = oneStarNumber;
		TwoStarNumber = twoStarNumber;
		ThreeStarNumber = threeStarNumber;
		FourStarNumber = fourStarNumber;
		FiveStarNumber = fiveStarNumber;
		if(options != null){
			this.options = options;
		}
		if(!TextUtils.isEmpty(offers)){
			Offers = offers;
		}else{
			Offers= "";
		}
		if(!TextUtils.isEmpty(specification)){
			Specification = specification;
		}else {
			Specification= "";
		}
		if(!TextUtils.isEmpty(sellerInfo)){
			SellerInfo = sellerInfo;
		}else{
			SellerInfo= "";
		}
		this.isViewVisible= isViewVisible;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		if(!TextUtils.isEmpty(productName)){
			ProductName = productName;
		}else {
			ProductName= "";
		}
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		if(!TextUtils.isEmpty(productType)){
			ProductType = productType;
		}else {
			ProductType= "";
		}
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		if(!TextUtils.isEmpty(currency)){
			Currency = currency;
		}else {
			Currency= "";
		}
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getProductRate() {
		return ProductRate;
	}
	public void setProductRate(int productRate) {
		ProductRate = productRate;
	}
	public String getStockStatus() {
		return StockStatus;
	}
	public void setStockStatus(String stockStatus) {
		if(!TextUtils.isEmpty(stockStatus)){
			StockStatus = stockStatus;
		}else {
			StockStatus= "";
		}
	}
	public int getProductReviewNumber() {
		return ProductReviewNumber;
	}
	public void setProductReviewNumber(int productReviewNumber) {
		ProductReviewNumber = productReviewNumber;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		if(!TextUtils.isEmpty(imageUrl.toString())){
			ImageUrl = imageUrl;
		}
	}
	public String getManufacturerName() {
		return ManufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		if(!TextUtils.isEmpty(manufacturerName)){
			ManufacturerName = manufacturerName;
		}else {
			ManufacturerName= "";
		}
	}
	public boolean isIsShowPrice() {
		return IsShowPrice;
	}
	public void setIsShowPrice(boolean isShowPrice) {
		IsShowPrice = isShowPrice;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public String getProductShortDescription() {
		return ProductShortDescription;
	}
	public void setProductShortDescription(String productShortDescription) {
		ProductShortDescription = productShortDescription;
	}
	public int getMaxQty() {
		return MaxQty;
	}
	public void setMaxQty(int maxQty) {
		MaxQty = maxQty;
	}
	public String getMediaUrl() {
		return MediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		if(!TextUtils.isEmpty(mediaUrl)){
			MediaUrl = mediaUrl;
		}else {
			MediaUrl= "";
		}
	}
	public boolean isOneStarNumber() {
		return OneStarNumber;
	}
	public void setOneStarNumber(boolean oneStarNumber) {
		OneStarNumber = oneStarNumber;
	}
	public boolean isTwoStarNumber() {
		return TwoStarNumber;
	}
	public void setTwoStarNumber(boolean twoStarNumber) {
		TwoStarNumber = twoStarNumber;
	}
	public boolean isThreeStarNumber() {
		return ThreeStarNumber;
	}
	public void setThreeStarNumber(boolean threeStarNumber) {
		ThreeStarNumber = threeStarNumber;
	}
	public boolean isFourStarNumber() {
		return FourStarNumber;
	}
	public void setFourStarNumber(boolean fourStarNumber) {
		FourStarNumber = fourStarNumber;
	}
	public boolean isFiveStarNumber() {
		return FiveStarNumber;
	}
	public void setFiveStarNumber(boolean fiveStarNumber) {
		FiveStarNumber = fiveStarNumber;
	}

	public ModelOptions getOptions() {
		return options;
	}

	public void setOptions(ModelOptions options) {
		if(options != null){
			this.options = options;
		}
	}

	public String getOffers() {
		return Offers;
	}

	public void setOffers(String offers) {
		if(!TextUtils.isEmpty(offers)){
			Offers = offers;
		}else{
			Offers= "";
		}
	}

	public String getSpecification() {
		return Specification;
	}

	public void setSpecification(String specification) {
		if(!TextUtils.isEmpty(specification)){
			Specification = specification;
		}else {
			Specification= "";
		}
	}

	public String getSellerInfo() {
		return SellerInfo;
	}

	public void setSellerInfo(String sellerInfo) {
		if(!TextUtils.isEmpty(sellerInfo)){
			SellerInfo = sellerInfo;
		}else{
			SellerInfo= "";
		}
	}
	
	public boolean getIsViewVisible() {
		return isViewVisible;
	}

	public void setViewVisible(boolean isViewVisible) {
		this.isViewVisible = isViewVisible;
	}
	
	public ModelPrice getModelPrice() {
		return modelPrice;
	}

	public void setModelPrice(ModelPrice modelPrice) {
		if(modelPrice != null){
			this.modelPrice = modelPrice;
		}
	}

	@Override
	public String toString() {
		return "ModelProduct [Id=" + Id + ", ProductName=" + ProductName + ", ProductType=" + ProductType
				+ ", Currency=" + Currency + ", Price=" + Price + ", ProductRate=" + ProductRate + ", StockStatus="
				+ StockStatus + ", ProductReviewNumber=" + ProductReviewNumber + ", ImageUrl=" + ImageUrl
				+ ", ManufacturerName=" + ManufacturerName + ", IsShowPrice=" + IsShowPrice + ", ProductDescription="
				+ ProductDescription + ", ProductShortDescription=" + ProductShortDescription + ", MaxQty=" + MaxQty
				+ ", MediaUrl=" + MediaUrl + ", OneStarNumber=" + OneStarNumber + ", TwoStarNumber=" + TwoStarNumber
				+ ", ThreeStarNumber=" + ThreeStarNumber + ", FourStarNumber=" + FourStarNumber + ", FiveStarNumber="
				+ FiveStarNumber + ", options=" + options + ", Offers=" + Offers + ", Specification=" + Specification
				+ ", SellerInfo=" + SellerInfo + "]";
	}
}
