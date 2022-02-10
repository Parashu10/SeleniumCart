package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductInfoPage {
	
	private WebDriver driver;
	
	public Map<String, String> productInfomap;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By imagesCount = By.cssSelector(".col-sm-8 img");
	private By metaproductData = By.cssSelector("#content ul.list-unstyled:nth-of-type(1) li");
	private By productHeader = By.xpath("//div[@id = 'content']//h1");
	private By metapriceData = By.cssSelector("#content ul.list-unstyled:nth-of-type(2) li");
//	private By buttonAdd = By.id("button-cart");
	
	
	public String getPrdouctInfoPageHeader() {
		String text = driver.findElement(productHeader).getText();
		return text;
	}
	
	public int getImagesCount() {
		return driver.findElements(imagesCount).size();
	}
	
	public Map<String, String> getProductInfomap() {
		productInfomap = new TreeMap<String,String>();
		productInfomap.put("MetaData",getPrdouctInfoPageHeader());
		getProductMetadata();
		getProductpricedata();
		return productInfomap;
	}
	
	private void getProductMetadata() {
		List<WebElement> productMetaList = driver.findElements((metaproductData));
		for(WebElement e : productMetaList) {
			String text = e.getText();
			String[] temp = text.split(":");
			String key = temp[0].trim();
			String value = temp[1].trim();
			productInfomap.put(key, value );
		}
		
	}
	
	private void getProductpricedata() {
		List<WebElement> productMetaList = driver.findElements((metapriceData));
		String metakey = productMetaList.get(0).getText().trim();
		String Metavalue = productMetaList.get(1).getText().trim();
		productInfomap.put("price", metakey );
		productInfomap.put("EXprice", Metavalue );
		}
		
	}
	