package helpers

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import actions.CategoryScActions

import actions.GeneralActions

import actions.Navigations
import internal.GlobalVariable
import validation.GeneralValidation
import validation.SearchValidations

public class GeneralHelpers {
	/***
	 * initialise the website
	 * @author walid afifi
	 * @author Razan
	 * add verification that pageTitle is not empty
	 */
	public static void initScenario() {
		WebUI.openBrowser('');
		WebUI.maximizeWindow()

		Navigations.navigateToHomePage()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
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
	public static void navigateTotags() {
		CategoryScActions.hoverTags()
  }
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
