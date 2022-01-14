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
}