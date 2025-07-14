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
import POM_Repositery.OpportiunityOrgname;

public class OpportiunityOrgnamePOM {
	
	public static void main(String[] args) throws Throwable {
	
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	JavaUtility jlib=new JavaUtility();
	
	String browser=flib.getDataFromPropertiesFile("browser");
	String url=flib.getDataFromPropertiesFile("url");
	String Username=flib.getDataFromPropertiesFile("username");
	String Password=flib.getDataFromPropertiesFile("password");
	
	String opportiunityname=elib.getDataFromExcel("opportiunity", 1, 2)+jlib.getRandomNumber();
	String orgname=elib.getDataFromExcel("opportiunity", 1, 3);

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
	
	OpportiunityOrgname op=new OpportiunityOrgname(driver);
	op.getOpportunitybtn().click();
	op.getCreateopportiunitytbtn().click();
	op.getOpportiunitynamebtn().click();
	
	op.createopportunitypage(opportiunityname, orgname,driver);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(orgname);

	driver.findElement(By.xpath("//input[@name='search']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//form[@name='selectall']/descendant::a[contains(text(),'faceBook_306')]")).click();
	
	// switch to child window:
	wlib.switchToTabOnURL(driver, "Potentials&action");

	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	
	String actopportiunityname=driver.findElement(By.id("dtlview_Opportunity Name")).getText();
	System.out.println(actopportiunityname);
	if(actopportiunityname.equals(opportiunityname))
	{
	System.out.println(opportiunityname+ "is created==PASS");
	}
	else
	{
	System.out.println(opportiunityname+ "is not created==FAIL");
	}
	
	op.logout();
	driver.quit();
	
	
	

}
}