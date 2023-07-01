package MainProjectTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class be {
	public static void main(String[] args) {
		

	WebDriver driver=new ChromeDriver();
	System.out.println("1");
	driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	System.out.println("2");
	driver.manage().window().maximize();
	
	By NewsTitle = By.xpath("//div[@class='e_a_37591358 q_a_37591358']");
	System.out.println("3");
	List <WebElement> newHeading=driver.findElements(NewsTitle);
	for(WebElement news:newHeading) {
		System.out.println(news.getText());
		System.out.println("4");
	}
	driver.quit();
}
}
