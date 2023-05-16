package Selinium_webDriver_basictest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
	
		String exptitle="Login: Mercury Tours";
		String actitle=driver.getTitle();
		if(exptitle.equals(actitle)) {
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");	
		}
		driver.close();
	}
} 
