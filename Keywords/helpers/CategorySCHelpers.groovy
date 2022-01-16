package helpers
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject

import actions.CategoryScActions
import actions.ProductDetailsActions
import internal.GlobalVariable
import validation.GeneralValidation
import validation.CategoryValidations
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement


public class CategorySCHelpers {
	/***
	 * @author Razan
	 * get object's selector, hover and click it
	 * @param selector
	 */

	//	public static void navigateTotags(String selector){
	//
	//		CategoryScActions.hoveranchor("Object Repository/Category/a_ComputerRegister")
	//		//CategoryScActions.ClickObject(selector)
	//	}

	/***
	 * hover, navigate to computer and register with url and title assertion
	 * @author Razan
	 */

	public static void navigateComputerRegister() {
		String computerRegister = "Object Repository/Category/a_ComputerRegister"
		WebUI.mouseOver(findTestObject(computerRegister))
		String hoverColor = CategoryScActions.getcssvvalueforTagsColor(computerRegister)
		assert	hoverColor.equals(GlobalVariable.moveColr)
		String transform =WebUI.getCSSValue(findTestObject(computerRegister), "text-transform")
		assert	transform.equals(GlobalVariable.upperCaseTransform)
		WebUI.click(findTestObject(computerRegister))
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.computerRegisterURL)
		GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.computerRegisterTitle)
	}

	public static void selectCasioManufacturar() {
		TestObject manuDefault = findTestObject("Object Repository/Category/a_casio")
		WebUI.click(manuDefault)
		//add loading verification
		TestObject casioSelect = findTestObject("Object Repository/Category/button_afterSelectCasio")
		String text = WebUI.getAttribute(casioSelect, "title")
		assert text.equals(GlobalVariable.CasioSelect)
		TestObject firstSelectedFilter = findTestObject("Object Repository/Category/a_casioSelectedFilter")
		String casio = WebUI.getText(firstSelectedFilter)
		assert casio.equals(GlobalVariable.CasioSelect)
		
		List<WebElement> filteredList = WebUI.findWebElements(findTestObject('Object Repository/Category/li_filteredList'), GlobalVariable.globalTimeOut) 
		CategoryScActions.getDefaultProjectCategoryFilter(filteredList.size().toString()) // false on console

	}

	public static void checkCollabse(String Selector) {
		TestObject divCollapse = findTestObject(Selector)
		WebUI.verifyElementAttributeValue(divCollapse, 'aria-expanded', 'true',2)
	}

	public static void selectModalsp1000() {
		checkCollabse("Object Repository/Category/div_collabse1")
		TestObject modal = findTestObject("Category/button_modalNum")
		WebUI.click(modal)
		//add loading verification
		TestObject modalSelect = findTestObject("Object Repository/Category/a_sp001")
		WebUI.click(modalSelect)
		String text = WebUI.getAttribute(modalSelect, "title")
		text.equals(GlobalVariable.modalSelect)
		TestObject secondSelectedFilter = findTestObject("Object Repository/Category/A_SP001selectedFilter")
		String sp001 = WebUI.getText(secondSelectedFilter)
		sp001.equals(GlobalVariable.modalSelect)
		
//		List<WebElement> filteredList = WebUI.findWebElements(findTestObject('Object Repository/Category/li_filteredList'), GlobalVariable.globalTimeOut)
//		
//		CategoryScActions.getDefaultProjectCategoryFilter(filteredList.size().toString()) // false on console

	}


	public static void EnterCasioSP1000Product() {
		String titleSelector = "Object Repository/Category/sp001Casiprodoct/h2_sp1000CasioTitle"
		String minPriceSelector ="Object Repository/Category/sp001Casiprodoct/span_SP1000CasioProductMinPrice"
		String maxPrice = "Object Repository/Category/sp001Casiprodoct/span_sp1000CasioProductMaxPrice"
		String image = "Object Repository/Category/sp001Casiprodoct/img_casioSP1000"
		CategoryValidations.validateText(titleSelector,GlobalVariable.sp1000casioproductTitle)
		CategoryValidations.validateText(minPriceSelector,GlobalVariable.sp1000casioproductMinPrice)
		CategoryValidations.validateText(maxPrice, GlobalVariable.sp1000casioproductMaxPrice)
		TestObject productClick = findTestObject("Object Repository/Category/sp001Casiprodoct/a_product")
		WebUI.click(productClick)

	}

	public static void ValidateCasioSP1000ProductDetails() {
		String productName= "Object Repository/Category/sp1000CasioProductDetails/h1_sp1000CasioProduct"
		String productPrice="Object Repository/Category/sp1000CasioProductDetails/span_productPrice"
		String inStock = "Object Repository/Category/sp1000CasioProductDetails/div_InStock"
		CategoryValidations.validateText(productName, GlobalVariable.sp1000casioproductTitle)
		//CategoryValidations.validateText(inStock,GlobalVariable.instockText)
		//CategoryValidations.validatePrice(productPrice,GlobalVariable.sp1000Casioprice)

	}

	public static void enterTenItemsFromProduct() {
		CategoryValidations.validateCartNo(GlobalVariable.initialCartBadge)
		String qty = "Object Repository/Category/sp1000CasioProductDetails/input_quantity"
		TestObject textSelector = findTestObject(qty)
		WebUI.clearText(textSelector)
		WebUI.sendKeys(textSelector, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(textSelector, GlobalVariable.itemsQty10)
		WebUI.click(findTestObject("Object Repository/Category/sp1000CasioProductDetails/h1_sp1000CasioProduct"))
		TestObject addToCart = findTestObject("Object Repository/Category/sp1000CasioProductDetails/button_addToCart")
		//WebUI.mouseOver(addToCart)
//		WebUI.click(addToCart)
		ProductDetailsActions.addToCartAction()
//		CategoryValidations.validateCartNo(GlobalVariable.afterAdd10ItemsBadge)
		GeneralValidation.verifyCurrentPageTitleIsNotEmpty()


	}

	public static BigDecimal formatNumber(String selector){
		TestObject cartLabelTotalPrice = findTestObject(selector)
		String Actualprice =WebUI.getText(cartLabelTotalPrice)
		String Formatedprice = Actualprice.replace('$',"")
		BigDecimal FormatedDecimalPrice = new BigDecimal(Formatedprice)
		return FormatedDecimalPrice
	}

	public static void checkEqualityNumber(BigDecimal Price,BigDecimal Expected) {

		WebUI.verifyEqual(Price, Expected)

	}

	public static void checkMeniCartBadge() {
		String priceLabelCart = "Object Repository/Category/labelCart"
		BigDecimal actual = formatNumber(priceLabelCart)
		BigDecimal expected =new BigDecimal(GlobalVariable.total10)
		checkEqualityNumber(actual,expected)

	}


	public static void navigateToCart() {
		TestObject CartNavigate = findTestObject("Object Repository/Category/a_cart")
		WebUI.click(CartNavigate)
		GeneralValidation.verifyCurrentPageURL(GlobalVariable.cartURL)
		GeneralValidation.verifyCurrentPageTitleValue(GlobalVariable.cartTitle)

	}





}

