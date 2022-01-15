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

import actions.PrimaryHeaderActions
import internal.GlobalVariable
import validation.PrimaryHeaderValidations

public class PrimaryHeaderHelpers {
	public static void topNav() {
		PrimaryHeaderValidations.verifyTopNavStyle()
		PrimaryHeaderValidations.verifyTopNavPresent()
		PrimaryHeaderValidations.verifySearchFieldIsExists()
		PrimaryHeaderValidations.verifyQiuckOrderLinkExists()
		PrimaryHeaderValidations.verifyLogoPresent()
		PrimaryHeaderValidations.verifyLogoDimension()
		PrimaryHeaderValidations.verifyHeaderExists()
		PrimaryHeaderValidations.verifyCartLinkExists()
		PrimaryHeaderValidations.verifyAccountLinkExists()
	}
	
	public static void rightLinkehoverEffect() {
		PrimaryHeaderActions.myAccountMouseMoveOver()
		PrimaryHeaderValidations.verifyMyAccountHoverEffect()
		
		PrimaryHeaderActions.quickOrderMouseMoveOver()
		PrimaryHeaderValidations.verifyQuickOrderHoverEffect()
		
		PrimaryHeaderActions.reOrderMouseMoveOver()
		PrimaryHeaderValidations.verifyReOrderHoverEffect()
	}
}
