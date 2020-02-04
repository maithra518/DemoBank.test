package Demobank.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Demobank.pageobjects1.LoginPage;
import Demobank.utils.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
@Test(dataProvider="Logindata")
public void LoginDDT(String user,String pwd) {
	LoginPage lp=new LoginPage(driver);
	lp.setUsername(user);
	lp.setPassword(pwd);
	lp.clicksubmit();
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);	
	}else {
		Assert.assertTrue(true);
		lp.clicklogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
public boolean isAlertPresent() {
	try {
		driver.switchTo().alert();
		return true;
	}catch(NoAlertPresentException e)
	{
		return false;
	}
}
@DataProvider(name="Logindata")
String [][] getData() throws IOException{
	String path=System.getProperty("user.dir")+"\\src\\test\\java\\Demobank\\testData\\testData.xlsx";
	int rownum=XLUtils.getRowCount(path, "Sheet1");
	int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	String logindata[][]=new String[rownum][colcount];
	for(int i=1;i<rownum;i++)
	{for(int j=0;i<colcount;j++)
	{
		logindata[i-1][j]=XLUtils.getCellData(path,  "Sheet1", i,j);
	}
		
	}return logindata;
}
}
