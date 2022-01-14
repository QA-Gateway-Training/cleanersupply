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

import internal.GlobalVariable

public class defaultFooterValidatins {
	
	public static void verifyExistingOftopFooterImage() {
		TestObject image = findTestObject("Object Repository/defaultFooter/img_topFooter")
		WebUI.verifyElementVisible(image)
		
	}
	
	public static void verifyBackGroundandMaxHeightOfTopFooter() {
		TestObject topFooter = findTestObject("Object Repository/defaultFooter/div_topFooter")
		String backgroundColor =WebUI.getCSSValue(topFooter, 'background')
		String footerTopMaxheight=WebUI.getCSSValue(topFooter, 'max-height')
		assert backgroundColor.contains(GlobalVariable.topFooterBackGroundColor)
		assert footerTopMaxheight.equals(GlobalVariable.footerMaxHeight)
		
	}
	
	public static void verifyExistingOffooterBody() {
		TestObject footerBody = findTestObject("Object Repository/defaultFooter/div_footerBody")
		WebUI.verifyElementVisible(footerBody)
		
	}
	
//	public static void verifyFooterRowsNumber() {
//		TestObject cols = findTestObject("Object Repository/CheckOutForm/button_expirationYear")
//		WebUI.click(button)
//		List <WebElement> Years =
//				WebUI.findWebElements(findTestObject("Object Repository/CheckOutForm/a_expirationCardYear"),
//				GlobalVariable.elementVisibilityTimeOut)
//		int maxYear = Years.size();
//		Random random = new Random();
//		int randomyear= random.nextInt(maxYear);
//		Years.get(randomyear).click();
//		
//	}
	
	
		public static void verifyBackGroundandPaddingOfFooterBody() {
		TestObject div_footerBody = findTestObject("Object Repository/defaultFooter/div_footerBody")
		String backgroundColor =WebUI.getCSSValue(div_footerBody, 'background')
		String padding=WebUI.getCSSValue(div_footerBody, 'padding')
		assert backgroundColor.contains(GlobalVariable.footerBodyBackGroundColor)
		println(padding)
//		assert padding.equals(GlobalVariable.footerMaxHeight)
		
	}
	
}
