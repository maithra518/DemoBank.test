package Demobank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Demobank.pageobjects1.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void LoginTest() throws IOException, InterruptedException
	{
		
		logger.info("URL launched");
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username");
		lp.setPassword(password);
		logger.info("password");
		lp.clicksubmit();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);
		logger.info("test passed");
		}else {
			captureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("test failed");
			
		}
		
	}
	

}
