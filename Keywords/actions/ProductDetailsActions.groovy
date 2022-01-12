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

public class ProductDetailsActions {
	public static void hoverOverSizeLink(TestObject obj) {
	}

	/**
	 * Hover on the x-large size link
	 * @author waleedafifi
	 */
	public static void hoverOverXLargeSizeLink() {
		TestObject obj = findTestObject('Object Repository/Product details/a_xLargeLink')
		WebUI.mouseOver(obj)
	}

	/**
	 * Hover on the large size link
	 * @author waleedafifi
	 */
	public static void hoverOverLargeSizeLink() {
		TestObject obj = findTestObject('Object Repository/Product details/a_largeLink')
		WebUI.mouseOver(obj)
	}

	/**
	 * Click on x-large link
	 * @author waleedafifi 
	 */
	public static void xLargeSizeLinkClickAction() {
		TestObject obj = findTestObject('Object Repository/Product details/a_xLargeLink')
		WebUI.click(obj)
	}

	/**
	 * Click on large link
	 * @author waleedafifi
	 */
	public static void largeSizeLinkClickAction() {
		TestObject obj = findTestObject('Object Repository/Product details/a_largeLink')
		WebUI.click(obj)
	}
	
	public static void addToCartOnHover() {
		TestObject container = findTestObject('Object Repository/Product details/div_addToCartContainer')
		WebUI.mouseOver(container)

	}
}
