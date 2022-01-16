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
import actions.MiniCartActions
import actions.QuickOrderActions
import internal.GlobalVariable
import validation.CheckoutPageValidation
import validation.GeneralValidation
import validation.MiniCartValidations
import validation.QuickOrderValidations
import validation.ShoppingCartValidations

public class QuickOrderHelpers {

	public static List<Integer> cartItem = new ArrayList<>();

	public static List<WebElement> quantities
	public static List<WebElement> titles
	public static List<WebElement> prices
	public static List<WebElement> totals
	public static List<WebElement> stocksNotify
	public static List<WebElement> images
	public static List<WebElement> sku
	public static List<quickOrder> products

	public static List<WebElement> quantitiesShopping
	public static List<WebElement> pricesShopping
	public static List<WebElement> totalsShopping
	public static List<WebElement> titlesShopping
	public static List<WebElement> stocksNotifyShopping
	public static List<WebElement> imagesShopping
	public static List<WebElement> skuShopping


	/***
	 * navigation to quick order page: verify visibility, hover link, verify style, click the link
	 * @author shaimaa Iqtefan
	 */
	public static void navigateToQuickOrderPage() {
		TestObject quickOrderLink = findTestObject("Object Repository/Quick Order/a_quickOrder")
		WebUI.verifyElementVisible(quickOrderLink)
		GeneralActions.hoverItem(quickOrderLink)
		GeneralValidation.verifyColorChangeOnHover(findTestObject("Object Repository/Quick Order/i_quickOrderIcon"),GlobalVariable.quickOrderIconColor)
		QuickOrderActions.clickQuickOrderLink()
	}

	/***
	 * navigation to shopping cart page: hover button, verify style, click the link
	 * @author shaimaa Iqtefan
	 */
	public static void navigateToAddToCartPage() {
		TestObject addToCartBtn = findTestObject('Object Repository/Quick Order/button_addToCart')
		GeneralActions.hoverItem(addToCartBtn)
		//assert WebUI.getCSSValue(container, 'box-shadow').equals('rgba(0, 0, 0, 0.3) 0px 0px 10px 2px')
		QuickOrderActions.clickAddToCartBtn()
	}

	/***
	 * navigation to shopping cart page, verify hearder, titl, url 
	 * @author shaimaa Iqtefan
	 */
	public static void navigationAndVerifyingShoppingCart() {
		QuickOrderHelpers.navigateToAddToCartPage()
		TestObject shopCartHeader = findTestObject("Object Repository/Shopping Cart/h1_shopCartHeader")
		WebUI.waitForElementPresent(shopCartHeader, 5)

		GeneralHelpers.verifyNavigationToPage(GlobalVariable.shoppingCartPageTitle, shopCartHeader, GlobalVariable.shopCartHeader,
				GlobalVariable.shoppingCartUrl)
	}

	/***
	 * filling stock number, verify placeholder, focus the input, verify it's style, reflected value
	 * @author shaimaa Iqtefan
	 */
	public static void fillStockNoQuickOrder(TestObject stockInput, String value) {
		QuickOrderValidations.verifyInputPlaceholder(stockInput)
		QuickOrderValidations.verifyInputEmpty(stockInput)
		GeneralActions.focusItem(stockInput)
		//	assert WebUI.verifyEqual(WebUI.getCSSValue(stockInput, 'box-shadow'), GlobalVariable.checkOutInputShadow)
		//	assert WebUI.verifyEqual(WebUI.getCSSValue(stockInput, 'border-color'), GlobalVariable.checkOutinputborderColor)
		WebUI.sendKeys(stockInput, value+ Keys.ENTER)
		GeneralValidation.verifyInputValue(stockInput, value)
	}

	/***
	 * filling Quantity input with random value, verify reflected value
	 * @author shaimaa Iqtefan
	 */
	public static void fillQuantityQuickOrder(TestObject quantityInput) {
		int randomQuantity = (int) (Math.random() * 50 + 1)
		WebUI.sendKeys(quantityInput, Keys.chord(Keys.BACK_SPACE) +randomQuantity+Keys.TAB )
		GeneralValidation.verifyInputValue(quantityInput, randomQuantity.toString())
	}

	/***
	 * calculate and check the total number is right
	 * @author shaimaa Iqtefan
	 */
	public static void verifyQuickOrderTotal(TestObject price, TestObject expectedSubTotal, TestObject quantityInput) {
		int quantity = Integer.parseInt(WebUI.getAttribute(quantityInput, "value"))
		QuickOrderValidations.verifyQuickOrderSubTotal(quantity, price, expectedSubTotal)
	}

	/***
	 * calculate the total number of all products totals
	 * @author shaimaa Iqtefan
	 */
	public static double calculateQuickOrdersTotal(String first, String sec, String third, String fourth,String fifth) {
		DecimalFormat format = new DecimalFormat("#.##")
		double firstTotal = QuickOrderActions.formatPriceAndTotal(first)
		double secTotal = QuickOrderActions.formatPriceAndTotal(sec)
		double thirdTotal = QuickOrderActions.formatPriceAndTotal(third)
		double fourthTotal = QuickOrderActions.formatPriceAndTotal(fourth)
		double fifthTotal = QuickOrderActions.formatPriceAndTotal(fifth)
		return Double.parseDouble(format.format(firstTotal + secTotal + thirdTotal + fourthTotal + fifthTotal));
	}

	/***
	 * navigation to quick order page, verify url, title, header
	 * @author shaimaa Iqtefan
	 */
	public static void navigationAndVerifyToQuickOrder() {
		QuickOrderHelpers.navigateToQuickOrderPage()

		TestObject quickOrderHeader = findTestObject("Object Repository/Quick Order/span_quickOrderHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.quickOrderPageTitle, quickOrderHeader,
				GlobalVariable.quickOrderHeader, GlobalVariable.quickOrderUrl)
	}

	/***
	 * verify quick order header style and non visibility of addToCart Button
	 * @author shaimaa Iqtefan
	 */
	public static void headerAndTableStyle() {
		QuickOrderValidations.veriyHeaderStyle()
		TestObject quickOrderTableRows = findTestObject("Object Repository/Quick Order/tr_allQuickOrderRows")
		GeneralValidation.verifyBackgroundColor(quickOrderTableRows,GlobalVariable.grayBgColor)
		TestObject addToCartBtn = findTestObject("Object Repository/Quick Order/button_addToCart")
		WebUI.verifyElementNotPresent(addToCartBtn,2)
	}

	/***
	 * filling stock number and verify value is reflected
	 * @author shaimaa Iqtefan
	 */
	public static void fillingVerifyingStockNo() {
		TestObject firstStockNo = findTestObject("Object Repository/Quick Order/input_0quickOrderStock")
		WebUI.waitForElementPresent(firstStockNo, 5)
		TestObject secStockNo = findTestObject("Object Repository/Quick Order/input_1quickOrderStock")
		TestObject thirdStockNo = findTestObject("Object Repository/Quick Order/input_2quickOrderStock")
		TestObject fourthStockNo = findTestObject("Object Repository/Quick Order/input_3quickOrderStock")
		TestObject fivthStockNo = findTestObject("Object Repository/Quick Order/input_4quickOrderStock")

		QuickOrderHelpers.fillStockNoQuickOrder(firstStockNo, GlobalVariable.firstStockNo)
		TestObject addToCartBtn = findTestObject("Object Repository/Quick Order/button_addToCart")
		WebUI.verifyElementVisible(addToCartBtn)
		QuickOrderHelpers.fillStockNoQuickOrder(secStockNo, GlobalVariable.secStockNo)
		QuickOrderHelpers.fillStockNoQuickOrder(thirdStockNo, GlobalVariable.thirdStockNo)
		QuickOrderHelpers.fillStockNoQuickOrder(fourthStockNo, GlobalVariable.fourthStockNo)
		QuickOrderHelpers.fillStockNoQuickOrder(fivthStockNo, GlobalVariable.fifthStockNo)
	}

	/***
	 * verify visibility of Product Details when filling stock number
	 * @author shaimaa Iqtefan
	 */
	public static void visibilityOfProductDetails() {
		QuickOrderHelpers.getProductsSelectorsFromTable()

		for(int i=0; i<=4; i++) {
			TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
			TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])
			TestObject Imgs = WebUI.convertWebElementToTestObject(images[i])
			TestObject Prices = WebUI.convertWebElementToTestObject(prices[i])

			WebUI.verifyElementPresent(Title, GlobalVariable.elementVisibilityTimeOut)
			WebUI.verifyElementPresent(Imgs, GlobalVariable.elementVisibilityTimeOut)
			WebUI.verifyElementPresent(Prices, GlobalVariable.elementVisibilityTimeOut)
			WebUI.verifyElementText(StocksNotify, "In Stock!")
		}
	}

	/***
	 * get Products Selectors From quick order Table
	 * @author shaimaa Iqtefan
	 */
	public static void getProductsSelectorsFromTable() {
		quantities = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_quantities"),GlobalVariable.webElementTimeOut)
		titles = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/a_quickOrderTitle"),GlobalVariable.webElementTimeOut)
		prices = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderPrice"),GlobalVariable.webElementTimeOut)
		totals = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/span_quickOrderTotal"),GlobalVariable.webElementTimeOut)
		stocksNotify = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/div_quickOrderStock"),GlobalVariable.webElementTimeOut)
		images = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/img_quickOrderProductImg"),GlobalVariable.webElementTimeOut)
		sku = WebUI.findWebElements(findTestObject("Object Repository/Quick Order/input_tabkeSku"),GlobalVariable.webElementTimeOut)
	}

	/***
	 * get Products Selectors From Shopping Cart Table
	 * @author shaimaa Iqtefan
	 */
	public static void getProductsSelectorFromShoppingCartTabke() {
		quantitiesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/input_shoppingCartProductQuantity"),GlobalVariable.webElementTimeOut)
		pricesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/td_shoppingCartProductPrice"),GlobalVariable.webElementTimeOut)
		totalsShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/td_shoppingCartProductTotal"),GlobalVariable.webElementTimeOut)
		titlesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/a_shoppingCartProductTitle"),GlobalVariable.webElementTimeOut)
		stocksNotifyShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/div_shoppingCartStock"),GlobalVariable.webElementTimeOut)
		imagesShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/img_shoppingCartProductImg"),GlobalVariable.webElementTimeOut)
		skuShopping = WebUI.findWebElements(findTestObject("Object Repository/Shopping Cart/span_shopiingTableSku"),GlobalVariable.webElementTimeOut)
	}

	/***
	 * verify Products in Shopping Cart page are Same With the Stored (previously entered) Products
	 * @author shaimaa Iqtefan
	 */
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
			TestObject sku = WebUI.convertWebElementToTestObject(skuShopping[y])

			assert products[i].Quantity.equals(WebUI.getAttribute(Quantity,"value"))
			assert products[i].Price.equals(WebUI.getText(price))
			assert products[i].Total.equals(WebUI.getText(total))
			assert products[i].Title.equals(WebUI.getText(title))
			assert products[i].StocksNotify.equals(WebUI.getText(stock))
			assert products[i].Sku.equals(WebUI.getText(sku))
			String expectedImg = products[i].Img;
			String realImg = WebUI.getAttribute(img,"src");
			assert expectedImg.substring(expectedImg.indexOf("?"))[0].equals(realImg.substring(realImg.indexOf("?"))[0])
			y++;
		}
	}

	/***
	 * filling Quantity inputs with random value for each product
	 * @author shaimaa Iqtefan
	 */
	public static void fillingQuanitiesInputs() {
		for(int i=0; i<=4; i++) {
			TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
			QuickOrderHelpers.fillQuantityQuickOrder(Quantity)
		}
	}

	/***
	 * store added Products Details on list And Verify Total is right
	 * @author shaimaa Iqtefan
	 */
	public static void storeProductsDetailsAndVerifyTotal() {
		products = new ArrayList<quickOrder>();
		for(int i=0; i<=4; i++) {
			TestObject Quantity = WebUI.convertWebElementToTestObject(quantities[i])
			TestObject Price = WebUI.convertWebElementToTestObject(prices[i])
			TestObject Total = WebUI.convertWebElementToTestObject(totals[i])
			TestObject Title = WebUI.convertWebElementToTestObject(titles[i])
			TestObject Img = WebUI.convertWebElementToTestObject(images[i])
			TestObject StocksNotify = WebUI.convertWebElementToTestObject(stocksNotify[i])
			TestObject Sku = WebUI.convertWebElementToTestObject(sku[i])

			products.add(new quickOrder(WebUI.getAttribute(Quantity,"value"),WebUI.getText(Price), WebUI.getText(Total),WebUI.getText(Title),
					WebUI.getAttribute(Img,"src"),WebUI.getText(StocksNotify),WebUI.getAttribute(Sku,"value")))
			String name = WebUI.getText(Title)
			String qyt = WebUI.getAttribute(Quantity, 'value')
			String price = WebUI.getText(Price).replaceAll("[^0-9\\.]","")
			String sku = WebUI.getAttribute(Sku,"value")

			cartItem.add(GeneralHelperFunctions.makeListOfItems(name, price, sku, qyt))

			QuickOrderHelpers.verifyQuickOrderTotal(Price, Total, Quantity)
		}
		GlobalVariable.cartItems = cartItem
	}

	/***
	 * verify Cart Total is right And Rows No as expected
	 * @author shaimaa Iqtefan
	 */
	public static void verifyCartTotalAndRowsNo(int no) {
		QuickOrderValidations.verifyCartTotal(products[0].Total, products[1].Total, products[2].Total,
				products[3].Total, products[4].Total)

		List<WebElement> productsNoCartTr = WebUI
				.findWebElements(findTestObject("Object Repository/Quick Order/tr_productsInCart")
				,GlobalVariable.webElementTimeOut)
		QuickOrderValidations.verifyProductsNoInCart(no, productsNoCartTr.size())
	}

	/***
	 * hover On Mini Cart Header and verify values 
	 * @author shaimaa Iqtefan
	 */
	public static void hoverOnMiniCartHeader() {
		MiniCartActions.hoverOnMiniCartLink()
		MiniCartValidations.verifyHoverStyleOnMiniCartLink()
		MiniCartValidations.verifyMiniCartTotals()
		MiniCartValidations.miniCartItemCount()
		QuickOrderHelpers.verifyMiniCartAddedProductRefelectDetails()
	}


	public static void verifyAddedProductRefelectDetails() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/div_productPrice'), GlobalVariable.globalTimeOut)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/input_productQuantity'), GlobalVariable.globalTimeOut)
		List<WebElement> prodSKU = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/span_skuNumber'), GlobalVariable.globalTimeOut)
		List<WebElement> prodName = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/a_tableProductNameTitle'), GlobalVariable.globalTimeOut)
		List<WebElement> totalPrice = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/div_priceTotal'), GlobalVariable.globalTimeOut)

		List cartItem = GlobalVariable.cartItems
		boolean flag = false


		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('innerText');
			String sku = prodSKU.get(idx).getAttribute('innerText');
			String name = prodName.get(idx).getAttribute('innerText');
			println("sku: "+sku)
			for(int i = 0; i < cartItem.size(); i++) {
				println("compare2: "+cartItem[i][2])
				if(name.contains(cartItem[i][0]) && sku.contains(cartItem[i][2])) {
					flag = true
					break
				}
			}
		}

		assert flag : "Verify Added Product To MiniCart Refelected"
	}

	public static void verifyMiniCartAddedProductRefelectDetails() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Mini Cart/span_miniCartProductPrice'), 1)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Mini Cart/td_miniCartTableQuantityTableData'), 1)
		List<WebElement> prodSKU = WebUI.findWebElements(findTestObject('Object Repository/Mini Cart/span_productSKU'), 1)
		List<WebElement> prodName = WebUI.findWebElements(findTestObject('Object Repository/Mini Cart/a_productName'), 1)

		List cartItem = GlobalVariable.cartItems
		boolean flag = false


		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('innerText');
			String sku = prodSKU.get(idx).getAttribute('innerText').split("#")[1].trim();
			String name = prodName.get(idx).getAttribute('innerText');
			println("sku: "+sku)
			for(int i = 0; i < cartItem.size(); i++) {
				println("compare2: "+cartItem[i][2])
				if(name.contains(cartItem[i][0]) && sku.contains(cartItem[i][2])) {
					flag = true
					break
				}
			}
		}

		assert flag : "Verify Added Product To MiniCart Refelected"
	}

	public static void navigateToCartPage() {
		ShoppingCartValidations.verifyShoppingCartItemEqualMiniCartBadge()
		ShoppingCartValidations.verifyShoppingCartItemEqualToSummaryItem()
		ShoppingCartValidations.verifyTotalPriceForProductTable()
		ShoppingCartValidations.verifyTotalPriceInSummaryTable()
		QuickOrderHelpers.verifyAddedProductRefelectDetails()
	}

	public static void initCheckoutPage() {
		CheckoutPageValidation.verifyTotalPrice()
		CheckoutPageValidation.verifyCheckoutAsGuest()
		CheckoutPageValidation.verifyCheckoutAsGuestSelected()
		CheckoutPageValidation.verifyProductSummaryItemQountityTotal()
		QuickOrderHelpers.verifyAddedProductRefelectDetails()
	}
}

public class quickOrder{
	public String Quantity;
	public String Price;
	public String Total;
	public String Title;
	public String Img;
	public String StocksNotify;
	public String Sku;

	public quickOrder(String _Quantity,String _Price, String _Total, String _Title,String _Img ,String _StocksNotify,String _Sku) {
		Quantity = _Quantity;
		Price = _Price;
		Total = _Total;
		Title = _Title;
		Img = _Img;
		StocksNotify = _StocksNotify;
		Sku =_Sku;
	}
}