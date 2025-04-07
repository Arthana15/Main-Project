package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	
	WaitUtility wait=new WaitUtility();
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//p[text()='Manage News']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNews;
	@FindBy(xpath="//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-danger']")private WebElement clickOnNewManageNews;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enterNewsInfo;
	@FindBy(xpath="//button[@type='submit']")private WebElement saveButtonNews;
	
	@FindBy(xpath="//a[@href='javascript:void(0)']")private WebElement searchNewsButton;
	@FindBy(xpath="//input[@name='un']")private WebElement titleNewsSearch;
	@FindBy(xpath="//button[@value='sr']")private WebElement searchTitleNewsButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement newsCreatedAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[text()='FASHION']")private WebElement newsSearchUpdate;
	
	/*public void clickOnManageNews() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", manageNews);
		manageNews.click();
	}*/
	public ManageNewsPage clickOnNewManageNews() {
		clickOnNewManageNews.click();
		return this;
	}
	
	public ManageNewsPage enterNewsDetailsOnNewsField(String newsValue) {
		enterNewsInfo.sendKeys(newsValue);
		return this;
	}
	public ManageNewsPage clickOnSaveNewsButton() {
		wait.waitUntilElementToBeClickable(driver, saveButtonNews);
		saveButtonNews.click();
		return this;
	}
	public ManageNewsPage clickOnSearchButton() {
		searchNewsButton.click();
		return this;
	}
	public ManageNewsPage enterTitleOnTitleField(String newsValue) {
		titleNewsSearch.sendKeys(newsValue);
		return this;
	}
	public ManageNewsPage clickOnSearchTitleButton() {
		searchTitleNewsButton.click();
		return this;
	}
	public boolean isNewsCreatedAlertDisplayed() {
		return newsCreatedAlert.isDisplayed();
	}
	public boolean isNewsSearchUpdateIconDisplayed() {
		return newsSearchUpdate.isDisplayed();
	}
}
