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
	}

	/**
	 * Navigate to checkout form page
	 * @author waleedafifi
	 */
	public static void navigateToCheckoutInformationForm() {
		CheckoutPageActions.navigateToCheckoutPageForm()
	}
	
	public static void ShippingAddressDiv() {
		TestObject shippingAddrDiv = findTestObject("Object Repository/CheckOut Details/div_shippingAddr")
		WebUI.scrollToElement(shippingAddrDiv,GlobalVariable.elementVisibilityTimeOut)
		WebUI.verifyElementVisible(shippingAddrDiv)
		GeneralValidation.verifyBackgroundColor(shippingAddrDiv, GlobalVariable.grayBgColor)
		TestObject shippingAddrDivHeader = findTestObject("Object Repository/CheckOut Details/h2_shippingAddrDivHeader")
		WebUI.verifyElementVisible(shippingAddrDivHeader)
		assert WebUI.getText(shippingAddrDivHeader).equals("SHIPPING ADDRESS")
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
	
	public static void standardShippingAddress() {
		TestObject StandardShippingDiv = findTestObject("Object Repository/CheckOut Details/dic_standardShiping")
		WebUI.verifyElementVisible(StandardShippingDiv)
		GeneralValidation.verifyBackgroundColor(StandardShippingDiv, GlobalVariable.grayBgColor)
		
		//assert WebUI.getText(StandardShippingDiv).equals("FAST, FREE Standard Shipping")
		
		TestObject ShippingOptionLink = findTestObject("Object Repository/CheckOut Details/a_shippingOptionLink")
		assert WebUI.getAttribute(ShippingOptionLink, "class").contains("collapsed")
		WebUI.click(ShippingOptionLink)
		assert !WebUI.getAttribute(ShippingOptionLink, "class").contains("collapsed")
		
		TestObject standardDelivery = findTestObject("Object Repository/CheckOut Details/span_standard_Delivery")
		assert WebUI.getCSSValue(standardDelivery, "border-color").equals("rgb(82, 36, 127)")
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
		String[] allpaymentDetails =  WebUI.getText(paymentDetails).split("\n")
		println(allpaymentDetails)
		assert allpaymentDetails[0].equals(GlobalVariable.cardType +" **** "+GlobalVariable.CreditCardNumber.toString().substring(11))
		assert allpaymentDetails[1].equals(GlobalVariable.creditCardNAme)
		assert allpaymentDetails[2].equals("Expires: "+ GlobalVariable.monthValue.toString().split(" ")[0].replace('0', '') + "/" +GlobalVariable.yearValue.toString().substring(2))
		
		TestObject poNoDiv = findTestObject("Object Repository/CheckOut Details/div_PoNoDiv")
		WebUI.verifyElementVisible(poNoDiv)
		
		TestObject poNoInput = findTestObject("Object Repository/CheckOut Details/input_paymentMethodPo")
		assert WebUI.getAttribute(poNoInput, "value").equals(GlobalVariable.poNumber)
		
		TestObject commentInput = findTestObject("Object Repository/CheckOut Details/input_paymentMethodComment")
		assert WebUI.getAttribute(commentInput, "value").equals(GlobalVariable.comment)
		
	}
	
	
}
