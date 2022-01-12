package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

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

	/**
	 * Hover on add to cart
	 * @author waleedafifi
	 */
	public static void addToCartOnHover() {
		TestObject container = findTestObject('Object Repository/Product details/div_addToCartContainer')
		WebUI.mouseOver(container)
	}

	/**
	 * Add the product to cart
	 * @author waleedafifi
	 */
	public static void addToCartAction() {
		TestObject btn = findTestObject('Object Repository/Product details/button_addToCart')
		WebUI.click(btn)
	}

	/**
	 * Fill product quantity with passed params
	 * @param txt
	 */
	public static void fillQuantityInput(int txt) {
		TestObject ipt = findTestObject('Object Repository/Product details/input_productQuantity')
		WebUI.sendKeys(ipt, Keys.chord(Keys.BACK_SPACE) + txt)
	}
	
	public static void selectGreenColor() {
		TestObject color = findTestObject('Object Repository/Product details/a_greenColor')
		WebUI.click(color)
	}
}
