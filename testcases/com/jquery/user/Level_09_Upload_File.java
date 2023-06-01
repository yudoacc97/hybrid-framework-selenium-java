package com.jquery.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorJQuery;
import pageObjects.jQuery.UploadFilePageObject;

public class Level_09_Upload_File extends BaseTest {
	private WebDriver driver;
	private UploadFilePageObject uploadFilePage;
	private String cSharpFile = "CSharp.png";
	private String rubyFile = "Ruby.png";
	private String javaFile = "Java.png";
	private String pythonFile = "Python.png";
	private String javaScriptFile = "JavaScripts.png";
	private String[] multipleFiles = { cSharpFile, rubyFile, javaFile, pythonFile, javaScriptFile };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		uploadFilePage = PageGeneratorJQuery.getUploadFilePage(driver);
	}

	@Test
	public void Upload_File_01_One_File() {
		uploadFilePage.uploadFileToJQueryPage(javaFile);

		Assert.assertTrue(uploadFilePage.isFileNameLoadedDisplayed(javaFile));

		uploadFilePage.clickToStartButton();

		Assert.assertTrue(uploadFilePage.isFileLinkUpLoadedDisplayed(javaFile));

		Assert.assertTrue(uploadFilePage.isFileImageUpLoadedDisplayed(javaFile));
	}

	@Test
	public void Upload_File_02_Multiple_Files() {
		uploadFilePage.refreshJQueryUploadPage();

		uploadFilePage.uploadMultipleFilesToJQueryPage(multipleFiles);

		Assert.assertTrue(uploadFilePage.isFileNameLoadedDisplayed(cSharpFile));
		Assert.assertTrue(uploadFilePage.isFileNameLoadedDisplayed(rubyFile));
		Assert.assertTrue(uploadFilePage.isFileNameLoadedDisplayed(javaFile));
		Assert.assertTrue(uploadFilePage.isFileNameLoadedDisplayed(pythonFile));
		Assert.assertTrue(uploadFilePage.isFileNameLoadedDisplayed(javaScriptFile));

		uploadFilePage.clickToStartButton();

		Assert.assertTrue(uploadFilePage.isFileLinkUpLoadedDisplayed(cSharpFile));
		Assert.assertTrue(uploadFilePage.isFileLinkUpLoadedDisplayed(rubyFile));
		Assert.assertTrue(uploadFilePage.isFileLinkUpLoadedDisplayed(javaFile));
		Assert.assertTrue(uploadFilePage.isFileLinkUpLoadedDisplayed(pythonFile));
		Assert.assertTrue(uploadFilePage.isFileLinkUpLoadedDisplayed(javaScriptFile));

		Assert.assertTrue(uploadFilePage.isFileImageUpLoadedDisplayed(cSharpFile));
		Assert.assertTrue(uploadFilePage.isFileImageUpLoadedDisplayed(rubyFile));
		Assert.assertTrue(uploadFilePage.isFileImageUpLoadedDisplayed(javaFile));
		Assert.assertTrue(uploadFilePage.isFileImageUpLoadedDisplayed(pythonFile));
		Assert.assertTrue(uploadFilePage.isFileImageUpLoadedDisplayed(javaScriptFile));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
