package by.diploma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ItemPage extends HomePage {
    public SelenideElement itemName = $(byXpath("//h1[@itemprop='name' and text()='Floral Top  ']"));
    public SelenideElement addToCartButton = $(byXpath("//button[@type='submit' and span='Add to cart']"));

}