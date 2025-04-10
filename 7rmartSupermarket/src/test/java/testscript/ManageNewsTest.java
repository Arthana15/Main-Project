package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ManageNewsTest extends Base {

	ManageNewsPage managenews;
	HomePage homepage;

	@Test(description = "Verify whether user is able to create new news")
	public void verifyWhetherUserIsAbleToAddNews() throws IOException {
		/* login */
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = login.clickOnSignInButton();

		// ManageNewsPage news = new ManageNewsPage(driver);
		managenews = homepage.clickOnManageNews();
		managenews.clickOnNewManageNews();
		String newsValue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterNewsDetailsOnNewsField(newsValue);
		// explicit wait
		// WaitUtility wait = new WaitUtility();
		// wait.waitUntilElementToBeClickable(driver, news.saveButtonNews);
		managenews.clickOnSaveNewsButton();

		boolean isNewsCreatedAlertDisplayed = managenews.isNewsCreatedAlertDisplayed();
		Assert.assertTrue(isNewsCreatedAlertDisplayed, Messages.CREATE_NEWS_ERROR);

	}

	@Test(description = "Verify whether user is able to search for news ")
	public void verifyWhetherUserIsAbleToSearchNews() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = login.clickOnSignInButton();

		// ManageNewsPage news = new ManageNewsPage(driver);
		managenews = homepage.clickOnManageNews();
		managenews.clickOnSearchButton();
		String newsValue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTitleOnTitleField(newsValue);
		managenews.clickOnSearchTitleButton();
		boolean isNewsSearchUpdateIconDisplayed = managenews.isNewsSearchUpdateIconDisplayed();
		Assert.assertTrue(isNewsSearchUpdateIconDisplayed, Messages.SEARCH_NEWS_ERROR);

	}

}
