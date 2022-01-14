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

public class CheckoutPageValidation {
	/**
	 * Verify total prices on page load
	 * @author waleedafifi
	 */
	public static void verifyTotalPrice() {
		TestObject titleTotal = findTestObject('Object Repository/CheckOut/span_checkoutTitleTotal')
		TestObject subTotal = findTestObject('Object Repository/CheckOut/td_summaryTableTotal')
		TestObject total = findTestObject('Object Repository/CheckOut/td_summaryTotalSubTotal')
		
		assert WebUI.getText(titleTotal).contains(GlobalVariable.totalPrice)
		assert WebUI.getText(subTotal).contains(GlobalVariable.totalPrice)
		assert WebUI.getText(total).contains(GlobalVariable.totalPrice)
	}
	
	/**
	 * Verify checkout as a guest label content
	 * @author waleedafifi
	 */
	public static void verifyCheckoutAsGuest() {
		TestObject lbl = findTestObject('Object Repository/CheckOut/label_checkoutAsGuest')
		assert WebUI.getText(lbl).contains('Checkout as Guest')
	}
	
	/**
	 * Verify checkout as a guest is selected
	 * @author waleedafifi 
	 */
	public static void verifyCheckoutAsGuestSelected() {
		TestObject radio = findTestObject('Object Repository/CheckOut/input_checkoutAsGuestRadioButton')
		assert WebUI.verifyElementChecked(radio, GlobalVariable.globalTimeOut)
//		assert WebUI.getAttribute(radio, 'checked').equals('checked')
	}
	
	/**
	 * Verify product summary table to have the multiply ( quantity, price )
	 * @author waleedafifi
	 */
	public static void verifyProductSummaryItemQountityTotal() {
		List<WebElement> productPrice = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/td_shoppingCartProductPrice'), GlobalVariable.globalTimeOut)
		List<WebElement> productQuantity = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/input_shoppingCartProductQuantity'), GlobalVariable.globalTimeOut)
		List<WebElement> productTotal = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/td_shoppingCartProductTotal'), GlobalVariable.globalTimeOut)

		for(int idx = 0; idx < productPrice.size(); idx++) {
			String prc = productPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = productQuantity.get(idx).getAttribute('value');
			String total = productTotal.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");

//			cartTotalPrice += Float.parseFloat(total)

			assert total.equals(String.format("%.2f", (Float.parseFloat(prc) * Integer.parseInt(qt))))
		}
	}
	
}
