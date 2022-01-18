import java.awt.Color as Color
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import actions.CategoryScActions as CategoryScActions
import helpers.CategorySCHelpers as CategorySCHelpers
import helpers.GeneralHelpers as GeneralHelpers
import internal.GlobalVariable as GlobalVariable
import validation.CategoryValidations as CategoryValidations
import validation.CheckOutFormValidation as CheckOutFormValidation
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import helpers.checkOutFormHelper as checkOutFormHelper
import actions.checkOutFormAction as checkOutFormAction
import helpers.MiniCartHelpers as MiniCartHelpers
import actions.MiniCartActions as MiniCartActions
import helpers.ShoppingCartHelpers as ShoppingCartHelpers
import helpers.CheckoutPageHelpers as CheckoutPageHelpers
import validation.GeneralValidation as GeneralValidation
import validation.CheckoutPageValidation
import helpers.PrimaryHeaderHelpers

GeneralHelpers.initScenario()
PrimaryHeaderHelpers.cartLinkHover()
String computerRegister = 'Object Repository/Category/a_ComputerRegister'

//CategoryValidations.checkHoverFlyMenuUNVisibility()
CategoryScActions.hovertags()

String tags = 'Object Repository/Category/a_tags'

CategoryValidations.checkanchorHoverColorBackground(tags, GlobalVariable.moveColr, GlobalVariable.whiteColor)

CategoryValidations.checkHoverFlyMenuVisibility()

CategorySCHelpers.navigateComputerRegister( // navigation assertion and action 
    )

 TestObject header = findTestObject('Object Repository/Category/h1_computerRegisterTags' // verify header
    )

GeneralValidation.verifyPageHeader(header, GlobalVariable.computerRegisterHeader)

CategoryValidations.validatespanText(GlobalVariable.computerRegisterspan // breadcrumb
    )

CategoryScActions.getDefaultProjectCategoryFilter(GlobalVariable.expectedProductNum // true on console
    )

CategoryScActions.getDefaultValueOfSortBy(GlobalVariable.sortByDefault)

CategoryScActions.getDefaultManufacturar(GlobalVariable.manufacturarDefault)

CategoryScActions.getDefaultModal(GlobalVariable.defaultmodal)

CategorySCHelpers.checkCollabse("Object Repository/Category/div_collabse1")

CategoryScActions.clickOnManuWithassertOPened(GlobalVariable.menuExpandValue // click and assert drop down for manufacturar
    )

CategorySCHelpers.selectCasioManufacturar()

CategorySCHelpers.selectModalsp1000()

CategorySCHelpers.EnterCasioSP1000Product()

CategorySCHelpers.ValidateCasioSP1000ProductDetails()
CategoryValidations.validateProductDetailsText(GlobalVariable.broductBreadCrump)

CategorySCHelpers.enterTenItemsFromProduct()

MiniCartActions.navigateToCartPage()

ShoppingCartHelpers.navigateToCartPage()

ShoppingCartHelpers.navigateToCheckoutPage()

CheckoutPageHelpers.initCheckoutPage()

CheckoutPageHelpers.navigateToCheckoutInformationForm()

checkOutFormHelper.fillCheckOutForm()

CheckoutPageValidation.verifyNavigationToCheckoutDetails()
CheckoutPageHelpers.ShippingAddressDiv()
CheckoutPageHelpers.verifyShippingDetailsInCeckout()
CheckoutPageHelpers.standardShippingAddress()
CheckoutPageHelpers.paymentMethodDiv()
CheckoutPageHelpers.verifyPaymentMethodDetails()

WebUI.closeBrowser()