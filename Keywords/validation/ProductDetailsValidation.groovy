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

public class ProductDetailsValidation {
	public static void verifyProductDetailsPageBreadCrumb() {
		TestObject obj = findTestObject('Object Repository/Product details/ul_breadcrumb')
		assert WebUI.getText(obj).contains(GlobalVariable.breadCrumb)
	}
	
	public static void verifyProductDetailsName() {
		TestObject productName = findTestObject('Object Repository/Product details/h1_productName')
		assert WebUI.verifyElementPresent(productName, GlobalVariable.globalTimeOut)
		assert WebUI.getText(productName).contains(GlobalVariable.productName)
	}
	
	public static void verifySKUNotEmpty() {
		TestObject sku = findTestObject('Object Repository/Product details/span_skuNumber')
		assert !WebUI.getText(sku).isEmpty()
	}
	
	public static void verifyDefaultProductSize() {
		TestObject size = findTestObject('Object Repository/Product details/a_xSmallLink')
		assert WebUI.getAttribute(size, 'class').contains(GlobalVariable.selected)
		assert WebUI.getCSSValue(size, 'background-color').equals(GlobalVariable.selectedSizeBackgroundColor)
		assert WebUI.getCSSValue(size, 'color').equals(GlobalVariable.whiteColor)
	}
	
	public static void verifyOnHoverStyle() {
		TestObject size = findTestObject('Object Repository/Product details/a_xLargeLink')
		assert WebUI.getCSSValue(size, 'background-color').equals(GlobalVariable.grayColor)
		assert WebUI.getCSSValue(size, 'color').equals(GlobalVariable.whiteColor)
	}
	
	public static void verifyProductPrice(TestObject obj, String price) {
		String numberOnly = price.replaceAll("[^0-9\\.]","");
//		TestObject prc = findTestObject('Object Repository/Product details/span_productPrice')
		assert WebUI.getText(obj).contains(numberOnly)
	}
	
	public static void verifyProductColorSelect(TestObject obj, String colorName) {
		assert WebUI.verifyElementPresent(obj, GlobalVariable.globalTimeOut)
		assert WebUI.getAttribute(obj, 'class').contains(GlobalVariable.selected)
	}
	
	public static void verifyProductAvailability(boolean stockStatus = true) {
		TestObject stock = findTestObject('Object Repository/Product details/div_stockNotifcations')
		if(stockStatus) {
			assert WebUI.getText(stock).contains(GlobalVariable.txtInStock)
			assert WebUI.getCSSValue(stock, 'color').equals(GlobalVariable.greenColor)
		} else {
			assert WebUI.getText(stock).contains(GlobalVariable.txtOutStock)
			assert WebUI.getCSSValue(stock, 'color').equals(GlobalVariable.redColor)
		}
	}
}
