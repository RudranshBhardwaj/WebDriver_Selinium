package Project_cognizant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class program {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Select the browser you want to choose: ");
		System.out.println("Press 1 for ChromeBrowser or Press 2 for Edge browser");
		int choice=sc.nextInt();
		WebDriver driver = null;
		
		switch (choice) {
		case 1:
			
			 driver=new ChromeDriver();

		break;
		
		case 2:
			driver=new EdgeDriver();
			break;
		
		default:
			System.out.println("You have Press Wrong Key");
		}
		
		try {
			
		TakesScreenshot ts=(TakesScreenshot)driver;
			
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//taking 
		
		
		//selecting car type
		driver.findElement(By.cssSelector("select[name='make']")).sendKeys("Audi");
		Thread.sleep(1500);
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\fullpage.png");
		FileUtils.copyFile(src, trg);
		
		driver.findElement(By.xpath("//select[@name='color']")).sendKeys("White");
//		Thread.sleep(1500);
		File colour=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\colour.png");
		FileUtils.copyFile(src, colour);
		
		
		driver.findElement(By.xpath("//input[@value='Diesel']")).click();
//		Thread.sleep(1500);
		File fuel=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\fuel.png");
		FileUtils.copyFile(src, fuel);
		
		driver.findElement(By.name("parksensor")).click();
//		Thread.sleep(1500);
		File optinal=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\optinal.png");
		FileUtils.copyFile(src, optinal);

		

		
		//Click on Help button
		driver.findElement(By.id("helpbutton")).click();
//		Thread.sleep(1500);
		//click on online chat support
		driver.findElement(By.id("chatbutton")).click();
//		Thread.sleep(1500);
		//click on visit button
		driver.findElement(By.id("visitbutton")).click();
//		Thread.sleep(1500);
	
		

		String mainWindow = driver.getWindowHandle();
		
		
		System.out.println("Total number of windows are open: "+driver.getWindowHandles().size());
	
		Set<String> allwindows = driver.getWindowHandles();
		

		String visitWindow = null;
		for (String window : allwindows) {
		   String title= driver.switchTo().window(window).getTitle();
		    if (title.equals("Visit Us")) {
		        visitWindow = window;
//		        System.out.println(driver.getWindowHandle()); 
		    } 
		}
		
		if (visitWindow != null) {
		    System.out.println("Browser window with title 'Visit Us' is found.");
		    driver.switchTo().window(visitWindow);
		    driver.close();
		} else {
		    System.out.println("Browser window with title 'Visit Us' is not found.");
		}
		driver.switchTo().window(mainWindow);

	
	
	 } catch (NoSuchWindowException e) {
	      System.out.println("Unable to find the window: " + e.getMessage());
	    } finally {
	      driver.quit();
	    }
		
	}
}
