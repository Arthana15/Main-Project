package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement mainTitle; // actual

	@FindBy(xpath = "//p[text()='Manage News']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNews;
	@FindBy(xpath="//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-danger']")private WebElement clickOnNewManageNews;
	@FindBy(xpath = "//a[@class='nav-link']//child::i[@class='nav-icon fas fa-users']")
	private WebElement adminUser;
	@FindBy(xpath = "//p[text()='Manage Users']//parent::a[@class='nav-link']")
	private WebElement manageUsers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement clickSubCategoryTile;
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")private WebElement clickOnNewSubcategoryButton;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinButton;

	public HomePage clickOnAdmin() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		logout.click();
		return new LoginPage(driver);
	}

	public HomePage clickOnSignInButton() {
		signinButton.click();
		return new HomePage(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", manageNews);
		manageNews.click();
		return new ManageNewsPage(driver);
	}
	public ManageNewsPage clickOnNewManageNews() {
		clickOnNewManageNews.click();
		return new ManageNewsPage(driver);
	}

	public AdminUsersPage clickOnAdminUser() {
		adminUser.click();
		return new AdminUsersPage(driver);
	}

	public AdminUsersPage clickOnManageUsers() {
		manageUsers.click();
		return new AdminUsersPage(driver);
	}

	public SubCategoryPage pageScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		return new SubCategoryPage(driver);
	}

	public SubCategoryPage clickOnSubCategoryTile() {
		clickSubCategoryTile.click();
		return new SubCategoryPage(driver);
	}
	public SubCategoryPage clickOnNewSubcategoryButton() {
		clickOnNewSubcategoryButton.click();
		return new SubCategoryPage(driver);
	}
	public SubCategoryPage clickOnSearchButton() {
		searchButton.click();
		return new SubCategoryPage(driver);
	}

	// assertion
	public String getTextFromTitle() {
		return mainTitle.getText();
	}

}
