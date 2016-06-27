package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.DriverFactory;
import test.SmokeTest;



public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(){
		this.driver = DriverFactory.getDriver();
	}
	
	
	private By txt_UserName = By.id("txtEMail");
	private By txt_password = By.id("txtPassword");
	private By btn_SignIn = By.id("BtnSignIn");
	private By btn_ForgotPassword = By.id("lnkForgotPassword");
	private By btn_SignUp = By.id("lbEnrollBegin");
	
	
	public void typeUserName(String user){
		driver.findElement(txt_UserName).sendKeys(user);
	}
	
	public void typePassword(String psw){
		driver.findElement(txt_password).sendKeys(psw);
	}
	
	public void clickSignInButton(){
		driver.findElement(btn_SignIn).click();
	}
	
	public void clickForgotPasswordButton(){
		driver.findElement(btn_ForgotPassword).click();
	}
	
	public void clickSignUpButton(){
		driver.findElement(btn_SignUp).click();
	}
	
	public void loginExamFX(String user, String psw){
		typeUserName(user);
		typePassword(psw);
		clickSignInButton();
		SmokeTest.com.waitForPageTitle("ExamFX | Launch Course");
	}
	



}
