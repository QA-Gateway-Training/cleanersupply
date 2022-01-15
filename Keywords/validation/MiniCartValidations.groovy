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

import actions.QuickOrderActions
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import java.text.DecimalFormat

public class MiniCartValidations {

	/**
	 * Verify hover effect style on mini cart link
	 * @author waleedafifi
	 */
	public static void verifyHoverStyleOnMiniCartLink() {
		TestObject miniCart = findTestObject('Mini Cart/a_miniCartLink')
		assert WebUI.getCSSValue(miniCart, 'background-color').equals(GlobalVariable.whiteColor)

		TestObject cartIcon = findTestObject('Mini Cart/i_cartIcon')
		assert WebUI.getCSSValue(miniCart, 'color').equals(GlobalVariable.purpleColor)
	}

	/**
	 * Verify miniCart total price
	 * @author waleedafifi
	 */
	public static void verifyMiniCartTotals() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Mini Cart/span_miniCartProductPrice'), 1)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Mini Cart/td_miniCartTableQuantityTableData'), 1)
		List<WebElement> prodTotal = WebUI.findWebElements(findTestObject('Mini Cart/td_miniCartTotalPrice'), 1)

		Float totalOfTotal = 0

		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String total = prodTotal.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");

			totalOfTotal += Float.parseFloat(total)

			assert total.contains(String.format("%.2f", (Float.parseFloat(prc) * Integer.parseInt(qt))))
		}

		TestObject miniCartTotal = findTestObject('Mini Cart/span_miniCartSubTotal')
		assert WebUI.getText(miniCartTotal).replace('$', '').replace(',', '').contains(String.format("%.2f", totalOfTotal))
	}

	/**
	 * Verify added product reflect to mini cart items
	 * @author waleedafifi 
	 */
	public static void verifyAddedProductRefelectDetails() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Mini Cart/span_miniCartProductPrice'), 1)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Mini Cart/td_miniCartTableQuantityTableData'), 1)
		List<WebElement> prodSKU = WebUI.findWebElements(findTestObject('Object Repository/Mini Cart/span_productSKU'), 1)
		List<WebElement> prodName = WebUI.findWebElements(findTestObject('Object Repository/Mini Cart/a_productName'), 1)

		List cartItem = GlobalVariable.cartItems
		boolean flag = false

		println cartItem

		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('innerText');
			String sku = prodSKU.get(idx).getAttribute('innerText');
			String name = prodName.get(idx).getAttribute('innerText');

			for(int i = 0; i < cartItem.size(); i++) {
				if(name.contains(cartItem[i][0]) && sku.contains(cartItem[i][2])) {
					flag = true
					break
				}
			}
		}

		assert flag : "Verify Added Product To MiniCart Refelected"
	}

	/**
	 * Verify mini cart items count
	 * @author waleedafifi
	 */
	public static void miniCartItemCount() {
		List<WebElement> productRow = WebUI.findWebElements(findTestObject('Mini Cart/tr_miniCartTableRow'), 1)
		TestObject counterBadge = findTestObject('Mini Cart/span_cartCounterPadge')

		assert WebUI.getText(counterBadge).contains(productRow.size().toString())
	}
	
	/**
	 * Verify if the mini cart dropdown displayed
	 * @author waleedafifi
	 */
	public static void verifyMiniCartDropDownIsDisplayed() {
		TestObject to = findTestObject('Object Repository/Mini Cart/div_miniCartDropDown')
		assert WebUI.verifyElementPresent(to, GlobalVariable.globalTimeOut)
	}
}
