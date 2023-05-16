package selinium_webDriver_Css_Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css_locator {

	

			public static void main(String[] args) throws InterruptedException {
				
				WebDriver driver=new ChromeDriver();
				
				driver.get("https://demo.nopcommerce.com/");
				driver.manage().window().maximize();


				//css with tag & id
				//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
				//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");

				//tag class
				//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
				//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("MacBook");
				
				//tag & attribute
				
				//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("MacBook");
				//driver.findElement(By.cssSelector("[name='q']")).sendKeys("MacBook");
				
				//tag class & attribute
				driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("MacBook");
				
//				driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.product-grid.home-page-product-grid > div.item-grid > div:nth-child(1) > div > div.picture > a > img")).click();
			Thread.sleep(10000);
				driver.quit();
			}

		

	

}
