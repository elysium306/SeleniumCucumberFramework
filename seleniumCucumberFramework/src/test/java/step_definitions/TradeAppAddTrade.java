package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppAddTrade {
	
	BrowserUtils utils = new BrowserUtils();
	TradeAppPage tradepage = new TradeAppPage();
	
	String inputSymbol;
	
	@Given("I am on the app log in page")
	public void i_am_on_the_app_log_in_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("tradeAppUrl"));
	    utils.waitUntilElementVisible(tradepage.username);
	    Assert.assertTrue(tradepage.username.isDisplayed());
	}
	
	@When("I enter valid username {string} and password {string}")
	public void i_enter_valid_username_and_password(String username, String password) {
		tradepage.username.sendKeys(username);
		tradepage.password.sendKeys(password);
	}
	
	@When("I click on trade signin button")
	public void i_click_on_trade_signin_button() {
	    tradepage.signinBtn.click();
	}
	
	@Then("I should be in the trade homepage")
	public void i_should_be_in_the_trade_homepage() {
	   utils.waitUntilElementVisible(tradepage.addTradeBtn);
	   Assert.assertTrue(tradepage.addTradeBtn.isDisplayed());
	}
	
	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
	    tradepage.addTradeBtn.click();
	}
	
	@Then("I should be on Save Trade Form")
	public void i_should_be_on_save_trade_form() {
	   utils.waitUntilElementVisible(tradepage.buyOrSellDropdown);
	   Assert.assertTrue(tradepage.buyOrSellDropdown.isDisplayed());
	}
	
	@When("I select {string} and enter symble {string} entrydate {string} entryprice {string} exitdate {string} exitprice {string}")
	public void i_select_and_enter_symble_entrydate_entryprice_exitdate_exitprice(
			String buyToOpen, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		
		inputSymbol = symbol;
		
	   utils.selectByVisibleText(tradepage.buyOrSellDropdown, buyToOpen);
	   tradepage.tradeSymbol.sendKeys(symbol);
	   tradepage.entryDate.sendKeys(entryDate);
	   tradepage.entryPrice.sendKeys(entryPrice);
	   tradepage.exitDate.sendKeys(exitDate);
	   tradepage.exitPrice.sendKeys(exitPrice);
	   
	}
	
	@When("I click save button")
	public void i_click_save_button() throws InterruptedException {
	 tradepage.addTradeSaveBtn.click();
	 Thread.sleep(2000);
	}
	
	@Then("the trade is displayed in the trade table")
	public void the_trade_is_displayed_in_the_trade_table() {
	   utils.waitUntilElementVisible(tradepage.anyRowStockSymbol.get(0));
	   
	   for ( WebElement element : tradepage.anyRowStockSymbol) {
		   String actualStockSymbol = element.getText();
		   boolean flag = false;
		   if (actualStockSymbol.equals(inputSymbol)) {
			   flag = true;
			   Assert.assertTrue(flag);
			   break;
		}   
	}
	}
	
	@When("I enter following trade details")
	public void i_enter_following_trade_details(DataTable dataTable) {
		List<String> list = dataTable.asList();
		inputSymbol = list.get(1);
		
		   utils.selectByVisibleText(tradepage.buyOrSellDropdown, list.get(0));
		   tradepage.tradeSymbol.sendKeys(list.get(1));
		   tradepage.entryDate.sendKeys(list.get(2));
		   tradepage.entryPrice.sendKeys(list.get(3));
		   tradepage.exitDate.sendKeys(list.get(4));
		   tradepage.exitPrice.sendKeys(list.get(5));
		
	}

}
