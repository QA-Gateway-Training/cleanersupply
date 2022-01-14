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

import actions.CheckoutPageActions
import internal.GlobalVariable
import validation.CheckoutPageValidation
import validation.GeneralValidation

public class CheckoutPageHelpers {

	/**
	 * Check page on load have the default values of the totals
	 * @author waleedafifi
	 */
	public static void initCheckoutPage() {
		CheckoutPageValidation.verifyTotalPrice()
		CheckoutPageValidation.verifyCheckoutAsGuest()
		CheckoutPageValidation.verifyCheckoutAsGuestSelected()
		CheckoutPageValidation.verifyProductSummaryItemQountityTotal()
		CheckoutPageValidation.verifyAddedProductRefelectDetails()
	}

	/**
	 * Navigate to checkout form page
	 * @author waleedafifi
	 */
	public static void navigateToCheckoutInformationForm() {
		CheckoutPageActions.navigateToCheckoutPageForm()
	}

	public static void ShippingAddressDiv() {
		CheckoutPageActions.moveToShippingAddressDiv()	
		CheckoutPageValidation.verifyVisibilityAndHeaderShipping()
	}
	
	public static void verifyShippingDetailsInCeckout() {
		TestObject address = findTestObject("Object Repository/CheckOut Details/span_shippingAddressDetails")
		String[] allAddress =  WebUI.getText(address).split("\n")
		assert allAddress[0].equals(GlobalVariable.companyValue)
		assert allAddress[1].equals(GlobalVariable.fNameValue+" "+ GlobalVariable.lNameValue)
		assert allAddress[2].equals(GlobalVariable.address1)
		assert allAddress[3].equals(GlobalVariable.address2)
		assert allAddress[4].equals(GlobalVariable.city + ", "+GlobalVariable.stateAbbr +" "+ GlobalVariable.zipCode)
		assert allAddress[5].equals(GlobalVariable.phone + " x" + GlobalVariable.phoneExt)
		assert allAddress[6].equals(GlobalVariable.USDcountry)
	}

	public static void ShippingDetailsInCeckout() {
		TestObject address = findTestObject("Object Repository/CheckOut Details/span_shippingAddressDetails")
		CheckoutPageValidation.verifyShippingDetails(address)
	}

	public static void standardShippingAddress() {
		TestObject StandardShippingDiv = findTestObject("Object Repository/CheckOut Details/dic_standardShiping")
		WebUI.verifyElementVisible(StandardShippingDiv)
		GeneralValidation.verifyBackgroundColor(StandardShippingDiv, GlobalVariable.grayBgColor)
		//assert WebUI.getText(StandardShippingDiv).equals("FAST, FREE Standard Shipping")

		TestObject ShippingOptionLink = findTestObject("Object Repository/CheckOut Details/a_shippingOptionLink")
		CheckoutPageActions.clickShippingOptionLink(ShippingOptionLink)

		CheckoutPageValidation.verifyDeliveryInputChecked()
		WebUI.click(ShippingOptionLink)
	}

	public static void paymentMethodDiv() {
		TestObject paymentMethodHeader = findTestObject("Object Repository/CheckOut Details/h2_paymentMethodHeader")
		WebUI.verifyElementVisible(paymentMethodHeader)
		assert WebUI.getText(paymentMethodHeader).equals(GlobalVariable.paymentMethodDivTitle)
		//GeneralValidation.verifyBackgroundColor(paymentMethodHeader.parentObject, GlobalVariable.grayBgColor)
	}

	public static void verifyPaymentMethodDetails() {
		TestObject paymentDetails = findTestObject("Object Repository/CheckOut Details/span_paymentMethodDetails")
		CheckoutPageValidation.verifyPaymentMethodDetails(paymentDetails)
		
		TestObject poNoDiv = findTestObject("Object Repository/CheckOut Details/div_PoNoDiv")
		WebUI.verifyElementVisible(poNoDiv)

		TestObject poNoInput = findTestObject("Object Repository/CheckOut Details/input_paymentMethodPo")
		assert WebUI.getAttribute(poNoInput, "value").equals(GlobalVariable.poNumber)

		TestObject commentInput = findTestObject("Object Repository/CheckOut Details/input_paymentMethodComment")
		assert WebUI.getAttribute(commentInput, "value").equals(GlobalVariable.comment)
	}
}
