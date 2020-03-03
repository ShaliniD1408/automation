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

public class RETC_023 {

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
	

	@Test (priority=3,enabled = true)
	public void RETC_022() throws InterruptedException
	{
		driver.findElement(By.className("sign-in")).click();
		loginPOM.enterUserName("admin");
		loginPOM.enterPassword("admin@123");
		loginPOM.clickOnLoginWithAccount();
		screenShot.captureScreenShot();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("All Users")).click();
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/thead/tr/th"));
		System.out.println("No of columns in the table is: "+col.size());
		try
		{
		for(int i=0;i<col.size();i++)
		{
			String userna=col.get(i).getAttribute("id");
			if (userna.contentEquals("username"))
			{
				
				List<WebElement> row = driver.findElements(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr/td/strong/a"));
				System.out.println("No of rows in the table is: "+row.size());
			for(int j=0;j<row.size();j++)
				{
					
					String name=row.get(j).getText();
					//System.out.println("Row is: "+j+" Data is: "+name);
					if(name.contentEquals("abc1"))
					{
						int k=++j;
						int l = ++i;
						int m=++l;
						//System.out.println("c:"+l+"R:"+k);
						driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/th/input")).click();
						String oldrole=driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/td[4]")).getText();
						Select role1 = new Select(driver.findElement(By.id("new_role")));
						role1.selectByVisibleText("Agent");
						//role1.selectByVisibleText("Customer");
						driver.findElement(By.id("changeit")).click();
						WebElement message1=driver.findElement(By.id("message"));
						String messagestr=message1.getText();
						System.out.println("Message displayed is "+messagestr);
						if(messagestr.contains("Changed roles"))
						{
							System.out.println("Role change was successful");
							
						}
						else
						{
							System.out.println("Role change was NOT successful");
						}
						String newrole=driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/td[4]")).getText();
						System.out.println("The role is changed from "+oldrole+" to "+newrole);	
						break;
					
					}
					
					
					
				}
							
			}
		}
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			
		}
		
	}
	
}
