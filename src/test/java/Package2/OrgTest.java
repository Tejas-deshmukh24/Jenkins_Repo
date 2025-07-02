package Package2;

import org.testng.annotations.Test;

public class OrgTest {
	
	@Test
	public void createcOrgTest() {
		System.out.println("Execute createOrgTest successful");
		String url=System.getProperty("url","http://localhost:8080/");
		String browser=System.getProperty("browser","chrome");
		String username=System.getProperty("username","admin");
		String password=System.getProperty("password","admin");
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		System.out.println("Execute createOrgTest");
	}
	
	@Test
	public void modifyOrgTest() {
		System.out.println("Execute modifyOrgTest");
	}
	

}
