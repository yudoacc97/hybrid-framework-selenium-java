package pageUIs.jQuery;

public class WebTablePageUI {

	// Table 1
	public static final String PAGINATION_PAGE_BY_NUMBER = "//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%S']";
	public static final String FILTER_TEXTBOX_BY_LABEL = "//div[text()='%s']/parent::div//following-sibling::input";
	public static final String ROW_DISPLAYED_BY_VALUES = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String TOTAL_PAGINATION_PAGES = "//ul[@class='qgrd-pagination-ul']//a";
	public static final String ALL_ROWS_EACH_PAGE = "//tbody/tr";

	// Table 2
	public static final String LOAD_DATA_BUTTON = "//button[text()='Load Data']";
	public static final String APPEND_ROW_BUTTON = "//button[@title='Append Row']";
	public static final String REMOVE_LAST_ROW_BUTTON = "//button[@title='Remove Last Row']";
	public static final String COLUMN_INDEX_BY_LABEL = "//table//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW_NUMBER_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String ICON_BY_ROW_NUMBER_AND_TITLE = "//tbody/tr[%s]//button[@title='%s']";

}
