package com.sat.StepDefinitions;


import com.sat.Pages.SwagLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLoginStepDefs {

	
	private ConfigFileReader config = new ConfigFileReader();
	SwagLoginPage swaglogin=new SwagLoginPage(TestBase.getDriver());
	
			
	
	@Given("User navigates to Swag Home Page {string} with {string} and {string}")
	public void user_navigates_to_Swag_Home_Page_and(String url, String user1, String password) {
		TestBase.getDriver().get(config.getSwagHomeUrl(url));
		try {
			swaglogin.loginSwagHomePage(config.getSwagHomeuserId(user1),
					config.getSwagHomepassword(password));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//resalepagelogin.clickonsignin();
	}
	@When("I click the Login Button")
	public void click_on_Swag_login() throws InterruptedException {
		
		long starttime= System.currentTimeMillis();
		
		swaglogin.clickonSwagLogin();
		long endTime=System.currentTimeMillis();
		long elaspedTime=endTime - starttime;
		System.out.println("Element is Elasped: "+elaspedTime);
	
		String title=TestBase.getDriver().getTitle();
		System.out.println("Title of Page"+title);
		
	}
	 @Then("validate {string} is displayed on Product Page")
	 public void Validate_swag_title(String Title) throws InterruptedException {
		
			 swaglogin.validateSwagLoginSuccMsg(Title);
		   
	 }	 
	 @And("I have clicked the Sauce Labs Backpack Add to Cart")
	 public void Click_add_to_cart() throws InterruptedException
	 {
		 swaglogin.ClickAddItemSwag();
	 }
	 
	 @And("the Shopping Cart Badge had the text {string}")
	 public void Validate_addcart_text(String ExpectedText) throws InterruptedException
	 {
		 swaglogin.ValidateAdditemText(ExpectedText);
	 }
	 
	 @Then("I have Clicked the Shopping Cart Badge")
	 public void Click_addcart() throws InterruptedException
	 {
		 swaglogin.click_on_addcart();
	 }
	 
	 @And("I have Clicked the Checkout Button")
	 public void Click_on_checkout_button()
	 {
		 swaglogin.Click_on_checkout_button();
	 }
	 
	 @And("I set FirstName as Random FirstName")
	 public void generateFirstName()
	 {
		 swaglogin.genearteFirstName();
		
	 }
	 @And("I set SecondName as Random SecondName")
	 public void generateSecondName()
	 {
		 swaglogin.geneartelastName();
		
	 }
	 @And("I set Zip  code Field Random Zip Code")
	 public void generateZipCode()
	 {
		 swaglogin.geneartezipcode();
			
		 }
	 
	 @And("I click the Continue Button")
	 public void ClickOnContinueButton()
	 {
		 swaglogin.clickoncontinue();
	 }
	 
	 @Then("the {string} is {string}")
	 public void ValidateFinishButton(String element, String displayStatus)
	 {
		 swaglogin.validateFinishBtnDisplay(element,displayStatus);
	 }
}
	 
	 
	