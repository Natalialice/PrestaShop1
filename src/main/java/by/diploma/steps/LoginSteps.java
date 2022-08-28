package by.diploma.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginSteps {
    //MyAccountPage accountPage = new MyAccountPage();

    @Given("User is on {string} page")
    public void userIsOnPage(String pageAddress) {
        open(pageAddress);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
    }

    @When("User enter login {string}")
    public void userEnterlogin(String loginText) {
        $(By.id("email")).sendKeys(loginText);
    }

    @When("User enter password {string}")
    public void userEnterPassword(String passwordText) {
        $(By.id("passwd")).sendKeys(passwordText);
    }

    @When("User press {string} button")
    public void userClickSingInButton(String singInButton) {
        $(By.id("SubmitLogin")).click();
    }

    @And("User press {string}")
    public void userLogOut(String logout) {
        $(By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/ru/?mylogout=']")).click();
    }

    @And("User back authentication page {string}")
    public void userBackAuthenticationPage(String logout) {
        $(By.xpath("//h1[text()='Authentication']"));
    }

    @Then("User went to {string} page")
    public void isInvalidData(String myAccountPage) {
        $(By.xpath("//h1[text()='My account']")).shouldHave();
    }

    @Then("Error message {string}")
    public void isloginWithInvalidEmailResult(String error) {
        $(By.xpath("//div[@class='alert alert-danger']//p[text()='There is 1 error']")).shouldHave(); // найти локатор на надписи инвалид емаил
    }

    @Then("Message {string}")
    public void isLoginWithEmptyEmailResult(String error) {
        $(By.xpath("//div[@class='alert alert-danger']//p[text()='There is 1 error']")).shouldHave(); // найти локатор на надписи An email address required.
  }
    @Then("User sees an error message {string}")
    public void isLoginWithEmptyPasswordResult(String error) {
        $(By.xpath("//div[@class='alert alert-danger']//p[text()='There is 1 error']")).shouldHave(); // найти локатор на надписи An password required.
    }
}
