package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilSection.Constants;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	
	//1//Own private Web Driver
	//2 constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. By locators
	
	By emailid = By.id("input-email");
	By password = By.id("input-password");
	By loginbtn = By.xpath("//input[@value = 'Login']");
	By registerLink = By.linkText("Register");
	By forgotpwd = By.linkText("Forgotten Password");
	By wrongError = By.cssSelector(".alert.alert-danger.alert-dismissible");
	
	//4 . Page Actions
	
	
	@Step("--------login page title test 1234-------") 
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getApplicationUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean verifyRegisterLink() {
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public boolean verifyforgotpwdLink() {
		return driver.findElement(forgotpwd).isDisplayed();
	}
	
	@Step("do login with username: {0} + password {1}")
	public AccountPage clickingLoginBtn(String un, String pwd) {
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		return new AccountPage(driver);
	}
	
	public boolean loginwithWrongCredential(String username, String pawd) {
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(password).sendKeys(pawd);
		driver.findElement(loginbtn).click();
		String errMsg = driver.findElement(wrongError).getText();
		if(errMsg.contains(Constants.ERR_WHILE_LOGIN)) {
			return false;
		}
		return true;
		
		
	}
	
	public RegisterPage goToRegisterLink() {
	driver.findElement(registerLink).click();
	return new RegisterPage(driver);
}
	
	

}
