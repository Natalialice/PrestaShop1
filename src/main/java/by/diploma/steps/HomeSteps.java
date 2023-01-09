package by.diploma.steps;

import by.diploma.pages.HomePage;
import by.diploma.pages.ItemPage;
import io.cucumber.java.en.When;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @When("User adds the product {string} to the cart from Home page")
    public ItemPage chooseProductFromHomePage(String productName){
        homePage.openHomePage("http://prestashop.qatestlab.com.ua/en/");
        homePage.addToCartProductFromHomePage(productName);
        return new ItemPage();
    }

}
