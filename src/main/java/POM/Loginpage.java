//package POM;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//public class Loginpage {
//	WebDriver driver;
//	//constructor
//	public Loginpage(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//		this.driver=driver;
//		System.out.println("contructor called");
//	}
//	//Locator
//	By logo=By.xpath("//img[@alt='company-branding']");
//	By username=By.xpath("//input[@placeholder='Username']");
//	By password=By.xpath("//input[@placeholder='Password']");
//	By loginBy=By.xpath("//button[normalize-space()='Login']");
//
//	//Action method
//	public void userna(String user_keys) {
//		driver.findElement(username).sendKeys(user_keys);
//	}
//	public void password(String pass_keys) {
//		driver.findElement(password).sendKeys(pass_keys);
//	}
//	public void submit() {
//		driver.findElement(loginBy).click();
//	}
//	public boolean logoPresence() {
//		return	driver.findElement(loginBy).isDisplayed();
//	}
//}
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	public WebDriver driver;
	
	//Constructor
	Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// locators
	By img_logo_loc=By.xpath("//img[@alt='company-branding']");
	By txt_username_loc=By.name("username");
	By txt_password_loc=By.cssSelector("input[placeholder='Password']");
	By btn_submit_loc=By.xpath("//button[normalize-space()='Login']");
	
	
	//Action methods
	
	public void setUserName(String username)
	{
		driver.findElement(txt_username_loc).sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(txt_password_loc).sendKeys(password);
	}
	
	public void clickSubmit()
	{
		driver.findElement(btn_submit_loc).click();
	}
	
	public boolean checkLogoPresence()
	{
		boolean status=driver.findElement(img_logo_loc).isDisplayed();
		return status;
	}
	
	
}
