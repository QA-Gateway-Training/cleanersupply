package helpers

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

import actions.GeneralActions
import actions.Navigations
import internal.GlobalVariable
import validation.GeneralValidation
import validation.SearchValidations

public class GeneralHelpers {
	/***
	 * initialise the website
	 * @author walid afifi
	 */
	public static void initScenario() {
		WebUI.openBrowser('');
		WebUI.maximizeWindow()

		Navigations.navigateToHomePage()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)

		GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.homePageTitle)
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.baseUrl)
	}

	/**
	 * Fill search field with specific term
	 * Verify the value reflected to the same search term
	 * Verify search box is visible when filling the search field
	 * Click on search button
	 * 
	 * @author waleedafifi
	 */
	public static void headerSearchFillAndClick() {
		GeneralActions.fillHeaderSearch(GlobalVariable.searchTerm)
		GeneralValidation.verifySearchFieldValue(GlobalVariable.searchTerm)
		GeneralValidation.verifySearchDropdownIsDisplayed()
		SearchValidations.VerifySearchForContainSearchTerm(GlobalVariable.searchTerm)
		SearchValidations.VerifySearchDropDownTopBarStyle()
		GeneralActions.clickSearchButton()
	}

	/**
	 * Verify result page title
	 * Verify result page url contain plastic as search term
	 * Verify result section heading contain search result
	 */
	public static void navigateToResultPage() {
		GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.searchResultTitle)
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.plasticResultPage)
		GeneralValidation.verifySectionHeading(GlobalVariable.searchReasultHeadingTag)
	}
}
