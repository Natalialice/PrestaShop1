package by.diploma.steps;

import by.diploma.pages.ItemPage;
import by.diploma.pages.OrderPage;
import by.diploma.pages.ProductWomenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;


public class ItemSteps {
    public ItemPage itemPage = new ItemPage();
    public ProductWomenPage productWomenPage = new ProductWomenPage();
    public OrderPage orderPage = new OrderPage();

    @When("User went to Item page")
    public void userWentToItemPage() {
        itemPage.itemName.shouldHave(visible);
    }

    @And("Added product to cart")
    public OrderPage clickAddToCartButton() {
        itemPage.addToCartButton.click();
        productWomenPage.clickShoppingCartButton();
        orderPage.checkoutButton.click();
        orderPage.formYourAddresses.isDisplayed();
        return new OrderPage();
    }
}
