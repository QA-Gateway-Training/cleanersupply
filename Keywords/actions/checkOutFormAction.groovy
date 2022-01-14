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
import org.openqa.selenium.WebElement
import internal.GlobalVariable
import helpers.CategorySCHelpers
public class checkOutFormAction {

	public static void sendValue(String selector,String value) {
		TestObject element  =findTestObject(selector)
		WebUI.setText(element, value)
	}

	public static void selectStateValue(String buttonSelector,String aSelector, String spanSelected) {
		TestObject selector1 = findTestObject(buttonSelector)
		WebUI.click(selector1)
		CategorySCHelpers.checkCollabse(buttonSelector)
		TestObject selectedState = findTestObject(aSelector)
		WebUI.click(selectedState)
		String selectedStatespan =WebUI.getText(findTestObject(spanSelected))
		assert selectedStatespan.equals(GlobalVariable.state)
	}

	public static void clickReviewButton() {
		TestObject button = findTestObject("Object Repository/CheckOutForm/a_reviewOrder")
		WebUI.click(button)
	}

	public static void selectRandomExpirationDateExceptNowMonth() {
		TestObject button = findTestObject("Object Repository/CheckOutForm/button_expirationDate")
		WebUI.click(button)
		List <WebElement> Months =
				WebUI.findWebElements(findTestObject("Object Repository/CheckOutForm/a_expirationDate"),
				GlobalVariable.elementVisibilityTimeOut)
		int maxMonth = Months.size();
		Random random = new Random();
		int randomMonth= random.nextInt(maxMonth);
		GlobalVariable.monthValue = Months.get(randomMonth).getAttribute('innerText')
		println(Months.get(randomMonth).getAttribute('innerText'))
		Months.get(randomMonth).click();
		
	}

	public static void selectRandomExpirationYearExceptNowMonth() {
		TestObject button = findTestObject("Object Repository/CheckOutForm/button_expirationYear")
		WebUI.click(button)
		List <WebElement> Years =
				WebUI.findWebElements(findTestObject("Object Repository/CheckOutForm/a_expirationCardYear"),
				GlobalVariable.elementVisibilityTimeOut)
		int maxYear = Years.size();
		Random random = new Random();
		int randomyear= random.nextInt(maxYear);
		GlobalVariable.yearValue = Years.get(randomyear).getAttribute('innerText')
		println(Years.get(randomyear).getAttribute('innerText'))
		Years.get(randomyear).click();
	}
}
