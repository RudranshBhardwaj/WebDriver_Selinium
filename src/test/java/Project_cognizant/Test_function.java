package Project_cognizant;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test_function {
	
	
	WebDriver driver = null;
	TakesScreenshot ts;
	JavascriptExecutor js=(JavascriptExecutor)driver;

	
	@BeforeTest
	void input() {
		System.out.println("Select the browser you want to choose: ");
		System.out.println("Press 1 for ChromeBrowser or Press 2 for Edge browser");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		
		switch (choice) {
		case 1:
			 driver=new ChromeDriver();
			 ts =(TakesScreenshot)driver;
			 break;
		case 2:
			driver=new EdgeDriver();
			ts =(TakesScreenshot)driver;
			break;
		default:
			System.out.println("You have Press Wrong Key");
		}
	}

	
	@Test(priority = 0)
	void open_page() throws IOException{
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File src=ts.getScreenshotAs(OutputType.FILE);  //taking screenShot
		File trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\fullpage.png");
		FileUtils.copyFile(src, trg);
	}

	
	
	
	
//	//selecting car type
	@Test(priority = 2,dependsOnMethods = {"open_page"})
	void car_type() throws IOException {
	WebElement car= driver.findElement(By.cssSelector("select[name='make']"));
	car.sendKeys("Audi");
	
	File car_src=ts.getScreenshotAs(OutputType.FILE);  //taking screenShot
	File car_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\car_type.png");
	FileUtils.copyFile(car_src, car_trg);
	
	}
//	
//	
//	//selecting colour
	@Test(priority = 3,dependsOnMethods = {"open_page"})
	void colour() throws IOException {
	driver.findElement(By.xpath("//select[@name='color']")).sendKeys("White");
	File colour_src=ts.getScreenshotAs(OutputType.FILE);
	File colour_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\colour.png");
	FileUtils.copyFile(colour_src, colour_trg);
	}
	
//	//selecting fuel type
	@Test(priority = 4,dependsOnMethods = {"open_page"})
	void click() throws IOException {
	driver.findElement(By.xpath("//input[@value='Diesel']")).click();
	
	File fuel_src=ts.getScreenshotAs(OutputType.FILE);
	File fuel_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\fuel.png");
	FileUtils.copyFile(fuel_src, fuel_trg);
	}
	
//	
//	//selecting sensor type
	@Test(priority = 5,dependsOnMethods = {"open_page"})
	void sensor() throws IOException {
	driver.findElement(By.name("parksensor")).click();
	File sensor_src=ts.getScreenshotAs(OutputType.FILE);
	File sensor_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\optinal.png");
	FileUtils.copyFile(sensor_src, sensor_trg);
	}

//	//Click on Help button
	@Test(priority = 6,dependsOnMethods = {"open_page"})
	void help() throws IOException {
	driver.findElement(By.id("helpbutton")).click();
	File help_src=ts.getScreenshotAs(OutputType.FILE);
	File help_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\help.png");
	FileUtils.copyFile(help_src, help_trg);
	}

//	//click on online chat support
	@Test(priority = 7,dependsOnMethods = {"open_page"})
	void chat() throws IOException {
	driver.findElement(By.id("chatbutton")).click();
	File online_src=ts.getScreenshotAs(OutputType.FILE);
	File online_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\online.png");
	FileUtils.copyFile(online_src, online_trg);
	}
//click on visit button
	@Test(priority = 8,dependsOnMethods = {"open_page"})
	void visit() throws IOException {
	driver.findElement(By.id("visitbutton")).click();
	File visit_src=ts.getScreenshotAs(OutputType.FILE);
	File visit_trg=new File(System.getProperty("user.dir")+ "\\ScreenShot\\visit.png");
	FileUtils.copyFile(visit_src, visit_trg);
	}
//	
	
	@Test(priority =9,dependsOnMethods = {"open_page"})
	void validation() {
		
	
	
	String mainWindow = driver.getWindowHandle();
	System.out.println("Total number of windows are open: "+driver.getWindowHandles().size());
	Set<String> allwindows = driver.getWindowHandles();
	String visitWindow = null;
	for (String window : allwindows) {
	   String title= driver.switchTo().window(window).getTitle();
	   
	    if (title.equals("Visit Us")) {
	        visitWindow = window;
	        System.out.println(driver.getWindowHandle()); 
	    } 
	}
	
	Assert.assertNotEquals(visitWindow, null,"Browser window with title 'Visit Us' is found.");
//	if (visitWindow != null) {
//	    System.out.println("Browser window with title 'Visit Us' is found.");
//	    driver.switchTo().window(visitWindow);
//	    driver.close();
//	} else {
//	    System.out.println("Browser window with title 'Visit Us' is not found.");
//	}
	driver.switchTo().window(mainWindow);
	}
	

	
	@AfterTest()
	void close() {
		driver.close();
		
		driver.quit();
	}

}
