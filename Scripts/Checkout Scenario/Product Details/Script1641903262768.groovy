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

import actions.MiniCartActions
import actions.SearchResultPageActions
import helpers.CheckoutPageHelpers
import helpers.GeneralHelpers
import helpers.MiniCartHelpers
import helpers.ProductDetailsHelpers
import helpers.SearchResultHelper
import helpers.ShoppingCartHelpers
import internal.GlobalVariable
import validation.SearchResultPageValidations

import org.openqa.selenium.Keys as Keys

GeneralHelpers.initScenario()
GeneralHelpers.headerSearchFillAndClick()
GeneralHelpers.navigateToResultPage()
SearchResultPageValidations.verifyDefaultValues()
SearchResultHelper.selectProductFilters()

SearchResultPageActions.NavigateToProductDetailsPage()

ProductDetailsHelpers.initProductDetailsPage()
// Green X large
ProductDetailsHelpers.hoverEffectAndClickXLargeSizeLink()
ProductDetailsHelpers.selectGreenColor()
ProductDetailsHelpers.fillProductQuantity(5)
ProductDetailsHelpers.addProductToCart()

MiniCartHelpers.hoverOnMiniCartHeader()

// Blue Large
ProductDetailsHelpers.hoverEffectAndClickLargeSizeLink()
ProductDetailsHelpers.selectRoyalBlueColor()
ProductDetailsHelpers.fillProductQuantity(4)
ProductDetailsHelpers.addProductToCart()

MiniCartHelpers.hoverOnMiniCartHeader()
MiniCartActions.navigateToCartPage()

ShoppingCartHelpers.navigateToCartPage()
ShoppingCartHelpers.navigateToCheckoutPage()

CheckoutPageHelpers.initCheckoutPage()
WebUI.closeBrowser()