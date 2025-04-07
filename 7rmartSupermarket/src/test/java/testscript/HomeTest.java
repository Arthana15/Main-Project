package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	HomePage homepage;

	@Test(description = "Verify whether user is able to logout successfully")
	public void verifyWhetherUserIsAbleToLogout() throws IOException {
		/* login */
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnSignInButton();

		/* logout */

		homepage.clickOnAdmin();
		loginpage = homepage.clickOnLogout();
		String actual = homepage.getTextFromTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.LOGOUT_ERROR);

	}

}
