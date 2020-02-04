
	package Demobank.utils;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.openqa.selenium.WebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestResult;
	import org.testng.TestListenerAdapter;
	//import org.testng.annotations.AfterMethod;
	//import org.testng.annotations.AfterTest;
	//import org.testng.annotations.BeforeMethod;
	//import org.testng.annotations.BeforeTest;
	//import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	import com.google.common.io.Files;

	public class Reporting extends TestListenerAdapter{	

	public WebDriver driver;
		
		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public ExtentTest logger;
		
		public void onStart(ITestContext testContext) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report-"+timeStamp+".html";

			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent.config.xml");
			
			extent = new ExtentReports();
			
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Hostname", "Localhost");
			//extent.setSystemInfo("OS", "windows10");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Tester name", "Santosh");
			
			htmlReporter.config().setDocumentTitle(" demoBank Test Project ");
			htmlReporter.config().setReportName("Functional test Report");
			htmlReporter.config().setTheme(Theme.DARK);
		}
		
		public void onTestSuccess(ITestResult tr) {
			logger=extent.createTest(tr.getName());
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public void onTestFailure(ITestResult tr) {
			logger=extent.createTest(tr.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
			
			String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
			File f = new File(screenshotPath);

			if(f.exists()) {
				try {
					logger.fail("screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void onTestSkipped(ITestResult tr) {
			logger=extent.createTest(tr.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

		}
		
		public void onFinish(ITestContext testContext) {
			extent.flush();
		}
	}


