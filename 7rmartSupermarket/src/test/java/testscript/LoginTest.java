package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;

	@Test(description = "Verify whether user is able to successfully login with valid credentials", priority = 1,groups={"smoke"})
	public void verifyWhetherUserCanLoginWithValidCredentials() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage=login.clickOnSignInButton();
		boolean isDashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.VALIDCREDENTIALERROR);
	}

	@Test(description = "Verify whether user is able to login with valid username and invalid password", priority = 2,groups={"smoke"})
	public void verifyWhetherUserCanLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(1, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage=login.clickOnSignInButton();
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Messages.INVALIDPASSWORDERROR);

	}

	@Test(description = "Verify whether user is able to login with invalid username and valid password", priority = 3)
	public void verifyWhetherUserCanLoginWithInValidUsernameAndValidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(2, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage=login.clickOnSignInButton();
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Messages.INVALIDUSERNAMEERROR);

	}

	@Test(description = "Verify whether user is able to login with invalid credentials", priority = 4,dataProvider="loginProvider")
	public void verifyWhetherUserCanLoginWithInValidCredentials(String usernameValue,String passwordValue) throws IOException {

		//String usernameValue = ExcelUtility.getStringData(3, 0, "SignInPage");
		//String passwordValue = ExcelUtility.getStringData(3, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage=login.clickOnSignInButton();
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Messages.INVALIDCREDENTIALERROR);

	}
	@DataProvider(name="loginProvider")

	public Object[][] getDataFromDataProvider() throws IOException

	{

		return new Object[][] { new Object[] {"admin","admin12"},

			new Object[] {"123","123"},

			//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}

		};
}}
