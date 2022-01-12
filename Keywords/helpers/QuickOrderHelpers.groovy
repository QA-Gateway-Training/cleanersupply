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
import actions.QuickOrderActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.QuickOrderValidations

public class QuickOrderHelpers {

	public static void fillStockNoQuickOrder(TestObject stockInput, String value) {
		GeneralActions.focusItem(stockInput)
		//	QuickOrderValidations.verifyChangesOnInputFocus(stockInput, "rgb(99, 99, 99) 0px -3px 0px 0px inset")
		WebUI.sendKeys(stockInput, value+ Keys.ENTER)
		GeneralValidation.verifyInputValue(stockInput, value)
	}

	public static void verifyQuickOrderTotal(TestObject title,TestObject price, TestObject expectedSubTotal, TestObject stock,TestObject quantityInput) {
		int randomQuantity = (int) (Math.random() * 50 + 4)
		WebUI.sendKeys(quantityInput, Keys.chord(Keys.BACK_SPACE) +randomQuantity+Keys.TAB )
		GeneralValidation.verifyInputValue(quantityInput, randomQuantity.toString())
		WebUI.verifyElementPresent(title, 2)
		WebUI.verifyElementText(stock, "In Stock!")
		QuickOrderValidations.verifyQuickOrderSubTotal(randomQuantity, price, expectedSubTotal)
	}

	public static double calculateQuickOrdersTotal(TestObject first, TestObject sec, TestObject third, TestObject fourth,TestObject fifth) {
		double firstTotal = QuickOrderActions.formatPriceAndTotal(first)
		double secTotal = QuickOrderActions.formatPriceAndTotal(sec)
		double thirdTotal = QuickOrderActions.formatPriceAndTotal(third)
		double fourthTotal = QuickOrderActions.formatPriceAndTotal(fourth)
		double fifthTotal = QuickOrderActions.formatPriceAndTotal(fifth)
		return firstTotal*secTotal*thirdTotal*fourthTotal*fifthTotal;
	}
}
