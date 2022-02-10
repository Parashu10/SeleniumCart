package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest {
	
	
	@DataProvider
	public Object[][] wrongData() {
		return new Object[][] {
			{"test@123", "test"},
			{"test@12", "test12"},
			{"naveenanimation20@gmail.com", "test"},
			{"naveenanimatssion20@gmail.com", "Selenium12345"},
			{"", ""}
		};
	}
	
	
	@Test(dataProvider ="wrongData" )
	public void loginNegativeTest(String username, String Paswd) {
//		Assert.assertFalse(loginpage.loginwithWrongCredential(username, Paswd));
		
		Boolean flag = loginpage.loginwithWrongCredential(username, Paswd);
		Assert.assertFalse(flag);
		
	}

}
