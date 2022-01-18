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

import helpers.GeneralHelperFunctions
import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class ProductDetailsValidation {

	/***
	 * Verify if product details page has breadcrumb and contain default from global variable
	 * @author waleedafifi
	 */
	public static void verifyProductDetailsPageBreadCrumb() {
		TestObject obj = findTestObject('Object Repository/Product details/ul_breadcrumb')
		assert WebUI.getText(obj).contains(GlobalVariable.breadCrumb)
	}

	/**
	 * Verify if product title contain part of the product name
	 * @author waleedafifi
	 */
	public static void verifyProductDetailsName(String pName = GlobalVariable.productName) {
		TestObject productName = findTestObject('Object Repository/Product details/h1_productName')
		assert WebUI.verifyElementPresent(productName, GlobalVariable.globalTimeOut)
		assert WebUI.getText(productName).contains(pName)
	}

	/**
	 * Verify product sku number is not empty
	 * @author waleedafifi
	 */
	public static void verifySKUNotEmpty() {
		TestObject sku = findTestObject('Object Repository/Product details/span_skuNumber')
		assert !WebUI.getText(sku).isEmpty()
	}

	/**
	 * Verify default size if has selected class, dark gray background, white color for the text
	 * @param xpath
	 * @author waleedafifi
	 */
	public static void verifyActiveProductSize(xpath) {
		TestObject size = GeneralHelperFunctions.makeTO(xpath)
		//		TestObject size = findTestObject('Object Repository/Product details/a_xLargeLink')
		assert WebUI.getAttribute(size, 'class').contains(GlobalVariable.selected)
		assert WebUI.getCSSValue(size, 'background-color').equals(GlobalVariable.selectedSizeBackgroundColor)
		assert WebUI.getCSSValue(size, 'color').equals(GlobalVariable.whiteColor)
	}

	/**
	 * Verify hover effect style on size links with light gray background, white color for the text
	 * @author waleedafifi
	 */
	public static void verifyOnHoverStyle() {
		TestObject size = findTestObject('Object Repository/Product details/a_xLargeLink')
		assert WebUI.getCSSValue(size, 'background-color').equals(GlobalVariable.grayColor)
		assert WebUI.getCSSValue(size, 'color').equals(GlobalVariable.whiteColor)
	}

	/**
	 * Verify product price if equal to passed price
	 * @param obj
	 * @param price
	 * @author waleedafifi
	 */
	public static void verifyProductPrice() {
		//		String numberOnly = price.replaceAll("[^0-9\\.]","");
		String numberOnly = GlobalVariable.productItems[2];

		TestObject prc = findTestObject('Object Repository/Product details/span_productPrice')

		float priceText = Float.parseFloat(WebUI.getText(prc).replaceAll("[^0-9\\.]",""))

		String[] splitedPrice = numberOnly.split("-");

		float num1 = Float.parseFloat(splitedPrice[0].replaceAll("[^0-9\\.]",""))
		float num2 = Float.parseFloat(splitedPrice[1].split("List")[0].replaceAll("[^0-9\\.]",""))

		assert (priceText >= num1 && priceText <= num2)

		//		assert WebUI.getText(obj).contains(numberOnly)
	}

	/**
	 * Verify the selected color has a selected class
	 * @param obj
	 * @param colorName
	 * @author waleedafifi
	 */
	public static void verifyProductColorSelect(TestObject obj, String colorName = 'Black') {
		assert WebUI.verifyElementPresent(obj, GlobalVariable.globalTimeOut)
		assert WebUI.getAttribute(obj, 'class').contains(GlobalVariable.selected)
		TestObject color = findTestObject('Object Repository/Product details/span_selectedColor')
		assert WebUI.getText(color).contains(colorName.toUpperCase())
	}

	/**
	 * Verify if the stock availability, if yes will have green color, if not will have red color
	 * @param stockStatus
	 * @author waleedafifi
	 */
	public static void verifyProductAvailability(boolean stockStatus = true) {
		TestObject stock = findTestObject('Object Repository/Product details/div_stockNotifcations')
		if(stockStatus) {
			assert WebUI.getText(stock).contains(GlobalVariable.txtInStock)
			assert WebUI.getCSSValue(stock, 'color').equals(GlobalVariable.greenColor)
		} else {
			assert WebUI.getText(stock).contains(GlobalVariable.txtOutStock)
			assert WebUI.getCSSValue(stock, 'color').equals(GlobalVariable.redColor)
		}
	}

	/**
	 * Verify add to cart button visibility based on buttonStatus 
	 * @param buttonStatus
	 * @author waleedafifi
	 */
	public static void verifyAddToCartButtonVisibility(boolean buttonStatus = true) {
		TestObject btn = findTestObject('Object Repository/Product details/button_addToCart')
		if(buttonStatus) {
			assert WebUI.verifyElementVisible(btn)
		} else {
			assert WebUI.verifyElementNotVisible(btn)
		}
	}

	/**
	 * Verify favorite icon visibility Based on status passed from the helper
	 * @param iconStatus
	 * @author waleedafifi
	 */
	public static void verifyFavoriteIconVisibility(boolean iconStatus = true) {
		TestObject ico = findTestObject('Object Repository/Product details/i_favorite')
		if(iconStatus) {
			assert WebUI.verifyElementVisible(ico)
		} else {
			assert WebUI.verifyElementNotVisible(ico)
		}
	}

	/**
	 * Verify favorite icon style to be gray
	 * @author waleedafifi
	 */
	public static void verifyFavoriteIconStyle() {
		TestObject ico = findTestObject('Object Repository/Product details/i_favorite')
		assert WebUI.getCSSValue(ico, 'color').equals(GlobalVariable.lightGray)
	}

	/**
	 * Verify add to cart style to be purple
	 * @author waleedafifi
	 */
	public static void verifyAddCartStyle() {
		TestObject btn = findTestObject('Object Repository/Product details/button_addToCart')
		assert WebUI.getCSSValue(btn, 'background-color').equals(GlobalVariable.purpleColor)
	}

	/**
	 * Verify hover effect on add to cart button
	 * @author waleedafifi
	 */
	public static void verifyAddToCartOnHover() {
		TestObject container = findTestObject('Object Repository/Product details/div_addToCartContainer')
		assert WebUI.getCSSValue(container, 'box-shadow').equals('rgba(0, 0, 0, 0.3) 0px 0px 10px 2px')
	}

	/**
	 * Verify product quantity field equals to passed params
	 * @param txt
	 * @author waleedafifi
	 */
	public static void verifyProductQuantityField(int txt) {
		TestObject ipt = findTestObject('Object Repository/Product details/input_productQuantity')
		assert WebUI.getAttribute(ipt, 'value').equals(txt.toString())
	}

	/**
	 * Verify text of the button contains LOADING
	 * @author waleedafifi
	 */
	public static void VerifyInnerTEXTLoadingAfterAddToCart() {
		TestObject btn = findTestObject('Object Repository/Product details/button_addToCart')
		assert WebUI.getText(btn).contains('Loading'.toUpperCase())
	}

	/**
	 * Verify text of the button contains ADDED TO CART
	 * @author waleedafifi
	 */
	public static void VerifyInnerTEXTAddedAfterAddToCart() {
		TestObject btn = findTestObject('Object Repository/Product details/button_addToCart')
		assert WebUI.getText(btn).contains('Added to cart'.toUpperCase())
	}

	/**
	 * Verify available color count
	 * @author waleedafifi
	 */
	public static void verifyAvailableColorCounter() {
		List<WebElement> clr = WebUI.findWebElements(findTestObject('Object Repository/Product details/div_colorOptions'), GlobalVariable.globalTimeOut)
		String availabelColor = GlobalVariable.productItems[3].toString().replaceAll("[^0-9]","")
		assert clr.size().equals(Integer.parseInt(availabelColor))
	}

	/**
	 * Verify product Specification dimension to contain passed params
	 * @param dimesion
	 * @author waleedafifi
	 */
	public static void verifyProductSpecSize(String dimesion) {
		TestObject to = findTestObject('Object Repository/Product details/span_productSpecSize')
		assert WebUI.getText(to).contains(dimesion)
	}

	public static void verifyVolumeTable(int qty = 1, String prodPrice) {
		List<WebElement> qtyTD = WebUI.findWebElements(findTestObject('Object Repository/Product details/Volume Table/td_qty'), GlobalVariable.globalTimeOut)
		List<WebElement> priceTD = WebUI.findWebElements(findTestObject('Object Repository/Product details/Volume Table/td_price'), GlobalVariable.globalTimeOut)
		List<WebElement> saveTD = WebUI.findWebElements(findTestObject('Object Repository/Product details/Volume Table/td_save'), GlobalVariable.globalTimeOut)

		boolean flag = false

		for(int idx = 0; idx < qtyTD.size(); idx++) {
			String originalPrice = priceTD[0].getText().replaceAll("[^0-9\\.]","")
			String price = priceTD[idx].getText().replaceAll("[^0-9\\.]","")
			String save = saveTD[idx].getText() == '—' ? '0' : saveTD[idx].getText().replaceAll("[^0-9\\.]","")
			String quntity = qtyTD[idx].getText().replaceAll("[^0-9\\.]","")

			Float savedPrice = Float.parseFloat(originalPrice) - (Float.parseFloat(originalPrice) * (Float.parseFloat(save) / 100))

			if(qty >= Integer.parseInt(quntity)) {
				flag = prodPrice == String.format("%.2f", savedPrice)
				break
			}
		}
		assert flag : 'Volume table price'
	}
}
