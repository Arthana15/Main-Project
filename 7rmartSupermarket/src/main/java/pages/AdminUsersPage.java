package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUsersPage {
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Users']//parent::a[@class='nav-link']")
	private WebElement manageUsers;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-danger']")
	private WebElement newUserButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUsername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectUserType;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveUser;

	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-primary']")
	private WebElement searchUserButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchUsername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchAdminUser;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement userCreated;
	@FindBy(xpath = "//h4[text()='Search Admin Users']")
	private WebElement activeText;

	public AdminUsersPage clickOnManageUsers() {
		// wait.waitUntilElementToBeSelected(driver, manageUsers);
		manageUsers.click();
		return this;
	}

	public AdminUsersPage clickOnNewUserButton() {
		newUserButton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnUsernameField(String adminUserValue) {
		newUsername.sendKeys(adminUserValue);
		return this;
	}

	public AdminUsersPage enterPasswordOnPasswordField(String adminPasswordValue) {
		newPassword.sendKeys(adminPasswordValue);
		return this;
	}

	public AdminUsersPage selectUserType() {
		Select select = new Select(selectUserType);
		select.selectByIndex(3);
		return this;
	}

	public AdminUsersPage clickOnSaveUserButton() {
		saveUser.click();
		return this;
	}

	public boolean isAdminUserCreatedAlertDisplayed() {
		return userCreated.isDisplayed();
	}

	public AdminUsersPage clickOnSearchUserButton() {
		searchUserButton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnSearchUsernameField(String adminUserValue) {
		searchUsername.sendKeys(adminUserValue);
		return this;
	}

	public AdminUsersPage searchUserType() {
		Select select = new Select(searchUserType);
		select.selectByIndex(2);
		return this;
	}

	public AdminUsersPage pageScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,360)", "");
		return this;
	}

	public AdminUsersPage clickOnSearchAdminUserButton() {
		searchAdminUser.click();
		return this;
	}

	/*
	 * public boolean isAdminUserUpdateIconDisplayed() { return
	 * updateAdminUser.isDisplayed(); }
	 */
	public String getTextFromAdminUserSearch() {
		return activeText.getText();
	}
}
