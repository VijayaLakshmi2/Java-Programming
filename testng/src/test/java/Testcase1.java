

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {

	/*@Test(priority=0)
	public  void one (){
		System.out.println("Executing test 1");
	}
	
	@Test(priority=1)
	public  void two (){
		System.out.println("Executing test 2");
	}
	
	@Test(priority=2)
	public  void three (){
		System.out.println("Executing test 3");
	}
	
	@Test(priority=1,dependsOnMethods="two")
	public  void four (){
		System.out.println("Executing test 4");
	}*/
	
	/*@Test
	public  void one (){
		System.out.println("Executing test 1");
	}
	
	@BeforeTest
	public  void two (){
		System.out.println("Executing test 2");
	}
	
	@AfterTest
	public  void three (){
		System.out.println("Executing test 3");
	}
	
	@Test
	public  void four (){
		System.out.println("Executing test 4");
	}*/
	
	@Test
	public  void one (){
		System.out.println("Executing test 1");
	}
	
	@BeforeTest
	public  void two (){
		System.out.println("Executing test 2");
	}
	
	@AfterTest
	public  void three (){
		System.out.println("Executing test 3");
	}
	
	@Test
	public  void four (){
		System.out.println("Executing test 4");
	}
}
