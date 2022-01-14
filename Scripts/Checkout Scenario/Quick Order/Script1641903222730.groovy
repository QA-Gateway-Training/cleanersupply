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

import org.eclipse.jdt.internal.compiler.ast.ForeachStatement
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
List<WebElement> titles = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),GlobalVariable.webElementTimeOut)
List<WebElement> stocksNotify = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),GlobalVariable.webElementTimeOut)
List<WebElement> prices = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),GlobalVariable.webElementTimeOut)
List<WebElement> totals = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),GlobalVariable.webElementTimeOut)
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

//------------------store 5 products details & verify the total is right ----------------
 
for(int i=0; i<=4; i++) {
	TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
	TestObject Price = WebUI.convertWebElementToTestObject(prices[i])
	TestObject Total = WebUI.convertWebElementToTestObject(totals[i])
	TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
	TestObject Img = WebUI.convertWebElementToTestObject(images[i])
	TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])
	
	products.add(new quickOrder(WebUI.getAttribute(Quantity,"value"),WebUI.getText(Price), WebUI.getText(Total),WebUI.getText(Title),
							WebUI.getAttribute(Img,"src"),WebUI.getText(StocksNotify)))
	
	QuickOrderHelpers.verifyQuickOrderTotal(Price, Total, Quantity)
}
println(products[1].Quantity + " "+products[1].Img)

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
List<WebElement> quantitiesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/input_shoppingCartProductQuantity"),GlobalVariable.webElementTimeOut)
List<WebElement> pricesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/td_shoppingCartProductPrice"),GlobalVariable.webElementTimeOut)
List<WebElement> totalsShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/td_shoppingCartProductTotal"),GlobalVariable.webElementTimeOut)
List<WebElement> titlesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/a_shoppingCartProductTitle"),GlobalVariable.webElementTimeOut)
List<WebElement> stocksNotifyShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/div_shoppingCartStock"),GlobalVariable.webElementTimeOut)
List<WebElement> imagesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/img_shoppingCartProductImg"),GlobalVariable.webElementTimeOut)


//-----------------verify the products details and totals in shopping cart----------
 int y=0;
for(int i=4; i>=0; i--) {
	TestObject Quantity = WebUI.convertWebElementToTestObject(quantitiesShopping[y])
	TestObject price  = WebUI.convertWebElementToTestObject(pricesShopping[y])
	TestObject total = WebUI.convertWebElementToTestObject(totalsShopping[y])
	TestObject title = WebUI.convertWebElementToTestObject(titlesShopping[y])
	TestObject stock = WebUI.convertWebElementToTestObject(stocksNotifyShopping[y])
	TestObject img = WebUI.convertWebElementToTestObject(imagesShopping[y])
	
   assert products[i].Quantity.equals(WebUI.getAttribute(Quantity,"value"))
   assert products[i].Price.equals(WebUI.getText(price))
   assert products[i].Total.equals(WebUI.getText(total))
   assert products[i].Title.equals(WebUI.getText(title))
   assert products[i].StocksNotify.equals(WebUI.getText(stock))
   String expectedImg = products[i].Img;
   String realImg = WebUI.getAttribute(img,"src");
   assert expectedImg.substring(expectedImg.indexOf("?"))[0].equals(realImg.substring(realImg.indexOf("?"))[0])
   y++;
}


//-----------------proceed to checkout----------

TestObject proceedCheckout = findTestObject("Object Repository/Shopping Cart/button_proceedToCheckout")
GeneralValidation.verifyBackgroundColor(proceedCheckout, GlobalVariable.checkoutBgColor)
GeneralActions.hoverItem(proceedCheckout)
//QuickOrderValidations.verifyChangeStyleOnBtnHover(proceedCheckout)
WebUI.click(proceedCheckout)

TestObject checkoutHeader = findTestObject("CheckOut/div_checkoutHeader")
GeneralHelpers.verifyNavigationToPage(GlobalVariable.checkoutPageTitle, checkoutHeader,
									  GlobalVariable.checkoutHeader, GlobalVariable.checkoutUrl)
//exist of icon lock


//-----------------details after checkout----------

TestObject checkoutDetailsHeader = findTestObject("Object Repository/CheckOut Details/h1_checkoutHeader")
GeneralHelpers.verifyNavigationToPage(GlobalVariable.checkoutDetailsPageTitle, checkoutDetailsHeader,
									  "CHECKOUT", GlobalVariable.checkoutDetailsUrl)

TestObject shippingAddrDiv = findTestObject("Object Repository/CheckOut Details/div_shippingAddr")
WebUI.verifyElementVisible(shippingAddrDiv)

TestObject shippingAddrDivHeader = findTestObject("Object Repository/CheckOut Details/div_shippingAddr")
WebUI.verifyElementVisible(shippingAddrDivHeader)
assert WebUI.getText(shippingAddrDivHeader).equals("SHIPPING ADDRESS")
GeneralValidation.verifyBackgroundColor(shippingAddrDivHeader, "#f1f2f2")

TestObject fullName = findTestObject("Object Repository/CheckOut Details/span_shippingAddrCustomerName")
assert WebUI.getText(fullName).equals("asd"+" "+"asd") //global variables

TestObject address = findTestObject("Object Repository/CheckOut Details/span_shippingAddressDetails")
String[] allAddress =  WebUI.getText(address).split("\n")
assert allAddress[0].equals("sdfd") //global variables
assert allAddress[1].equals("dsdf")
assert allAddress[2].equals("dsdf")
assert allAddress[3].equals("dsdf")


TestObject StandardShippingDiv = findTestObject("Object Repository/CheckOut Details/dic_standardShiping")
WebUI.verifyElementVisible(StandardShippingDiv)
//assert WebUI.getText(StandardShippingDiv).equals("FAST, FREE Standard Shipping")
GeneralValidation.verifyBackgroundColor(shippingAddrDivHeader, "#f1f2f2")

TestObject ShippingOptionLink = findTestObject("Object Repository/CheckOut Details/a_shippingOptionLink")
assert WebUI.getCSSValue(ShippingOptionLink, "class").contains("collapsed")
WebUI.click(ShippingOptionLink)
assert !WebUI.getCSSValue(ShippingOptionLink, "class").contains("collapsed")

TestObject standardDelivery = findTestObject("Object Repository/CheckOut Details/span_standard_Delivery")
assert WebUI.getCSSValue(standardDelivery, "border-color").equals("rgb(82, 36, 127)")
WebUI.click(ShippingOptionLink)

TestObject paymentMethodHeader = findTestObject("Object Repository/CheckOut Details/h2_paymentMethodHeader")
WebUI.verifyElementVisible(paymentMethodHeader)
assert WebUI.getText(paymentMethodHeader).equals("Payment Method")

GeneralValidation.verifyBackgroundColor(paymentMethodHeader.parentObject, "#f1f2f2")

TestObject paymentDetails = findTestObject("Object Repository/CheckOut Details/span_paymentMethodDetails")
String[] allpaymentDetails =  WebUI.getText(paymentDetails).split("\n")
assert allpaymentDetails[0].split(" ")[1].equals("****")
assert allpaymentDetails[0].split(" ")[2].equals("2222333344445555".substring(12)) //last 4 numbers from card
assert WebUI.getText(paymentMethodHeader).equals("Payment Method")
assert allpaymentDetails[1].equals("") //name on card
assert allpaymentDetails[2].equals("") //expires date

TestObject poNoDiv = findTestObject("Object Repository/CheckOut Details/div_PoNoDiv")
WebUI.verifyElementVisible(poNoDiv)









