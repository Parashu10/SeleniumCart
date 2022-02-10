package com.qa.opencart.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utilSection.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100 : open cart login page")
@Story("US 101 : Login form testing")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {
	
	
	@Description("login page title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =1)
	public void loginPageTitleTest() {
		String actualtitle= loginpage.getLoginPageTitle();
		Assert.assertEquals(actualtitle, Constants.LOGIN_PAGE_TITLE );
	}
	
	@Description("URL test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =2)
	public void verifyUrlTest(){
		String url = loginpage.getApplicationUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("Register link test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority =3)
	public void verifyRegisterLink() {
		Assert.assertTrue(loginpage.verifyRegisterLink());
	}
	
	@Description("Pwd link test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority =4, enabled=false)
	public void verifypwdLink() {
		Assert.assertTrue(loginpage.verifyRegisterLink());
	}
	
	@Description("login test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority =5)
	public void loginBtnTest() {
		accountpage = loginpage.clickingLoginBtn( prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertEquals(accountpage.getAccountPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}

}
