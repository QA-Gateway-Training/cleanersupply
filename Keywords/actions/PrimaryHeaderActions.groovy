package actions

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

public class PrimaryHeaderActions {
	
	/**
	 * Mouse over action on quick order link
	 * @author waleedafifi
	 */
	public static void quickOrderMouseMoveOver() {
		TestObject to = findTestObject('Object Repository/Primary Header/a_quickOrder')
		WebUI.mouseOver(to)
	}
	
	/**
	 * Mouse over action on reorder link
	 * @author waleedafifi
	 */
	public static void reOrderMouseMoveOver() {
		TestObject to = findTestObject('Object Repository/Primary Header/a_reOrder')
		WebUI.mouseOver(to)
	}
	
	/**
	 * Mouse over action on my account link
	 * @author waleedafifi
	 */
	public static void myAccountMouseMoveOver() {
		TestObject to = findTestObject('Object Repository/Primary Header/button_myAccount')
		WebUI.mouseOver(to)
	}
	
	/**
	 * Click action on my account link
	 * @author waleedafifi
	 */
	public static void myAccountMouseClick() {
		TestObject to = findTestObject('Object Repository/Primary Header/button_myAccount')
		WebUI.click(to)
	}
	
	/**
	 * Mouse over action on cart link
	 * @author waleedafifi
	 */
	public static void cartLinkMouseOver() {
		TestObject to = findTestObject('Object Repository/Primary Header/a_cart')
		WebUI.mouseOver(to)
	}
	
	/**
	 * Mouse over action on shipping details link
	 * @author waleedafifi
	 */
	public static void shippingDetailsMouseOver() {
		TestObject to = findTestObject('Primary Header/TobBar/a_headerShippingDetails')
		WebUI.mouseOver(to)
	}
	
	/**
	 * Mouse over action on customer service link
	 * @author waleedafifi
	 */
	public static void customerPhoneMouseOver() {
		TestObject to = findTestObject('Object Repository/Primary Header/TobBar/a_customerServiceLink')
		WebUI.mouseOver(to)
	}
}
