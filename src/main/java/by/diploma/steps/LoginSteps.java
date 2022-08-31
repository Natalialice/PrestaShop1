package by.diploma.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import by.diploma.pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginSteps {
    //MyAccountPage accountPage = new MyAccountPage();
    LoginPage loginPage = new LoginPage();

    @Given("User is on {string}")
    public void openPage(String url) {
        open(url);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User enter email {string}")
    public void userEnterEmailAddress(String loginText) {
        loginPage.enterUserName(loginText);
    }

    @When("User enter password {string}")
    public void userEnterPassword(String passwordText) {
        loginPage.userEnterPassword(passwordText);
    }

    @When("User press Sign in button")
    public void userClickSignInButton() {
        loginPage.userClickSignInButton();
    }

    @When("User press {string} button")
    public void userClickButton(String ButtonName) {
        $(By.xpath("//div/a[contains(text(),\"" + ButtonName + "\")]")).click();

    }

    @When("User press link by text {string}")
    public void userClickLink(String LinkText) {
        $(By.xpath("//a[normalize-space()=" + LinkText + "]")).click();
    }

    @And("User press {string}")
    public void userLogOut(String logout) {
        $(By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/ru/?mylogout=']")).click();
    }

    @And("User back authentication page {string}")
    public void userLoggedOut(String logout) {
        $(By.xpath("//h1[text()='Authentication']")).shouldHave(visible);
        Assert.assertEquals($(By.xpath("//h1[text()='Authentication']")).getText(), "AUTHENTICATION");
    }

    @Then("User went to {string} page")
    public void isInvalidData(String myAccountPage) {
        $(By.xpath("//h1[text()='My account']")).shouldHave(visible);
    }

    @Then("Check error message {string}")
    public void isloginWithInvalidPassword(String error) {
        $(By.xpath("//div[contains(@class, 'alert alert-danger')]//li")).shouldHave(visible);
        Assert.assertEquals($(By.xpath("//div[contains(@class, 'alert alert-danger')]//li")).getText(), "Invalid password.");
    }

    @And("Message {string} appeared on the page")
    public void isLoginWithEmptyEmail(String error) {
        $(By.xpath("//div[contains(@class, 'alert alert-danger')]//li")).shouldHave(visible);
        Assert.assertEquals($(By.xpath("//div[contains(@class, 'alert alert-danger')]//li")).getText(), "Email is required.");
    }

    @Then("User sees an error message {string}")
    public void isLoginWithEmptyPassword(String error) {
        $(By.xpath("//div[contains(@class, 'alert alert-danger')]//li")).shouldHave(visible);
        Assert.assertEquals($(By.xpath("//div[contains(@class, 'alert alert-danger')]//li")).getText(), "Password is required.");
    }
}
