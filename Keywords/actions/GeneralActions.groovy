package actions

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

import helpers.GeneralHelperFunctions
import internal.GlobalVariable

public class GeneralActions {
	/**
	 * Search for product using header search field
	 * @param searchTerm
	 * @author waleedafifi
	 */
	public static void fillHeaderSearch(String searchTerm) {
		TestObject searchField = findTestObject('Object Repository/Product details/input_searchField');
		WebUI.setText(searchField, searchTerm)
	}


	public static void hoverItem(TestObject item) {
		WebUI.mouseOver(item)
	}

	public static void focusItem(TestObject item) {
		WebUI.focus(item)
	}

	/**
	 * Click on search button
	 * @author waleedafifi
	 */

	public static void clickSearchButton() {
		TestObject searchField = findTestObject('Object Repository/Product details/btn_searchAction');
		WebUI.click(searchField);
	}

	public static List returnProductDetailsList() {
		TestObject productName = findTestObject('Object Repository/Product details/h1_productName')
		TestObject ipt = findTestObject('Object Repository/Product details/input_productQuantity')
		TestObject sku = findTestObject('Object Repository/Product details/span_skuNumber')
		TestObject prc = findTestObject('Object Repository/Product details/span_productPrice')

		String name = WebUI.getText(productName)
		String qyt = WebUI.getAttribute(ipt, 'value')
		String skuTxt = WebUI.getText(sku)
		String price = WebUI.getText(prc).replaceAll("[^0-9\\.]","")

		return GeneralHelperFunctions.makeListOfItems(name, price, skuTxt, qyt)
	}
}
