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

import actions.ProductDetailsActions
import internal.GlobalVariable
import validation.ProductDetailsValidation

public class ProductDetailsHelpers {
	
	public static void initProductDetailsPage() {
		ProductDetailsValidation.verifyActiveProductSize('//a[@title=\'X-Small - 15" x 18" x 3"\']')
		ProductDetailsValidation.verifyProductAvailability(false)
		ProductDetailsValidation.verifySKUNotEmpty()
		ProductDetailsValidation.verifyProductDetailsName()
		
		TestObject obj = findTestObject('Object Repository/Product details/a_blackColor')
		ProductDetailsValidation.verifyProductColorSelect(obj)
		ProductDetailsValidation.verifyFavoriteIconVisibility(false)
		ProductDetailsValidation.verifyAddToCartButtonVisibility(false)
		
	}
	
	/**
	 * Verify hover effect on x-large, then click on it and check the active style
	 * @author waleedafifi
	 */
	public static void verifyHoverEffectAndClickXLargeSizeLink() {
		ProductDetailsActions.hoverOverXLargeSizeLink()
		ProductDetailsValidation.verifyOnHoverStyle()

		ProductDetailsActions.xLargeSizeLinkClickAction()
		ProductDetailsValidation.verifyActiveProductSize('//a[@title=\'X-Large - 26" x 29" x 10"\']')
		ProductDetailsValidation.verifyProductAvailability()
		
		ProductDetailsValidation.verifyFavoriteIconVisibility()
		ProductDetailsValidation.verifyAddToCartButtonVisibility()
		
		ProductDetailsValidation.verifyAddCartStyle()
		ProductDetailsActions.addToCartOnHover()
		ProductDetailsValidation.verifyAddToCartOnHover()

	}
}
