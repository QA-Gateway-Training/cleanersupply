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
import actions.SearchResultPageActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.ProductDetailsValidation

public class ProductDetailsHelpers {

	/**
	 * Initial product details page on page load 
	 * @author waleedafifi
	 */
	public static void initProductDetailsPage() {
		GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.productItems[1])
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.productItems[0])

		ProductDetailsValidation.verifyProductDetailsPageBreadCrumb()
		ProductDetailsValidation.verifyActiveProductSize('//a[@title=\'X-Small - 15" x 18" x 3"\']')
		ProductDetailsValidation.verifyProductAvailability(false)
		ProductDetailsValidation.verifySKUNotEmpty()
		ProductDetailsValidation.verifyProductDetailsName()

		ProductDetailsValidation.verifyProductPrice()
		ProductDetailsValidation.verifyAvailableColorCounter()

		TestObject obj = findTestObject('Object Repository/Product details/a_blackColor')
		ProductDetailsValidation.verifyProductColorSelect(obj)
		ProductDetailsValidation.verifyFavoriteIconVisibility(false)
		ProductDetailsValidation.verifyAddToCartButtonVisibility(false)
	}

	/**
	 * Verify hover effect on x-large, then click on it and check the active style
	 * @author waleedafifi
	 */
	public static void hoverEffectAndClickXLargeSizeLink() {
		ProductDetailsActions.hoverOverXLargeSizeLink()
		ProductDetailsValidation.verifyOnHoverStyle()
		ProductDetailsActions.xLargeSizeLinkClickAction()

		ProductDetailsValidation.verifyProductDetailsName('X-LARGE')

		ProductDetailsValidation.verifyActiveProductSize('//a[@title=\'X-Large - 26" x 29" x 10"\']')
		ProductDetailsValidation.verifyProductAvailability()
		GeneralValidation.verifyCurrentPageURL(SearchResultPageActions.skuNumber())

		ProductDetailsValidation.verifyProductSpecSize('26" L x 29" H x 10" W')

		fillProductQuantity(5)

		String prodPrice = ProductDetailsActions.returnProductPrice()
		ProductDetailsValidation.verifyVolumeTable(5, prodPrice)

		ProductDetailsValidation.verifyFavoriteIconVisibility()
		ProductDetailsValidation.verifyAddToCartButtonVisibility()

		ProductDetailsValidation.verifyAddCartStyle()
	}

	/**
	 * Verify hover effect on large, then click on it and check the active style
	 * @author waleedafifi
	 */
	public static void hoverEffectAndClickLargeSizeLink() {
		WebUI.mouseOver(findTestObject('Product details/h2_descHeader'))
		println("Done")
		ProductDetailsActions.hoverOverLargeSizeLink()
		//		ProductDetailsValidation.verifyOnHoverStyle()

		ProductDetailsActions.largeSizeLinkClickAction()
		ProductDetailsValidation.verifyActiveProductSize('//a[@title=\'Large - 24" x 27" x 8"\']')
		//		ProductDetailsValidation.verifyProductAvailability()
		ProductDetailsValidation.verifyProductDetailsName('LARGE')
		GeneralValidation.verifyCurrentPageURL(SearchResultPageActions.skuNumber())

		ProductDetailsValidation.verifyProductSpecSize('24" L x 27" H x 8" W')

		fillProductQuantity(4)

		String prodPrice = ProductDetailsActions.returnProductPrice()
		ProductDetailsValidation.verifyVolumeTable(4, prodPrice)
		ProductDetailsValidation.verifyFavoriteIconVisibility()
		ProductDetailsValidation.verifyAddToCartButtonVisibility()

		ProductDetailsValidation.verifyAddCartStyle()
	}

	/**
	 * Select product green color
	 * @author waleedafifi
	 */
	public static void selectGreenColor() {
		ProductDetailsActions.selectGreenColor()
		TestObject obj = findTestObject('Object Repository/Product details/a_greenColor')
		ProductDetailsValidation.verifyProductColorSelect(obj, 'Green')
		ProductDetailsValidation.verifyProductDetailsName('GREEN')
		GeneralValidation.verifyCurrentPageURL(SearchResultPageActions.skuNumber())
	}

	/**
	 * Select product royal blue color
	 * @author waleedafifi
	 */
	public static void selectRoyalBlueColor() {
		ProductDetailsActions.selectRoyalBlueColor()
		TestObject obj = findTestObject('Object Repository/Product details/a_royalBlueColor')
		ProductDetailsValidation.verifyProductColorSelect(obj, 'ROYAL BLUE')
		ProductDetailsValidation.verifyProductDetailsName('ROYAL BLUE')
		GeneralValidation.verifyCurrentPageURL(SearchResultPageActions.skuNumber())
	}

	/**
	 * Fill product quantity
	 * @author waleedafifi
	 */
	public static void fillProductQuantity(int qyt) {
		ProductDetailsActions.fillQuantityInput(qyt)
		ProductDetailsValidation.verifyProductQuantityField(qyt)
	}

	/**
	 * Click add to cart button
	 * @author waleedafifi
	 */
	public static void addProductToCart() {
		ProductDetailsActions.addToCartOnHover()
		ProductDetailsValidation.verifyAddToCartOnHover()
		ProductDetailsActions.addToCartAction()

		//		ProductDetailsValidation.VerifyInnerTEXTLoadingAfterAddToCart()
		//		ProductDetailsValidation.VerifyInnerTEXTAddedAfterAddToCart()
		//		ProductDetailsValidation.verifyProductQuantityField(1)
		// add disabled

	}
}
