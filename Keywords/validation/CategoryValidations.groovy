package validation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import actions.CategoryScActions
import internal.GlobalVariable


public class CategoryValidations {

	/***
	 * @author Razan
	 * @param1 ExpectedHoverColor get expected hover anchor color 
	 * @param2 ExpectedHoverBackground get expected hover anchor background
	 */
	public static void checkanchorHoverColorBackground(String selector,String ExpectedHoverColor,String ExpectedHoverBackground) {
		String actualColor = CategoryScActions.getcssvvalueforTagsColor(selector)
		String actualBackground = CategoryScActions.getcssvvalueforTagsBackGround(selector)
		assert	actualColor.equals(ExpectedHoverColor)
		assert	actualBackground.equals(ExpectedHoverBackground)
	}

	public static void checkHoverFlyMenuVisibility() {
		TestObject menyFly = findTestObject("Object Repository/Category/ul_flyMenu")
		assert WebUI.verifyElementVisible(menyFly)
		assert WebUI.getAttribute(menyFly, "class").contains(GlobalVariable.flyMenyOpenedClass)
	}

	public static void checkHoverFlyMenuUNVisibility() {
		TestObject menyFly = findTestObject("Object Repository/Category/ul_flyMenu")
		assert WebUI.verifyElementNotPresent(menyFly, 0)
		assert WebUI.getAttribute(menyFly, "class").contains(!GlobalVariable.flyMenyOpenedClass)
	}

	public static void validatespanText(String ExpectedText){
		TestObject object=findTestObject("Object Repository/Category/span_omputerRegister")
		String text =	WebUI.getText(object)
		assert text.contains(ExpectedText.toUpperCase())
	}

	public static void validateText(String Selector ,String ExpectedText) {
		TestObject textSelector = findTestObject(Selector)
		String text =WebUI.getText(textSelector)
		WebUI.verifyEqual(text, ExpectedText.toUpperCase())
	}

	public static void validatePrice(String Selector,BigDecimal ExpectedPrice) {
		TestObject priceSelector = findTestObject(Selector)
		String price =WebUI.getText(priceSelector)
		//println (price)
		//println (ExpectedPrice)
		price = price.replace('\\$', "");
		//println(price)
		float f=Float.parseFloat(price);
		WebUI.verifyEqual(price, ExpectedPrice)

	}

	public static void validateCartNo(String ExpectedNo) {
		TestObject badge =findTestObject("Object Repository/Category/span_badge")
		String itemsNo=WebUI.getText(badge)
		WebUI.verifyEqual(itemsNo, ExpectedNo)
	}
}
