package by.diploma.steps;

import by.diploma.pages.AuthenticationPage;
import by.diploma.pages.ProductWomenPage;
import by.diploma.pages.OrderPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;

public class ProductWomanSteps {
    public ProductWomenPage productWomenPage = new ProductWomenPage();
    public AuthenticationPage authenticationPage = new AuthenticationPage();
    public OrderPage orderPage = new OrderPage();

    @When("Open authentication page and log in with valid data")
    public void openAuthenticationPageAndLogInWithValidData() {
        authenticationPage.clickSignInButton()
                .enterUserEmail("rey@tut.by")
                .enterUserPassword("123456")
                .clickSubmitLoginButton();
        productWomenPage.OpenWomenPage();
    }

    @Then("User adds the product {string} to the cart")
    public void userAddToCartProduct(String productName) {
        productWomenPage.addToCartProduct(productName);
        productWomenPage.layerCart.shouldBe(visible);
    }

    @When("User press checkout button")
    public OrderPage userPressCheckoutButton() {
        productWomenPage.clickCheckoutButton();
        return new OrderPage();
    }

    @When("Open Women page")
    public ProductWomenPage openWomenPage() {
        productWomenPage.OpenWomenPage();
        return new ProductWomenPage();
    }

    @Then("User went to Order page")
    public void userWentToSoppingCartSummary() {
        orderPage.product.shouldHave(visible);
        orderPage.total.shouldHave(visible);
    }

}
