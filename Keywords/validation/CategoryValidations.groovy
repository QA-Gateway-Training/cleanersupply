package validation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import actions.CategoryScActions


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

		public static void validatespanText(String ExpectedText){
			TestObject object=findTestObject("Object Repository/Category/span_omputerRegister")
			String text =	WebUI.getText(object)
			assert text.contains(ExpectedText.toUpperCase())
		}
}
