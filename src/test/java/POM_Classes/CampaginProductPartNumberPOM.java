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
import POM_Repositery.CampaignProductPartnumber;
import POM_Repositery.LoginPagePOM;

public class CampaginProductPartNumberPOM {
	
	
public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
		
		String browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		String Campaignname=elib.getDataFromExcel("campaign", 1, 5)+jlib.getRandomNumber();
		String PartNumber=elib.getDataFromExcel("campaign", 1, 3);
		
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
	
	
		CampaignProductPartnumber cm=new CampaignProductPartnumber(driver);
		cm.getMorebtn().click();
		cm.getCampaignbtn().click();
		cm.getCreatecampaignbtn().click();
		
		cm.createCampaignpartnumberpage(Campaignname,PartNumber,driver);
		Thread.sleep(2000);
		
		String actcampaignname=driver.findElement(By.id("dtlview_Campaign Name")).getText();
		System.out.println(actcampaignname);
		if(actcampaignname.equals(Campaignname))
		{
		System.out.println(Campaignname+ "is created==PASS");
		}
		else
		{
		System.out.println(Campaignname+ "is not created==FAIL");
		}
		
		cm.logout();
		driver.quit();
}
}
