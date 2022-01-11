package validation

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class GeneralValidation {
	/***
	 * Verify Current Page Title Is Not Empty
	 * @author waleedafifi
	 */
	public static void verifyCurrentPageTitleIsNotEmpty() {
		assert !WebUI.getWindowTitle().isEmpty()
	}

	/***
	 * verify current page title match the expected title
	 * @param expectedTitle
	 * @author waleedafifi
	 */
	public static void verifyCurrentPageTitleValue(String expectedTitle) {
		assert WebUI.getWindowTitle().equals(expectedTitle)
	}

	/**
	 * Verify Current Page URL matched the passed url
	 * @param expectedURL expectedURL or part of expectedURL
	 * @author waleedafifi
	 */
	public static void verifyCurrentPageURL(String expectedURL) {
		assert WebUI.getUrl().contains(expectedURL)
	}
	
	/**
	 * Verify the value of search filed is refelected
	 * @param searchValue
	 */
	public static void verifySearchFieldValue(String searchValue) {
		TestObject searchField = findTestObject('Object Repository/Product details/input_searchField');
		assert WebUI.getAttribute(searchField, 'value').equals(searchValue)
	}
	
	/**
	 * Verify search dropdown is displayed
	 * @author waleedafifi
	 */
	public static void verifySearchDropdownIsDisplayed() {
		TestObject searchBox = findTestObject('Object Repository/Product details/div_searchAutocompleteBox')
		assert WebUI.getAttribute(searchBox, 'style').contains('open')
	}
}
