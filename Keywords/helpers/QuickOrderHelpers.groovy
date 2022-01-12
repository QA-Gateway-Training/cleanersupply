package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

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

import actions.GeneralActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.QuickOrderValidations

public class QuickOrderHelpers {

	public static void fillProductQuickOrder(TestObject stockInput, String value, TestObject quantityInput, TestObject price, TestObject expectedSubTotal,TestObject title, TestObject stock) {
		GeneralActions.focusItem(stockInput)
		QuickOrderValidations.verifyChangesOnInputFocus(stockInput, GlobalVariable.shadowValue)
		WebUI.sendKeys(stockInput, value+ Keys.ENTER)
		GeneralValidation.verifyInputValue(stockInput, value)
		int randomQuantity = (int) (Math.random() * 50 + 5)
		WebUI.sendKeys(quantityInput, randomQuantity+""+Keys.TAB)
		GeneralValidation.verifyInputValue(quantityInput, randomQuantity)
		WebUI.verifyElementPresent(title, 2)
		WebUI.verifyElementText(stock, " In Stock!")
		QuickOrderValidations.verifyQuickOrderSubTotal(randomQuantity, price, expectedSubTotal)
	}
}
