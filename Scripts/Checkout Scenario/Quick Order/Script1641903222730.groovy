import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement
import actions.GeneralActions
import actions.MiniCartActions
import actions.Navigations
import actions.QuickOrderActions
import actions.ShoppingCartActions
import actions.checkOutFormAction
import helpers.CheckoutPageHelpers
import helpers.GeneralHelpers
import helpers.MiniCartHelpers
import helpers.QuickOrderHelpers
import helpers.ShoppingCartHelpers
import helpers.checkOutFormHelper
import internal.GlobalVariable
import validation.CheckoutPageValidation
import validation.GeneralValidation
import validation.MiniCartValidations
import validation.QuickOrderValidations
import validation.ShoppingCartValidations

import org.eclipse.jdt.internal.compiler.ast.ForeachStatement
import org.openqa.selenium.Keys as Keys


GeneralHelpers.initScenario()

//-------------------quick order------------------------

QuickOrderHelpers.navigationAndVerifyToQuickOrder()
QuickOrderValidations.verifyCartCounter("0")

//--------------filling product stock number inputs ----------

QuickOrderHelpers.headerAndTableStyle()
QuickOrderHelpers.fillingVerifyingStockNo()

//---------------filling quantity inputs and verify total----------

QuickOrderHelpers.fillingQuanitiesInputs()

//------------------store 5 products details & verify the total is right ----------------

QuickOrderHelpers.storeProductsDetailsAndVerifyTotal()

//-----------------navigation to shopping cart and verify it--------------------------------

QuickOrderHelpers.navigationAndVerifyingShoppingCart()

//-----------------verify cart counter and cart total same with products table----------

QuickOrderValidations.verifyCartCounter("5")
QuickOrderHelpers.verifyCartTotalAndRowsNo(5)

//-----------------verify cart counter and cart total inside mini cart ---------------

//MiniCartHelpers.hoverOnMiniCartHeader()
MiniCartActions.hoverOnMiniCartLink()
MiniCartValidations.verifyHoverStyleOnMiniCartLink()
MiniCartValidations.verifyMiniCartTotals()
MiniCartValidations.miniCartItemCount()

//ShoppingCartHelpers.navigateToCartPage()
ShoppingCartValidations.verifyShoppingCartItemEqualMiniCartBadge()
ShoppingCartValidations.verifyShoppingCartItemEqualToSummaryItem()
ShoppingCartValidations.verifyTotalPriceForProductTable()
ShoppingCartValidations.verifyTotalPriceInSummaryTable()

//-----------------verify the products details and totals in shopping cart same as stored products----------

QuickOrderHelpers.verifyShoppingCartProductsSameWithStoredProducts()

//-----------------proceed to checkout----------

ShoppingCartHelpers.navigateToCheckoutPage()

CheckoutPageValidation.verifyNaigationTOCheckOut()

//CheckoutPageHelpers.initCheckoutPage()
CheckoutPageValidation.verifyTotalPrice()
CheckoutPageValidation.verifyCheckoutAsGuest()
CheckoutPageValidation.verifyCheckoutAsGuestSelected()
CheckoutPageValidation.verifyProductSummaryItemQountityTotal()

CheckoutPageHelpers.navigateToCheckoutInformationForm()

//-----------------filling checkout form----------

checkOutFormHelper.fillCheckOutForm()

//-----------------details after checkout----------

CheckoutPageValidation.verifyNavigationToCheckoutDetails()

CheckoutPageHelpers.ShippingAddressDiv()

CheckoutPageHelpers.ShippingDetailsInCeckout()

CheckoutPageHelpers.standardShippingAddress()

CheckoutPageHelpers.paymentMethodDiv()

CheckoutPageHelpers.verifyPaymentMethodDetails()









