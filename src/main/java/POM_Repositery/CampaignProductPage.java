package POM_Repositery;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignProductPage {
	
	WebDriver driver;
	public CampaignProductPage(WebDriver driver) {
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
	   private WebElement productnameimg;
	
	@FindBy(xpath = "//input[@id='search_txt']")
	   private WebElement searchproductnamebtn;
	

	@FindBy(xpath = "//input[@name='search']")
	   private WebElement searchbtn;
	
	@FindBy(xpath = "//form[@name='selectall']/descendant::a[contains(text(),'mobile')]")
	   private WebElement productname;
	
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

	public WebElement getProductnameimg() {
		return productnameimg;
	}

	public WebElement getSearchproductnamebtn() {
		return searchproductnamebtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getProductname() {
		return productname;
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
    
	
	
	public void createcampaignwithproductpage(String Campaignname,String Productname,WebDriver driver) {
		campaignname.sendKeys(Campaignname);
		productnameimg.click();
		
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String windowId : allWindowId) {
			driver.switchTo().window(windowId);
		}
		
		searchproductnamebtn.sendKeys(Productname);
		searchbtn.click();
		productname.click();
		
		driver.switchTo().window(parentWindowId);
		savebtn.click();	
	}
	
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}

}
