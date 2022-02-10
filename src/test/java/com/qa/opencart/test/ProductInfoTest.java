package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utilSection.Constants;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void accountPageSetUp() {
		accountpage = loginpage.clickingLoginBtn(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@Test(priority = 1)
	public void productImagesCount() {
		searchPage = accountpage.doSearch("iMac");
		productInfoPage= searchPage.selectProduct("iMac");
		Assert.assertEquals(productInfoPage.getImagesCount(), Constants.IMAGE_COUNT);
	}
	
	@Test(priority = 2)
	public void productMetadataTest() {
		searchPage = accountpage.doSearch("MacBook");
		productInfoPage= searchPage.selectProduct("MacBook Pro");
		Map<String,String> actualProductMetadata = productInfoPage.getProductInfomap();
		actualProductMetadata.forEach((k,v) -> System.out.println(k+ ":" + v));
		softAssert.assertEquals(actualProductMetadata.get("MetaData"), "MacBook Pro");
		softAssert.assertEquals(actualProductMetadata.get("Product Code"), "Product 18");
		softAssert.assertAll();
		
	}

}
