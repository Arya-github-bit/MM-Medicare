package testscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class LoginTest extends Base
{

	@Test(description = "Verify Whether User is able to Login Successfully with Valid Username and Valid Password",groups = ("smoke"),retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleLoginSuccessfullywithValidUsernameandValidPassword()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String Password = ExcelUtility.getString(1, 1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseNameonUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnLoginButton();
		boolean isNavigatedToHomePage= loginpage.whetherDoctotTabDisplayed();
		assertTrue(isNavigatedToHomePage, "User is not able to login successfully with valid username and valid password");
	}
}
