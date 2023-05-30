package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getWindowID(WebDriver driver) {
		return driver.getWindowHandle();
	}

	protected Set<String> getAllWindowIDs(WebDriver driver) {
		return driver.getWindowHandles();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendKeysToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = getAllWindowIDs(driver);
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowIDs = getAllWindowIDs(driver);
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = getPageTitle(driver);
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	protected void closeAllTabsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = getAllWindowIDs(driver);
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForAllElementsVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForAllElementsInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void sendKeysToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	private long longTimeOut = 30;

}
