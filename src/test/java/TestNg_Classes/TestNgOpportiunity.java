package TestNg_Classes;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtilityClasses.BaseClass;
import GenericUtilityClasses.UtilityClassObject;
import POM_Repositery.HomePage;
import POM_Repositery.OpportiunityOrgname;
import POM_Repositery.OpportiunityPhone_Page;
import junit.framework.Assert;


@Listeners(GenericUtilityClasses.ListImpClass.class)
public class TestNgOpportiunity extends BaseClass {
	
	@Test(groups = {"smokeTest","regressionTest"})
	
	public void CreateOpportiunityOrgname() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		String opportiunityname=elib.getDataFromExcel("opportiunity", 1, 2)+jlib.getRandomNumber();
		String orgname=elib.getDataFromExcel("opportiunity", 1, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Read Data from HomePage");
		HomePage hp = new HomePage(driver);
		hp.getOpportunitybtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from OpportiunityOrgname");
		OpportiunityOrgname op=new OpportiunityOrgname(driver);
		op.getOpportunitybtn().click();
		op.getCreateopportiunitytbtn().click();
		op.getOpportiunitynamebtn().click();
		
		op.createopportunitypage(opportiunityname, orgname,driver);
		
		UtilityClassObject.getTest().log(Status.INFO,opportiunityname+ "=======>Read Data from Excel");
		String actopportiunityname=op.getHardassert().getText();
		boolean status=actopportiunityname.contains(opportiunityname);
		Assert.assertEquals(status, true);
		Reporter.log(opportiunityname+"OrgName Test Case Pass",true);	
	}
	
      
	
	@Test(groups = {"smokeTest","regressionTest"})
	
	public void CreateOpportiunityPhone() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		String opportiunityname=elib.getDataFromExcel("opportiunity", 1, 2)+jlib.getRandomNumber();
		String phonenumber=elib.getDataFromExcel("opportiunity", 1, 5);
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from HomePage");
		HomePage hp = new HomePage(driver);
		hp.getOpportunitybtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from OpportiunityPhone_Page");
		OpportiunityPhone_Page om=new OpportiunityPhone_Page(driver);
		om.getOpportunitybtn().click();
		om.getCreateopportiunitytbtn().click();
		om.getOpportiunitynamebtn().click();
		
		
		om.createopportunitypage(opportiunityname,phonenumber,driver);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,opportiunityname+ "=======>Read Data from Excel");
		String actopportiunityname=om.getHardassert().getText();
		boolean status=actopportiunityname.contains(opportiunityname);
		Assert.assertEquals(status, true);
		Reporter.log(opportiunityname+"PhoneNumber Test Case Pass",true);
			
	}

}
