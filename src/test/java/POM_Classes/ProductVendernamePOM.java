package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilityClasses.ExcelUtility;
import GenericUtilityClasses.FileUtility;
import GenericUtilityClasses.JavaUtility;
import GenericUtilityClasses.WebDriverUtility;
import POM_Repositery.LoginPagePOM;
import POM_Repositery.ProductVendernamePage;

public class ProductVendernamePOM {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
		
		String browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		String productname=elib.getDataFromExcel("product", 1, 2)+jlib.getRandomNumber();
		String SalesStartdate=elib.getDataFromExcel("product", 1, 3);
		String SalesEnddate=elib.getDataFromExcel("product", 1, 4);
		String vendername=elib.getDataFromExcel("product", 1, 5);
		
		WebDriver driver=null;
		//Launching browser
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		wlib.waitForPageToLoad(driver);
		driver.get(url);

		LoginPagePOM lp = new LoginPagePOM(driver);
		lp.logintoapp("admin", "admin");
		
		ProductVendernamePage pv=new ProductVendernamePage(driver);
		pv.getProduct().click();
		pv.getCreateproductbtn().click();
		pv.getProductnamebtn().click();
		pv.getStartdate().click();
		pv. getEnddate().click();
		
		pv.createproductpage(productname, vendername,driver);
		Thread.sleep(2000);
		
		
		String actproductname=driver.findElement(By.id("dtlview_Product Name")).getText();
		System.out.println(actproductname);
		if(actproductname.equals(productname))
		{
		System.out.println(productname+ "is created==PASS");
		}
		else
		{
		System.out.println(productname+ "is not created==FAIL");
		}
		
		String actvendername=driver.findElement(By.xpath("//td[@id='mouseArea_Vendor Name']//a[contains(text(),'Ketan')]")).getText();
		System.out.println(actvendername);
		if(actvendername.equals(vendername))
		{
		System.out.println(vendername+ "is created==PASS");
		}
		else
		{
		System.out.println(vendername+ "is not created==FAIL");
		}
	    pv.logout();
		driver.quit();	
		

	}

}
