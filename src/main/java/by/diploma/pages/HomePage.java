package by.diploma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    public SelenideElement signIn = $(byClassName("login"));
    public SelenideElement singOut = $(byClassName("logout"));

    public AuthenticationPage clickSignInButton() {
        signIn.click();
        return new AuthenticationPage();
    }

    public Boolean isLogin() {
        return singOut.isDisplayed();
    }

    public HomePage openHomePage(String url) {
        open(url);
        return new HomePage();
    }

}
