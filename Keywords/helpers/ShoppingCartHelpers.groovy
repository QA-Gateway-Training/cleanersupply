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

import actions.ShoppingCartActions
import internal.GlobalVariable
import validation.ShoppingCartValidations

public class ShoppingCartHelpers {
	public static void initShoppingCartPage() {
		ShoppingCartValidations.verifyShoppingCartIsEmpty()
	}

	/**
	 * Navigate to shopping cart page after clicking on cart link in the header
	 * @author waleedafifi
	 */
	public static void navigateToCartPage() {
		ShoppingCartValidations.verifyShoppingCartItemEqualMiniCartBadge()
		ShoppingCartValidations.verifyShoppingCartItemEqualToSummaryItem()
		ShoppingCartValidations.verifyTotalPriceForProductTable()
		ShoppingCartValidations.verifyTotalPriceInSummaryTable()
		ShoppingCartValidations.verifyAddedProductRefelectDetails()
	}

	/**
	 * Navigate to checkout page
	 * @author waleedafifi
	 */
	public static void navigateToCheckoutPage() {
		ShoppingCartValidations.verifyCheckoutButtonStyle()
		ShoppingCartActions.hoverCheckOutButton()
		ShoppingCartValidations.verifyCheckoutButtonOnHover()
		ShoppingCartActions.navigateToCheckOutPage()
	}
	
	/**
	 * Update and verify the quantities of the items in shipping cart
	 * @author waleedafifi
	 */
	public static void updateQuantities() {
		ShoppingCartActions.updateProductQuantity(4)
		ShoppingCartValidations.verifyQuantityValue(4)
		ShoppingCartActions.moveOutQuantityField()
		ShoppingCartValidations.verifyTotalPriceForProductTable()
		ShoppingCartValidations.verifyTotalPriceInSummaryTable()
	}
}
