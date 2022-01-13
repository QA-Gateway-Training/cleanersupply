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

	public static void navigateToQuickOrderPage() {
		TestObject quickOrderLink = findTestObject("Object Repository/Quick Order/a_quickOrder")
		WebUI.verifyElementVisible(quickOrderLink)
		GeneralActions.hoverItem(quickOrderLink)
		GeneralValidation.verifyColorChangeOnHover(findTestObject("Object Repository/Quick Order/i_quickOrderIcon"),GlobalVariable.quickOrderIconColor)
		QuickOrderActions.clickQuickOrderLink()
	}

	public static void navigateToAddToCartPage() {
		TestObject addToCartBtn = findTestObject('Object Repository/Quick Order/button_addToCart')
		//check background color
		GeneralActions.hoverItem(addToCartBtn)
		//QuickOrderValidations.verifyChangeStyleOnBtnHover(addToCartBtn)
		QuickOrderActions.clickAddToCartBtn()
	}
	
	public static void fillStockNoQuickOrder(TestObject stockInput, String value) {
		GeneralActions.focusItem(stockInput)
		//	QuickOrderValidations.verifyChangesOnInputFocus(stockInput, "rgb(99, 99, 99) 0px -3px 0px 0px inset")
		WebUI.sendKeys(stockInput, value+ Keys.ENTER)
		GeneralValidation.verifyInputValue(stockInput, value)
	}

	public static void fillQuantityQuickOrder(TestObject title,TestObject stock, TestObject quantityInput) {
		int randomQuantity = (int) (Math.random() * 50 + 1)
		WebUI.sendKeys(quantityInput, Keys.chord(Keys.BACK_SPACE) +randomQuantity+Keys.TAB )
		GeneralValidation.verifyInputValue(quantityInput, randomQuantity.toString())
		WebUI.verifyElementPresent(title, 2)
		WebUI.verifyElementText(stock, "In Stock!")
	}
	
	public static void verifyQuickOrderTotal(TestObject price, TestObject expectedSubTotal, TestObject quantityInput) {
		int quantity = Integer.parseInt(WebUI.getAttribute(quantityInput, "value"))
		QuickOrderValidations.verifyQuickOrderSubTotal(quantity, price, expectedSubTotal)
	}

	public static double calculateQuickOrdersTotal(String first, String sec, String third, String fourth,String fifth) {
		double firstTotal = QuickOrderActions.formatPriceAndTotal(first)
		double secTotal = QuickOrderActions.formatPriceAndTotal(sec)
		double thirdTotal = QuickOrderActions.formatPriceAndTotal(third)
		double fourthTotal = QuickOrderActions.formatPriceAndTotal(fourth)
		double fifthTotal = QuickOrderActions.formatPriceAndTotal(fifth)
		return firstTotal + secTotal + thirdTotal + fourthTotal + fifthTotal;
	}
}
