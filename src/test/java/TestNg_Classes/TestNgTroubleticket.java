package TestNg_Classes;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtilityClasses.BaseClass;
import GenericUtilityClasses.UtilityClassObject;
import POM_Repositery.HomePage;
import POM_Repositery.TrobleTicketContactPage;
import POM_Repositery.TroubleticketProductPage;
import junit.framework.Assert;


@Listeners(GenericUtilityClasses.ListImpClass.class)
public class TestNgTroubleticket extends BaseClass{

	@Test(groups = {"smokeTest","regressionTest"})
	
	public void CreateTroubleticketContact() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		String Troubleticketname=elib.getDataFromExcel("troubleticket", 1, 2)+jlib.getRandomNumber();
		String contact=elib.getDataFromExcel("troubleticket", 1, 8);
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from HomePage");
		HomePage hp = new HomePage(driver);
		hp.getTroubleticketbtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from TroubleTicketContactPage");
		TrobleTicketContactPage tc=new TrobleTicketContactPage(driver);
		tc.getTroubleticketbtn().click();
		tc.getCreatetroubleticketbtn().click();
		tc.getTitlename().click();
		
		tc.createtroubleticket(Troubleticketname, contact,driver);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,Troubleticketname+ "=======>Read Data from Excel");
		String actTroubleticketname=tc.getHardassert().getText();
		boolean status=actTroubleticketname.contains(Troubleticketname);
		Assert.assertEquals(status, true);
		Reporter.log(Troubleticketname+"Contact Test Case Pass",true);
	}
	
	
	
	@Test(groups = {"smokeTest","regressionTest"})
	
	public void CreateTroubleticketProduct() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		String Troubleticketname=elib.getDataFromExcel("troubleticket", 1, 2)+jlib.getRandomNumber();
		String productname=elib.getDataFromExcel("troubleticket", 1, 7);
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from HomePage");
		HomePage hp = new HomePage(driver);
		hp.getTroubleticketbtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from TroubleTicketProductPage");
		TroubleticketProductPage tp=new TroubleticketProductPage(driver);
		tp.getTroubleticketbtn().click();
		tp.getCreatetroubleticketbtn().click();
		tp.getTitlename().click();
		
		tp.createtroubleticket(Troubleticketname, productname, driver);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,Troubleticketname+ "=======>Read Data from Excel");
		String actTroubleticketname=tp.getHardassert().getText();
		boolean status=actTroubleticketname.contains(Troubleticketname);
		Assert.assertEquals(status, true);
		Reporter.log(Troubleticketname+"ProductName Test Case Pass",true);
		
	}
}
