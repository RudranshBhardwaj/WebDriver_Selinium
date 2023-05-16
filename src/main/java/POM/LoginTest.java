//package POM;
//
//import java.time.Duration;
//import  org.junit.Assert;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//public class LoginTest {
//	WebDriver driver;
//	Loginpage lp=new Loginpage(driver);
//	
//	
//	@BeforeClass
//	void setup() throws InterruptedException
//	{
//		
//		driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(5000);
//		System.out.println("lora");
//	}
//	
//	@Test()
//	@Order(1)
//	void testLogo()
//	{
//		
//		
//		Assert.assertEquals(lp.logoPresence(), true);
//		System.out.println(lp.logoPresence());
//	}
//	
////	
////	@Test()
////	@Order(2)
////	void testLogin()
////	{
////		
////		lp.userna("Admin");
////		lp.password("admin123");
////		lp.submit();
////		
////		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
////		System.out.println(driver.getTitle());
////	}
//	
//	@AfterClass
//	void tearDown()
//	{
//		driver.quit();
//	}
//}
package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;



public class LoginTest {
	WebDriver driver;
	Loginpage lp;
//	LoginPage2 lp;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
	}
	
	@Test()
	void testLogo()
	{
		lp=new Loginpage(driver);
//		lp=new LoginPage2(driver);
		
		Assert.assertEquals(lp.checkLogoPresence(), true);
	}
	
	
	@Test()
	void testLogin()
	{
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickSubmit();
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
				
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
