package by.diploma.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductWomenPage extends AuthenticationPage {
    private final String url = "http://prestashop.qatestlab.com.ua/en/3-women";
    public SelenideElement layerCart = $(byId("layer_cart"));
    private SelenideElement proceedToCheckoutButton = $(byXpath("//a[@class='btn btn-default button button-medium']"));
    private SelenideElement shoppingCartButton = $(byXpath("//div[@class='shopping_cart']//a[@title='View my shopping cart']"));
    public SelenideElement nameProduct = $(byXpath("//a[@class='product-name' and contains(text(), 'Floral Top')]"));

    public ProductWomenPage OpenWomenPage() {
        open(this.url);
        return new ProductWomenPage();
    }

    public ProductWomenPage addToCartProductFromWomenPage(String productName) {
        executeJavaScript("window.scrollBy(0,200)");
        SelenideElement preProduct = productList.$(byTitle(productName));
        preProduct.hover();
        SelenideElement product = $(byXpath(String.format("//a[contains(text(),'%s')]//ancestor::div[@class='product-container']//a[@title='Add to cart']", productName)));
        product.click();
        return this;
    }

    public OrderPage clickCheckoutButton() {
        proceedToCheckoutButton.click();
        return new OrderPage();
    }

    public ProductWomenPage clickNumberPage(String numberPage) {
        SelenideElement page = $(byXpath(String.format("//a[@href='http://prestashop.qatestlab.com.ua/en/3-women#/page-1']//span[text()='%s']", numberPage)));
        page.click();
        return this;
    }

    public ProductWomenPage clickShoppingCartButton() {
        shoppingCartButton.click();
        return new ProductWomenPage();
    }

    public ItemPage clickNameProduct() {
        nameProduct.click();
        return new ItemPage();
    }

    public ItemPage userChooseProduct(String productName) {
        executeJavaScript("window.scrollBy(0,2000)");
        clickNameProduct();
        return new ItemPage();
    }

}

