package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageFactory;
import pageFactory.nopCommerce.LoginPageFactory;
import pageFactory.nopCommerce.RegisterPageFactory;

public class Level_05_Page_Factory extends BaseTest {
	private WebDriver driver;
	private HomePageFactory homePage;
	private RegisterPageFactory registerPage;
	private LoginPageFactory loginPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = new HomePageFactory(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageFactory(driver);

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(emailAddress);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickToContinueButton();
		homePage = new HomePageFactory(driver);
	}

	@Test
	public void User_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageFactory(driver);

		loginPage.sendKeysToEmailTextbox(emailAddress);
		loginPage.sendKeysToPasswordTextbox(password);

		loginPage.clickToLoginButton();
		homePage = new HomePageFactory(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		homePage.clickToLogoutLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
