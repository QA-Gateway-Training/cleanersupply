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

import internal.GlobalVariable
import validation.CheckOutFormValidation
import actions.checkOutFormAction
public class checkOutFormHelper {

	public static void sendCompanyValue() {
		String selectorId = "Object Repository/CheckOutForm/input_company"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.companyValue)
	}

	public static void sendFnameValue() {
		String selectorId = "Object Repository/CheckOutForm/input_fname"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.fNameValue)
	}

	public static void sendlnameValue() {
		String selectorId = "Object Repository/CheckOutForm/input_lNAme"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.lNameValue)
	}

	public static void sendAddress1Value() {
		String selectorId = "Object Repository/CheckOutForm/input_address"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.address1)
	}

	public static void sendAddress2Value() {
		String selectorId = "Object Repository/CheckOutForm/input_address2"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.address2)
	}

	public static void sendzipCodeValue() {
		String selectorId = "Object Repository/CheckOutForm/input_zipCode"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.zipCode)
	}

	public static void sendCityValue() {
		String selectorId = "Object Repository/CheckOutForm/input_city"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.city)
	}

	public static void sendPhoneValue() {
		String selectorId = "Object Repository/CheckOutForm/input_phoneNum"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.phone)
	}

	public static void sendPhoneExtValue() {
		String selectorId = "Object Repository/CheckOutForm/input_phoneExt"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.phoneExt)
	}

	public static void sendemailValue() {
		String selectorId = "Object Repository/CheckOutForm/input_email"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.email)
	}

	public static void sendCreditCardNAme() {
		String selectorId 	="Object Repository/CheckOutForm/input_creditCardName"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.creditCardNAme)
	}

	public static void sendCreditCardNum() {
		String selectorId 	="Object Repository/CheckOutForm/input_cardNumber"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.CreditCardNumber)
	}

	public static void sendCreditCardCVV() {
		String selectorId 	="Object Repository/CheckOutForm/input_cvv"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.creditCVV)
	}

	// select expiration date
	// select year

	public static void sendPO() {
		String selectorId 	="Object Repository/CheckOutForm/input_PO"
		CheckOutFormValidation
				.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.poNumber)
	}



	public static void sendComment() {
		String selectorId 	="Object Repository/CheckOutForm/input_comments"
		//		CheckOutFormValidation
		//		.validateBoxShadowBlaceHolderBorder(selectorId)
		checkOutFormAction.sendValue(selectorId,GlobalVariable.comment)
	}
	
	public static void fillCheckOutForm() {
		TestObject CheckOutHeader = findTestObject("Object Repository/CheckOutForm/h1_checkOutHeader")
		
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.checkOutFormTitle,CheckOutHeader,
			GlobalVariable.checkOutFormHeader, GlobalVariable.checkOutFormURL)
		checkOutFormHelper.sendCompanyValue()
		checkOutFormHelper.sendFnameValue()
		checkOutFormHelper.sendlnameValue()
		checkOutFormHelper.sendAddress1Value()
		checkOutFormHelper.sendAddress2Value()
		checkOutFormHelper.sendzipCodeValue()
		checkOutFormHelper.sendCityValue()
		checkOutFormHelper.sendPhoneValue()
		checkOutFormHelper.sendPhoneExtValue()
		checkOutFormHelper.sendPhoneExtValue()
		checkOutFormHelper.sendemailValue()
		String button = "Object Repository/CheckOutForm/button_state"
		String aSelector="Object Repository/CheckOutForm/a_state"
		String selectedSpan = "Object Repository/CheckOutForm/span_selectedState"
		checkOutFormAction.selectStateValue(button,aSelector,selectedSpan)
		//CheckOutFormValidation.checkVisibilityOfFreeShippingFormandCollapsedByDefault()
		checkOutFormHelper.sendCreditCardNAme()
		checkOutFormHelper.sendCreditCardNum()
		checkOutFormHelper.sendCreditCardCVV()
		checkOutFormAction.selectRandomExpirationDateExceptNowMonth()
		checkOutFormAction.selectRandomExpirationYearExceptNowMonth()
		checkOutFormHelper.sendPO()
		checkOutFormHelper.sendComment()
		checkOutFormAction.clickReviewButton()
	}

}

