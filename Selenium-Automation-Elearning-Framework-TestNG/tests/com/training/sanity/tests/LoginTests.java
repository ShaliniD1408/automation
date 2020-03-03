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

public class LoginTests {

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
		//driver.get("http://realty-real-estatem1.upskills.in/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(100);
		driver.quit();
	}
	
	@Test(enabled =false )
	public void validLoginTest() {
		/*loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
	loginPOM.clickLoginBtn(); 
		loginPOM.clickOnLogin();*/
		/*driver.findElement(By.className("sign-in")).click();
		driver.findElement(By.cssSelector("#sign-in")).click();
		driver.findElement(By.id("user_login")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("manzoor");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText(" Lost Your Password?")).click();
				driver.findElement(By.id("user_login")).sendKeys("manzoor@gmail.com");
				driver.findElement(By.name("submit")).click();
		driver.findElement(By.name("pwd")).sendKeys("manzoor");
		driver.findElement(By.name("login")).click();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);*/
		//screenShot.captureScreenShot("First");
	}

	@Test(priority =3, enabled = true )
	public void RETC_011() {
		driver.findElement(By.className("sign-in")).click();
		driver.findElement(By.id("user_login")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("manzoor");
		driver.findElement(By.name("login")).click();
		screenShot.captureScreenShot();
	}
	
	@Test(priority=2, enabled = true)
	public void RETC_012()
	{
		driver.findElement(By.className("sign-in")).click();
		driver.findElement(By.linkText("Lost Your Password?")).click();
		driver.findElement(By.id("user_login")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.name("submit")).click();
		screenShot.captureScreenShot();
		/*driver.findElement(By.id("user_login")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("manzoor");
		driver.findElement(By.name("login")).click();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);*/
	}
	
	@Test (priority=1,enabled=false)
	public void RETC_023() throws InterruptedException
	{
		driver.findElement(By.className("sign-in")).click();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("admin@123");
		driver.findElement(By.name("login")).click();
		screenShot.captureScreenShot();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("All Users")).click();
		driver.findElement(By.linkText("Add New")).click();
	
		
		driver.findElement(By.id("user_login")).sendKeys("kKKzzzabc1234");
		String username4=driver.findElement(By.id("user_login")).getText();
		System.out.println("NewUSer name1 = "+username4);
		String username5=driver.findElement(By.id("user_login")).getAttribute("Value");
		System.out.println("NewUSer name1 = "+username5);
		driver.findElement(By.id("email")).sendKeys("kKKzzzabc1234@gmail.com");
		driver.findElement(By.id("first_name")).sendKeys("kKKzzzabccc");
		driver.findElement(By.id("last_name")).sendKeys("kKKzzzcccde");
		driver.findElement(By.id("url")).sendKeys("www.google.com");
	/*	//Thread.sleep(4000);
	//	Actions act = new Actions(driver);
		//act.contextClick(driver.findElement(By.linkText("Show password")));
		
	//	WebElement sp= driver.findElement(By.linkText("Show password"));
		//	Actions act = new Actions(driver);
		//	act.moveToElement(sp).click().build().perform();
	/*	WebElement passwordtext = driver.findElement(By.id("pass1-text"));
		WebElement hidebutton = driver.findElement(By.linkText("Hide password"));
		WebElement cancelbutton = driver.findElement(By.linkText("Cancel password change"));
		int len = passwordtext.getAttribute("value").length();
			if(len>0)
			{
				System.out.println("Password is displayed");
				if(hidebutton.isDisplayed()&& cancelbutton.isDisplayed())
		{
					System.out.println("Hide and Cancel button are enabled");
				}
				else
				{
					System.out.println("Hide and Cancel button are NOT enabled");
				}
			}
			else
			{
				System.out.println("Password is NOT displayed");
			}
			//delete above code
			*/
		
			Select role1 = new Select(driver.findElement(By.id("role")));
			role1.selectByVisibleText("Agent");
			Thread.sleep(2000);
			driver.findElement(By.id("createusersub")).click();
		//	Thread.sleep(1000);
			//driver.findElement(By.id("createusersub")).click();
			WebElement message1=driver.findElement(By.id("message"));
			String messagestr=message1.getText();
			System.out.println("Message displayed is "+messagestr);
			if (messagestr.contains("Edit user"))
			{
				System.out.println("User Created Successfully");
			}
			else
			{
				System.out.println("User Created NOT Successfully");
			}
			
			
			
	//	List<WebElement> col=driver.findElements(By.id("the-list"));
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/thead/tr/th"));
		System.out.println("No of columns in the table is: "+col.size());
		for(int i=0;i<col.size();i++)
		{
			//System.out.println(col.get(i).getAttribute("id"));
			String userna=col.get(i).getAttribute("id");
			if (userna.contentEquals("username"))
			{
				
				List<WebElement> row = driver.findElements(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr/td/strong/a"));
				System.out.println("No of rows in the table is: "+row.size());
			for(int j=0;j<row.size();j++)
				{
					//System.out.println(row.get(j).getText());
					String name=row.get(j).getText();
					System.out.println("Row is: "+j+" Data is: "+name);
					if(name.contentEquals("username4"))
					{
						int k=++j;
						int l = ++i;
						int m=++l;
						System.out.println("c:"+l+"R:"+k);
						driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/th/input")).click();
						String oldrole=driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/td[4]")).getText();
						Select role2 = new Select(driver.findElement(By.id("new_role")));
						//role1.selectByVisibleText("Agent");
						role2.selectByVisibleText("Customer");
						driver.findElement(By.id("changeit")).click();
						WebElement message2=driver.findElement(By.id("message"));
						String messagestr1=message2.getText();
						System.out.println("Message displayed is "+messagestr1);
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
					
					}
					
				}
							
			}
		}
	}
	@Test (priority=3,enabled = true)
	public void RETC_022() throws InterruptedException
	{
		driver.findElement(By.className("sign-in")).click();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("admin@123");
		driver.findElement(By.name("login")).click();
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
