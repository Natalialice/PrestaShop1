package by.diploma.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthenticationPage extends HomePage {
    private SelenideElement emailField = $(byId("email"));
    private SelenideElement passwordFild = $(byId("passwd"));
    private SelenideElement submitLogin = $(byId("SubmitLogin"));

    public SelenideElement errorMessage = $(byClassName("alert-danger"));


    public AuthenticationPage openHomePage(String url) {
        open(url);
        return new AuthenticationPage();
    }

    public AuthenticationPage enterUserEmail(String loginText) {
        emailField.sendKeys(loginText);
        return new AuthenticationPage();
    }

    public AuthenticationPage enterUserPassword(String passwordText) {
        passwordFild.sendKeys(passwordText);
        return new AuthenticationPage();
    }

    public MyAccountPage clickSubmitLoginButton() {
        submitLogin.click();
        return new MyAccountPage();
    }

    public AuthenticationPage clickSignOutButton() {
        singOut.click();
        return new AuthenticationPage();
    }

    public Boolean errorMessage(String error_text) {

        if (errorMessage.shouldHave(Condition.text(error_text)).isDisplayed()) {
            return true;
        }
        return false;
    }

}