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

import helpers.GeneralHelpers
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

		assert WebUI.getText(titleTotal).replace('$', '').replace(',', '').contains(GlobalVariable.totalPrice)
		assert WebUI.getText(subTotal).replace('$', '').replace(',', '').contains(GlobalVariable.totalPrice)
		assert WebUI.getText(total).replace('$', '').replace(',', '').contains(GlobalVariable.totalPrice)
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

	public static void verifyNavigationToCheckoutDetails() {
		TestObject checkoutDetailsHeader = findTestObject("Object Repository/CheckOut Details/h1_checkoutHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.checkoutDetailsPageTitle, checkoutDetailsHeader,
				"CHECKOUT", GlobalVariable.checkoutDetailsUrl)
	}

	public static void verifyVisibilityAndHeaderShipping() {
		TestObject shippingAddrDivHeader = findTestObject("Object Repository/CheckOut Details/h2_shippingAddrDivHeader")
		WebUI.verifyElementVisible(shippingAddrDivHeader)
		assert WebUI.getText(shippingAddrDivHeader).equals("SHIPPING ADDRESS")
	}

	public static void verifyShippingDetails(TestObject address) {
		String[] allAddress =  WebUI.getText(address).split("\n")
		assert allAddress[0].equals(GlobalVariable.companyValue)
		assert allAddress[1].equals(GlobalVariable.fNameValue+" "+ GlobalVariable.lNameValue)
		assert allAddress[2].equals(GlobalVariable.address1)
		assert allAddress[3].equals(GlobalVariable.address2)
		assert allAddress[4].equals(GlobalVariable.city + ", "+GlobalVariable.stateAbbr +" "+ GlobalVariable.zipCode)
		assert allAddress[5].equals(GlobalVariable.phone + " x" + GlobalVariable.phoneExt)
		assert allAddress[6].equals(GlobalVariable.USDcountry)
	}

	public static void verifyPaymentMethodDetails(TestObject paymentDetails) {
		String[] allpaymentDetails =  WebUI.getText(paymentDetails).split("\n")
		assert allpaymentDetails[0].equals(GlobalVariable.cardType +" **** "+GlobalVariable.CreditCardNumber.toString().substring(11))
		assert allpaymentDetails[1].equals(GlobalVariable.creditCardNAme)
		assert allpaymentDetails[2].equals("Expires: "+ GlobalVariable.monthValue.toString().split(" ")[0].replace('0', '') + "/" +GlobalVariable.yearValue.toString().substring(2))
	}

	public static void verifyDeliveryInputChecked() {
		TestObject standardDelivery = findTestObject("Object Repository/CheckOut Details/span_standard_Delivery")
		assert WebUI.getCSSValue(standardDelivery, "border-color").equals("rgb(82, 36, 127)")
	}

	public static void verifyNaigationTOCheckOut() {
		TestObject checkoutHeader = findTestObject("CheckOut/div_checkoutHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.checkoutPageTitle, checkoutHeader,
				GlobalVariable.checkoutHeader, GlobalVariable.checkoutUrl)
	}

	/**
	 * Verify added product reflected to the cart items
	 * @author waleedafifi
	 */
	public static void verifyAddedProductRefelectDetails() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/div_productPrice'), GlobalVariable.globalTimeOut)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/input_productQuantity'), GlobalVariable.globalTimeOut)
		List<WebElement> prodSKU = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/span_skuNumber'), GlobalVariable.globalTimeOut)
		List<WebElement> prodName = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/a_tableProductNameTitle'), GlobalVariable.globalTimeOut)
		List<WebElement> totalPrice = WebUI.findWebElements(findTestObject('Object Repository/CheckOut/Cart/div_priceTotal'), GlobalVariable.globalTimeOut)

		List cartItem = GlobalVariable.cartItems
		boolean flag = false

		println cartItem

		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('value');
			String sku = prodSKU.get(idx).getAttribute('innerText');
			String name = prodName.get(idx).getAttribute('innerText');

			for(int i = 0; i < cartItem.size(); i++) {
//				&& sku.contains(cartItem[i][2])
				if(name.contains(cartItem[i][0]) && qt.equals(cartItem[i][3])) {
					flag = true
					break
				}
			}
		}

		assert flag : "Verify summary Refelected to added cart"
	}
}
