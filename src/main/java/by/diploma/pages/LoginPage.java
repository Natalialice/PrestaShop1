package by.diploma.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;



import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public LoginPage Open() {
        open("http://prestashop.qatestlab.com.ua/en/authentication");
        return new LoginPage();
    }
    public LoginPage enterUserName(String loginText){
        $(By.xpath("//input[@id='email']")).sendKeys(loginText);
        return new LoginPage();
    }
    public LoginPage userEnterPassword(String passwordText) {
        $(By.xpath("//input[@id='passwd']")).sendKeys(passwordText);
        return new LoginPage();
    }

    public MyAccountPage userClickSignInButton() {
        $(By.xpath("//button[@id='SubmitLogin']")).click();
        return new MyAccountPage();
    }

}