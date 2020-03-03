package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userLogin;
	
	public void enterUserName(String userLogin){
		this.userLogin.clear();
		this.userLogin.sendKeys(userLogin);
	}
	
	@FindBy(name="pwd")
	private WebElement userPassword;
	
	public void enterPassword(String userPassword){
		this.userPassword.clear();
		this.userPassword.sendKeys(userPassword);
	}
	@FindBy (name="login")
	private WebElement loginButton;
	
	public void clickOnLoginWithAccount(){
		this.loginButton.click();
	}
	@FindBy (name="submit")
	private WebElement submitButton;
	
	public void clickOnSubmit(){
		this.submitButton.click();
	}
@FindBy(xpath="//*[@id='wpbody-content']/div[3]/form/table/thead/tr/th")
private WebElement col;

	/*@FindBy(class="sign-in")
	private WebElement signin;*/
	
	/*@FindBy(name="log")
	private WebElement usename;*/
	
	/*@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	*/
	public void clickOnLogin()
	{
		//driver.findElement(By.xpath("//*[class='sign-in']")).click();
		//this.signin.click();
	}
	public void enterUsername()
	{
		//this.usename.sendKeys("manzoor@gmail.com");
	}
}
