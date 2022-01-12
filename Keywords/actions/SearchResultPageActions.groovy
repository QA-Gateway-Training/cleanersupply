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

import helpers.GeneralHelperFunctions
import internal.GlobalVariable

public class SearchResultPageActions {
	/**
	 * Expand filter card based on it's id
	 * @param selector
	 * @author waleedafifi
	 */
	public static void expandFilterCard(String selector) {
		TestObject titleObj = GeneralHelperFunctions.makeTO('//div[@href="#'+selector+'"]')
		WebUI.click(titleObj)
	}

	public static void selectPackagingProduct() {
		TestObject productObject = findTestObject('Object Repository/Filter/a_packagingProduct')
		WebUI.click(productObject)
	}

	public static void selectPlasticBags() {
		TestObject productObject = findTestObject('Object Repository/Filter/a_plasticBags')
		WebUI.click(productObject)
	}
	
	public static void selectColorFilter() {
		TestObject colorObject = findTestObject('Object Repository/Filter/a_greenColor')
		WebUI.click(colorObject)
	}
}
