package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utilSection.Constants;
import com.qa.opencart.utilSection.ExcelUtil;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accountPageSetUp() {
		accountpage = loginpage.clickingLoginBtn(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@Test(priority = 1)
	public void getAccountPageTitleTest() {
		String actTitle = accountpage.getAccountPageTitle();
		Assert.assertEquals(actTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void getAccountPageHeaderTest() {
		String header = accountpage.getAccountPageHeader();
		Assert.assertEquals(header, Constants.ACCOUNT_PAGE_HEADER);
	}
	
	@Test(priority = 3)
	public void verifyLogoutExist() {
		Assert.assertTrue(accountpage.logoutLinkExist());
	}
	
	@Test(priority = 4)
	public void getHeaderSectionTest() {
		List<String> headerList = accountpage.getHeaderSection();
		Assert.assertEquals(headerList, Constants.expectedHeaderSectionList());
	}
	
	
//	@DataProvider
//	public Object[][] productData() {
//		return new Object[][] {
//			{"Macbook"},
//			{"Apple"},
//			{"Samsung"}
//		};
//	}
	
	@DataProvider
	public Object[][] getexcelMainProductData() {
		return ExcelUtil.getExcelData(Constants.MAINPRODUCT_SHEET_NAME);
	}
	
	
	@Test(priority = 5, dataProvider = "getexcelMainProductData")
	public void doSearchTest(String productName) {
		searchPage = accountpage.doSearch(productName);
		Assert.assertTrue(searchPage.getProductCountList()>0);
	}
	
	
//	@DataProvider
//	public Object[][] productSelectData() {
//		return new Object[][] {
//			{"Macbook", "MacBook Pro"},
//			{"Apple", "Apple Cinema 30\""},
//			{"Samsung", "Samsung SyncMaster 941BW"},
//			{"imac", "iMac"	}
//		};
//	} 
	
	@DataProvider
	public Object[][] getexcelProductData() {
		return ExcelUtil.getExcelData(Constants.PRODUCT_SHEET_NAME);
	}
	
//	@Test(priority = 6, dataProvider = "productSelectData" )
//	public void selectProduct(String productName, String mainProductName) {
//		searchPage = accountpage.doSearch(productName);
//		productInfoPage= searchPage.selectProduct(mainProductName);
//		Assert.assertEquals(productInfoPage.getPrdouctInfoPageHeader(), mainProductName);
//	}
	
	@Test(priority = 6, dataProvider = "getexcelProductData" )
	public void selectProduct(String productName, String mainProductName) {
		searchPage = accountpage.doSearch(productName);
		productInfoPage= searchPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getPrdouctInfoPageHeader(), mainProductName);
	}
	

}
