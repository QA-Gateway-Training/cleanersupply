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
import org.openqa.selenium.WebElement
import java.text.DecimalFormat

public class MiniCartValidations {
	public static void verifyHoverStyleOnMiniCartLink() {
		TestObject miniCart = findTestObject('Object Repository/Cart/a_miniCartLink')
		assert WebUI.getCSSValue(miniCart, 'background-color').equals(GlobalVariable.whiteColor)

		TestObject cartIcon = findTestObject('Object Repository/Cart/i_cartIcon')
		assert WebUI.getCSSValue(miniCart, 'color').equals(GlobalVariable.purpleColor)
	}

	public static void verifyMiniCartTotals() {
		List<WebElement> prodPrice = WebUI.findWebElements(findTestObject('Object Repository/Cart/span_miniCartProductPrice'), 1)
		List<WebElement> prodQyt = WebUI.findWebElements(findTestObject('Object Repository/Cart/td_miniCartTableQuantityTableData'), 1)
		List<WebElement> prodTotal = WebUI.findWebElements(findTestObject('Object Repository/Cart/td_miniCartTotalPrice'), 1)

		Float totalOfTotal = 0
		
		for(int idx = 0; idx < prodPrice.size(); idx++) {
			String prc = prodPrice.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String qt = prodQyt.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");
			String total = prodTotal.get(idx).getAttribute('innerText').replaceAll("[^0-9\\.]","");

			totalOfTotal += Float.parseFloat(total)
			
			assert total.contains(new DecimalFormat("#.##").format(Float.parseFloat(prc) * Integer.parseInt(qt)))
		}
		
		TestObject miniCartTotal = findTestObject('Object Repository/Cart/span_miniCartSubTotal')
		assert WebUI.getText(miniCartTotal).contains(totalOfTotal.toString())
	}
	
	public static void miniCartItemCount() {
		List<WebElement> productRow = WebUI.findWebElements(findTestObject('Object Repository/Cart/tr_miniCartTableRow'), 1)
		TestObject counterBadge = findTestObject('Object Repository/Cart/span_cartCounterPadge')
		
		assert WebUI.getText(counterBadge).contains(productRow.size().toString())
		
	} 
}