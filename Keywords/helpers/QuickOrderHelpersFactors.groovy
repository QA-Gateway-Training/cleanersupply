package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.DecimalFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

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

public class QuickOrderHelpersFactors {
	public static List<Integer> cartItem = new ArrayList<>();

	public static List<WebElement> quantities
	public static List<WebElement> titles
	public static List<WebElement> prices
	public static List<WebElement> totals
	public static List<WebElement> stocksNotify
	public static List<WebElement> images
	public static List<quickOrder> products

	public static List<WebElement> quantitiesShopping
	public static List<WebElement> pricesShopping
	public static List<WebElement> totalsShopping
	public static List<WebElement> titlesShopping
	public static List<WebElement> stocksNotifyShopping
	public static List<WebElement> imagesShopping



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

	public static void navigationAndVerifyingShoppingCart() {
		QuickOrderHelpers.navigateToAddToCartPage()
		TestObject shopCartHeader = findTestObject("Object Repository/Shopping Cart/h1_shopCartHeader")
		WebUI.waitForElementPresent(shopCartHeader, 5)

		GeneralHelpers.verifyNavigationToPage(GlobalVariable.shoppingCartPageTitle, shopCartHeader, GlobalVariable.shopCartHeader,
				GlobalVariable.shoppingCartUrl)
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
		DecimalFormat format = new DecimalFormat("#.##")
		double firstTotal = QuickOrderActions.formatPriceAndTotal(first)
		double secTotal = QuickOrderActions.formatPriceAndTotal(sec)
		double thirdTotal = QuickOrderActions.formatPriceAndTotal(third)
		double fourthTotal = QuickOrderActions.formatPriceAndTotal(fourth)
		double fifthTotal = QuickOrderActions.formatPriceAndTotal(fifth)
		return Double.parseDouble(format.format(firstTotal + secTotal + thirdTotal + fourthTotal + fifthTotal));
	}

	public static void navigationAndVerifyToQuickOrder() {
		QuickOrderHelpers.navigateToQuickOrderPage()

		TestObject quickOrderHeader = findTestObject("Object Repository/Quick Order/span_quickOrderHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.quickOrderPageTitle, quickOrderHeader,
				GlobalVariable.quickOrderHeader, GlobalVariable.quickOrderUrl)
	}

	public static void fillingVerifyingStockNo() {
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
	}

	public static void getProductsSelectorsFromTable() {
		quantities = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),GlobalVariable.webElementTimeOut)
		titles = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),GlobalVariable.webElementTimeOut)
		prices = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),GlobalVariable.webElementTimeOut)
		totals = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),GlobalVariable.webElementTimeOut)
		stocksNotify = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),GlobalVariable.webElementTimeOut)
		images = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/img_quickOrderProductImg"),GlobalVariable.webElementTimeOut)
	}

	public static void getProductsSelectorFromShoppingCartTabke() {
		quantitiesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/input_shoppingCartProductQuantity"),GlobalVariable.webElementTimeOut)
		pricesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/td_shoppingCartProductPrice"),GlobalVariable.webElementTimeOut)
		totalsShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/td_shoppingCartProductTotal"),GlobalVariable.webElementTimeOut)
		titlesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/a_shoppingCartProductTitle"),GlobalVariable.webElementTimeOut)
		stocksNotifyShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/div_shoppingCartStock"),GlobalVariable.webElementTimeOut)
		imagesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/img_shoppingCartProductImg"),GlobalVariable.webElementTimeOut)
	}

	public static void verifyShoppingCartProductsSameWithStoredProducts() {
		QuickOrderHelpers.getProductsSelectorFromShoppingCartTabke()

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
	}

	public static void fillingQuanitiesInputs() {
		QuickOrderHelpers.getProductsSelectorsFromTable()

		for(int i=0; i<=4; i++) {
			TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
			TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
			TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])
			QuickOrderHelpers.fillQuantityQuickOrder(Title, StocksNotify, Quantity)
		}
	}

	public static void storeProductsDetailsAndVerifyTotal() {
		products = new ArrayList<quickOrder>();
		for(int i=0; i<=4; i++) {
			TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
			TestObject Price = WebUI.convertWebElementToTestObject(prices[i])
			TestObject Total = WebUI.convertWebElementToTestObject(totals[i])
			TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
			TestObject Img = WebUI.convertWebElementToTestObject(images[i])
			TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])

			products.add(new quickOrder(WebUI.getAttribute(Quantity,"value"),WebUI.getText(Price), WebUI.getText(Total),WebUI.getText(Title),
					WebUI.getAttribute(Img,"src"),WebUI.getText(StocksNotify)))

			String name = WebUI.getText(Title)
			String qyt = WebUI.getAttribute(Quantity, 'value')
			String price = WebUI.getText(Price).replaceAll("[^0-9\\.]","")

			cartItem.add(GeneralHelperFunctions.makeListOfItems(name, price, 'none', qyt))
			GlobalVariable.cartItems = cartItem

			QuickOrderHelpers.verifyQuickOrderTotal(Price, Total, Quantity)
		}
	}

	public static void verifyCartTotalAndRowsNo(int no) {
		QuickOrderValidations.verifyCartTotal(products[0].Total, products[1].Total, products[2].Total,
				products[3].Total, products[4].Total)

		List<WebElement> productsNoCartTr = WebUI
				.findWebElements(findTestObject("Object Repository/Quick Order/tr_productsInCart")
				,GlobalVariable.webElementTimeOut)
		QuickOrderValidations.verifyProductsNoInCart(no, productsNoCartTr.size())
	}
}

public class quickOrderFactor{
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