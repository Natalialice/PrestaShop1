package by.diploma.pages;

import static com.codeborne.selenide.Selenide.open;

public class MyAccountPage {
    public MyAccountPage openMyAccountPage(String url) {
        open(url);
        return new MyAccountPage();
    }
}
