package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {

	AdminUsersPage adminuser;
	HomePage homepage;

	@Test
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = login.clickOnSignInButton();

		// AdminUsersPage admin=new AdminUsersPage(driver);
		homepage.clickOnAdminUser();
		adminuser = homepage.clickOnManageUsers();
		adminuser.clickOnNewUserButton();
		RandomDataUtility random = new RandomDataUtility();
		// String adminUserValue=ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		String adminUserValue = random.createRandomUsername();
		adminuser.enterUsernameOnUsernameField(adminUserValue);
		// String adminPasswordValue=ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		String adminPasswordValue = random.createRandomPassword();
		adminuser.enterPasswordOnPasswordField(adminPasswordValue);
		adminuser.selectUserType().clickOnSaveUserButton();

		boolean isAdminUserCreatedAlertDisplayed = adminuser.isAdminUserCreatedAlertDisplayed();
		Assert.assertTrue(isAdminUserCreatedAlertDisplayed, Messages.CREATE_ADMINUSER_ERROR);

	}

	@Test
	public void verifyWhetherUserIsAbleToSearchUser() throws IOException {
		/* login */
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = login.clickOnSignInButton();

		/* Search */

		homepage.clickOnAdminUser();
		adminuser = homepage.clickOnManageUsers().clickOnSearchUserButton();
		String adminUserValue = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminuser.enterUsernameOnSearchUsernameField(adminUserValue);
		adminuser.searchUserType().pageScroll().clickOnSearchAdminUserButton();

		// boolean
		// isAdminUserUpdateIconDisplayed=admin.isAdminUserUpdateIconDisplayed();
		// Assert.assertTrue(isAdminUserUpdateIconDisplayed, "Search result were not
		// displayed");

		String actual = adminuser.getTextFromAdminUserSearch();
		// String expected="Active";
		String expected = "Search Admin Users";
		Assert.assertEquals(actual, expected, Messages.SEARCH_ADMINUSER_ERROR);

	}

}
