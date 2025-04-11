package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}@FindBy( xpath ="//input[@placeholder='Enter Email']")WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Enter Password']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement LoginButton;
	@FindBy(xpath = "//div[@class='text-end text-white'][1]")WebElement doctorTab;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alert;

	public void enterUseNameonUserNameField(String userName)
	{
		userNameField.sendKeys(userName);


	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		
	}
	public void clickOnLoginButton()
	{
		WaitUtility waitUtility= new WaitUtility();
		waitUtility.waitUntilElementToBeClickable(driver, LoginButton);
		LoginButton.click();
		
	}
	public boolean whetherDoctotTabDisplayed ()
	{
		Boolean dashBoardDisplay =doctorTab.isDisplayed();
		return dashBoardDisplay;

	}
	public boolean whetherAlertIsDisplayed()
	{
		boolean isAlertDisplayed = alert.isDisplayed();
		return isAlertDisplayed;

	}


}
