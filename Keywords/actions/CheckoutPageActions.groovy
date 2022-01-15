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

import internal.GlobalVariable
import validation.GeneralValidation

public class CheckoutPageActions {
	/**
	 * Navigate to checkout information page
	 * @author waleedafifi
	 */
	public static void navigateToCheckoutPageForm() {
		TestObject btn = findTestObject('Object Repository/CheckOut/button_continueButton')
		WebUI.click(btn)
	}
	
	public static void moveToShippingAddressDiv() {
		TestObject shippingAddrDiv = findTestObject("Object Repository/CheckOut Details/div_shippingAddr")
		WebUI.scrollToElement(shippingAddrDiv,GlobalVariable.elementVisibilityTimeOut)
		WebUI.verifyElementVisible(shippingAddrDiv)
		GeneralValidation.verifyBackgroundColor(shippingAddrDiv, GlobalVariable.grayBgColor)
	}
	
	public static void clickShippingOptionLink(TestObject ShippingOptionLink) {
		assert WebUI.getAttribute(ShippingOptionLink, "class").contains("collapsed")
		WebUI.click(ShippingOptionLink)
		assert !WebUI.getAttribute(ShippingOptionLink, "class").contains("collapsed")
	}
}
