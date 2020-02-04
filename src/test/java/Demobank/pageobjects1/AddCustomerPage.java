package Demobank.pageobjects1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Demobank.testcases.BaseClass;

public class AddCustomerPage extends BaseClass {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how=How.XPATH,using="//a[contains(text(),'New Customer')]")
    @CacheLookup
    WebElement clickNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
    @CacheLookup
    WebElement testCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
    @CacheLookup
    WebElement radioGender;
	
	@FindBy(how=How.NAME,using="dob")
    @CacheLookup
    WebElement custDob;
	
	@FindBy(how=How.NAME,using="addr")
    @CacheLookup
    WebElement custAddress;
	
	@FindBy(how=How.NAME,using="city")
    @CacheLookup
    WebElement custCity;
	
	@FindBy(how=How.NAME,using="state")
    @CacheLookup
    WebElement custState;
	@FindBy(how=How.NAME,using="pinno")
    @CacheLookup
    WebElement custPinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
    @CacheLookup
    WebElement custPhoneno;
	
	@FindBy(how=How.NAME,using="emailid")
    @CacheLookup
    WebElement custEmail;
	
	@FindBy(how=How.NAME,using="password")
    @CacheLookup
    WebElement custPassword;
	
	@FindBy(how=How.NAME,using="sub")
    @CacheLookup
    WebElement custSubmit;
	
	
	public void clickNewCustomer() {
		clickNewCustomer.click();
	}
	public void testCustomerName(String cname) {
		testCustomerName.sendKeys(cname);
	}
	public void radioGender(String custGender) {
		radioGender.sendKeys(custGender);
	}
	public void custDob(String dd,String mm,String yy) {
		custDob.sendKeys(dd);
		custDob.sendKeys(mm);
		custDob.sendKeys(yy);
		
	}
	public void custAdress(String custAddr) {
		custAddress.sendKeys(custAddr);
	}
	public void custCity(String custcity) {
		custCity.sendKeys(custcity);
	}
	public void custState(String custstate) {
		custState.sendKeys(custstate);
	}

	public void custPinno(String custPin) {
		custPinno.sendKeys(custPin);
	}
	public void custPhoneno(String custphoneNo) {
		custPhoneno.sendKeys(custphoneNo);
	}
	public void custEmail(String custemail) {
		custEmail.sendKeys(custemail);
	}
	public void custPassword(String custpass) {
		custPassword.sendKeys(custpass);
	}
	public void custSubmit() {
		custSubmit.click();
	}
	
	
	
	
	
	
	
}
