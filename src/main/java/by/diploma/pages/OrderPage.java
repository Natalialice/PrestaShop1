package by.diploma.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OrderPage extends AuthenticationPage {
    public SelenideElement checkoutButton = $(byXpath("//span[text()='Proceed to checkout']"));
    public SelenideElement product = $(byXpath("//th[@class='cart_product first_item' and text()='Product']"));
    public SelenideElement total = $(byXpath("//td[@class='total_price_container text-right']/span[text()='Total']"));
    public SelenideElement totalPrice = $(byId("total_price"));
    public SelenideElement tableCart_summary = $(byXpath("//table[@id]"));
    public SelenideElement deleteButton = $(byXpath("//a[contains(text(),'Stripe Top')]//ancestor::tr[@class='cart_item last_item first_item address_0 odd']//a[@title='Delete']"));
    public SelenideElement alertWarningMessage = $(byClassName("alert-warning"));
    public SelenideElement formYourAddresses = $(byXpath("//form[@id='add_address']"));

    public void deleteProductFromCartTable() {
        tableCart_summary.shouldHave(Condition.visible);
        deleteButton.click();
    }

    public void pressCheckoutButton() {
        checkoutButton.click();
    }


}
