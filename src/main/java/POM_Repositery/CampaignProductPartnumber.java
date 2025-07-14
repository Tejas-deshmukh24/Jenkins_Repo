package POM_Repositery;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampaignProductPartnumber {
	
	WebDriver driver;
	public CampaignProductPartnumber(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	   private WebElement morebtn;
	
	@FindBy(xpath = "//a[@name='Campaigns']")
	   private WebElement campaignbtn;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	   private WebElement Createcampaignbtn;
	
	@FindBy(name = "campaignname")
	   private WebElement campaignname;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	   private WebElement productpartnoimg;

	@FindBy(xpath = "//select[@name='search_field']")
	   private WebElement partnooption;
	
	@FindBy(xpath = "//input[@id='search_txt']")
	   private WebElement partnumber;

	@FindBy(xpath = "//input[@name='search']")
	   private WebElement searchbtn;

	@FindBy(xpath = "//form[@name='selectall']/descendant::a[contains(text(),'Mobile')]")
	   private WebElement partnumbertext;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	   private WebElement savebtn;
	
	@FindBy(id = "dtlview_Campaign Name")
	   private WebElement hardassert;
	 
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	   private WebElement adminimg;
		
    @FindBy(linkText = "Sign Out")
	   private WebElement singout;
	public WebElement getMorebtn() {
		return morebtn;
	}

	public WebElement getCampaignbtn() {
		return campaignbtn;
	}

	public WebElement getCreatecampaignbtn() {
		return Createcampaignbtn;
	}

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getProductpartnoimg() {
		return productpartnoimg;
	}

	public WebElement getPartnooption() {
		return partnooption;
	}

	public WebElement getSearchpartnumber() {
		return partnumber;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getPartnumbertext() {
		return partnumbertext;
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
    
    
	public void createCampaignpartnumberpage(String Campaignname,String PartNumber,WebDriver driver) {
		campaignname.sendKeys(Campaignname);
		productpartnoimg.click();
		
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String windowId : allWindowId) {
			driver.switchTo().window(windowId);
		}
		
		
//		partnooption.click();
		Select select=new Select(partnooption);
		select.selectByVisibleText("Part Number");
		
		partnumber.sendKeys(PartNumber);
		searchbtn.click();
		partnumbertext.click();
		
		driver.switchTo().window(parentWindowId);
		savebtn.click();	
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}
	
}
