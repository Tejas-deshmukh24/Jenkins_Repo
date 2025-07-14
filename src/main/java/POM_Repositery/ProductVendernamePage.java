package POM_Repositery;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductVendernamePage {
	
	WebDriver driver;
	public ProductVendernamePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createproductbtn;
	
	@FindBy(name = "productname")
	private WebElement productnamebtn;
	
	@FindBy(name = "sales_start_date")
	private WebElement startdate;
	
	@FindBy(name = "sales_end_date")
	private WebElement enddate;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement venderemailimg;
	
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement vendernamebtn;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//form[@name='selectall']/descendant::a[contains(text(),'Ketan')]")
	private WebElement venderemailtext;
	
	@FindBy(xpath = "(//input[contains(@title,'Save [Alt+S]')])[1]")
	private WebElement savebtn;
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement asserthard;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singout;
	
	
	public WebElement getProduct() {
		return product;
	}

	public WebElement getCreateproductbtn() {
		return createproductbtn;
	}

	public WebElement getProductnamebtn() {
		return productnamebtn;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}

	
	public WebElement getVenderemailimg() {
		return venderemailimg;
	}

	public WebElement getVendernamebtn() {
		return vendernamebtn;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getVenderemailtext() {
		return venderemailtext;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getAsserthard() {
		return asserthard;
	}

	
	public WebElement getAdminimg() {
		return adminimg;
	}

	
	
	public void createproductpage(String productname,String vendername,WebDriver driver) {
		productnamebtn.sendKeys(productname);
		venderemailimg.click();
		
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String windowId : allWindowId) {
			driver.switchTo().window(windowId);
		}
		
		vendernamebtn.sendKeys(vendername);
		searchbtn.click();
		venderemailtext.click();
		
		
		driver.switchTo().window(parentWindowId);
		savebtn.click();	
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}

}



