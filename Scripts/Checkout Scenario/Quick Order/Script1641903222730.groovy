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
import validation.QuickOrderValidations

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
TestObject secStockNo = findTestObject("Object Repository/Quick Order/input_1quickOrderStock")
TestObject thirdStockNo = findTestObject("Object Repository/Quick Order/input_2quickOrderStock")
TestObject fourthStockNo = findTestObject("Object Repository/Quick Order/input_3quickOrderStock")
TestObject fivthStockNo = findTestObject("Object Repository/Quick Order/input_4quickOrderStock")


QuickOrderHelpers.fillStockNoQuickOrder(firstStockNo, GlobalVariable.firstStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(secStockNo, GlobalVariable.secStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(thirdStockNo, GlobalVariable.thirdStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(fourthStockNo, GlobalVariable.fourthStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(fivthStockNo, GlobalVariable.fifthStockNo)


List<WebElement> quantities = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),2)
List<WebElement> prices = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),2)
List<WebElement> totals = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),2)
List<WebElement> titles = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),2)
List<WebElement> stocksNotify = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),2)
List<WebElement> images = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/img_quickOrderProductImg"),2)

//arrange
TestObject firstQuantity = WebUI.convertWebElementToTestObject(quantities[0])
TestObject firstPrice = WebUI.convertWebElementToTestObject(prices[0])
TestObject firstTotal = WebUI.convertWebElementToTestObject(totals[0])
TestObject firstTitle = WebUI.convertWebElementToTestObject(titles[0])
TestObject firstImg = WebUI.convertWebElementToTestObject(images[0])
TestObject firstStocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[0])

QuickOrderHelpers.verifyQuickOrderTotal(firstTitle, firstPrice, firstTotal, firstStocksNotify, firstQuantity)

TestObject secQuantity = WebUI.convertWebElementToTestObject(quantities[1])
TestObject secPrice = WebUI.convertWebElementToTestObject(prices[1])
TestObject secTotal = WebUI.convertWebElementToTestObject(totals[1])
TestObject secTitle = WebUI.convertWebElementToTestObject(titles[1])
TestObject sectImg = WebUI.convertWebElementToTestObject(images[1])
TestObject secStocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[1])

QuickOrderHelpers.verifyQuickOrderTotal(secTitle, secPrice, secTotal, secStocksNotify, secQuantity)

TestObject thirdQuantity = WebUI.convertWebElementToTestObject(quantities[2])
TestObject thirdPrice = WebUI.convertWebElementToTestObject(prices[2])
TestObject thirdTotal = WebUI.convertWebElementToTestObject(totals[2])
TestObject thirdTitle = WebUI.convertWebElementToTestObject(titles[2])
TestObject thirdImg = WebUI.convertWebElementToTestObject(images[2])
TestObject thirdStocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[2])

QuickOrderHelpers.verifyQuickOrderTotal(thirdTitle, thirdPrice, thirdTotal, thirdStocksNotify, thirdQuantity)

TestObject fourthQuantity = WebUI.convertWebElementToTestObject(quantities[3])
TestObject fourthPrice = WebUI.convertWebElementToTestObject(prices[3])
TestObject fourthTotal = WebUI.convertWebElementToTestObject(totals[3])
TestObject fourthImg = WebUI.convertWebElementToTestObject(images[3])
TestObject fourthTitle = WebUI.convertWebElementToTestObject(titles[3])
TestObject fourthStocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[3])

QuickOrderHelpers.verifyQuickOrderTotal(fourthTitle, fourthPrice, fourthTotal, fourthStocksNotify, fourthQuantity)

TestObject fifthQuantity = WebUI.convertWebElementToTestObject(quantities[4])
TestObject fifthPrice = WebUI.convertWebElementToTestObject(prices[4])
TestObject fifthTotal = WebUI.convertWebElementToTestObject(totals[4])
TestObject fifthTitle = WebUI.convertWebElementToTestObject(titles[4])
TestObject fifthImg = WebUI.convertWebElementToTestObject(images[4])
TestObject fifthStocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[4])

QuickOrderHelpers.verifyQuickOrderTotal(fifthTitle, fifthPrice, fifthTotal, fifthStocksNotify, fifthQuantity)

TestObject addToCartBtn = findTestObject('Object Repository/Quick Order/button_addToCart')
//check background color
GeneralActions.hoverItem(addToCartBtn)
//QuickOrderValidations.verifyChangeStyleOnBtnHover(addToCartBtn)
QuickOrderActions.clickAddToCartBtn()
//check url, title

QuickOrderValidations.verifyCartCounter("5")
QuickOrderValidations.verifyCartTotal(firstTotal, secTotal, thirdTotal, fourthTotal, fifthTotal)


List<WebElement> quantitiesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),2)
List<WebElement> pricesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),2)
List<WebElement> totalsCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),2)
List<WebElement> titlesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),2)
List<WebElement> stocksNotifyCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),2)
List<WebElement> imagesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/img_quickOrderProductImg"),2)




