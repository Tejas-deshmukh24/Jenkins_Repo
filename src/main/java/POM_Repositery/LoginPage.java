package POM_Repositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilityClasses.WebDriverUtility;

public class LoginPage extends WebDriverUtility { // rule1 - create a seperate java class
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	
	
// rule4 - object encapsulation set pivate and us getters
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

// rule3 -object initialization
// rule5 - object utilization
// rule6 - provide action(this is called business library which is specific to
// business means it can used only for this application
// it is a business method
	
	public void loginToApp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}

	public void loginToApp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
}
