package Project_cognizant;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driver {
	public static void main(String arg[]){

		System.out.println("Select the browser you want to choose: ");
		System.out.println("Press 1 for ChromeBrowser or Press 2 for Edge browser");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		WebDriverManager.chromedriver().setup();

		switch (choice) {
		case 1:
			break;
		case 2:
			break;
		default:
			System.out.println("You have Press Wrong Key");
		}
	}
}
