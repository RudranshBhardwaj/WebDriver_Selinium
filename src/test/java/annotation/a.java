package annotation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class a {
 
	@BeforeSuite
	void hi() {
		System.out.println("suite call");
	}
	@AfterSuite
	void by() {
		System.out.println("after suite");
	}
	
}
