package TestNg_Classes;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtilityClasses.BaseClass;
import GenericUtilityClasses.ListImpClass;
import GenericUtilityClasses.UtilityClassObject;
import POM_Repositery.CampaignProductPage;
import POM_Repositery.CampaignProductPartnumber;
import POM_Repositery.HomePage;
import junit.framework.Assert;


@Listeners(GenericUtilityClasses.ListImpClass.class)
public class TestNgCampaign extends BaseClass {
	
	@Test(groups = {"smokeTest","regressionTest"})
	
	public void CreateCampaignProduct() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		String Campaignname=elib.getDataFromExcel("campaign", 1, 5)+jlib.getRandomNumber();
		String Productname=elib.getDataFromExcel("campaign", 1, 4);
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from HomePage");
		HomePage hp = new HomePage(driver);
		hp.getMorelink().click();
		hp.getCampaignslink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from CampaignProductPage");
		CampaignProductPage cp=new CampaignProductPage(driver);
		cp.getMorebtn().click();
		cp.getCampaignbtn().click();
		cp.getCreatecampaignbtn().click();
		
		cp.createcampaignwithproductpage(Campaignname, Productname, driver);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,Campaignname+ "=======>Read Data from Excel");
		String actcampaignname=cp.getHardassert().getText();
		boolean status=actcampaignname.contains(Campaignname);
		Assert.assertEquals(status, true);
		Reporter.log(Campaignname+"ProductName Test Case Pass",true);	
	}
	
	
	
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateProductPartNumber() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		String Campaignname=elib.getDataFromExcel("campaign", 1, 5)+jlib.getRandomNumber();
		String PartNumber=elib.getDataFromExcel("campaign", 1, 3);
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from HomePage");
		HomePage hp = new HomePage(driver);
		hp.getMorelink().click();
		hp.getCampaignslink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from CampaignProductPage");
		CampaignProductPartnumber cm=new CampaignProductPartnumber(driver);
		cm.getMorebtn().click();
		cm.getCampaignbtn().click();
		cm.getCreatecampaignbtn().click();
		
		cm.createCampaignpartnumberpage(Campaignname,PartNumber,driver);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,Campaignname+ "======>Read Data from Excel");
		String actcampaignname=cm.getHardassert().getText();
		boolean status=actcampaignname.contains(Campaignname);
		Assert.assertEquals(status, true);
		Reporter.log(Campaignname+"PartNumber Test Case Pass",true);
		
	
	}

}
