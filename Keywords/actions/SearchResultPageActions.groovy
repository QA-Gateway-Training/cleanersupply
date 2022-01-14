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

public class SearchResultPageActions {
	/**
	 * Expand filter card based on it's id
	 * @param selector
	 * @author waleedafifi
	 */
	public static void expandFilterCard(String selector) {
		TestObject titleObj = GeneralHelperFunctions.makeTO('//div[@href="#'+selector+'"]')
		WebUI.click(titleObj)
	}

	/**
	 * Select packaging product filter
	 * @author waleedafifi
	 */
	public static void selectPackagingProduct() {
		TestObject productObject = findTestObject('Object Repository/Filter/a_packagingProduct')
		WebUI.click(productObject)
	}

	/**
	 * Select plastic bags filter
	 * @author waleedafifi
	 */
	public static void selectPlasticBags() {
		TestObject productObject = findTestObject('Object Repository/Filter/a_plasticBags')
		WebUI.click(productObject)
	}

	/**
	 * Select green color filter
	 * @author waleedafifi
	 */
	public static void selectColorFilter() {
		TestObject colorObject = findTestObject('Object Repository/Filter/a_greenColor')
		WebUI.click(colorObject)
	}

	/**
	 * Navigate to product page and store the product info into Global Variable
	 * @author waleedafifi
	 */
	public static void NavigateToProductDetailsPage() {
		TestObject item = findTestObject('Object Repository/Product details/a_productItem')

		addFilteredProductToGlobalVariable()

		WebUI.click(item);
	}

	/**
	 * Add filtered product to GlobalVariable
	 * @author waleedafifi
	 */
	public static void addFilteredProductToGlobalVariable() {

		List<Integer> item = new ArrayList<>();

		TestObject href = findTestObject('Object Repository/Search Result/a_productItemLink')
		TestObject name = findTestObject('Object Repository/Search Result/h2_productName')
		TestObject price = findTestObject('Object Repository/Search Result/div_priceRange')
		TestObject color = findTestObject('Object Repository/Search Result/span_availability')

		String hrefTxt = WebUI.getAttribute(href, 'href')
		String nameTxt = WebUI.getText(name)
		String priceTxt = WebUI.getText(price)
		String colorTxt = WebUI.getText(color)

		item.addAll(Arrays.asList(hrefTxt, nameTxt, priceTxt, colorTxt));

		GlobalVariable.productItems = item
	}

	/**
	 * return sku number from product details page to checkit in the url
	 * @return String
	 * @author waleedafifi
	 */
	public static String skuNumber() {
		TestObject sku = findTestObject('Object Repository/Product details/span_skuNumber')
		return WebUI.getText(sku)
	}
}
