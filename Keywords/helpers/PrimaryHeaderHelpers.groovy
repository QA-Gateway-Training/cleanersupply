package helpers

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

import actions.MiniCartActions
import actions.PrimaryHeaderActions
import actions.defaultFooterActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.MiniCartValidations
import validation.PrimaryHeaderValidations

public class PrimaryHeaderHelpers {

	/**
	 * Top navigation init style
	 * @author waleedafifi
	 */
	public static void topNav() {
		PrimaryHeaderValidations.verifyTopNavStyle()
		PrimaryHeaderValidations.verifyTopNavPresent()
		PrimaryHeaderValidations.verifySearchFieldIsExists()
		PrimaryHeaderValidations.verifyQiuckOrderLinkExists()
		PrimaryHeaderValidations.verifyLogoPresent()
		PrimaryHeaderValidations.verifyLogoDimension()
		PrimaryHeaderValidations.verifyHeaderExists()
		PrimaryHeaderValidations.verifyCartLinkExists()
		PrimaryHeaderValidations.verifyAccountLinkExists()
	}

	/**
	 * Mouse move over my account, quick order, reorder
	 * @author waleedafifi
	 */
	public static void rightLinkehoverEffect() {
		PrimaryHeaderActions.myAccountMouseMoveOver()
		PrimaryHeaderValidations.verifyMyAccountHoverEffect()

		PrimaryHeaderActions.quickOrderMouseMoveOver()
		PrimaryHeaderValidations.verifyQuickOrderHoverEffect()

		PrimaryHeaderActions.reOrderMouseMoveOver()
		PrimaryHeaderValidations.verifyReOrderHoverEffect()
	}

	/**
	 * Mouse move over the cart link
	 * @author waleedafifi
	 */
	public static void cartLinkHover() {
		PrimaryHeaderActions.cartLinkMouseOver()
		MiniCartValidations.verifyHoverStyleOnMiniCartLink()
		MiniCartValidations.verifyMiniCartDropDownIsDisplayed()
		PrimaryHeaderValidations.verifyMiniCartIsEmpty()
		PrimaryHeaderValidations.verifyMiniCartIsEmptyImage()
	}

	/**
	 * Account button action to open the dropdown card
	 * @author waleedafifi
	 */
	public static void myAccountButton() {
		PrimaryHeaderActions.myAccountMouseClick()
		PrimaryHeaderValidations.verifyAccountDropDownDisplayed()
	}

	/**
	 * ToopBar init style and visibility
	 * @author waleedafifi
	 */
	public static void headerTopBar() {
		PrimaryHeaderValidations.verifyTopBarVisability()
		PrimaryHeaderValidations.verifyTopBarStyle()
		PrimaryHeaderValidations.verifyInfoHolderTextAlignment()
		PrimaryHeaderValidations.verifyShippingInfoContent()
		PrimaryHeaderValidations.verifyShippingInfoStyle()
		PrimaryHeaderValidations.verifyShippingDetailsStyle()
	}

	/**
	 * Mouse move over the shipping details
	 * @author waleedafifi
	 */
	public static void shippingDetailsAction() {
		PrimaryHeaderActions.shippingDetailsMouseOver()
		PrimaryHeaderValidations.verifyShippingDetailsLinkOnHover()
	}

	/**
	 * Customer service visibility and init style
	 * @author waleedafifi
	 */
	public static void customerService() {
		PrimaryHeaderValidations.verifyTopBarCustomerServicesVisibility()
		PrimaryHeaderValidations.verifyCustomerServicePhoneStyle()
		PrimaryHeaderValidations.verifyCustomerServiceLinkStyle()
	}

	/**
	 * Mouse move over the customer service link
	 * @author waleedafifi
	 */
	public static void customerServiceLinkAction() {
		PrimaryHeaderActions.customerPhoneMouseOver()
		PrimaryHeaderValidations.verifyCustomerServiceLinkHoverStyle()
	}

	/**
	 * Navigate to home page after clicking on ligi
	 * @author waleedafifi
	 */
	public static void NavigateToHomePageUsingLogo() {
		PrimaryHeaderActions.logoClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.homePageTitle)
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.baseUrl)
	}

	/**
	 * Navigate to shipping details after click on details link
	 * @author waleedafifi
	 */
	public static void navigateToShippingDetailsPage() {
		PrimaryHeaderActions.detailsLinkClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Fast, Free Shipping')
		GeneralValidation.verifyCurrentPageURL('https://www.cleanersupply.com/fast-free-shipping/')
	}

	/**
	 * Navigate to customer service after click on details link
	 * @author waleedafifi
	 */
	public static void navigateToCustomerServicePage() {
		PrimaryHeaderActions.customerSeriveLinkClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Customer Service')
		GeneralValidation.verifyCurrentPageURL('customer-service')
	}

	/**
	 * Navigate to Qiuck order page after click on details link
	 * @author waleedafifi
	 */
	public static void navigateToQuickOrder() {
		defaultFooterActions.clickQuickOrder()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Quick Order')
		GeneralValidation.verifyCurrentPageURL('quick-order')
	}

	/**
	 * Navigate to ReORder page after click on details link
	 * @author waleedafifi
	 */
	public static void navigateToReOrderPage() {
		defaultFooterActions.clickpreviouslyOrdered()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Log In')
		GeneralValidation.verifyCurrentPageURL('previously-ordered')
	}

	/**
	 * Navigate to Shopping cart page after click on details link
	 * @author waleedafifi
	 */
	public static void navigateToCartPage() {
		MiniCartActions.navigateToCartPage()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Shopping Cart')
		GeneralValidation.verifyCurrentPageURL('shopping-cart')
	}
}
