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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import helpers.GeneralHelperFunctions
import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class SearchResultPageValidations {

	/**
	 * Verify default value for the result page
	 * @author waleedafifi
	 */
	public static void verifyDefaultValues() {
		TestObject sectionHeading = findTestObject('Object Repository/Search Result/h2_productListHeading')
		assert WebUI.getText(sectionHeading).contains(GlobalVariable.searchTerm.toString().toUpperCase())
		assert WebUI.getText(sectionHeading).contains(GlobalVariable.defaultProductCount)

		TestObject filterOption = findTestObject('Object Repository/Search Result/span_filterOption')
		assert WebUI.getText(filterOption).equals(GlobalVariable.featured)

		TestObject selectedFilters = findTestObject('Object Repository/Search Result/ul_selectedFilters')
		assert WebUI.verifyElementNotPresent(selectedFilters, 5)

		//		List<WebElement> filterOptionList = findTestObject('Object Repository/Search Result/li_facetGroup')
		//		for(int index = 1; index < filterOptionList.size(); index++) {
		//			WebElement randomClassificationOption = filterOptionList.get(index)
		//			TestObject selectedClassificationOption = WebUI.convertWebElementToTestObject(randomClassificationOption)
		//			assert !WebUI.getAttribute(selectedClassificationOption, 'class').contains('selected')
		//		}
	}

	public static void verifyFilterCardExpanded(String selector, boolean cardStatus = true) {
		TestObject titleObj = GeneralHelperFunctions.makeTO('//div[@href="#'+selector+'"]')
		TestObject contentObj = GeneralHelperFunctions.makeTO('//div[@id="'+selector+'"]')

		if(cardStatus) {
			assert !WebUI.getAttribute(titleObj, 'class').contains('collapsed')
			assert WebUI.getAttribute(contentObj, 'class').contains('in')
		} else {
			assert WebUI.getAttribute(titleObj, 'class').contains('collapsed')
			assert !WebUI.getAttribute(contentObj, 'class').contains('in')
		}
	}

	public static int verifyFilterCounter() {
		TestObject filterObject = findTestObject('Object Repository/Filter/li_packagingProduct');
		String filterNumberOnly = WebUI.getText(filterObject).replaceAll("[^0-9]", "");

		return Integer.parseInt(filterNumberOnly)
	}

	public static int verifyPlasticFilterCounter() {
		TestObject filterObject = findTestObject('Object Repository/Filter/li_plasticBags');
		String filterNumberOnly = WebUI.getText(filterObject).replaceAll("[^0-9]", "");
		return Integer.parseInt(filterNumberOnly)
	}

	public static int verifyColorFilterCounter() {
		TestObject filterObject = findTestObject('Object Repository/Filter/li_greenColor');
		String filterNumberOnly = WebUI.getText(filterObject).replaceAll("[^0-9]", "");
		return Integer.parseInt(filterNumberOnly)
	}

	public static void verifyProductHeadingTotal(int counter) {
		TestObject headingObject = findTestObject('Object Repository/Search Result/h2_productListHeading');
		String headingNumberOnly = WebUI.getText(headingObject).replaceAll("[^0-9]", "");

		assert headingNumberOnly.equals(counter.toString())
	}
}
