package Listener;

import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtilityClasses.BaseClass;
import POM_Repositery.HomePage;
import POM_Repositery.ProductVenderEmailPage;
import POM_Repositery.ProductVendernamePage;
import junit.framework.Assert;


@Listeners(GenericUtilityClasses.ListImpClass.class)
public class TestNgProductListener extends BaseClass {
	
	@Test(retryAnalyzer = GenericUtilityClasses.ReteryListenerImp.class)
	
	public void CreateProductVendername() throws Throwable {
		
		String productname=elib.getDataFromExcel("product", 1, 2)+jlib.getRandomNumber();
		String SalesStartdate=elib.getDataFromExcel("product", 1, 3);
		String SalesEnddate=elib.getDataFromExcel("product", 1, 4);
		String vendername=elib.getDataFromExcel("product", 1, 5);
		
		HomePage hp = new HomePage(driver);
		hp.getProduct().click();
		
	
		ProductVendernamePage pv=new ProductVendernamePage(driver);
		pv.getProduct().click();
		pv.getCreateproductbtn().click();
		pv.getProductnamebtn().click();
		pv.getStartdate().click();
		pv. getEnddate().click();
		
		pv.createproductpage(productname, vendername,driver);
		Thread.sleep(2000);
		
		
		String actproductname=pv.getAsserthard().getText();
		boolean status=actproductname.contains(productname);
		Assert.assertEquals(status, false);
		Reporter.log(productname+"VenderName Test Case Pass",true);
		
		String actvendername=driver.findElement(By.xpath("//td[@id='mouseArea_Vendor Name']//a[contains(text(),'Ketan')]")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actvendername, productname);
		soft.assertAll();
}
	
	
	
	@Test(groups = {"smokeTest","regressionTest"})
	
	public void CreateProductEmail() throws Throwable {
		
		String productname=elib.getDataFromExcel("product", 1, 2)+jlib.getRandomNumber();
		String SalesStartdate=elib.getDataFromExcel("product", 1, 3);
		String SalesEnddate=elib.getDataFromExcel("product", 1, 4);
		String venderemail=elib.getDataFromExcel("product", 1, 6);
		
		HomePage hp = new HomePage(driver);
		hp.getProduct().click();
		
		
	
		
		ProductVenderEmailPage pe=new ProductVenderEmailPage(driver);
		pe.getProduct().click();
		pe.getCreateproductbtn().click();
		pe.getProductnamebtn().click();
		pe.getStartdate().click();
		pe. getEnddate().click();
		
		pe.createproductpage(productname, venderemail, driver);
		Thread.sleep(2000);
		
		String actproductname=pe.getHardasserts().getText();
		boolean status=actproductname.contains(productname);
		Assert.assertEquals(status, true);
		Reporter.log(productname+"VenderEmail Test Case Pass",true);
		
		
	}
}
