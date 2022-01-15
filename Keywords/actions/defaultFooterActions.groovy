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
import helpers.GeneralHelpers
public class defaultFooterActions {

	public static void clickFavouritLink() {
		TestObject favourites = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_favourites")
		WebUI.scrollToElement(favourites, 3)
		WebUI.click(favourites)
	}

	public static void clickpreviouslyOrdered() {
		TestObject previouslyOrdered = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_previouslyOrdered")
		WebUI.click(previouslyOrdered)
	}
	public static void clickQuickOrder() {
		TestObject quick = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_quickOrder")
		WebUI.click(quick)
	}

	public static void clickOnOnlineOrder() {
		TestObject quick = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_onlineOrdering")
		WebUI.click(quick)
	}

	public static void fillEmailSubscriber() {
		TestObject emailInput = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/input_emailSubscribe")
		WebUI.setText(emailInput, GlobalVariable.email)
		String text = WebUI.getAttribute(emailInput, 'value')
		assert text.equals(GlobalVariable.email)
	}

	public static void clickOnSignUpSubscriber() {
		TestObject signUpBtn = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/a_signIpSubscriber")
		WebUI.click(signUpBtn)
		TestObject successMsg = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_successMessage")
		assert WebUI.verifyElementVisible(successMsg)
		String msg =WebUI.getText(successMsg)
		assert msg.equals(GlobalVariable.emailSuccessMessage)
	}
}
