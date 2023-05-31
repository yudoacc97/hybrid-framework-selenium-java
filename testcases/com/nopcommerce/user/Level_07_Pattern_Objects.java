package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorNopCommerce;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_07_Pattern_Objects extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		homePage.clickToHeaderLinkByText(driver, "Register");
		registerPage = PageGeneratorNopCommerce.getRegisterPage(driver);

		registerPage.sendKeysToTextboxByID(driver, "FirstName", firstName);
		registerPage.sendKeysToTextboxByID(driver, "LastName", lastName);
		registerPage.sendKeysToTextboxByID(driver, "Email", emailAddress);
		registerPage.sendKeysToTextboxByID(driver, "Password", password);
		registerPage.sendKeysToTextboxByID(driver, "ConfirmPassword", password);

		registerPage.clickToButtonByText(driver, "Register");

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		homePage.clickToHeaderLinkByText(driver, "Log in");
		loginPage = PageGeneratorNopCommerce.getLoginPage(driver);

		loginPage.sendKeysToTextboxByID(driver, "Email", emailAddress);
		loginPage.sendKeysToTextboxByID(driver, "Password", password);

		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		Assert.assertTrue(homePage.isHeaderLinkByTextDisplayed(driver, "My account"));

		homePage.clickToHeaderLinkByText(driver, "Log out");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
