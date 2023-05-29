package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Page_Object_Model {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(emailAddress);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickToContinueButton();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.sendKeysToEmailTextbox(emailAddress);
		loginPage.sendKeysToPasswordTextbox(password);

		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		homePage.clickToLogoutLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}

}
