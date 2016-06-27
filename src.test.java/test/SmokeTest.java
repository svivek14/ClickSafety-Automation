package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.CommonMethods;
import common.DriverFactory;
import pageobject.Home_LaunchCoursePage;
import pageobject.LoginPage;
import pageobject.VerifyInformationPage;


public class SmokeTest {
	static WebDriver driver;
	LoginPage loginPage; 
	Home_LaunchCoursePage homePage; 
	VerifyInformationPage verifyInformationPage;
	public static CommonMethods com;
	
	
	public Properties prop = CommonMethods.prop;
	private String strUserID = prop.getProperty("strUserID");
	private String strPassword = prop.getProperty("strPassword");

	
	
	@BeforeClass
	public void setUp(){
		driver = DriverFactory.setUpDriver();
		loginPage = new LoginPage();
		homePage = new Home_LaunchCoursePage();
		verifyInformationPage = new VerifyInformationPage();
		com = new CommonMethods();
	}

	
	@Test(groups = "Login")
	private void test1() throws Exception {
		Reporter.log("UserName/Password ="+strUserID+"/"+strPassword);
		loginPage.loginExamFX(strUserID,strPassword);
		homePage.assertPageTitle();
	}
	
	@Test(groups = "Home Page")
	private void test2(){
		Reporter.log("UserName/Password ="+strUserID+"/"+strPassword);
		homePage.assertTextOnHeaderLaunchCourse();
		homePage.ClickLaunchExam_PropertyAndCasualty();
		verifyInformationPage.assertTextOnVerifyInfoHeader();
	}
	
	@Test(groups = "Verify Page")
	private void test3(){
		Reporter.log("UserName/Password ="+strUserID+"/"+strPassword);
		verifyInformationPage.assertTextOnNameAndAddressBlock();
	}
	
	@AfterClass
	public void tearDown(){
		DriverFactory.shutDownDriver();
	}

}
