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

import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

public class ShoppingCartActions {
	/**
	 * Navigate to checkout page
	 * @author waleedafifi
	 */
	public static void navigateToCheckOutPage() {
		TestObject btn = findTestObject('Object Repository/Shopping Cart/button_proceedToCheckout')
		WebUI.click(btn)
	}

	/**
	 * Trigger mouse move on checkout button
	 * @author waleedafifi
	 */
	public static void hoverCheckOutButton() {
		TestObject btn = findTestObject('Object Repository/Shopping Cart/button_proceedToCheckout')
		WebUI.mouseOver(btn)
	}
	
	/**
	 * Update product quantity in shopping cart page based on passed params
	 * @param qyt
	 * @author waleedafifi
	 */
	public static void updateProductQuantity(int qyt) {
		List<WebElement> quantityInput = WebUI.findWebElements(findTestObject('Object Repository/Shopping Cart/input_shoppingCartProductQuantity'), GlobalVariable.globalTimeOut)
		for (int idx = 0; idx < quantityInput.size(); idx++) {
			quantityInput[idx].sendKeys(Keys.chord(Keys.BACK_SPACE) + qyt.toString())
		} 
	}
}
