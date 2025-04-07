package testscript;

import java.io.IOException;

import org.apache.logging.log4j.message.Message;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	
	SubCategoryPage subcategory;
	HomePage homepage;

	@Test(description = "Verify whether user is able to add new subcategory")
	public void verifyWhetherUserIsAbleToAddNewSubCategory() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage loginpage = new LoginPage(driver);
		homepage=loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnSignInButton();

		//SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategory=homepage.pageScroll();
		subcategory.clickOnSubCategoryTile().clickOnNewSubcategoryButton().selectCategory();
		String subcategoryValue = ExcelUtility.getStringData(0, 0, "SubCategoryPage");
		subcategory.enterSubcategoryOnSubcategoryField(subcategoryValue).chooseImage().pageScroll().clickOnSaveButton();

		boolean isAlertSubcategoryDisplayed = subcategory.isAlertSubcategoryDisplayed();
		Assert.assertTrue(isAlertSubcategoryDisplayed,Messages.ADD_SUBCATEGORY_ERROR);

	}

	@Test(description = "Verify whether user is able to search Subcategory list")
	public void verifyWhetherUserIsAbleToSearchSubCategory() throws IOException {
		/* login */
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage loginpage = new LoginPage(driver);
		homepage=loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnSignInButton();

		//SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategory=homepage.clickOnSubCategoryTile();
		subcategory.clickOnSearchButton().selectSearchCategory();
		String subcategoryValue = ExcelUtility.getStringData(0, 0, "SubCategoryPage");
		subcategory.enterSearchSubcategory(subcategoryValue).pageScroll().clickOnSearch();

		boolean isSearchUpdateSubcategoryIconDisplayed = subcategory.isSearchUpdateSubcategoryIconDisplayed();
		Assert.assertTrue(isSearchUpdateSubcategoryIconDisplayed,Messages.SEARCH_SUBCATEGORY_ERROR);
	}

}
