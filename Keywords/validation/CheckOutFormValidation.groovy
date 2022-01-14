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

public class CheckOutFormValidation {

	public static void validateBoxShadowBlaceHolderBorder(String selector){
		TestObject input = findTestObject(selector)
		WebUI.focus(input)
		//		WebUI.delay(5)
		String shadow =WebUI.getCSSValue(input, 'box-shadow')
		String borderColor =WebUI.getCSSValue(input, 'border-color')
		println (shadow)
		println (borderColor)
		assert WebUI.verifyEqual(shadow, GlobalVariable.checkOutInputShadow)
		assert WebUI.verifyEqual(borderColor, GlobalVariable.checkOutinputborderColor)
		//		String text = WebUI.verifyElementHasAttribute(input,'placeholder',2)
		//		WebUI.verifyEqual(text, '')

	}

	//	public static void checkVisibilityOfFreeShippingFormandCollapsedByDefault() {
	//		TestObject shippingFree = findTestObject(".clearfix a.pull-right")
	//		WebUI.click(findTestObject("Object Repository/CheckOutForm/h2_paymentMethod"))
	//		WebUI.verifyElementVisible(shippingFree)
	//		String attribute = WebUI.getAttribute(shippingFree, 'class')
	//		assert attribute.contains("collapsed")
	//	}


	//	public static void checkVisibilityOfFreeShippingFormandCollapsedByDefault() {
	//		TestObject shippingFree = findTestObject(".clearfix a.pull-right")
	//		WebUI.click(findTestObject("Object Repository/CheckOutForm/h2_paymentMethod"))
	//		WebUI.verifyElementVisible(findTestObject("Object Repository/CheckOutForm/h2_clearfixShippingFree"))
	//		String attribute = WebUI.getAttribute(shippingFree, 'class')
	//		assert attribute.contains("collapsed")
	//	}
}
