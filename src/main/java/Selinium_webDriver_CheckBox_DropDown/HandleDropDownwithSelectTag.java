package Selinium_webDriver_CheckBox_DropDown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HandleDropDownwithSelectTag {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		//this will capture dropdown
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country-list']"));
		//this will capture all element in dropdown
		Select drpCountry=new Select(drpCountryEle);
		
		//1) Selecting an option from the dropdown
		//three method available for selecting
		//drpCountry.selectByVisibleText("USA");
		 //drpCountry.selectByValue("4"); // use this only if value attribute is present for option tag
		//drpCountry.selectByIndex(3); //France
		
		// 2) Find total options in dropdown
		List<WebElement> options=drpCountry.getOptions();
		System.out.println("total number of options:"+options.size());
		
		//3) print options in console window
		/*for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}*/
		
		//using enhanced loop
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
			
	}

}

