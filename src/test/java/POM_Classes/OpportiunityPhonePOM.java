package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilityClasses.ExcelUtility;
import GenericUtilityClasses.FileUtility;
import GenericUtilityClasses.JavaUtility;
import GenericUtilityClasses.WebDriverUtility;
import POM_Repositery.LoginPagePOM;
import POM_Repositery.OpportiunityPhone_Page;

public class OpportiunityPhonePOM {
	
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
		String phonenumber=elib.getDataFromExcel("opportiunity", 1, 5);
//		String SalesEnddate=elib.getDataFromExcel("product", 1, 4);
		
		WebDriver driver=new ChromeDriver();
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		
		LoginPagePOM lp = new LoginPagePOM(driver);
		lp.logintoapp("admin", "admin");
	
		OpportiunityPhone_Page om=new OpportiunityPhone_Page(driver);
		om.getOpportunitybtn().click();
		om.getCreateopportiunitytbtn().click();
		om.getOpportiunitynamebtn().click();
		
		
		om.createopportunitypage(opportiunityname,phonenumber,driver);
		
		Thread.sleep(2000);
		
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
		
		om.logout();
		driver.quit();
		
		
	}

}
