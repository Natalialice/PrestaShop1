package by.diploma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class OrderPage extends AuthenticationPage {
    public SelenideElement checkoutButton = $(byXpath("//a[@href='http://prestashop.qatestlab.com.ua/ru/order?step=1']"));
    public SelenideElement product = $(byXpath("//th[@class='cart_product first_item' and text()='Product']"));
    public SelenideElement total = $(byXpath("//td[@class='total_price_container text-right']/span[text()='Total']"));
    public SelenideElement table = $(byId("cart_summary"));
    public SelenideElement totalPrice = $(byId("total_price"));
}
