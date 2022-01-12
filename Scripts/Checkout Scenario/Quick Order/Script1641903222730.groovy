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
import actions.Navigations
import actions.QuickOrderActions
import helpers.GeneralHelpers
import helpers.QuickOrderHelpers
import internal.GlobalVariable
import validation.GeneralValidation

import org.openqa.selenium.Keys as Keys

GeneralHelpers.initScenario()


TestObject quickOrderLink = findTestObject("Object Repository/Quick Order/a_quickOrder") 
WebUI.verifyElementVisible(quickOrderLink)
GeneralActions.hoverItem(quickOrderLink)
GeneralValidation.verifyColorChangeOnHover(findTestObject("Object Repository/Quick Order/i_quickOrderIcon"),"rgba(82, 36, 127, 1)") 
QuickOrderActions.clickQuickOrderLink()
//verify url,header

TestObject firstStockNo = findTestObject("Object Repository/Quick Order/input_0quickOrderStock")
WebUI.waitForElementPresent(firstStockNo, 5)
List<WebElement> quantities = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),2)
List<WebElement> prices = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),2)
List<WebElement> totals = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),2)
List<WebElement> titles = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),2)
List<WebElement> stocksNotify = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),2)


TestObject firstQuantity = WebUI.convertWebElementToTestObject(quantities[0])
TestObject firstPrice = WebUI.convertWebElementToTestObject(prices[0])
TestObject firstTotal = WebUI.convertWebElementToTestObject(totals[0])
TestObject firstTitle = WebUI.convertWebElementToTestObject(titles[0])
TestObject firstTitlefirstStocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[0])

QuickOrderHelpers.fillProductQuickOrder(firstStockNo, GlobalVariable.firstStockNo, firstQuantity, firstPrice, 
										firstTotal, firstTitle, firstTitle)


