package POM_Repositery;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportiunityOrgname {
	
	WebDriver driver;
	public OpportiunityOrgname(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	   @FindBy(linkText = "Opportunities")
	   private WebElement opportunitybtn;
	   
	   @FindBy(xpath = "//img[@title='Create Opportunity...']")
	   private WebElement createopportiunitytbtn;
	   
	   @FindBy(name = "potentialname")
		private WebElement opportiunitynamebtn;
	   
	   @FindBy(xpath = "(//img[contains(@title,'Select')])[1]")
		private WebElement searchphoneimg;
	   
	   @FindBy(xpath = "//input[@id='search_txt']")
		private WebElement orgnamebtn;
	   
	   @FindBy(xpath = "//input[@name='search']")
		private WebElement searchbtn;
	   
	   @FindBy(xpath = "//form[@name='selectall']/descendant::a[contains(text(),'faceBook_306')]")
		private WebElement phonenotext;
	   
	   @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
		private WebElement savebtn;
	   
	   @FindBy(id = "dtlview_Opportunity Name")
		private WebElement hardassert;
	   
	   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	   private WebElement adminimg;
		
	   @FindBy(linkText = "Sign Out")
	   private WebElement singout;
	   
	     
	
	public WebElement getOpportunitybtn() {
		return opportunitybtn;
	}

	public WebElement getCreateopportiunitytbtn() {
		return createopportiunitytbtn;
	}

	public WebElement getOpportiunitynamebtn() {
		return opportiunitynamebtn;
	}

	public WebElement getSearchphoneimg() {
		return searchphoneimg;
	}

	public WebElement getOrgnamebtn() {
		return orgnamebtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getPhonenotext() {
		return phonenotext;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getHardassert() {
		return hardassert;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public void createopportunitypage(String opportiunityname,String orgname,WebDriver driver) {
		opportiunitynamebtn.sendKeys(opportiunityname);
		getSearchphoneimg().click();
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String windowId : allWindowId) {
			driver.switchTo().window(windowId);
		}
		
		getOrgnamebtn().sendKeys(orgname);
		getSearchbtn().click();
		getPhonenotext().click();
		
		
		
		
		
		
		
		driver.switchTo().window(parentWindowId);
		savebtn.click();
		
		
		
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}

}

	


