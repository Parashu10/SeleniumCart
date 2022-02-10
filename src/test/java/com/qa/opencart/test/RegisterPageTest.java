package com.qa.opencart.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utilSection.Constants;
import com.qa.opencart.utilSection.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void setRegistration() {
		registerPage = loginpage.goToRegisterLink();
	}
	
	public String rnadomEmail() {
		Random randomGenerator = new Random();
		String emailID = "sept2022" +randomGenerator.nextInt(1000)+"@gmail.com";
		return emailID;
	}
	
	
	@DataProvider
	public Object[][] getexcelRegisterData() {
		return ExcelUtil.getExcelData(Constants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getexcelRegisterData")
	public void  registrationTest(String firstName , String lastName , String telephone, String password, String subscribe) {
		
		Assert.assertTrue(registerPage.registerUser( firstName ,  lastName,  rnadomEmail(),  telephone,  password,  subscribe));
		
	}
}

