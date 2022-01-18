import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import helpers.GeneralHelpers as GeneralHelpers
import validation.defaultFooterValidatins as defaultFooterValidatins
import actions.defaultFooterActions as defaultFooterActions
import helpers.defaultFooterHelpers as defaultFooterHelpers
//switch to defaultwindow index 0 
GeneralHelpers.initScenario()

defaultFooterValidatins.verifyExistingOftopFooterImage()

defaultFooterValidatins.verifyBackGroundandMaxHeightOfTopFooter()

defaultFooterValidatins.verifyExistingOffooterBody()

defaultFooterValidatins.verifyBackGroundandPaddingOfFooterBody()

defaultFooterValidatins.verifyExistingOffooterBodyRightColomn()

defaultFooterValidatins.verifyExistingOffooterBodyMiddleColomn()

defaultFooterValidatins.verifyExistingOffooterBodyLeftColomn()

defaultFooterValidatins.verifyRequestCatalogueLink()

defaultFooterValidatins.verifycassifiedListLink()

defaultFooterValidatins.verifyExistingOfRegionButtonandClickable()

defaultFooterValidatins.verifyClickingOnFeedBackButtonShowPopUP()

defaultFooterValidatins.fillModalWithAssertValueAndClose()

defaultFooterActions.clickpreviouslyOrdered()

defaultFooterValidatins.verifyClickingPreviouslyOrdered()

defaultFooterActions.clickQuickOrder()

defaultFooterValidatins.verifyExistingOfLeftFooterTitle()

defaultFooterValidatins.verifyExistingOfLeftFooterSubTitle()

defaultFooterValidatins.verifyExistingOfEmailAndValidatingIt()

defaultFooterActions.fillEmailSubscriber()

defaultFooterActions.clickOnSignUpSubscriber()

defaultFooterValidatins.verifyExistingOfConnectUsTitleandhasexpectedTitle()

defaultFooterValidatins.verifyEmailContactAddresAndHasExpectedAddress()

defaultFooterValidatins.verifyExistingangOfEmailIconAndHasExpectedStyle()

defaultFooterValidatins.verifyContactInfoAddressAsExpected()

defaultFooterValidatins.verifyExistingangOfPhoneIconAndHasExpectedStyle()

String english = 'Object Repository/defaultFooter/footerBody/leftColumn/div_englishSpeaking'

defaultFooterHelpers.verifyPresentOfContactNumberasExpectedTextAndStyle(english, GlobalVariable.englishContact)

String korean = 'Object Repository/defaultFooter/footerBody/leftColumn/div_koreanSpeaking'

defaultFooterHelpers.verifyPresentOfContactNumberasExpectedTextAndStyle(korean, GlobalVariable.koreanSpeaking)

String international = 'Object Repository/defaultFooter/footerBody/leftColumn/div_internationalOrders'

defaultFooterHelpers.verifyPresentOfContactNumberasExpectedTextAndStyle(international, GlobalVariable.internationalOrdersContact)

defaultFooterValidatins.verifyLogoExisting()

defaultFooterValidatins.verifyFaceBookIconExistingAndRedirection()

defaultFooterValidatins.verifyYoutubeIconExistingAndRedirection()

defaultFooterValidatins.verifyInstagramIconExistingAndRedirection()

defaultFooterValidatins.verifylinkedInIconExistingAndRedirection()