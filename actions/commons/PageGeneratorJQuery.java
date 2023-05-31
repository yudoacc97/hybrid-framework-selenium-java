package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.jQuery.UploadFilePageObject;
import pageObjects.jQuery.WebTablePageObject;

public class PageGeneratorJQuery {

	public static WebTablePageObject getWebTablePage(WebDriver driver) {
		return new WebTablePageObject(driver);
	}

	public static UploadFilePageObject getUploadFilePage(WebDriver driver) {
		return new UploadFilePageObject(driver);
	}

}
