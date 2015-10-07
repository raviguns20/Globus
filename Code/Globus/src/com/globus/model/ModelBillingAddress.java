package com.globus.model;

import android.text.TextUtils;

public class ModelBillingAddress {
	private int AddressBookId;
	private String FirstName;
	private String LastName;
	private String Company;
	private String City;
	private String CountryId;
	private String Suffix;
	private int Postcode;
	private String Telephone;
	private String Fax;
	private String Street;
	private int RegionId;
	private int Gender;
	private String Mobile;
	private String Street1;
	private String Street2;
	private String CountryName;
	//private String State;
	private int ZoneId;		 				
	private String ZoneName;		 
	private String AddressType;
	private int Status;	 	 	 
	private String Message;

	public ModelBillingAddress(int AddressBookId,String FirstName, String LastName,String Company,String City,
			String CountryId,String Suffix,int Postcode,String Telephone,String Fax,String Street,int RegionId,
			int Gender,String Mobile,String Street1,String Street2,String CountryName,int ZoneId,String ZoneName,String AddressType) {

		this.AddressBookId=AddressBookId;
		this.Postcode=Postcode;
		this.RegionId=RegionId;
		this.Gender=Gender;

		if (!TextUtils.isEmpty(FirstName))
			this.FirstName = FirstName;
		else
			this.FirstName = "";

		if (!TextUtils.isEmpty(LastName))
			this.LastName = LastName;
		else
			this.LastName = "";
		
		if (!TextUtils.isEmpty(Company))
			this.Company = Company;
		else
			this.Company = "";

		if (!TextUtils.isEmpty(CountryId))
			this.CountryId = CountryId;
		else
			this.CountryId = "";
		
		if (!TextUtils.isEmpty(City))
			this.City = City;
		else
			this.City = "";
		
		if (!TextUtils.isEmpty(Suffix))
			this.Suffix = Suffix;
		else
			this.Suffix = "";

		if (!TextUtils.isEmpty(Telephone))
			this.Telephone = Telephone;
		else
			this.Telephone = "";
		
		if (!TextUtils.isEmpty(Fax))
			this.Fax = Fax;
		else
			this.Fax = "";
		
		if (!TextUtils.isEmpty(Street))
			this.Street = Street;
		else
			this.Street = "";
		
		if (!TextUtils.isEmpty(Mobile))
			this.Mobile = Mobile;
		else
			this.Mobile = "";
		
		if (!TextUtils.isEmpty(Street1))
			this.Street1 = Street1;
		else
			this.Street1 = "";
		
		if (!TextUtils.isEmpty(Street2))
			this.Street2 = Street2;
		else
			this.Street2 = "";
		
		if (!TextUtils.isEmpty(CountryName))
			this.CountryName = CountryName;
		else
			this.CountryName = "";
//		if (!TextUtils.isEmpty(State))
//			this.State = State;
//		else
//			this.State = "";
		if (!TextUtils.isEmpty(ZoneName))
		this.ZoneName = ZoneName;
	else
		this.ZoneName = "";
		
		this.ZoneId=ZoneId;
		
		if (!TextUtils.isEmpty(AddressType))
		this.AddressType = AddressType;
	else
		this.AddressType = "";

	}




	public int getAddressBookId() {
		return AddressBookId;
	}

	public void setAddressBookId(int AddressBookId) {
		this.AddressBookId = AddressBookId;

	}
	
	public int getPostcode() {
		return Postcode;
	}

	public void setPostcode(int Postcode) {
		this.Postcode = Postcode;

	}
	
	public int getRegionId() {
		return RegionId;
	}

	public void setRegionId(int RegionId) {
		this.RegionId = RegionId;

	}
	
	public int getGender() {
		return Gender;
	}

	public void setGender(int Gender) {
		this.Gender = Gender;

	}

	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {

		if (!TextUtils.isEmpty(FirstName))
			this.FirstName = FirstName;
		else
			this.FirstName = "";

	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {

		if (!TextUtils.isEmpty(LastName))
			this.LastName = LastName;
		else
			this.LastName = "";

	}

	
	public String getCompany() {
		return Company;
	}

	public void setCompany(String Company) {
		if (!TextUtils.isEmpty(Company))
			this.Company = Company;
		else
			this.Company = "";

	}
	
	public String getCountryId() {
		return CountryId;
	}

	public void setCountryId(String CountryId) {

		if (!TextUtils.isEmpty(CountryId))
			this.CountryId = CountryId;
		else
			this.CountryId = "";
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {

		if (!TextUtils.isEmpty(City))
			this.City = City;
		else
			this.City = "";
	}
	
	public String getSuffix() {
		return Suffix;
	}

	public void setSuffix(String Suffix) {
		if (!TextUtils.isEmpty(Suffix))
			this.Suffix = Suffix;
		else
			this.Suffix = "";

	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String Telephone) {

		if (!TextUtils.isEmpty(Telephone))
			this.Telephone = Telephone;
		else
			this.Telephone = "";
	}
	public String getFax() {
		return Fax;
	}

	public void setFax(String Fax) {
		if (!TextUtils.isEmpty(Fax))
			this.Fax = Fax;
		else
			this.Fax = "";

	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String Street) {

		if (!TextUtils.isEmpty(Street))
			this.Street = Street;
		else
			this.Street = "";
	}
	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String Mobile) {
		if (!TextUtils.isEmpty(Mobile))
			this.Mobile = Mobile;
		else
			this.Mobile = "";

	}

	public String getStreet1() {
		return Street1;
	}

	public void setStreet1(String Street1) {

		if (!TextUtils.isEmpty(Street1))
			this.Street1 = Street1;
		else
			this.Street1 = "";
	}
	public String getStreet2() {
		return Street2;
	}

	public void setStreet2(String Street2) {
		if (!TextUtils.isEmpty(Street2))
			this.Street2 = Street2;
		else
			this.Street2 = "";

	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String CountryName) {

		if (!TextUtils.isEmpty(CountryName))
			this.CountryName = CountryName;
		else
			this.CountryName = "";
	}
//	public String getState() {
//		return State;
//	}
//
//	public void setState(String State) {
//		if (!TextUtils.isEmpty(State))
//			this.State = State;
//		else
//			this.State = "";
//
//	}

	
	public int getZoneId() {
		return ZoneId;
	}

	public void setZoneId(int ZoneId) {
		this.ZoneId = ZoneId;

	}
	
	public String getZoneName() {
		return ZoneName;
	}

	public void setZoneName(String ZoneName) {
		if (!TextUtils.isEmpty(ZoneName))
			this.ZoneName = ZoneName;
		else
			this.ZoneName = "";

	}
	public String getAddressType() {
		return AddressType;
	}

	public void setAddressType(String AddressType) {
		if (!TextUtils.isEmpty(AddressType))
			this.AddressType = AddressType;
		else
			this.AddressType = "";

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
