package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
	
	public AmazonPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchInputField;
	
	@FindBy(id = "nav-search-submit-button")
	public WebElement searchButton;
	
	@FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	public WebElement searchResultText;

	@FindBy (linkText = "Sign in securely")
	public WebElement signinSecurelyBtn;
	
	@FindBy (xpath ="//div[@class='a-box']//h1[@class='a-spacing-small']")
	public WebElement signInText;
	
	@FindBy (id = "ap_email")
	public WebElement signInEmailField;
	
	@FindBy (id = "continue")
	public WebElement signInContinueBtn;
	
	@FindBy (xpath = "//h4[@class='a-alert-heading']")
	public WebElement signInErrorMessageHeader;
	
	@FindBy(id = "ap_password")
	public WebElement signInPasswordField;
}
