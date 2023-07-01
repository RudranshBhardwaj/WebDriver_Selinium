package parallel;

import org.testng.annotations.Test;

public class InvocationCountDemo {

	@Test(invocationCount=10)//run 10 times
	void test()
	{
	System.out.println("testing...");	
	}
	
}
