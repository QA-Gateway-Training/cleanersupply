package validation

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

import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class ShoppingCartValidations {

	public static Float cartTotalPrice = 0

	/**
	 * Verify shopping cart is empty if no product add to the cart
	 * @author waleedafifi
	 */
	public static void verifyShoppingCartIsEmpty() {
		TestObject table = findTestObject('Object Repository/Shopping Cart/table_productTable')
		assert WebUI.verifyElementNotPresent(table, GlobalVariable.globalTimeOut)
	}

	/**
	 * Verify if the number of items in the table are equals to the miniCart badge number
	 * @author waleedafifi
	 */
	public static void verifyShoppingCartItemEqualMiniCartBadge() {
		List<WebElement> itemCount = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/tr_shoppingCartProductRow'), GlobalVariable.globalTimeOut)
		TestObject badgeCount = findTestObject('Object Repository/Mini Cart/span_cartCounterPadge')
		assert Integer.parseInt(WebUI.getText(badgeCount)) == itemCount.size()
	}

	/**
	 * Verify if the item number are equals to the summary item count
	 * @author waleedafifi
	 */
	public static void verifyShoppingCartItemEqualToSummaryItem() {
		List<WebElement> itemCount = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/tr_shoppingCartProductRow'), GlobalVariable.globalTimeOut)
		TestObject summaryCount = findTestObject('Object Repository/Shopping Cart/td_summaryTableItemCount')
		assert Integer.parseInt(WebUI.getText(summaryCount).replaceAll("[^0-9\\.]","")) == itemCount.size()
	}

	/**
	 * Verify product total price and add the total of total to a global variable to been used in the summary totals
	 * @author waleedafifi
	 */
	public static void verifyTotalPriceForProductTable() {
		List<WebElement> productPrice = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/td_shoppingCartProductPrice'), GlobalVariable.globalTimeOut)
		List<WebElement> productQuantity = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/input_shoppingCartProductQuantity'), GlobalVariable.globalTimeOut)
		List<WebElement> productTotal = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/td_shoppingCartProductTotal'), GlobalVariable.globalTimeOut)

		for(int idx = 0; idx < productPrice.size(); idx++) {
			String prc = productPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = productQuantity.get(idx).getAttribute('value');
			String total = productTotal.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");

			cartTotalPrice += Float.parseFloat(total)

			assert total.equals(String.format("%.2f", (Float.parseFloat(prc) * Integer.parseInt(qt))))
		}
	}

	/**
	 * Verify total prices n the summary table if it's equal to product sub total
	 */
	public static void verifyTotalPriceInSummaryTable() {
		TestObject summaryTotal = findTestObject('Object Repository/Shopping Cart/td_summaryTableTotal')
		TestObject subTotal = findTestObject('Object Repository/Shopping Cart/td_summaryTotalSubTotal')

		String roundedTotal = String.format("%.2f", cartTotalPrice)
		GlobalVariable.totalPrice = roundedTotal

		cartTotalPrice = 0

		assert WebUI.getText(summaryTotal).replace('$', '').replace(',', '').contains(roundedTotal)
		assert WebUI.getText(subTotal).replace('$', '').replace(',', '').contains(roundedTotal)
	}

	/**
	 * Verify checkout button stye to have the default style
	 * @author waleedafifi
	 */
	public static void verifyCheckoutButtonStyle() {
		TestObject btn = findTestObject('Object Repository/Shopping Cart/button_proceedToCheckout')
		WebUI.mouseOver(findTestObject('Object Repository/Shopping Cart/a_shoppingCartProductTitle'))
		assert WebUI.getCSSValue(btn, 'background-color').contains(GlobalVariable.purpleColor)
		assert WebUI.getCSSValue(btn, 'color').contains(GlobalVariable.whiteColor)
	}

	/**
	 * Verify checkout button on hover effect
	 * @author waleedafifi
	 */
	public static void verifyCheckoutButtonOnHover() {
		TestObject btn = findTestObject('Object Repository/Shopping Cart/button_proceedToCheckout')
		assert WebUI.getCSSValue(btn, 'box-shadow').equals(GlobalVariable.btnHoverBoxShadow)
	}

	/**
	 * Verify added product reflected to the cart items
	 * @author waleedafifi
	 */
	public static void verifyAddedProductRefelectDetails() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/td_shoppingCartProductPrice'), 1)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/input_shoppingCartProductQuantity'), 1)
		List<WebElement> prodSKU = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/span_shoppingCartSkuNumber'), 1)
		List<WebElement> prodName = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/a_shoppingCartProductTitle'), 1)

		List cartItem = GlobalVariable.cartItems
		boolean flag = false

		println cartItem

		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('value');
			String sku = prodSKU.get(idx).getAttribute('innerText');
			String name = prodName.get(idx).getAttribute('innerText');

			for(int i = 0; i < cartItem.size(); i++) {
				if(name.contains(cartItem[i][0]) && sku.contains(cartItem[i][2]) && qt.equals(cartItem[i][3])) {
					flag = true
					break
				}
			}
		}

		assert flag : "Verify Added Product To Shopping Cart Refelected"
	}

	/**
	 * Verify if the the value of quantity of items equal to passed params
	 * @param qyt
	 * @author waleedafifi
	 */
	public static void verifyQuantityValue(int qyt) {
		List<WebElement> quantityInput = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/input_shoppingCartProductQuantity'), GlobalVariable.globalTimeOut)
		for (WebElement ipt : quantityInput) {
			TestObject to = WebUI.convertWebElementToTestObject(ipt)
			assert WebUI.getAttribute(to, 'value').equals(qyt.toString())
		}
	}
}
