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

public class SeconderyHeaderActions {
	
	/**
	 * Click on tags and form link item
	 * @author waleedafifi
	 */
	public static void tagsAndFormsClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_tagsAndForm')
		WebUI.click(to)
	}
	
	/**
	 * Click on counter and checkin link item
	 * @author waleedafifi
	 */
	public static void counterAndCheckinClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_counterAndCheckin')
		WebUI.click(to)
	}
	
	/**
	 * Click on Bags link item
	 * @author waleedafifi
	 */
	public static void bagsClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_bags')
		WebUI.click(to)
	}
	
	/**
	 * Click on Pressing and spotting link item
	 * @author waleedafifi
	 */
	public static void pressingAndSpottingClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_pressingAndSpotting')
		WebUI.click(to)
	}
	
	/**
	 * Click on packaging link item
	 * @author waleedafifi
	 */
	public static void packagingClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_packaging')
		WebUI.click(to)
	}
	
	/**
	 * Click on Racks link item
	 * @author waleedafifi
	 */
	public static void racksClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_racks')
		WebUI.click(to)
	}
	
	/**
	 * Click on Tailoring link item
	 * @author waleedafifi
	 */
	public static void tailoringClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_tailoring')
		WebUI.click(to)
	}
	
	/**
	 * Click on Laundromat link item
	 * @author waleedafifi
	 */
	public static void laundromatClickAction() {
		TestObject to = findTestObject('Object Repository/Secondary Header/a_laundromat')
		WebUI.click(to)
	}
}
