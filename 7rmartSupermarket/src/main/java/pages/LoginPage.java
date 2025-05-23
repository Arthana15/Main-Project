package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@name='username']")private WebElement username;
	@FindBy(xpath="//input[@name='password']")private WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")private WebElement signinButton;
	
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	
	public LoginPage enterUsernameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
		return this;
		}

	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}

	public HomePage clickOnSignInButton(){
		signinButton.click();
		return new HomePage(driver);
	}
	//assertion
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
