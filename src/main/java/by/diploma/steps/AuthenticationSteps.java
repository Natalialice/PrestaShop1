package by.diploma.steps;


import by.diploma.pages.AuthenticationPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AuthenticationSteps {

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Given("User is on {string}")
    public void openPage(String url) {
        authenticationPage.openHomePage(url);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User click Sign In button")
    public void clickSignInButton() {
        authenticationPage.clickSignInButton();
    }

    @When("User enter email {string} and password {string}")
    public void userEnterEmailAddressAndPassword(String loginText, String passwordText) {
        authenticationPage.enterUserEmail(loginText).enterUserPassword(passwordText);
    }

    @When("User press SubmitLogin button")
    public void userClickSignInButton() {
        authenticationPage.clickSubmitLoginButton();
    }

    @And("User press Sign out button")
    public void userPressSignOutButton() {
        authenticationPage.clickSignOutButton();
    }

    @Then("User went to My account page")
    public void userIsLogin() {
        Assert.assertTrue(authenticationPage.isLogin());
    }

    @Then("User back Authentication page")
    public void userIsNotLogin() {
        Assert.assertFalse(authenticationPage.isLogin());
    }


    @Then("Check error message {string}")
    public void userSeesAnError(String text) {
        authenticationPage.errorMessage.shouldHave(Condition.text(text));

    }
}
