package by.diploma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public SelenideElement signIn = $(byClassName("login"));
    public SelenideElement singOut = $(byClassName("logout"));
    public SelenideElement productList = $(byXpath("//ul[@class='product_list grid row']"));
    public SelenideElement popularProductList = $(byId("center_column")); //

    public AuthenticationPage clickSignInButton() {
        executeJavaScript("window.scrollBy(0,-250)");
        signIn.click();
        return new AuthenticationPage();
    }

    public Boolean isLogin() {
        return singOut.isDisplayed();
    }

    public HomePage openHomePage(String url) {
        open(url);
        return new HomePage();
    }

    public HomePage addToCartProductFromHomePage(String productName) {
        executeJavaScript("window.scrollBy(0,500)");
        SelenideElement preProduct = popularProductList.$(byTitle(productName));
        preProduct.hover();
        SelenideElement product = $(byXpath(String.format("//a[contains(text(),'%s')]//ancestor::div[@class='product-container']//a[@title='Add to cart']", productName)));
        product.click();
        return this;

    }
}
