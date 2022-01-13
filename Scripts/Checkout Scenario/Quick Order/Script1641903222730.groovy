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

//-------------------quick order------------------------
QuickOrderHelpers.navigateToQuickOrderPage()

TestObject quickOrderHeader = findTestObject("Object Repository/Quick Order/span_quickOrderHeader")
GeneralHelpers.verifyNavigationToPage(GlobalVariable.quickOrderPageTitle, quickOrderHeader, 
									  GlobalVariable.quickOrderHeader, GlobalVariable.quickOrderUrl)

//--------------product stock number inputs ----------
TestObject firstStockNo = findTestObject("Object Repository/Quick Order/input_0quickOrderStock")
WebUI.waitForElementPresent(firstStockNo, 5)
TestObject secStockNo = findTestObject("Object Repository/Quick Order/input_1quickOrderStock")
TestObject thirdStockNo = findTestObject("Object Repository/Quick Order/input_2quickOrderStock")
TestObject fourthStockNo = findTestObject("Object Repository/Quick Order/input_3quickOrderStock")
TestObject fivthStockNo = findTestObject("Object Repository/Quick Order/input_4quickOrderStock")

//--------------filling stock no----------------------
QuickOrderHelpers.fillStockNoQuickOrder(firstStockNo, GlobalVariable.firstStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(secStockNo, GlobalVariable.secStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(thirdStockNo, GlobalVariable.thirdStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(fourthStockNo, GlobalVariable.fourthStockNo)
QuickOrderHelpers.fillStockNoQuickOrder(fivthStockNo, GlobalVariable.fifthStockNo)

//---------------get quick order products details----------
List<WebElement> quantities = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),GlobalVariable.webElementTimeOut)
List<WebElement> prices = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),GlobalVariable.webElementTimeOut)
List<WebElement> totals = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),GlobalVariable.webElementTimeOut)
List<WebElement> titles = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),GlobalVariable.webElementTimeOut)
List<WebElement> stocksNotify = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),GlobalVariable.webElementTimeOut)
List<WebElement> images = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/img_quickOrderProductImg"),GlobalVariable.webElementTimeOut)

//---------------filling quantity inputs and verify total----------
for(int i=0; i<=4; i++) {
	TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
	TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
	TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])
	QuickOrderHelpers.fillQuantityQuickOrder(Title, StocksNotify, Quantity)
}

//List<Object> products = new List<Object>();
class quickOrder{
	public String Quantity;
	public String Price;
	public String Total;
	public String Title;
	public String Img;
	public String StocksNotify;
	
	public quickOrder(String _Quantity,String _Price, String _Total, String _Title,String _Img ,String _StocksNotify) {
		Quantity = _Quantity;
		Price = _Price;
		Total = _Total;
		Title = _Title;
		Img = _Img;
		StocksNotify = _StocksNotify;
	}
}

List<quickOrder> products = new ArrayList<quickOrder>();

for(int i=0; i<=4; i++) {
	TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
	TestObject Price = WebUI.convertWebElementToTestObject(prices[i])
	TestObject Total = WebUI.convertWebElementToTestObject(totals[i])
	TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
	TestObject Img = WebUI.convertWebElementToTestObject(images[i])
	TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])
	products.add(new quickOrder(WebUI.getText(Quantity),WebUI.getText(Price), WebUI.getText(Total),WebUI.getText(Title),
							WebUI.getAttribute(Img,"src"),WebUI.getText(StocksNotify)))
	QuickOrderHelpers.verifyQuickOrderTotal(Price, Total, Quantity)
}

//-----------------add to cart--------------------------------
QuickOrderHelpers.navigateToAddToCartPage()
TestObject shopCartHeader = findTestObject("Object Repository/Shopping Cart/h1_shopCartHeader")
WebUI.waitForElementPresent(shopCartHeader, 5)

GeneralHelpers.verifyNavigationToPage(GlobalVariable.addToCartPageTitle, shopCartHeader, GlobalVariable.shopCartHeader, 
									  GlobalVariable.shoppingCartUrl)


//-----------------verify cart counter and cart total----------
QuickOrderValidations.verifyCartCounter("5")
println(products[0].Total+" "+ products[1].Total+" "+ products[2].Total+" "+products[3].Total+" "+ products[4].Total) 
QuickOrderValidations.verifyCartTotal(products[0].Total, products[1].Total, products[2].Total, 
									  products[3].Total, products[4].Total)

List<WebElement> productsNoCartTr = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/tr_productsInCart"),GlobalVariable.webElementTimeOut)
QuickOrderValidations.verifyProductsNoInCart(5, productsNoCartTr.size())


//-----------------get products details from shopping cart page----------
List<WebElement> quantitiesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),GlobalVariable.webElementTimeOut)
List<WebElement> pricesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),GlobalVariable.webElementTimeOut)
List<WebElement> totalsCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),GlobalVariable.webElementTimeOut)
List<WebElement> titlesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),GlobalVariable.webElementTimeOut)
List<WebElement> stocksNotifyCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),GlobalVariable.webElementTimeOut)
List<WebElement> imagesCheckout = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/img_quickOrderProductImg"),GlobalVariable.webElementTimeOut)


//-----------------verify the products details and totals in shopping cart----------





//-----------------proceed to checkout----------

TestObject proceedCheckout = findTestObject("Object Repository/Shopping Cart/button_proceedToCheckout")
GeneralActions.hoverItem(proceedCheckout)
//GeneralValidation.verifyColorChangeOnHover(proceedCheckout,GlobalVariable.quickOrderIconColor)
WebUI.click(proceedCheckout)









