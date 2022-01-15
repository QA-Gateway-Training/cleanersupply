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

public class PrimaryHeaderValidations {
	
	/**
	 * Verify if the search field is exists
	 * @author waleedafifi
	 */
	public static void verifySearchFieldIsExists() {
		TestObject search = findTestObject('Object Repository/Primary Header/div_headerSearch')
		assert WebUI.verifyElementPresent(search, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if the logo appear
	 * @author waleedafifi
	 */
	public static void verifyLogoPresent() {
		TestObject img = findTestObject('Object Repository/Primary Header/img_logo')
		assert WebUI.verifyElementPresent(img, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if the header is exists
	 * @author waleedafifi
	 */
	public static void verifyHeaderExists() {
		TestObject header = findTestObject('Object Repository/Primary Header/header')
		assert WebUI.verifyElementPresent(header, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if the quick order is exists
	 * @author waleedafifi
	 */
	public static void verifyQiuckOrderLinkExists() {
		TestObject quick = findTestObject('Object Repository/Primary Header/a_quickOrder')
		assert WebUI.verifyElementPresent(quick, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if my account button is exists
	 * @author waleedafifi
	 */
	public static void verifyAccountLinkExists() {
		TestObject account = findTestObject('Object Repository/Primary Header/button_myAccount')
		assert WebUI.verifyElementPresent(account, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if cart link is exists
	 * @author waleedafifi
	 */
	public static void verifyCartLinkExists() {
		TestObject cart = findTestObject('Object Repository/Primary Header/a_cart')
		assert WebUI.verifyElementPresent(cart, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if top navigation is displayed 
	 * @author waleedafifi
	 */
	public static void verifyTopNavPresent() {
		TestObject topNav = findTestObject('Object Repository/Primary Header/div_navTop')
		assert WebUI.verifyElementPresent(topNav, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if top bar is displayed 
	 * @author waleedafifi
	 */
	public static void verifyTopBarVisability() {
		TestObject topBar = findTestObject('Primary Header/TobBar/div_topBarHeader')
		assert WebUI.verifyElementPresent(topBar, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify if top navigation default style
	 * @author waleedafifi
	 */
	public static void verifyTopNavStyle() {
		TestObject topNav = findTestObject('Object Repository/Primary Header/div_navTop')
		assert WebUI.getCSSValue(topNav, 'background-color').contains(GlobalVariable.topNavBackgroundColor)
	}
	
	/**
	 * Verify if top bar default style
	 * @author waleedafifi
	 */
	public static void verifyTopBarStyle() {
		TestObject topBar = findTestObject('Primary Header/TobBar/div_topBarHeader')
		assert WebUI.getCSSValue(topBar, 'background-color').contains(GlobalVariable.topBarBackgroundColor)
	}
	
	/**
	 * Verify if my account dropdown box displayed after clicking on my account button
	 * @author waleedafifi
	 */
	public static void verifyAccountDropDownDisplayed() {
		TestObject liAccount = findTestObject('Object Repository/Primary Header/li_myAccount')
		TestObject accountContainer = findTestObject('Object Repository/Primary Header/My Account/div.accountDropDown')
		
		assert WebUI.getAttribute(liAccount, 'class').contains('open')
		assert WebUI.verifyElementPresent(accountContainer, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify logo dimensions width
	 * @author waleedafifi
	 */
	public static void verifyLogoDimension() {
		TestObject logo = findTestObject('Object Repository/Primary Header/img_logo')
		String width =WebUI.getCSSValue(logo, 'width')
		assert width.equals('121px')
	}
	
	/**
	 * Verify hover effect on quick order link
	 * @author waleedafifi
	 */
	public static void verifyQuickOrderHoverEffect() {
		TestObject to = findTestObject('Object Repository/Primary Header/i_iconQuickOrder')
		assert WebUI.getCSSValue(to, 'color').equals(GlobalVariable.purpleColor)
	}
	
	/**
	 * Verify hover effect reorder link
	 * @author waleedafifi
	 */
	public static void verifyReOrderHoverEffect() {
		TestObject to = findTestObject('Object Repository/Primary Header/i_iconReOrder')
		assert WebUI.getCSSValue(to, 'color').equals(GlobalVariable.purpleColor)
	}
	
	/**
	 * Verify hover effect on my account link
	 * @author waleedafifi
	 */
	public static void verifyMyAccountHoverEffect() {
		TestObject to = findTestObject('Object Repository/Primary Header/i_iconMyAccount')
		assert WebUI.getCSSValue(to, 'color').equals(GlobalVariable.purpleColor)
	}
	
	/**
	 * Verify mini cart if has your cart is empty text when the cart is empty
	 * @author waleedafifi
	 */
	public static void verifyMiniCartIsEmpty() {
		TestObject to = findTestObject('Object Repository/Primary Header/span_emptCart')
		assert WebUI.getText(to).contains('YOUR CART IS EMPTY')
	}
	
	/**
	 * Verify default style for shipping info in the top bar
	 * @author waleedafifi
	 */
	public static void verifyShippingInfoStyle() {
		TestObject to = findTestObject('Primary Header/TobBar/span_headerShippingInfo')
		assert WebUI.getCSSValue(to, 'font-weight').contains('900')
		assert WebUI.getCSSValue(to, 'color').contains(GlobalVariable.blackColor)
		assert WebUI.getCSSValue(to, 'font-family').contains('"Nunito Sans", sans-serif')
	}
	
	/**
	 * Verify shipping information content
	 * @author waleedafifi
	 */
	public static void verifyShippingInfoContent() {
		TestObject to = findTestObject('Primary Header/TobBar/span_headerShippingInfo')
		assert WebUI.getText(to).contains('FREE SHIPPING & RETURNS ON ORDERS OVER $99')
	}
	
	/**
	 * Verify shipping details link default style
	 * @author waleedafifi
	 */
	public static void verifyShippingDetailsStyle() {
		TestObject to = findTestObject('Primary Header/TobBar/a_headerShippingDetails')
		assert WebUI.getCSSValue(to, 'font-weight').contains('400')
		assert WebUI.getCSSValue(to, 'color').contains(GlobalVariable.blackColor)
		assert WebUI.getCSSValue(to, 'font-family').contains('"Nunito Sans", sans-serif')
	}
	
	/**
	 * Verify shipping details link on hover
	 * @author waleedafifi
	 */
	public static void verifyShippingDetailsLinkOnHover() {
		TestObject to = findTestObject('Primary Header/TobBar/a_headerShippingDetails')
		assert WebUI.getCSSValue(to, 'text-decoration').contains('underline')
	}
	
	/**
	 * Verify shipping information aligned to center
	 * @author waleedafifi
	 */
	public static void verifyInfoHolderTextAlignment() {
		TestObject to = findTestObject('Primary Header/TobBar/div_infoHolder')
		assert WebUI.getCSSValue(to, 'text-align').contains('center')
	}
	
	/**
	 * Verify top bar customer service visibility
	 * @author waleedafifi
	 */
	public static void verifyTopBarCustomerServicesVisibility() {
		TestObject to = findTestObject('Object Repository/Primary Header/TobBar/div_customerServicesArea')
		assert WebUI.verifyElementPresent(to, GlobalVariable.globalTimeOut)
	}
	
	/**
	 * Verify default style for the customer service link
	 * @author waleedafifi
	 */
	public static void verifyCustomerServiceLinkStyle() {
		TestObject to = findTestObject('Object Repository/Primary Header/TobBar/a_customerServiceLink')
		assert WebUI.getCSSValue(to, 'font-weight').contains('700')
		assert WebUI.getCSSValue(to, 'color').contains(GlobalVariable.blackColor)
		assert WebUI.getCSSValue(to, 'font-family').contains('"Nunito Sans", sans-serif')
	}
	
	/**
	 * Verify customer service phone default style
	 * @author waleedafifi
	 */
	public static void verifyCustomerServicePhoneStyle() {
		TestObject to = findTestObject('Object Repository/Primary Header/TobBar/span_customerAreaPhone')
		assert WebUI.getCSSValue(to, 'font-weight').contains('700')
		assert WebUI.getCSSValue(to, 'color').contains(GlobalVariable.blackColor)
		assert WebUI.getCSSValue(to, 'font-family').contains('"Nunito Sans", sans-serif')
	}
	
	/**
	 * Verify hover effect on customer service link
	 * @author waleedafifi
	 */
	public static void verifyCustomerServiceLinkHoverStyle() {
		TestObject to = findTestObject('Object Repository/Primary Header/TobBar/a_customerServiceLink')
		assert WebUI.getCSSValue(to, 'text-decoration').contains('underline')
	}
}
