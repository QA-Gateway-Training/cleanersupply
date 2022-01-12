import java.awt.Color

import actions.CategoryScActions
import helpers.CategorySCHelpers as CategorySCHelpers
import helpers.GeneralHelpers as GeneralHelpers
import internal.GlobalVariable as GlobalVariable
import validation.CategoryValidations as CategoryValidations

GeneralHelpers.initScenario()


String computerRegister ="Object Repository/Category/a_ComputerRegister"
CategoryScActions.hovertags()


//CategoryValidations.checkanchorHoverColorBackground(tags, GlobalVariable.tagsHoverColor,
//	GlobalVariable.tagsHoverBackgound)
CategorySCHelpers.navigateComputerRegister()

CategoryValidations.validatespanText(GlobalVariable.computerRegisterspan )