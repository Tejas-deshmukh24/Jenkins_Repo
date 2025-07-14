package GenericUtilityClasses;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener , ISuiteListener {	
	
//	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configurations");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceSeleniumReport/reportBackup_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
	   //Add Env information & create Test:
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");	
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("====== =====>"+result.getMethod().getMethodName()+">=====START======");
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====> STARTED <====");
	}
		
	public void onTestSuccess(ITestResult result) {
		System.out.println("====== =====>"+result.getMethod().getMethodName()+">=====END======");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"====> COMPLETED <====");
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot eDriver = (TakesScreenshot)  BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
/*		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+ "+" +time+ ".png"));
		} catch (IOException | java.io.IOException e) {
			e.printStackTrace();
		}				                            */
		
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====> FAILED <====");
	}

		
		
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
	
	