package com.sat.StepDefinitions;

import java.util.concurrent.TimeUnit;

import com.sat.Pages.SwagLoginPage;
import com.sat.config.ConfigFileReader;
import com.sat.testbase.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLoginFailedStepDefs {

	
	private ConfigFileReader config = new ConfigFileReader();
	SwagLoginPage swaglogin=new SwagLoginPage(TestBase.getDriver());
	
			
	
	@Given("User navigates to Swag Home Page {string}")
	public void user_navigates_to_Swag_Home_Page_and(String url) {
		TestBase.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		TestBase.getDriver().get(config.getSwagHomeUrl(url));		
	}
	@When("I set the {string} to {string}")
	public void setusername(String field, String value)
	{
		WebElement element= TestBase.getDriver().findElement(By.xpath("//input[@placeholder='"+field+"']"));
		element.sendKeys(value);
	}
	@And("I set a {string} to {string}")
	public void setpassword(String field, String value)
	{
		
		WebElement element= TestBase.getDriver().findElement(By.xpath("//input[@placeholder='"+field+"']"));
		element.sendKeys(value);
		System.out.print(element);
	}
	@Then("the {string} is displayed")
	public void verifyErrorMessageDisplayed(String errormsg)
	{
		WebElement element= TestBase.getDriver().findElement(By.xpath("//h3[text()='"+errormsg+"']"));
		Assert.assertEquals(errormsg, element.getText());
	
	}
	@After
	public void quitBrowser()
	{
	//	TestBase.getDriver().quit();
	}
}
	 
	 
	