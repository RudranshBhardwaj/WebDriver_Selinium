package Project_cognizant;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_function {

	WebDriver driver = null;
	TakesScreenshot ts;
	JavascriptExecutor jse;
	

	@BeforeTest
	void input() {
		System.out.println("Select the browser you want to choose: ");
		System.out.println("Press 1 for ChromeBrowser\n  Press 2 for Edge browser");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		WebDriverManager.chromedriver().setup();

		switch (choice) {
		case 1:
			driver = new ChromeDriver();
			ts = (TakesScreenshot) driver;
			jse = (JavascriptExecutor) driver;
			break;
		case 2:
			driver = new EdgeDriver();
			ts = (TakesScreenshot) driver;
			jse = (JavascriptExecutor) driver;
			break;
		default:
			System.out.println("You have Press Wrong Key");
		}
	}

	
	
	@Test(priority = 0)
	void open_page() throws IOException, InterruptedException {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		Thread.sleep(30);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		File src = ts.getScreenshotAs(OutputType.FILE); // taking screenShot
		File trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\fullpage.png");
		FileUtils.copyFile(src, trg);
		
		String title_bar=driver.getTitle();
		Assert.assertEquals(title_bar,"Build my Car - Configuration","Link you have provide is not working" );
	}

	
	
//		//selecting car type
	@Test(priority = 2, dependsOnMethods = { "open_page" })
	void car_type() throws IOException {
		WebElement car = driver.findElement(By.cssSelector("select[name='make']"));
		//Highlight the selected part
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;');", car);

		car.sendKeys("Audi");
		//taking screenShot
		File car_src = ts.getScreenshotAs(OutputType.FILE); // taking screenShot
		File car_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\car_type.png");
		FileUtils.copyFile(car_src, car_trg);

	}
	
	

//		//selecting colour
	@Test(priority = 3, dependsOnMethods = { "open_page" })
	void colour() throws IOException {
		WebElement colour = driver.findElement(By.xpath("//select[@name='color']"));
//		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;');", colour);
		WebElement white = driver.findElement(By.cssSelector("option[value='wt']"));
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid blue;');", white);
		colour.sendKeys("White");

		// screenShot
		
		File colour_src = ts.getScreenshotAs(OutputType.FILE);
		File colour_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\colour.png");
		FileUtils.copyFile(colour_src, colour_trg);
	}

//		//selecting fuel type
	@Test(priority = 4, dependsOnMethods = { "open_page" })
	void click() throws IOException {

		WebElement fuel= driver.findElement(By.xpath("//input[@value='Diesel']"));
		fuel.click();

		//ScreenShot
		File fuel_src = ts.getScreenshotAs(OutputType.FILE);
		File fuel_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\fuel.png");
		FileUtils.copyFile(fuel_src, fuel_trg);
	}

	//
//		//selecting sensor type
	@Test(priority = 5, dependsOnMethods = { "open_page" })
	void sensor() throws IOException {
		WebElement sensor= driver.findElement(By.name("parksensor"));
		sensor.click();

		//ScreenShot
		File sensor_src = ts.getScreenshotAs(OutputType.FILE);
		File sensor_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\optinal.png");
		FileUtils.copyFile(sensor_src, sensor_trg);
	}

//		//Click on Help button
	@Test(priority = 6, dependsOnMethods = { "open_page" })
	void help() throws IOException {
		WebElement help=driver.findElement(By.id("helpbutton"));
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;');", help);
		help.click();
		
//		File help_src = ts.getScreenshotAs(OutputType.FILE);
//		File help_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\help.png");
//		FileUtils.copyFile(help_src, help_trg);
	}

//		//click on online chat support
	@Test(priority = 7, dependsOnMethods = { "open_page" })
	void chat() {
		WebElement chat=driver.findElement(By.id("chatbutton"));
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;');", chat);
		chat.click();
		
//		File online_src = ts.getScreenshotAs(OutputType.FILE);
//		File online_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\online.png");
//		FileUtils.copyFile(online_src, online_trg);
	}

	// click on visit button
	@Test(priority = 8, dependsOnMethods = { "open_page" })
	void visit()  {
		
		WebElement visit=driver.findElement(By.id("visitbutton"));
		//for highlighting the clicked part
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;');", visit);
		visit.click();
		
//		File visit_src = ts.getScreenshotAs(OutputType.FILE);
//		File visit_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\visit.png");
//		FileUtils.copyFile(visit_src, visit_trg);
	}
	//

	@Test(priority = 9, dependsOnMethods = { "open_page" })
	void validation() throws IOException {
		//for screenShot
		File valid_src = ts.getScreenshotAs(OutputType.FILE);
		File valid_trg = new File(System.getProperty("user.dir") + "\\ScreenShot\\last.png");
		FileUtils.copyFile(valid_src, valid_trg);
		
		
		String mainWindow = driver.getWindowHandle();
		System.out.println("Total number of windows are open: " + driver.getWindowHandles().size());
		Set<String> allwindows = driver.getWindowHandles();
		String visitWindow = null;
		for (String window : allwindows) {
			String title = driver.switchTo().window(window).getTitle();

			if (title.equals("Visit Us")) {
				visitWindow = window;
//				System.out.println(driver.getWindowHandle());
			}
		}


		if (visitWindow != null) {
			Assert.assertNotEquals(visitWindow, null, "Browser window with title 'Visit Us' is found.");
		    System.out.println("Browser window with title 'Visit Us' is found.");
//		    driver.switchTo().window(visitWindow);
//		    driver.close();
		} else
		{
//		    System.out.println("Browser window with title 'Visit Us' is not found.");
			Assert.assertNotEquals(visitWindow,null,"Browser window with title 'Visit Us' is not found.");
		}
		driver.switchTo().window(mainWindow);
	}

	@AfterTest()
	void close() {
		driver.close();

		driver.quit();

	}

}
