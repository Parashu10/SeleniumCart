package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
//	private By acPageHeader = By.xpath("//div[@id='logo']//a");
	private By acPageHeaderText = By.linkText("Your Store");
	private By logOutButton = By.linkText("Logout");
	private By headerSection = By.xpath("//div[@id = 'content']/h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("span.input-group-btn");
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public String getAccountPageHeader() {
		return driver.findElement(acPageHeaderText).getText();
	}
	
	public List<String> getHeaderSection() {
		List<WebElement> headerSectionList = driver.findElements(headerSection);
		List<String> headerListActual = new ArrayList<String>();
		for (WebElement e : headerSectionList) {
			String text = e.getText();
			headerListActual.add(text);
		}
		return headerListActual;
	}
	
	public boolean logoutLinkExist() {
		return driver.findElement(logOutButton).isDisplayed();
		
	}
	
	public void clickLogout() {
		if(logoutLinkExist()) {
			driver.findElement(logOutButton).click();
		}
	}
	
	public SearchPage doSearch(String productName) {
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(productName);
		driver.findElement(searchButton).click();
		return new SearchPage(driver);
	}
	
	
	
	
	
	
	
}
