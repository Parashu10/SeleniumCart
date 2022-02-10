package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager options;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Your Browser is " + browserName );
		
		options = new OptionsManager(prop);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(options.chromeOptions());
			tldriver.set(new ChromeDriver(options.chromeOptions()));
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver(options.FireFoxOptions());	
			tldriver.set(new FirefoxDriver(options.FireFoxOptions()));
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please pass right browser");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get("https://demo.opencart.com/index.php?route=account/login");
		
		return getDriver();
			
	}
	
	
	public static WebDriver getDriver() {
		return tldriver.get();
	}
	
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;
		
		String env = System.getProperty("env");
		
		if(env==null) {
			System.out.println("running in prod envt");
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Running in envt:" + env);
			try {
			switch (env) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;

			default:
				System.out.println("pass proper envt");
				break;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	public String getScreenShot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
		
	}

}



