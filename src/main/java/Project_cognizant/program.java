package Project_cognizant;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		
		try {
		
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("//select[@name='make']")).sendKeys("Audi");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//select[@name='color']")).sendKeys("White");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@value='Diesel']")).click();
		Thread.sleep(1500);
	
		driver.findElement(By.xpath("//input[@name='parksensor']")).click();
		Thread.sleep(1500);

		

		
		//Click on Help button
		driver.findElement(By.xpath("//button[@id='helpbutton']")).click();
		Thread.sleep(1500);
		//click on online chat support
		driver.findElement(By.xpath("//button[@id='chatbutton']")).click();
		Thread.sleep(1500);
		//click on visit button
		driver.findElement(By.xpath("//button[@id='visitbutton']")).click();
		Thread.sleep(1500);
	
		

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
