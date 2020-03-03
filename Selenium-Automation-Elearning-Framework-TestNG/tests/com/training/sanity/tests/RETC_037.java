package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_037 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(100);
		driver.quit();
	}
	
	@Test(priority =3, enabled = true )
	public void RETC_037() throws InterruptedException {
		driver.findElement(By.className("sign-in")).click();
		loginPOM.enterUserName("Admin");
		loginPOM.enterPassword("admin@123");
		loginPOM.clickOnLoginWithAccount();
		driver.findElement(By.linkText("Real Estate")).click();
driver.findElement(By.linkText("Plots")).click();
driver.findElement(By.partialLinkText("Nullam")).click();
Thread.sleep(2000);
driver.findElement(By.name("your-name")).sendKeys("Tata");
driver.findElement(By.name("your-email")).sendKeys("tata@gmail.com");
driver.findElement(By.name("your-subject")).sendKeys("Enquiry regarding Nullam apartment");
driver.findElement(By.name("your-message")).sendKeys("Please let me know when the apartment will be completed");
driver.findElement(By.xpath("//input[@type='submit']")).click();
		screenShot.captureScreenShot();
	}

	}
	
