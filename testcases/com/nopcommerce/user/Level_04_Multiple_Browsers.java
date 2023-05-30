package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_04_Multiple_Browsers extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
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

}
