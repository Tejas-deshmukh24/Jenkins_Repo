package Package1;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.annotations.Test;

public class ContactTest {
	
	@Test
	public void createcontactTest() {
		
		String url=System.getProperty("url","http://localhost:8080/");
		String browser=System.getProperty("browser","chrome");
		String username=System.getProperty("username","admin");
		String password=System.getProperty("password","admin");
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		System.out.println("Execute createcontactTest");
	}
	
	@Test
	public void modifycontactTest() {
		System.out.println("Execute modifycontactTest");
	}
	
	@Test
	public void deletecontactTest() {
		System.out.println("Execute SuccessfullydeletecontactTest");
	}
	

}
