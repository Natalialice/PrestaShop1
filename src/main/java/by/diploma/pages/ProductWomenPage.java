package by.diploma.pages;

import static com.codeborne.selenide.Selenide.open;

public class ProductWomenPage {
    public ProductWomenPage Open() {
        open("http://prestashop.qatestlab.com.ua/en/3-women");
        return new ProductWomenPage();
    }}
