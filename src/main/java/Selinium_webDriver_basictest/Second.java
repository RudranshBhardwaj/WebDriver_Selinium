
//Test case
//--------
//1) Launch browser
//2) open url
//	https://opensource-demo.orangehrmlive.com/
//3) Provide username  - Admin
//4) Provide password  - admin123
//5) Click on Login button 
//6) Verify the title of dashboard page   
//	Exp title : OrangeHRM
//7) close browser
//

package Selinium_webDriver_basictest;

import java.sql.Driver;
import  org.openqa.selenium.NoSuchElementException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Second {
	
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	//This will maximize the page
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	// when page will load, it will wait for 5sec.
	Thread.sleep(5000);
	driver.findElement(By.name("username")).sendKeys("aaaaadmin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	
	//Even the login will Fail the title validation will pass
	
	//Title validation
//	
//	String act_title=driver.getTitle();
//	String exp_titleString="OrangeHRM";
//	if(act_title.equals(exp_titleString)) {
//		System.out.println("pass");
//	}
//	else {
//		System.out.println("Fail");
//		
//	}
	//driver.close();
	//it will give SocketException error
	//so use this
	
	//Now we are using Lable validation after successful login
	Thread.sleep(5000);
	//Here problem is that when you try to login with invalid user/pass, then it will show error because lower page is not opened yet, and you are trying to find the element.
	// put this in try and catch
	String act_title=null;
	try {
	 act_title= driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
	 
	}
	catch (NoSuchElementException e) {
		// TODO: handle exception
		act_title="";
	}
	String exp_titleString="Dashboard";
	if (act_title.equals(exp_titleString)){
		System.out.println("successful login");
	}
	else {
		System.out.println("not login successful");
	}
	
	
//	driver.quit();
	}
}
