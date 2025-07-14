package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilityClasses.ExcelUtility;
import GenericUtilityClasses.FileUtility;
import GenericUtilityClasses.JavaUtility;
import GenericUtilityClasses.WebDriverUtility;
import POM_Repositery.LoginPagePOM;
import POM_Repositery.TrobleTicketContactPage;

public class TroubleticketcontactpagePOM {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
		
		String browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		String Troubleticketname=elib.getDataFromExcel("troubleticket", 1, 2)+jlib.getRandomNumber();
		String contact=elib.getDataFromExcel("troubleticket", 1, 8);
//		String SalesEnddate=elib.getDataFromExcel("product", 1, 4);
		
		WebDriver driver=new ChromeDriver();
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		
		LoginPagePOM lp = new LoginPagePOM(driver);
		lp.logintoapp("admin", "admin");
	
		TrobleTicketContactPage tc=new TrobleTicketContactPage(driver);
		tc.getTroubleticketbtn().click();
		tc.getCreatetroubleticketbtn().click();
		tc.getTitlename().click();
		
		tc.createtroubleticket(Troubleticketname, contact,driver);
		Thread.sleep(2000);
		
		String actopportiunityname=driver.findElement(By.id("dtlview_Title")).getText();
		System.out.println(actopportiunityname);
		if(actopportiunityname.equals(Troubleticketname))
		{
		System.out.println(Troubleticketname+ "is created==PASS");
		}
		else
		{
		System.out.println(Troubleticketname+ "is not created==FAIL");
		}
		
		
		tc.logout();
		driver.quit();

	}

}
