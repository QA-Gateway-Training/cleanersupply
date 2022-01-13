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
		
		assert WebUI.getText(summaryTotal).contains(cartTotalPrice)
		assert WebUI.getText(subTotal).contains(cartTotalPrice)
	}
}
