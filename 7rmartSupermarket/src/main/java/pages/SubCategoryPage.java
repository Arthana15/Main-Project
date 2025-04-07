package pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;


public class SubCategoryPage {
	WaitUtility wait=new WaitUtility();
	
public WebDriver driver;
	
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")private WebElement clickSubCategoryTile;
	//@FindBy(xpath="//a[p[text()='Sub Category']]")private WebElement subcategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")private WebElement clickOnNewSubcategoryButton;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement selectCategory;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement enterSubcategory;
	@FindBy(xpath="//input[@id='main_img']")private WebElement imageUpload;
	@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath="//button[@value='sr']")private WebElement clickSearch;
	@FindBy(xpath="//select[@id='un']")private WebElement selectSearchCategory;
	@FindBy(xpath="//input[@name='ut']")private WebElement enterSearchSubcategory;
	
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertSubcategory;
	@FindBy(xpath="//button[@class='close']")private WebElement alertSubcategory;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3193&page_ad=1']")private WebElement searchSubcategoryUpdate;
	@FindBy(xpath="//h4[text()='List Sub Categories']")private WebElement searchSubcategoryUpdate;
	
	//public void clickOnSubCategory() {
		//subcategory.click();
	//}
	public SubCategoryPage clickOnSubCategoryTile() {
		clickSubCategoryTile.click();
		return this;
	}
	public SubCategoryPage clickOnNewSubcategoryButton() {
		clickOnNewSubcategoryButton.click();
		return this;
	}	
	public SubCategoryPage selectCategory() {
		
	//	Select select=new Select(selectCategory);
		//wait.waitUntilElementToBeVisible(driver,selectCategory);
		//select.selectByIndex(7);
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownWithIndex(selectCategory,7);
		return this;
		
	}	
	public SubCategoryPage enterSubcategoryOnSubcategoryField(String subcategoryValue) {
		enterSubcategory.sendKeys(subcategoryValue);
		return this;
	}	
	public SubCategoryPage chooseImage() {
		//imageUpload.sendKeys("C:\\Users\\artha\\eclipse-workspace\\7rmartSupermarket\\src\\test\\resources\\kale.jpg");
		imageUpload.sendKeys(Constants.IMAGEDATAFILE);
		return this;
	}
	public SubCategoryPage pageScroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		return this;
	}
	public SubCategoryPage clickOnSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
		return this;
	}
	public boolean isAlertSubcategoryDisplayed() {
		return alertSubcategory.isDisplayed();
	}
	
				
	public SubCategoryPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}
	public SubCategoryPage selectSearchCategory() {
		Select select=new Select(selectSearchCategory);
		select.selectByIndex(7);
		
		return this;
	}		
	public SubCategoryPage enterSearchSubcategory(String subcategoryValue) {
		enterSearchSubcategory.sendKeys(subcategoryValue);
		return this;
	}
	public SubCategoryPage clickOnSearch() {
		clickSearch.click();
		return this;
	}
	public boolean isSearchUpdateSubcategoryIconDisplayed() {
		return searchSubcategoryUpdate.isDisplayed();
	}
}
