package linkBroken_screenShot;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Capture full page screenshot - selenium 3 & 4
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\fullpage.png");
		FileUtils.copyFile(src, trg);
		 
		
//		 capture screenshot of specific area from webpage -- selenium 4+
		
		WebElement featuredproducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File src1=featuredproducts.getScreenshotAs(OutputType.FILE);
		File trg1=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\featureproducts.png");
		
		FileUtils.copyFile(src1, trg1);
		
		
		
		// capture screenshot of specific Web element -- selenium 4+
		
//			WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//		
//			File src=logo.getScreenshotAs(OutputType.FILE);
//			File trg=new File("E:\\java\\WebDriver_Selinium\\ScreenShot\\logo.png");
//			FileUtils.copyFile(src, trg);
//				
				
				
		
	}

}
