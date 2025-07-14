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
import POM_Repositery.ProductVenderEmailPage;

public class ProductVenderemailPOM {

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
		String venderemail=elib.getDataFromExcel("product", 1, 6);
		
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
		
		ProductVenderEmailPage pe=new ProductVenderEmailPage(driver);
		pe.getProduct().click();
		pe.getCreateproductbtn().click();
		pe.getProductnamebtn().click();
		pe.getStartdate().click();
		pe. getEnddate().click();
		
		pe.createproductpage(productname, venderemail, driver);
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
		
		
		pe.logout();
		driver.quit();

		
		
		

	}

}
