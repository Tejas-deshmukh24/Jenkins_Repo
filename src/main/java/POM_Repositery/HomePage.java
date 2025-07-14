package POM_Repositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;
     public HomePage(WebDriver driver) {
   	 this.driver=driver;
   	 PageFactory.initElements(driver, this);	
    }
	
     @FindBy(linkText = "Opportunities")
	 private WebElement opportunitybtn;
	
    @FindBy(linkText = "Products")
 	private WebElement product;
 	
    @FindBy(linkText = "Trouble Tickets")
    private WebElement troubleticketbtn;
    	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignslink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singout;
	
	
	public WebDriver getDriver() {
		return driver;
	}  

	

	public WebElement getOpportunitybtn() {
		return opportunitybtn;
	}



	public WebElement getProduct() {
		return product;
	}



	public WebElement getTroubleticketbtn() {
		return troubleticketbtn;
	}



	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getMorelink() {
		return morelink;
	}


	public void NavigateToCampaignPage() {
		Actions act = new  Actions(driver);
		act.moveToElement(morelink).perform();
		campaignslink.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}
}
