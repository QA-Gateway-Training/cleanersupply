package helpers
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CategoryScActions
import internal.GlobalVariable
import validation.GeneralValidation


public class CategorySCHelpers {
	/***
	 * @author Razan
	 * get object's selector, hover and click it
	 * @param selector
	 */
	
//	public static void navigateTotags(String selector){
//		
//		CategoryScActions.hoveranchor("Object Repository/Category/a_ComputerRegister")
//		//CategoryScActions.ClickObject(selector)
//	}
	
	/***
	 * hover, navigate to computer and register with url and title assertion
	 * @author Razan
	 */
	
	public static void navigateComputerRegister() {
		String computerRegister = "Object Repository/Category/a_ComputerRegister"
		WebUI.mouseOver(findTestObject("Object Repository/Category/a_ComputerRegister"))
		WebUI.click(findTestObject("Object Repository/Category/a_ComputerRegister"))
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.computerRegisterURL)
		//GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.computerRegisterTitle)
	}
}
