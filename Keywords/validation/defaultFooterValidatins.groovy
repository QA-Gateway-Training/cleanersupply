package validation

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.sl.usermodel.Placeholder

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
import helpers.GeneralHelpers
import actions.defaultFooterActions
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


	public static void verifyExistingOffooterBodyRightColomn() {
		TestObject RightColomn = findTestObject("Object Repository/defaultFooter/div_footerBodyRightcolumn")
		WebUI.verifyElementVisible(RightColomn)

	}

	public static void verifyExistingOffooterBodyMiddleColomn() {
		TestObject MiddleColomn = findTestObject("Object Repository/defaultFooter/div_footerBodyMiddleColumn")
		WebUI.verifyElementVisible(MiddleColomn)

	}

	public static void verifyExistingOffooterBodyLeftColomn() {
		TestObject LeftColomn = findTestObject("Object Repository/defaultFooter/div_footerBodyLeftColumn")
		WebUI.verifyElementVisible(LeftColomn)

	}

	public static void verifyRequestCatalogueLink() {
		TestObject requestCatalouge = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_requestCatalogue")
		WebUI.verifyElementVisible(requestCatalouge)
		WebUI.click(requestCatalouge)
		TestObject requestCatalougeHeader = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/h2_requestCatalogue")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.requestHeaderTitle,requestCatalougeHeader,
				GlobalVariable.requestCatalogueHeader, GlobalVariable.requestCatalogueURL)
		String color = WebUI.getCSSValue(requestCatalouge, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
		TestObject catalogueIcon = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/span_catalogueIcon")
		WebUI.verifyElementVisible(catalogueIcon)

	}

	public static void verifycassifiedListLink() {
		TestObject a_classifiedList = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_classifiedList")
		WebUI.verifyElementVisible(a_classifiedList)
		WebUI.click(a_classifiedList)
		TestObject classifiedListHeader = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/h2_classifiedList")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.classifiedTitle,classifiedListHeader,
				GlobalVariable.classifiedListHeader, GlobalVariable.classifiedURL)
		String color = WebUI.getCSSValue(a_classifiedList, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
		TestObject classifiedIcon = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/span_classifieds")
		WebUI.verifyElementVisible(classifiedIcon)
	}


	public static void verifyExistingOfRegionButtonandClickable() {
		TestObject buttonRegion = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/button_region")
		WebUI.verifyElementVisible(buttonRegion)
		String expanded = WebUI.getAttribute(buttonRegion, 'aria-expanded')
		//assert expanded.equals("false")
		WebUI.click(buttonRegion)
		//assert expanded.equals("true")
		TestObject DefaultRegion = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/span_defaultRegionText")
		String textRegion=WebUI.getText(DefaultRegion)
		assert textRegion.equals(GlobalVariable.defaultRegionText)
	}

	public static void verifyClickingOnFeedBackButtonShowPopUP() {
		TestObject modal = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/div_leave-feedback-form")
		WebUI.verifyElementNotVisible(modal)
		TestObject feedBackBtn = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_leaveFeedbackOpen")
		WebUI.click(feedBackBtn)
		WebUI.verifyElementVisible(modal)
		//		TestObject headerFeadBack = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/h2_feedback")
		//		String header = WebUI.getAttribute(headerFeadBack, 'value')
		//		assert header.equals(GlobalVariable.feedbackHeader)
	}

	public static void fillModalWithAssertValueAndClose() {
		TestObject comment = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/textarea_feedback")
		WebUI.setText(comment, GlobalVariable.comment)
		String attrubute = WebUI.getAttribute(comment, 'value')
		assert attrubute.equals(GlobalVariable.comment)
		TestObject email = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/input_feedBackEmail")
		WebUI.setText(email, GlobalVariable.email)
		String value = WebUI.getAttribute(email, 'value')
		assert value.equals(GlobalVariable.email)
		//		TestObject recaptcha = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/span_recaptcha")
		//		WebUI.click(recaptcha)
		TestObject close = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/button_closeFeedbackModal")
		WebUI.click(close)
	}

	public static void verifyClickingFavourites() {

		TestObject loginHeader = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/h2_loginHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.loginPageTitle,loginHeader,
				GlobalVariable.loginPageHeader, GlobalVariable.favouriteURL)
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
	}

	public static void verifyClickingPreviouslyOrdered() {

		TestObject loginHeader = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/h2_loginHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.loginPageTitle,loginHeader,
				GlobalVariable.loginPageHeader, GlobalVariable.previouslyOrderURL)
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
	}

	public static void verifyClickingOnQuickOrder() {
		TestObject quickOrderHeader = findTestObject("Object Repository/Quick Order/span_quickOrderHeader")
		GeneralHelpers.verifyNavigationToPage(GlobalVariable.quickOrderPageTitle, quickOrderHeader,
				GlobalVariable.quickOrderHeader, GlobalVariable.quickOrderUrl)
		WebUI.navigateToUrl(GlobalVariable.baseUrl)

	}

	public static void verifyClickingOnOnlineOrder() {
		TestObject quickOrderHeader = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/a_onlineOrdering")
		//		assert WebUI.getWindowTitle().equals(GlobalVariable.onlineOrderingTitle)
		//assert WebUI.getUrl().equals(GlobalVariable.onlineOrderingUrl)
		WebUI.navigateToUrl(GlobalVariable.baseUrl)

	}

	public static void verifyExistingOfSampleFooter() {

	}

	public static void verifyExistingOfLeftFooterTitle() {
		TestObject leftFooterTitle = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_leftFooterTitle")
		assert WebUI.verifyElementPresent(leftFooterTitle, 0)
		String text =WebUI.getText(leftFooterTitle)
		assert text.equals(GlobalVariable.leftFooterTitle.toString().toUpperCase())

	}

	public static void verifyExistingOfLeftFooterSubTitle() {
		TestObject leftFooterSubTitle = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_leftFootersubTitle")
		assert WebUI.verifyElementPresent(leftFooterSubTitle, 0)
		String text =WebUI.getText(leftFooterSubTitle)
		assert text.equals(GlobalVariable.leftfooterSubTitle)

	}

	public static void verifyExistingOfEmailAndValidatingIt() {
		TestObject emailInput = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_leftFooterTitle")
		assert WebUI.verifyElementPresent(emailInput, GlobalVariable.pageLoadTimeOut)
		//		String emailPlaceHolder =WebUI.getAttribute(emailInput, 'placeholder')
		//		assert WebUI.verifyEqual(emailPlaceHolder, GlobalVariable.subscriberPlaceHolder)
	}

	public static void verifyExistingOfConnectUsTitleandhasexpectedTitle() {
		TestObject connectUs = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_contactUsTitle")
		assert WebUI.verifyElementPresent(connectUs, GlobalVariable.pageLoadTimeOut)
		String text =WebUI.getText(connectUs)
		assert text.equals(GlobalVariable.contactUsTitle)
	}



	public static void  verifyEmailContactAddresAndHasExpectedAddress() {
		TestObject emailIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_emailIcon")
		assert WebUI.verifyElementPresent(emailIcon, GlobalVariable.pageLoadTimeOut)

	}
	public static void  verifyExistingangOfEmailIconAndHasExpectedStyle() {
		TestObject emailIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_emailIcon")
		assert WebUI.verifyElementPresent(emailIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(emailIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
	}

	public static void  verifyContactInfoAddressAsExpected() {
		TestObject contactInfo = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_contactInfo")
		assert WebUI.verifyElementPresent(contactInfo, GlobalVariable.pageLoadTimeOut)
		assert WebUI.getText(contactInfo).equals(GlobalVariable.workTime)
	}
	public static void  verifyExistingangOfPhoneIconAndHasExpectedStyle() {
		TestObject phoneIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_mobileIcon")
		assert WebUI.verifyElementPresent(phoneIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(phoneIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
	}

	public static void verifyLogoExisting() {
		TestObject Footerlogo = findTestObject("Object Repository/defaultFooter/footerBody/rightColumn/img_bbb-logo")
		assert WebUI.verifyElementPresent(Footerlogo, GlobalVariable.pageLoadTimeOut)
		String width =WebUI.getCSSValue(Footerlogo, 'width')
		String height=WebUI.getCSSValue(Footerlogo, 'height')
		assert width.equals(GlobalVariable.logoFooterWidth)
		assert height.equals(GlobalVariable.logoFooterHeight)
	}

	public static void  verifyChatLinkExistAndHasExpectedColor() {
		TestObject chatEmail = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/a_chat")
		assert WebUI.verifyElementPresent(chatEmail, GlobalVariable.pageLoadTimeOut)

	}
	public static void  verifychatIconExistingAndHasExpectedColor() {
		TestObject chatIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/span_emailIcon")
		assert WebUI.verifyElementPresent(chatIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(chatIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
	}

	//social media link verification

	public static void  verifyFaceBookIconExistingAndRedirection() {
		TestObject FaceBookIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/a_facebook")
		assert WebUI.verifyElementPresent(FaceBookIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(FaceBookIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)

	}

	public static void  verifyYoutubeIconExistingAndRedirection() {
		TestObject YoutubeIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/a_youtube")
		assert WebUI.verifyElementPresent(YoutubeIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(YoutubeIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
	}

	public static void  verifyInstagramIconExistingAndRedirection() {
		TestObject instagramIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/a_instagram")
		assert WebUI.verifyElementPresent(instagramIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(instagramIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
	}

	public static void  verifylinkedInIconExistingAndRedirection() {
		TestObject linkedInIcon = findTestObject("Object Repository/defaultFooter/footerBody/leftColumn/a_linkedIn")
		assert WebUI.verifyElementPresent(linkedInIcon, GlobalVariable.pageLoadTimeOut)
		String color = WebUI.getCSSValue(linkedInIcon, 'color')
		assert color.equals(GlobalVariable.footerbodyWightColor)
	}



}
