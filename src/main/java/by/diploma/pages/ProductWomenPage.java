package by.diploma.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class ProductWomenPage extends AuthenticationPage {
    private final String url = "http://prestashop.qatestlab.com.ua/en/3-women";
    private SelenideElement productList = $(byClassName("product_list"));
    public SelenideElement layerCart = $(byId("layer_cart"));
    private ElementsCollection categoriesCheckBoxes = $$("#ul_layered_category_0 a");
    private ElementsCollection colorCheckBoxes = $$("#ul_layered_id_attribute_group_3 a");
    private SelenideElement enabledFilterst = $("#enabled_filters");
    private SelenideElement proceedToCheckoutButton = $(byXpath("//a[@class='btn btn-default button button-medium']"));

    public ProductWomenPage OpenWomenPage() {
        open(this.url);
        return new ProductWomenPage();
    }

    public ProductWomenPage addToCartProduct(String productName) {
        SelenideElement preProduct = productList.$(byTitle(productName));
        preProduct.hover();
        SelenideElement product = $(byXpath(String.format("//a[contains(text(),'%s')]//ancestor::div[@class='product-container']//a[@title='Add to cart']", productName)));
        product.click();
        return this;
    }
    public OrderPage clickCheckoutButton() {
        proceedToCheckoutButton.click();
        return new OrderPage();}

    public ProductWomenPage setCategoriesByName(String checkboxName) {
        categoriesCheckBoxes.findBy(Condition.text(checkboxName)).click();
        enabledFilterst.shouldHave(Condition.text(String.format("Categories: %s", checkboxName)));
        return this;
    }

    public ProductWomenPage setColorByName(String checkBoxName) {
        colorCheckBoxes.findBy(Condition.text(checkBoxName)).click();
        enabledFilterst.shouldHave(Condition.text(String.format("Color: %s", checkBoxName)));
        return this;
    }
}
