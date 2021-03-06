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

import actions.SearchResultPageActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.SearchResultPageValidations

public class SearchResultHelper {

	/**
	 * Expand filter cards
	 * @author waleedafifi
	 */
	public static void filterCardExpand() {
		SearchResultPageActions.expandFilterCard('collapse6')
		SearchResultPageValidations.verifyFilterCardExpanded('collapse6')
	}

	/**
	 * Select product filter ( Packaging product, Plastic bags, Green color)
	 * @author waleedafifi
	 */
	public static void selectProductFilters() {
		SearchResultPageActions.selectPackagingProduct()
		GeneralValidation.verifyLoader()
		int f1 = SearchResultPageValidations.verifyFilterCounter();
		SearchResultPageValidations.verifyProductHeadingTotal(f1)
		SearchResultPageValidations.verifyPackagingProductFilterSelected()
		SearchResultPageValidations.verifySelectedFilter('Packaging Products')

		SearchResultPageActions.selectPlasticBags()
		GeneralValidation.verifyLoader()
		SearchResultPageValidations.verifyPlasticBagsFilterSelected()
		SearchResultPageValidations.verifySelectedFilter('Plastic Bags')
		
		filterCardExpand()
//		SearchResultPageActions.expandColorCardFilter()

		SearchResultPageActions.selectColorFilter()
		GeneralValidation.verifyLoader()
		SearchResultPageValidations.verifyColorFilterSelected()
		SearchResultPageValidations.verifySelectedFilter('Green')

		int colorCounter = SearchResultPageValidations.verifyColorFilterCounter()
		SearchResultPageValidations.verifyProductHeadingTotal(colorCounter)

		// Total number is incorrect for plastic bags and packaging (Bug)
		//SearchResultPageValidations.verifyProductHeadingTotal(f1+f2)
	}

	public static void checkSearchPagePagination() {
		SearchResultPageValidations.verifyPaginationExists()
		SearchResultPageValidations.verifyPagination()
	}
}
