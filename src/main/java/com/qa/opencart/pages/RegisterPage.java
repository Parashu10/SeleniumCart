package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilSection.Constants;
import com.qa.opencart.utilSection.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil ele;
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
		ele = new ElementUtil(driver);
	}
	
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By passwordConfirm = By.id("input-confirm");
	private By subscribeYes	= By.xpath("(//label[@class='radio-inline']/input[@type='radio'])[position()=1]");
	private By subscribeNo	= By.xpath("(//label[@class='radio-inline']/input[@type='radio'])[position()=2]");
	private By agree = By.name("agree");
	private By continuebutton = By.cssSelector(".btn.btn-primary");
	private By regLink = By.linkText("Register");
	private By message = By.cssSelector("div#content h1");
	private By logout	= By.linkText("Logout");
	
	
	public boolean registerUser(String firstName, String lastName, String email, String telephone, String password, String subscribe) {
		ele.doSendKeys(this.firstName, firstName);
		ele.doSendKeys(this.lastName, lastName);
		ele.doSendKeys(this.email, email);
		ele.doSendKeys(this.telephone, telephone);
		ele.doSendKeys(this.password, password);
		ele.doSendKeys(this.passwordConfirm, password);
		if(subscribe.equals("Yes")) {
			driver.findElement(subscribeYes).click();
		}
		else {
			driver.findElement(subscribeNo).click();
		}
		driver.findElement(agree).click();
		driver.findElement(continuebutton).click();
		String msg= driver.findElement(message).getText();
		if(msg.contains(Constants.SUCCESS_MESSAGE)){
			driver.findElement(logout).click();
			driver.findElement(regLink).click();
			return true;
		}
		return false;
	}
	
	

}
