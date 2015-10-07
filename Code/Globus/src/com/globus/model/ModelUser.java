package com.globus.model;

import android.text.TextUtils;

public class ModelUser {

	private String UserId;
	private String UserEmail;

	private String UserName;
	private int CartQty;
	private String FirstName;
	private String LastName;
	private String socialId;
	private String password;

	private String Day;
	private String Month;
	private String Year;
	private String Gender;

	public ModelUser() {

	}

	public ModelUser(String UserId, String UserEmail, String UserName,
			int CartQty, String socialId, String password, String Day,
			String Month, String Year, String Gender) {

		if (!TextUtils.isEmpty(socialId))
			this.UserId = UserId;
		else
			this.UserId = "";

		if (!TextUtils.isEmpty(password))
			this.password = password;
		else
			this.password = "";

		if (!TextUtils.isEmpty(UserEmail))
			this.UserEmail = UserEmail;
		else
			this.UserEmail = "";

		if (!TextUtils.isEmpty(UserName))
			this.UserName = UserName;
		else
			this.UserName = "";

		this.CartQty = CartQty;

		if (!TextUtils.isEmpty(socialId))
			this.socialId = socialId;
		else
			this.socialId = "";

		if (!TextUtils.isEmpty(Day))
			this.Day = Day;
		else
			this.Day = "";

		if (!TextUtils.isEmpty(Month))
			this.Month = Month;
		else
			this.Month = "";

		if (!TextUtils.isEmpty(Year))
			this.Year = Year;
		else
			this.Year = "";

		if (!TextUtils.isEmpty(Gender))
			this.Gender = Gender;
		else
			this.Gender = "";

	}

	public ModelUser(String UserId, String UserName, String FirstName,
			String LastName, String UserEmail, String socialId,
			String password, String Day, String Month, String Year,
			String Gender) {

		if (!TextUtils.isEmpty(socialId))
			this.UserId = UserId;
		else
			this.UserId = "";

		if (!TextUtils.isEmpty(UserEmail))
			this.UserEmail = UserEmail;
		else
			this.UserEmail = "";

		if (!TextUtils.isEmpty(password))
			this.password = password;
		else
			this.password = "";

		if (!TextUtils.isEmpty(UserName))
			this.UserName = UserName;
		else
			this.UserName = "";

		if (!TextUtils.isEmpty(FirstName))
			this.FirstName = FirstName;
		else
			this.FirstName = "";

		if (!TextUtils.isEmpty(LastName))
			this.LastName = LastName;
		else
			this.LastName = "";

		if (!TextUtils.isEmpty(socialId))
			this.socialId = socialId;
		else
			this.socialId = "";

		if (!TextUtils.isEmpty(Day))
			this.Day = Day;
		else
			this.Day = "";

		if (!TextUtils.isEmpty(Month))
			this.Month = Month;
		else
			this.Month = "";

		if (!TextUtils.isEmpty(Year))
			this.Year = Year;
		else
			this.Year = "";

		if (!TextUtils.isEmpty(Gender))
			this.Gender = Gender;
		else
			this.Gender = "";
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {

		if (!TextUtils.isEmpty(day))
			this.Day = day;
		else
			this.Day = "";
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {

		if (!TextUtils.isEmpty(month))
			this.Month = month;
		else
			this.Month = "";
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {

		if (!TextUtils.isEmpty(year))
			this.Year = year;
		else
			this.Year = "";
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		if (!TextUtils.isEmpty(gender))
			this.Gender = gender;
		else
			this.Gender = "";
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String UserId) {

		if (!TextUtils.isEmpty(UserId))
			this.UserId = UserId;
		else
			this.UserId = "";
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String UserEmail) {
		if (!TextUtils.isEmpty(UserEmail))
			this.UserEmail = UserEmail;
		else
			this.UserEmail = "";

	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {

		if (!TextUtils.isEmpty(UserName))
			this.UserName = UserName;
		else
			this.UserName = "";
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

	public int getCartQty() {
		return CartQty;
	}

	public void setCartQty(int CartQty) {
		this.CartQty = CartQty;

	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		if (!TextUtils.isEmpty(socialId))
			this.socialId = socialId;
		else
			this.socialId = "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		if (!TextUtils.isEmpty(password))
			this.password = password;
		else
			this.password = "";

	}
}
