package pageobject;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import common.CommonMethods;
import common.DriverFactory;



public class VerifyInformationPage {
	WebDriver driver;
	CommonMethods cm;
	
	public VerifyInformationPage(){
		this.driver = DriverFactory.getDriver();
	}
	
	Properties prop = CommonMethods.prop;
	private String strUserName = prop.getProperty("strUserName");
	
	private String txt_VerifyInfo = "Verify Information";
	private By hed_VerifyInfo = By.id("content_h1");
	private By loc_NameAndID = By.id("content_lblName");
	private By loc_Address = By.id("content_lblAddress");
	private String txt_Address = "x1100 HARNESS DR";


	
	public void assertTextOnVerifyInfoHeader(){
		Assert.assertEquals(driver.findElement(hed_VerifyInfo).getText(), txt_VerifyInfo);
	}
	
	public void assertTextOnNameAndAddressBlock(){
		Assert.assertTrue(driver.findElement(loc_NameAndID).getText().contains(strUserName));
		Assert.assertEquals(driver.findElement(loc_Address).getText(), txt_Address);
	}

}
