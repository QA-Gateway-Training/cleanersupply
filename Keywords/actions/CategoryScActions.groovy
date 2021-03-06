package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class CategoryScActions{

	/***
	 * @author Razan
	 *	@description hover tags and forms 
	 */
	public static void hovertags() {
		WebUI.mouseOver(findTestObject("Object Repository/Category/a_tags"))
	}

	/**
	 * @author Razan
	 * @return the converted value.
	 * @param rgba The RGBA value to convert.
	 */
	public static int convertRgbaToArgb(int rgba) {
		return (rgba >>> 8) | (rgba << (32 - 8));
	}
	/**
	 * get the color object value
	 * @author Razan
	 * @return the color CSS value for object.
	 * @param selector Get the selector of the object.
	 */


	public static String getcssvvalueforTagsColor(String selector){
		return WebUI.getCSSValue(findTestObject(selector), 'color').toString()
	}

	/**
	 * get the background object value
	 * @author Razan
	 * @return the background CSS value for object.
	 * @param selector Get the selector of the object.
	 */

	public static String getcssvvalueforTagsBackGround(String selector){
		return WebUI.getCSSValue(findTestObject(selector), 'background-color').toString()
	}

	/** Click on specific given selector's object
	 * @author Razan
	 * @param selector Get the selector of the object.
	 */

	public static void ClickObject(String selector) {
		WebUI.click(findTestObject(selector))
	}



	/***
	 * @description get default product number in product's result and
	 * @author Razan
	 */

	public static void getDefaultProjectCategoryFilter(String ExpectedProductNum) {

		TestObject defaultProductsCount = findTestObject("Object Repository/Category/h2_productNum")
		String text =	WebUI.getText(defaultProductsCount)
		String numberOnly= text.replaceAll("[^0-9]", "");
//		assert numberOnly.equals(ExpectedProductNum)
		
//		TestObject selectedFilters = findTestObject('Object Repository/Search Result/ul_selectedFilters')
//		assert WebUI.verifyElementNotPresent(selectedFilters, 5)
	}

	/***
	 * @description get default sort by value
	 * @author Razan
	 */

	public static void getDefaultValueOfSortBy(String ExpectedValue) {
		TestObject defaultProductsfilter = findTestObject("Object Repository/Category/span_featuredDefault")
		String text = WebUI.getText(defaultProductsfilter)
		assert text.equals(ExpectedValue)
	}



	/***
	 * @description get default Manufacturar value
	 * @author Razan
	 */


	public static void getDefaultManufacturar(String Expected) {
		TestObject manuDefault = findTestObject("Object Repository/Category/span_manuDefault")
		String actual = WebUI.getText(manuDefault)
		assert	actual.equals(Expected)
	}

	/***
	 * @description get default Modal value
	 * @author Razan
	 */

	public static void getDefaultModal(String Expected) {
		TestObject manuDefault = findTestObject("Object Repository/Category/span_defaultFilterModal")
		String actual = WebUI.getText(manuDefault)
		assert actual.equals(Expected)
	}
	//	public static void getDefaultProjectCategoryFilter() {
	//		WebElement defaultfilterPro = FindElement(By.partialLinkText("74 products"))
	//		TestObject element = WebUI.convertWebElementToTestObject(defaultfilterPro)
	//	}


	/**
	 * @author Razan
	 * @param1 ExpectedCSSEXpandedValue get expected css value
	 * verify that expanded menu that it is has the expected css value
	 */


	public static void clickOnManuWithassertOPened(String ExpectedCSSEXpandedValue) {
		TestObject expandedMenu = findTestObject('Object Repository/Category/sp001Casiprodoct/ul_manufature')
		TestObject manuDefault = findTestObject('Object Repository/Category/span_manuDefault')
		WebUI.click(manuDefault)
		String cssValue= WebUI.getAttribute(expandedMenu, 'aria-expanded')
		assert cssValue.equals(ExpectedCSSEXpandedValue)
	}
	
	
	public static void clickOnCasioWithassertOPened(String ExpectedCSSEXpandedValue) {
		TestObject expandedMenu = findTestObject('Object Repository/Category/sp001Casiprodoct/ul_sp1000list')
		TestObject manuDefault = findTestObject('Object Repository/Category/sp001Casiprodoct/span_modelDefault')
		WebUI.click(manuDefault)
		String cssValue= WebUI.getAttribute(expandedMenu, 'aria-expanded')
		assert cssValue.equals(ExpectedCSSEXpandedValue)
	}
}