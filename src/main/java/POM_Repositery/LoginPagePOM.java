package POM_Repositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
	
	//1.Create Seprate java class:
	//2.Object creation:

	     WebDriver driver; 
         public LoginPagePOM(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);	 	
     }
	
         
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//3.Object Initialization:
	//4.Object Encapsulation:     
	                                  //How to create getter method:
	                                  //First mouse right click, Go to source, Click on generate getter & Setter, Select WebElement
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
  //5.Provide Actions:
	public void logintoapp(String username , String password) {
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
