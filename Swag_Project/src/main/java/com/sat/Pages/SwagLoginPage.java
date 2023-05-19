package com.sat.Pages;

import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;


public class SwagLoginPage {

	private WebDriver driver;

	
	
	//input[@placeholder='Username']
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement SwagemailID;
	
	//input[@placeholder='Password']
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement Swagloginpassword;
	
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement Swaglogin;
	
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement succSwagLoginmsg;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement ClickAddToCart;
	
	//button[@id='checkout']
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement Clickcheckout;
	
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement swagFname;
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement swaglname;
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement zipcode;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continuebtn;
	
	@FindBy(xpath = "//button[@id='finish']")
	private List<WebElement> finishbtn;
	
	
	
	
	Testutil util = new Testutil();

	public SwagLoginPage(WebDriver driver) {
		
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isClickable(WebElement ele) {
	
		boolean flag = true;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("Element is clickable");
		} catch (Exception e) {
			System.out.println("Element isn't clickable");
			flag = false;
		}
		
		return flag;
		
		
	}
	
	public void loginSwagHomePage(String userid, String pwd) throws InterruptedException {
		SwagemailID.sendKeys(userid);
		Swagloginpassword.sendKeys(pwd);
	}
	
	public boolean clickonSwagLogin() { 
		TestBase.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		boolean flag = true;
		try {
			//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Swaglogin));
				System.out.println("Element is clickable");
			Swaglogin.click();	
			WebDriverWait wait= new WebDriverWait(driver,10);
			WebElement succesele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
			System.out.println(succesele);
		} catch (Exception e) {
			System.out.println("Element isn't clickable");
					
		}
		return flag;
	}
	
/*
	public Boolean clickonSwagLogin(String userid) {
		Swaglogin.click();
		WebElement errorMessage= driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
		System.out.println(errorMessage.getText());
		
		//validate if the error message or element is displayed
		if(errorMessage.isDisplayed())
		{
			Boolean True= errorMessage.isDisplayed();
			System.out.println("Login Failed for User" +userid);
			return True;
		}
		else 
		{
			Boolean False= errorMessage.isDisplayed();
			System.out.println("Login was successful for User" +userid);
			return False;
		}
	}
	*/
	public void validateSwagLoginSuccMsg(String expected) {
		//span[text()='Products']
		List<WebElement> list = driver.findElements(By.xpath("//span[text()='"+expected +"']"));
		System.out.println(list.size());
		if (list.isEmpty()) {
			  Assert.assertEquals(0, list.size());
			  System.out.println("Use is not able to Login");	//condition = false;
			  
			}
		else {
		String actual = succSwagLoginmsg.getText();
		if (expected.equals(actual)) {
			System.out.println("Both Actual and Expected strings are equal");
		} else {
			System.out.println("Both Actual and Expected strings are not equal");
		}
		System.out.println("actual : " + actual);
		System.out.println("expected : " + expected);
	}
	}
	
	public void ClickAddItemSwag()
	{
		Wait.elementToBeClickable(driver, AddToCart, 5);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.actionMethodClick(driver, AddToCart);
	}
	
	public void ValidateAdditemText(String expectedcountItem)
	{
		
		List<WebElement> Itemcount = driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"));
	
		System.out.println("size of error " + Itemcount.size());
		if(Itemcount.size()!=0) {
			System.out.println("item is added to Shopping Cart");
			String actual_count_num=Itemcount.get(0).getText();
			if (expectedcountItem.equals(actual_count_num)) {
				System.out.println("Both Actual and Expected strings are equal");
			} else {
				System.out.println("Both Actual and Expected strings are not equal");
			}
			System.out.println("actual Count in Cart : " + expectedcountItem);
			System.out.println("expected Count in Cart: " + actual_count_num);
			
		}
	}
	
	public void click_on_addcart()
	{
		Wait.elementToBeClickable(driver,ClickAddToCart , 5);
		//BookAppointmentButton.click();
		util.actionMethodClick(driver, ClickAddToCart);
		//util.jsclick(driver, ClickAddToCart);
	}
	
	public void Click_on_checkout_button()
	{
		Wait.elementToBeClickable(driver,Clickcheckout , 5);
		//BookAppointmentButton.click();
		util.actionMethodClick(driver, Clickcheckout);
		//util.jsclick(driver, ClickAddToCart);
	}
	
	public void genearteFirstName()
	{
		Faker faker= new Faker();
		String FirstName= faker.name().firstName();
		System.out.println("Generate First name"+FirstName);
		swagFname.sendKeys(FirstName);
	}
	public void geneartelastName()
	{
		Faker faker= new Faker();
		String lastName= faker.name().lastName();
		System.out.println("Generate First name"+lastName);
		swaglname.sendKeys(lastName);
	}
	
	public void geneartezipcode()
	{
		Faker faker= new Faker();
		String ZipCode= faker.address().zipCode();
		System.out.println("Generate First name"+ZipCode);
		zipcode.sendKeys(ZipCode);
	}
	
	public void clickoncontinue() {
		continuebtn.click();
	}
	
	public void validateFinishBtnDisplay(String element, String displayStatus) {
	//	boolean expectedstatus= displayStatus.equalsIgnoreCase("Displayed");
		System.out.println("size of error " + finishbtn.size());
		if (finishbtn.isEmpty()) {
			  Assert.assertEquals(0, finishbtn.size());
			  System.out.println("Finish is not Visible hence user is not able to checkout");	//condition = false;
			}
		else {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	//	assertTrue(((WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(finishbtn))).isDisplayed());
		String ele=finishbtn.get(0).getText();
		assertTrue(ele.equalsIgnoreCase(element));
		System.out.println("Button is displayed.");
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		//boolean verifyTitle = Register_success_msg.isDisplayed();
		//assertTrue(verifyTitle);
		/*
		if(expectedstatus) {
			assertTrue(wait.until(ExpectedConditions.visibilityOf(finishbtn)).isDisplayed());
			System.out.println("Button is displayed.");
		}
		else {
			assertTrue(wait.until(ExpectedConditions.invisibilityOf(finishbtn)));
			System.out.println("Button is not displayed.");
		}
	}

*/
		}
	}
}
