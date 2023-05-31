package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.WebTablePageUI;

public class WebTablePageObject extends BasePage {
	private WebDriver driver;

	public WebTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Table 1
	public void clickToPaginationPageByNumber(String pageNumber) {
		waitForElementClickable(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPaginationPageByNumberActive(String pageNumber) {
		waitForElementVisible(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void sendKeysToFilterTextboxByLabel(String labelName, String textValue) {
		waitForElementVisible(driver, WebTablePageUI.FILTER_TEXTBOX_BY_LABEL, labelName);
		sendKeysToElement(driver, WebTablePageUI.FILTER_TEXTBOX_BY_LABEL, textValue, labelName);
		pressKeyToElement(driver, WebTablePageUI.FILTER_TEXTBOX_BY_LABEL, Keys.ENTER, labelName);
	}

	public boolean isRowDisplayedByValues(String females, String country, String males, String total) {
		waitForElementVisible(driver, WebTablePageUI.ROW_DISPLAYED_BY_VALUES, females, country, males, total);
		return isElementDisplayed(driver, WebTablePageUI.ROW_DISPLAYED_BY_VALUES, females, country, males, total);
	}

	public List<String> getAllValuesAtAllPaginationPages() {
		int totalPages = getElementsSize(driver, WebTablePageUI.TOTAL_PAGINATION_PAGES);

		List<String> valuesAllPages = new ArrayList<String>();

		for (int pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
			clickToPaginationPageByNumber(String.valueOf(pageNumber));
			isPaginationPageByNumberActive(String.valueOf(pageNumber));

			List<WebElement> allRowsEachPage = getListWebElement(driver, WebTablePageUI.ALL_ROWS_EACH_PAGE);

			for (WebElement eachRow : allRowsEachPage) {
				valuesAllPages.add(eachRow.getText());
			}
		}

		for (String valuesEachPage : valuesAllPages) {
			System.out.println(valuesEachPage);
		}

		return valuesAllPages;
	}

	// Table 2
	public void clickToLoadDataButton() {
		waitForElementClickable(driver, WebTablePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, WebTablePageUI.LOAD_DATA_BUTTON);
	}

	public void clickToAppendRowButton() {
		waitForElementClickable(driver, WebTablePageUI.APPEND_ROW_BUTTON);
		clickToElement(driver, WebTablePageUI.APPEND_ROW_BUTTON);
	}

	public void clickToRemoveLastRowButton() {
		waitForElementClickable(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
		clickToElement(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
	}

	public int getColumnIndexByLabelName(String labelName) {
		return getElementsSize(driver, WebTablePageUI.COLUMN_INDEX_BY_LABEL, labelName) + 1;
	}

	public void sendKeysToTextboxByLabelAtRowNumber(String labelName, String rowNumber, String textValue) {
		int columnIndex = getColumnIndexByLabelName(labelName);
		waitForElementVisible(driver, WebTablePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, textValue, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByLabelAtRowNumber(String labelName, String rowNumber, String textItem) {
		int columnIndex = getColumnIndexByLabelName(labelName);
		waitForElementClickable(driver, WebTablePageUI.DROPDOWN_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, WebTablePageUI.DROPDOWN_BY_ROW_NUMBER_AND_COLUMN_INDEX, textItem, rowNumber, String.valueOf(columnIndex));
	}

	public void checkToCheckboxByLabelAtRowNumber(String labelName, String rowNumber) {
		int columnIndex = getColumnIndexByLabelName(labelName);
		waitForElementClickable(driver, WebTablePageUI.CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, WebTablePageUI.CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void unCheckToCheckboxByLabelAtRowNumber(String labelName, String rowNumber) {
		int columnIndex = getColumnIndexByLabelName(labelName);
		waitForElementClickable(driver, WebTablePageUI.CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		unCheckToDefaultCheckbox(driver, WebTablePageUI.CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void sendKeysToDatetimeTextboxByLabelAtRowNumber(String labelName, String rowNumber, String textValue) {
		int columnIndex = getColumnIndexByLabelName(labelName);
		waitForElementVisible(driver, WebTablePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		removeAttributeInDOM(driver, WebTablePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, "type", rowNumber, String.valueOf(columnIndex));
		sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, textValue, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconAtRowNumberByIconTitle(String rowNumber, String iconTitle) {
		waitForElementClickable(driver, WebTablePageUI.ICON_BY_ROW_NUMBER_AND_TITLE, rowNumber, iconTitle);
		clickToElement(driver, WebTablePageUI.ICON_BY_ROW_NUMBER_AND_TITLE, rowNumber, iconTitle);
	}

}
