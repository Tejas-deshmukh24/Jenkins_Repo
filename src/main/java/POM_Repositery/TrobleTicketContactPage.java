package POM_Repositery;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TrobleTicketContactPage {
	
	WebDriver driver;
	public TrobleTicketContactPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

   @FindBy(linkText = "Trouble Tickets")
   private WebElement troubleticketbtn;
   
   @FindBy(xpath = "(//img[@title='Create Ticket...'])[1]")
   private WebElement createtroubleticketbtn;
   
   @FindBy(name = "ticket_title")
   private WebElement titlename;
   
   @FindBy(xpath = "(//img[@title='Select'])[1]")
   private WebElement contactimg;
   
   @FindBy(xpath = "//input[@id='search_txt']")
   private WebElement contactbtn;
   
   @FindBy(name = "search")
   private WebElement searchbtn;
   
   @FindBy(xpath = "//form[@name='selectall']/descendant::a[contains(text(),'Tejasdes_12')]")
   private WebElement contacttext;
   
   @FindBy(xpath = "//input[contains(@class,'crmButton small save')]")
   private WebElement savebtn;
   
   @FindBy(id = "dtlview_Title")
   private WebElement hardassert;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminimg;
	
   @FindBy(linkText = "Sign Out")
   private WebElement singout;
	
   
public WebElement getTroubleticketbtn() {
	return troubleticketbtn;
}

public WebElement getCreatetroubleticketbtn() {
	return createtroubleticketbtn;
}

public WebElement getTitlename() {
	return titlename;
}

public WebElement getContactimg() {
	return contactimg;
}

public WebElement getContactbtn() {
	return contactbtn;
}

public WebElement getSearchbtn() {
	return searchbtn;
}

public WebElement getContacttext() {
	return contacttext;
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

public void createtroubleticket(String ticketname, String contact,WebDriver driver) {
	titlename.sendKeys(ticketname);
	contactimg.click();
	String parentWindowId = driver.getWindowHandle();
	Set<String> allWindowId = driver.getWindowHandles();
	allWindowId.remove(parentWindowId);
	for(String windowId : allWindowId) {
		driver.switchTo().window(windowId);
	}
	
	contactbtn.sendKeys(contact);
	getSearchbtn().click();
	getContacttext().click();
	
	driver.switchTo().window(parentWindowId);
	savebtn.click();
}

public void logout() {
	Actions act = new Actions(driver);
	act.moveToElement(adminimg).perform();
	singout.click();
}

}

   
   
   
   
	


