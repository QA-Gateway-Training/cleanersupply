package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

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

import actions.GeneralActions
import actions.SeconderyHeaderActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.SeconderyHeaderValidation

public class SeconderyHeaderHelper {

	public static List<WebElement> navBottomItems
	public static List<WebElement> dropDownMenus
	public static List<WebElement> allDropDownMenusLinks


	public static void verifyNavLinksStyle(TestObject link, String expectedTitle) {
		assert WebUI.getText(link).equals(expectedTitle)
		SeconderyHeaderValidation.verifyElmStyle(link,"color",GlobalVariable.footerbodyWightColor)
		SeconderyHeaderValidation.verifyElmStyle(link,"font-weight",GlobalVariable.navLinkFontWeight)
		SeconderyHeaderValidation.verifyElmStyle(link,"text-transform","uppercase")
	}

	public static void verifyAllNavLinksStyle() {
		SeconderyHeaderHelper.getNavBottomItems()
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[0]),"TAGS & FORMS")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[1]),"COUNTER & CHECK-IN")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[2]),"BAGS")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[3]),"PRESSING & SPOTTING")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[4]),"PACKAGING")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[5]),"RACKS")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[6]),"TAILORING")
		SeconderyHeaderHelper.verifyNavLinksStyle(WebUI.convertWebElementToTestObject(navBottomItems[7]),"LAUNDROMAT")
	}

	public static void hoverMainNavLink(TestObject link,TestObject menu) {

		SeconderyHeaderValidation.verifyElmStyle(link,"color", GlobalVariable.searchHeaderTopBarBackgroundColor)
		SeconderyHeaderValidation.verifyElmStyle(link,"cursor", "pointer")
		GeneralValidation.verifyBackgroundColor(link, GlobalVariable.whiteColor)
		SeconderyHeaderValidation.verifyElmStyle(menu,"display", "block")
		//		SeconderyHeaderValidation.verifyElmStyle(menu,"width","1349px")// "100%")
		SeconderyHeaderValidation.verifyElmStyle(menu,"border-bottom-color", GlobalVariable.searchHeaderTopBarBackgroundColor)
		SeconderyHeaderValidation.verifyElmStyle(menu,"border-bottom-width", "2px")
		GeneralValidation.verifyBackgroundColor(menu, GlobalVariable.whiteColor)
		assert WebUI.getAttribute(findTestObject("Object Repository/Secondary Header/ul_navBottom"),"class").contains("open-desktop")
	}

	public static void hoverDropDownNavLink(TestObject link) {
		SeconderyHeaderValidation.verifyElmStyle(link,"color", GlobalVariable.blackColor)
		GeneralActions.hoverItem(link)
		//		SeconderyHeaderValidation.verifyElmStyle(link,"color", GlobalVariable.searchHeaderTopBarBackgroundColor)
	}

	public static void getNavBottomItems() {
		navBottomItems = WebUI.findWebElements(findTestObject("Object Repository/Secondary Header/a_linksNavBottom"),GlobalVariable.webElementTimeOut)
	}

	public static void getDropMenus() {
		dropDownMenus = WebUI.findWebElements(findTestObject("Object Repository/Secondary Header/div_dropdownMenus"),GlobalVariable.webElementTimeOut)
		allDropDownMenusLinks = WebUI.findWebElements(findTestObject("Object Repository/Secondary Header/a_allDropDownLinks"),GlobalVariable.webElementTimeOut)
	}

	public static void hoverAllMainNavLinksAndCheckStyle() {
		//		SeconderyHeaderHelper.getNavBottomItems()
		//		SeconderyHeaderHelper.getDropMenus()
		int y=27;
		for(int i=0; i<=7 ; i++) {
			TestObject link = WebUI.convertWebElementToTestObject(navBottomItems[i])
			GeneralActions.hoverItem(link)
			SeconderyHeaderHelper.getDropMenus()
			SeconderyHeaderHelper.hoverMainNavLink(link,
					WebUI.convertWebElementToTestObject(dropDownMenus[i]))
			println(allDropDownMenusLinks[y].getAttribute("innerText"))
			SeconderyHeaderHelper.hoverDropDownNavLink(WebUI.convertWebElementToTestObject(allDropDownMenusLinks[y]))
			y = y+27
		}

	}
	
	/**
	 * Navigate to Tags and Forms then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToTagsAndForms() {
		SeconderyHeaderActions.tagsAndFormsClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Dry Cleaning Tags')
		GeneralValidation.verifyCurrentPageURL('Tags-Forms')
	}

	
	/**
	 * Navigate to Counter and Checkin then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToCounterAndCheckin() {
		SeconderyHeaderActions.counterAndCheckinClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Store Counter')
		GeneralValidation.verifyCurrentPageURL('Counter-Check-In')
	}
	
	/**
	 * Navigate to Bags then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToBags() {
		SeconderyHeaderActions.bagsClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Bags')
		GeneralValidation.verifyCurrentPageURL('Bags')
	}
	
	/**
	 * Navigate to pressing and spotting then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToPressingAndSpotting() {
		SeconderyHeaderActions.pressingAndSpottingClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Pressing, Spotting')
		GeneralValidation.verifyCurrentPageURL('Pressing-Spotting')
	}
	
	/**
	 * Navigate to packaging then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToPackaging() {
		SeconderyHeaderActions.packagingClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Packaging Supplies')
		GeneralValidation.verifyCurrentPageURL('Packaging')
	}
	
	/**
	 * Navigate to packaging then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToRacks() {
		SeconderyHeaderActions.racksClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Rack Accessories')
		GeneralValidation.verifyCurrentPageURL('Racks')
	}
	
	/**
	 * Navigate to Tailoring Supplies then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToTailoring() {
		SeconderyHeaderActions.tailoringClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Tailoring Supplies')
		GeneralValidation.verifyCurrentPageURL('Tailoring')
	}
	
	/**
	 * Navigate to Laundromat Supplies then validate the url, title
	 * @author waleedafifi
	 */
	public static void navigateToLaundromat() {
		SeconderyHeaderActions.laundromatClickAction()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimeOut)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()
		GeneralValidation.verifyCurrentPageTitleValue('Laundromat Supplies')
		GeneralValidation.verifyCurrentPageURL('Laundromat')
	}

}
