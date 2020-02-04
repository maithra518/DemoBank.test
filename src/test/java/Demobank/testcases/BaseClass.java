package Demobank.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import Demobank.utils.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getAppUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
			public static WebDriver driver;
			public static Logger logger;
			@Parameters("browser")
			@BeforeClass
			
			public void setup(String brows)
			{
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				//driver=new ChromeDriver();
				logger=Logger.getLogger("ebanking");
				PropertyConfigurator.configure("log4jproperties");
				if(brows.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
					driver=new ChromeDriver();
				}else if(brows.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
					driver=new FirefoxDriver();
				}
				driver.get(baseURL);
			}
			@AfterClass
			public void tearDown()
			{
				driver.quit();
			}
			public void captureScreenshot(WebDriver driver,String tname) throws IOException {
				TakesScreenshot ts=(TakesScreenshot) driver;
				File source =ts.getScreenshotAs(OutputType.FILE);
				File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
				Files.copy(source, target);
				System.out.println("screenshot taken");
			}

}
