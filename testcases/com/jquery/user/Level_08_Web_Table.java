package com.jquery.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorJQuery;
import pageObjects.jQuery.WebTablePageObject;

public class Level_08_Web_Table extends BaseTest {
	private WebDriver driver;
	private WebTablePageObject webTablePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
	}

	public void Web_Table_01() {
		webTablePage.clickToPaginationPageByNumber("14");
		Assert.assertTrue(webTablePage.isPaginationPageByNumberActive("14"));

		webTablePage.clickToPaginationPageByNumber("7");
		Assert.assertTrue(webTablePage.isPaginationPageByNumberActive("7"));

		webTablePage.clickToPaginationPageByNumber("13");
		Assert.assertTrue(webTablePage.isPaginationPageByNumberActive("13"));

		webTablePage.clickToPaginationPageByNumber("10");
		Assert.assertTrue(webTablePage.isPaginationPageByNumberActive("10"));

		webTablePage.sendKeysToFilterTextboxByLabel("Females", "11727960");
		webTablePage.sendKeysToFilterTextboxByLabel("Country", "India");
		webTablePage.sendKeysToFilterTextboxByLabel("Males", "13060130");
		webTablePage.sendKeysToFilterTextboxByLabel("Total", "24788090");
		Assert.assertTrue(webTablePage.isRowDisplayedByValues("11727960", "India", "13060130", "24788090"));

		webTablePage.getAllValuesAtAllPaginationPages();
		// * Gán vào mảng List actualValues -> So sánh với 1 file khác expectedValues
	}

	@Test
	public void Web_Table_02() {
		webTablePage.clickToLoadDataButton();
		webTablePage.clickToAppendRowButton();
		webTablePage.sendKeysToTextboxByLabelAtRowNumber("Company", "9", "AFC");
		webTablePage.clickToIconAtRowNumberByIconTitle("9", "Move Up");
		webTablePage.clickToIconAtRowNumberByIconTitle("9", "Remove Current Row");
		webTablePage.sendKeysToTextboxByLabelAtRowNumber("Contact Person", "8", "Dong");
		webTablePage.clickToIconAtRowNumberByIconTitle("8", "Insert Row Above");
		webTablePage.clickToIconAtRowNumberByIconTitle("8", "Move Down");
		webTablePage.selectDropdownByLabelAtRowNumber("Country", "8", "Japan");
		webTablePage.clickToIconAtRowNumberByIconTitle("8", "Move Up");
		webTablePage.checkToCheckboxByLabelAtRowNumber("NPO?", "7");
		webTablePage.clickToIconAtRowNumberByIconTitle("8", "Remove Current Row");
		webTablePage.sendKeysToTextboxByLabelAtRowNumber("Order Placed", "7", "123");
		webTablePage.clickToIconAtRowNumberByIconTitle("6", "Move Down");
		webTablePage.clickToIconAtRowNumberByIconTitle("7", "Remove Current Row");
		webTablePage.clickToIconAtRowNumberByIconTitle("6", "Move Up");
		webTablePage.sendKeysToDatetimeTextboxByLabelAtRowNumber("Member Since", "5", "6/5/2023");
		webTablePage.clickToIconAtRowNumberByIconTitle("4", "Remove Current Row");
		webTablePage.clickToIconAtRowNumberByIconTitle("5", "Remove Current Row");
		webTablePage.clickToRemoveLastRowButton();
		webTablePage.clickToIconAtRowNumberByIconTitle("3", "Move Down");
		webTablePage.clickToIconAtRowNumberByIconTitle("2", "Move Down");
		webTablePage.clickToIconAtRowNumberByIconTitle("1", "Remove Current Row");
		webTablePage.clickToRemoveLastRowButton();
		webTablePage.clickToIconAtRowNumberByIconTitle("2", "Remove Current Row");
		webTablePage.unCheckToCheckboxByLabelAtRowNumber("NPO?", "1");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
