package com.akbr.pages;

import org.openqa.selenium.By;

import com.akbr.base.BaseTest;

public class ShoppingCart extends BaseTest{


	public By orderByItemTextBoxSku=By.xpath("(//input[@data-auid='CartSummary_OdFormElement_Element'])[1]");


	public By orderByItemTextBoxQty=By.xpath("(//input[@data-auid='CartSummary_OdFormElement_Element'])[2]");

	public By orderByItemButtonAddToCart=By.xpath("//button[@data-auid='CartSummary_OdButton_OrderByItemSectionAddToCart']");


	public By shoppingCartButtonInterstitial=By.xpath("//a[contains(text(),'Shopping Cart')]");

	public By shoppingCartHeader=By.xpath("//span[@data-auid='cart_header_shoppingCart']");

	public By cart_link_continueShopping=By.xpath("//a[@data-auid='cartHeader_button_ContinueShopping']");

	public By carHometIcon=By.xpath("//span[@class='od-header-badge-text']");

	public By shoppingCartHeaders=By.xpath("//span[@data-auid='cart_header_shoppingCart']");


	public ShoppingCart addItemToCartByOBI(String sku, int qty)
	{
		WaitForElementToAppear();
		getShoppingCartPage();
		scrollTillObjectIsVisible(orderByItemTextBoxSku);
		clearAndSendKey(orderByItemTextBoxSku, sku);
		clearAndSendKey(orderByItemTextBoxQty, String.valueOf(qty));
		click(orderByItemButtonAddToCart);
		paddedWait();
		jsClick(shoppingCartButtonInterstitial);

		return new ShoppingCart();
	}

	public ShoppingCart getShoppingCartPage() {

		if(isPresentAndDisplayed(shoppingCartHeaders)) {
			System.out.println("You are on ShoppingCart Page");
		}
		else{
			click(carHometIcon);
			WaitForElementToAppear();
			verifyElementPresentOnPage(shoppingCartHeader);
			verifyTextExistsOnElement(shoppingCartHeader,"Shopping Cart");
		}

		return new ShoppingCart();
	}



}
