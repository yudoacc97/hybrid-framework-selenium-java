package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.UploadFilePageUI;

public class UploadFilePageObject extends BasePage {
	private WebDriver driver;

	public UploadFilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadFileToJQueryPage(String fileName) {
		uploadFile(driver, fileName);
	}

	public void uploadMultipleFilesToJQueryPage(String... fileNames) {
		uploadFile(driver, fileNames);
	}

	public boolean isFileNameLoadedDisplayed(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, UploadFilePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(1);
		}
	}

	public boolean isFileLinkUpLoadedDisplayed(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.FILE_LINK_UPLOADED, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.FILE_LINK_UPLOADED, fileName);
	}

	public boolean isFileImageUpLoadedDisplayed(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.FILE_IMAGE_UPLOADED, fileName);
		return isImageLoaded(driver, UploadFilePageUI.FILE_IMAGE_UPLOADED, fileName);
	}

	public void refreshJQueryUploadPage() {
		refreshCurrentPage(driver);
		sleepInSecond(1);
	}

}
