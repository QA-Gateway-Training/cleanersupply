import java.awt.Color

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject

import actions.CategoryScActions
import helpers.CategorySCHelpers as CategorySCHelpers
import helpers.GeneralHelpers as GeneralHelpers
import internal.GlobalVariable as GlobalVariable
import validation.CategoryValidations as CategoryValidations
import validation.CheckOutFormValidation
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import helpers.checkOutFormHelper;
import actions.checkOutFormAction

import helpers.MiniCartHelpers 
import actions.MiniCartActions
import helpers.ShoppingCartHelpers
import helpers.CheckoutPageHelpers
GeneralHelpers.initScenario()

String computerRegister ="Object Repository/Category/a_ComputerRegister"
//CategoryValidations.checkHoverFlyMenuUNVisibility()
CategoryScActions.hovertags()
String tags = "Object Repository/Category/a_tags"
CategoryValidations.checkanchorHoverColorBackground(tags, GlobalVariable.moveColr,
GlobalVariable.tagsHoverBackgound)
CategoryValidations.checkHoverFlyMenuVisibility()
CategorySCHelpers.navigateComputerRegister()

CategoryValidations.validatespanText(GlobalVariable.computerRegisterspan )
CategoryScActions.getDefaultProjectCategoryFilter(GlobalVariable.expectedProductNum) // true on console
CategoryScActions.getDefaultValueOfSortBy(GlobalVariable.sortByDefault)
CategoryScActions.getDefaultManufacturar(GlobalVariable.manufacturarDefault)
CategoryScActions.getDefaultModal(GlobalVariable.defaultmodal)
//CategoryScActions.clickOnManuWithassertOPened(GlobalVariable.menuExpandValue)
//CategorySCHelpers.selectCasioManufacturar()
CategorySCHelpers.selectModalsp1000()
CategorySCHelpers.EnterCasioSP1000Product()
CategorySCHelpers.ValidateCasioSP1000ProductDetails()
CategorySCHelpers.enterTenItemsFromProduct()
//CategorySCHelpers.checkMeniCartBadge()
//CategorySCHelpers.navigateToCart()
//WebUI.navigateToUrl('https://www.cleanersupply.com/checkout/')
//WebUI.maximizeWindow()
MiniCartHelpers.hoverOnMiniCartHeader()
MiniCartActions.navigateToCartPage()

ShoppingCartHelpers.navigateToCartPage()
ShoppingCartHelpers.navigateToCheckoutPage()

CheckoutPageHelpers.initCheckoutPage()
CheckoutPageHelpers.navigateToCheckoutInformationForm()
checkOutFormHelper.fillCheckOutForm()
