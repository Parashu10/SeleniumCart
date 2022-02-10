package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilSection.ElementUtil;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtil ele;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementUtil(driver);
	}
	
	
	By produtCount = By.cssSelector("div.caption a");
	
	public int getProductCountList() {
	 int count = ele.waitForElementsToBeVisible(produtCount, 10, 2000).size();
		System.out.println("Count");
		return count;
	}
	
	
	public ProductInfoPage selectProduct(String mainProductName) {
		List<WebElement> productList = ele.waitForElementsToBeVisible(produtCount, 10, 2000);
		for(WebElement e : productList) {
			String text = e.getText();
			if(text.equals(mainProductName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}

}
