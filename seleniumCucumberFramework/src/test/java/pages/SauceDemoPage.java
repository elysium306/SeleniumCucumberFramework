package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SauceDemoPage {
	
	public SauceDemoPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "user-name")
	public WebElement usernameField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "login-button")
	public WebElement loginBtn;
	
	@FindBy(id = "inventory_container")
	public WebElement HomePageInventoryContainner;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	public List<WebElement> itemTitles;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement loginErrorMessage;
	
}
