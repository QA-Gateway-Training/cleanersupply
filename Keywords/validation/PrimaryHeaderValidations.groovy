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
	public static void verifySearchFieldIsExists() {
		TestObject search = findTestObject('Object Repository/Primary Header/div_headerSearch')
		assert WebUI.verifyElementPresent(search, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyLogoPresent() {
		TestObject img = findTestObject('Object Repository/Primary Header/img_logo')
		assert WebUI.verifyElementPresent(img, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyHeaderExists() {
		TestObject header = findTestObject('Object Repository/Primary Header/header')
		assert WebUI.verifyElementPresent(header, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyQiuckOrderLinkExists() {
		TestObject quick = findTestObject('Object Repository/Primary Header/a_quickOrder')
		assert WebUI.verifyElementPresent(quick, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyAccountLinkExists() {
		TestObject account = findTestObject('Object Repository/Primary Header/button_myAccount')
		assert WebUI.verifyElementPresent(account, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyCartLinkExists() {
		TestObject cart = findTestObject('Object Repository/Primary Header/a_cart')
		assert WebUI.verifyElementPresent(cart, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyTopNavPresent() {
		TestObject topNav = findTestObject('Object Repository/Primary Header/div_navTop')
		assert WebUI.verifyElementPresent(topNav, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyTopBarHeaderPresent() {
		TestObject topBar = findTestObject('Object Repository/Primary Header/div_topBarHeader')
		assert WebUI.verifyElementPresent(topBar, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyTopNavStyle() {
		TestObject topNav = findTestObject('Object Repository/Primary Header/div_navTop')
		assert WebUI.getCSSValue(topNav, 'background-color').equals('rgba(255, 200, 11, 1)')
	}
	
	public static void verifyTopBarStyle() {
		TestObject topBar = findTestObject('Object Repository/Primary Header/div_topBarHeader')
		assert WebUI.getCSSValue(topBar, 'background-color').equals('rgba(243, 243, 244, 1)')
	}
	
	public static void verifyAccountDropDownDisplayed() {
		TestObject liAccount = findTestObject('Object Repository/Primary Header/li_myAccount')
		TestObject accountContainer = findTestObject('Object Repository/Primary Header/My Account/div.accountDropDown')
		
		assert WebUI.getAttribute(liAccount, 'class').contains('open')
		assert WebUI.verifyElementPresent(accountContainer, GlobalVariable.globalTimeOut)
	}
	
	public static void verifyLogoDimension() {
		TestObject logo = findTestObject('Object Repository/Primary Header/img_logo')
		String width =WebUI.getCSSValue(logo, 'width')
		assert width.equals('121px')
	}
	
	public static void verifyQuickOrderHoverEffect() {
		TestObject to = findTestObject('Object Repository/Primary Header/i_iconQuickOrder')
		assert WebUI.getCSSValue(to, 'color').equals(GlobalVariable.purpleColor)
	}
	
	public static void verifyReOrderHoverEffect() {
		TestObject to = findTestObject('Object Repository/Primary Header/i_iconReOrder')
		assert WebUI.getCSSValue(to, 'color').equals(GlobalVariable.purpleColor)
	}
	
	public static void verifyMyAccountHoverEffect() {
		TestObject to = findTestObject('Object Repository/Primary Header/i_iconMyAccount')
		assert WebUI.getCSSValue(to, 'color').equals(GlobalVariable.purpleColor)
	}
	
}
