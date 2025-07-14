package GenericUtilityClasses;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import POM_Repositery.HomePage;
import POM_Repositery.LoginPage;

        public class BaseClass {

//		public static WebDriver driver= null;             //Other program use comment reopen:
		public  WebDriver driver= null;                   //Listener
		public  static WebDriver sdriver= null;           //Listener
		//creation of object

		public static DataBaseU dblib= new DataBaseU();

		public static FileUtility flib= new FileUtility();

		public static ExcelUtility elib= new ExcelUtility();

		public static JavaUtility jlib= new JavaUtility();

		public static WebDriverUtility wlib=new WebDriverUtility();


		
		@BeforeSuite(groups = {"smokeTest", "regressionTest"})

		public void configBS() throws Throwable  {

			System.out.println("===Connect To DB, Report Config===");
			dblib.getDbconnection();
		}

	
		
        @Parameters("BROWSER")
		@BeforeClass(groups = {"smokeTest", "regressionTest"})

		public void configBC(@Optional("chrome")String browser) throws Throwable {

			System.out.println("==Launch Browser==");

			String BROWSER = browser;
					//flib.getDataFromPropertiesFile("browser");
            
	//		String BROWSER = flib.getDataFromPropertiesFile("browser");

			System.out.println("B:"+BROWSER);

			if(BROWSER.equals("chrome")) {

				driver=new ChromeDriver();

			}else if (BROWSER.equals("firefox")) {

				driver=new FirefoxDriver();

			}else if (BROWSER.equals("edge")) {

				driver=new EdgeDriver();

			}else {

				driver=new ChromeDriver();

			}
			// wlib=new WebDriverUtility();           //Other Program:			 
			 sdriver = driver;                       //Listener:
			 
			 UtilityClassObject.setDriver(driver);
			 
		}

		

		@BeforeMethod(groups = {"smokeTest", "regressionTest"}) 

		public void configBM() throws Throwable {

			System.out.println("==Login==");

			String url = flib.getDataFromPropertiesFile("url");

			String username = flib.getDataFromPropertiesFile("username");

			String password = flib.getDataFromPropertiesFile("password");

			LoginPage lp=new LoginPage(driver);

			lp.loginToApp(url, username, password);
		}

		
		@AfterMethod(groups = {"smokeTest", "regressionTest"})

		public void configAM() {

		System.out.println("==LogOut==");

		HomePage hp=new HomePage(driver);

		hp.logout();

		}

		
		@AfterClass(groups = {"smokeTest", "regressionTest"})

		public void configAC() {

		System.out.println("==close browse==");

		driver.quit();

		}

		
		@AfterSuite(groups = {"smokeTest", "regressionTest"})

		public void configAS() throws SQLException {

		System.out.println("===close DB, Report BackUp");

		dblib.closeDbconnection();
			
		}
}
