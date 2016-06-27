package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import common.DriverFactory;



public class Home_LaunchCoursePage {
	
	WebDriver driver;
	
	
	public Home_LaunchCoursePage(){
		this.driver = DriverFactory.getDriver();
	}
	

	private String txt_SuccessfulLoginText = "You have successfully logged in and can now launch your course.";
	private String wtl_EFXLaunchCourse= "ExamFX | Launch Course";
	private String txt_LaunchCourse="LAUNCH COURSE";
	private By hed_LaunchCourse=By.cssSelector("h1.single");
	private By loc_SuccessfulLoginText = By.cssSelector("#Content_divLaunchHeader > p");
	private By lnk_LaunchYourExam_PropertAndCasualty = By.linkText("Click Here to Launch Your ExamFX - Property and Casualty Course.");
	
	

	
	public void assertSuccessfulLoginMessage(){
		Assert.assertEquals(driver.findElement(loc_SuccessfulLoginText).getText(), txt_SuccessfulLoginText);
	}
	
	public void assertTextOnHeaderLaunchCourse(){
		Assert.assertEquals(driver.findElement(hed_LaunchCourse).getText(), txt_LaunchCourse);
	}
	
	public void ClickLaunchExam_PropertyAndCasualty(){
		driver.findElement(lnk_LaunchYourExam_PropertAndCasualty).click();
	}
	
	public void assertPageTitle(){
		Assert.assertEquals(driver.getTitle(), wtl_EFXLaunchCourse);	
	}

}
