package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class SauceDemoLogin {
	
	SauceDemoPage page = new SauceDemoPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		Driver.getDriver().get("https://www.saucedemo.com/");
		
	}
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		page.usernameField.sendKeys(username);
		page.passwordField.sendKeys(password);
	}
	@And("I click on the login button")
	public void i_click_on_the_login_button() {
	    page.loginBtn.click();
	}
	@Then("I should be in the home page")
	public void i_should_be_in_the_home_page() {
		utils.waitUntilElementVisible(page.HomePageInventoryContainner);
		Assert.assertTrue(page.HomePageInventoryContainner.isDisplayed());
	}
	
	@And("There should be {int} items in the home page")
	public void there_should_be_items_in_the_home_page(Integer int1) {
		int actualSize = page.itemTitles.size();
		Assert.assertTrue(actualSize == int1);
	}
	
	// invalid test steps 
	
	@Then("I should not be in the home page")
	public void i_should_not_be_in_the_home_page() {
	    Assert.assertFalse(utils.isElementPresent(page.HomePageInventoryContainner));
	}
	
	@Then("There should an error message {string}")
	public void there_should_an_error_message(String expectedErrorMessage) {
	  String actualErrorMessage = page.loginErrorMessage.getText();
	  Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

}
