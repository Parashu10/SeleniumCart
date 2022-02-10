package com.qa.opencart.utilSection;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login1";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store";
	public static final int IMAGE_COUNT = 3;
	public static final int MACBOOK_PRO_COUNT = 3;
	public static final String ERR_WHILE_LOGIN = "Warning: No match for E-Mail Address and/or Password.";
	public static final String SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "OpenCartRegistration";
	public static final String PRODUCT_SHEET_NAME = "ProductInfo";
	public static final String MAINPRODUCT_SHEET_NAME = "MainProductData";

	public static List<String> expectedHeaderSectionList() {
		List<String> expHeaderList = new ArrayList<String>();
		expHeaderList.add("My Account");
		expHeaderList.add("My Orders");
		expHeaderList.add("My Affiliate Account");
		expHeaderList.add("Newsletter");
		
		return expHeaderList;
	}
	
	
}
