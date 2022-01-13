package helpers

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import actions.CategoryScActions

import actions.GeneralActions

import actions.Navigations
import internal.GlobalVariable
import validation.GeneralValidation

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

	public static void navigateTotags() {
		CategoryScActions.hoverTags()
	}
	public static void headerSearchFillAndClick() {
		GeneralActions.fillHeaderSearch(GlobalVariable.searchTerm)
		GeneralValidation.verifySearchFieldValue(GlobalVariable.searchTerm)
		GeneralValidation.verifySearchDropdownIsDisplayed()
		GeneralActions.clickSearchButton()
	}
}
