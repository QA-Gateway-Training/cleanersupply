import java.awt.Color

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CategoryScActions
import helpers.CategorySCHelpers as CategorySCHelpers
import helpers.GeneralHelpers as GeneralHelpers
import internal.GlobalVariable as GlobalVariable
import validation.CategoryValidations as CategoryValidations
import validation.CheckOutFormValidation

import helpers.checkOutFormHelper;
import actions.checkOutFormAction

GeneralHelpers.initScenario()
String computerRegister ="Object Repository/Category/a_ComputerRegister"
CategoryScActions.hovertags()
//CategoryValidations.checkanchorHoverColorBackground(tags, GlobalVariable.tagsHoverColor,
//	GlobalVariable.tagsHoverBackgound)
CategorySCHelpers.navigateComputerRegister()

CategoryValidations.validatespanText(GlobalVariable.computerRegisterspan )
CategoryScActions.getDefaultProjectCategoryFilter(GlobalVariable.expectedProductNum) // true on console
CategoryScActions.getDefaultValueOfSortBy(GlobalVariable.sortByDefault)
CategoryScActions.getDefaultManufacturar(GlobalVariable.manufacturarDefault)
CategoryScActions.getDefaultModal(GlobalVariable.defaultmodal)
CategoryScActions.clickOnManuWithassertOPened(GlobalVariable.menuExpandValue)
CategorySCHelpers.selectCasioManufacturar()
CategorySCHelpers.selectModalsp1000()
CategorySCHelpers.EnterCasioSP1000Product()
CategorySCHelpers.ValidateCasioSP1000ProductDetails()
CategorySCHelpers.enterTenItemsFromProduct()
CategorySCHelpers.checkMeniCartBadge()
CategorySCHelpers.navigateToCart()
WebUI.navigateToUrl('https://www.cleanersupply.com/checkout/')
WebUI.maximizeWindow()
checkOutFormHelper.sendCompanyValue()
checkOutFormHelper.sendFnameValue()
checkOutFormHelper.sendlnameValue()
checkOutFormHelper.sendAddress1Value()
checkOutFormHelper.sendAddress2Value()
checkOutFormHelper.sendzipCodeValue()
checkOutFormHelper.sendCityValue()
checkOutFormHelper.sendPhoneValue()
checkOutFormHelper.sendPhoneExtValue()
checkOutFormHelper.sendPhoneExtValue()
checkOutFormHelper.sendemailValue()
String button = "Object Repository/CheckOutForm/button_state"
String aSelector="Object Repository/CheckOutForm/a_state"
String selectedSpan = "Object Repository/CheckOutForm/span_selectedState"
checkOutFormAction.selectStateValue(button,aSelector,selectedSpan)
checkOutFormHelper.sendCreditCardNAme()
checkOutFormHelper.sendCreditCardNum()
checkOutFormHelper.sendCreditCardCVV()
checkOutFormHelper.sendPO()
checkOutFormHelper.sendComment()
checkOutFormAction.clickReviewButton()
