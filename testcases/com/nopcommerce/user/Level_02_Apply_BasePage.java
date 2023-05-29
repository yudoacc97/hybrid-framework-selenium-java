package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeysToElement(driver, "//input[@id='FirstName']", "Dong");
		sendKeysToElement(driver, "//input[@id='LastName']", "Do");
		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Password']", "123456");
		sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		clickToElement(driver, "//a[contains(@class,'continue-button')]");
	}

	@Test
	public void User_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Password']", "123456");

		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

		clickToElement(driver, "//a[@class='ico-logout']");
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
