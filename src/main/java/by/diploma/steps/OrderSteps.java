package by.diploma.steps;

import by.diploma.pages.OrderPage;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class OrderSteps {
    OrderPage orderPage = new OrderPage();

    @And("Delete product from cart")
    public void deleteProductFromCartTable() {
        orderPage.deleteProductFromCartTable();
        orderPage.pressCheckoutButton();
        Assert.assertEquals((orderPage.alertWarningMessage).getText(), "Your shopping cart is empty.");
    }

    @And("User check total price {string}")
    public void userCheckTotalPrice(String totalPrice) {
        Assert.assertEquals((orderPage.totalPrice).getText(), totalPrice);
    }
}
