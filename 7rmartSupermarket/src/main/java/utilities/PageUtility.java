package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	WebDriver driver;
	
	public PageUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
	public void selectDropdownWithIndex(WebElement element,int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
	}
	public void selectDropdownByVisibleText(WebElement element,String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
	public void verifyRightClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public void verifyMouseHover(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void handlingRadioButton(WebElement element) {
		element.click();
	}
	public void handlingCheckbox(WebElement element) {
		element.click();
	}

}
