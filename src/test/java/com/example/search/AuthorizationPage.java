package com.example.search;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {
    public SelenideElement buttonFalse = $x("//div[@class='dialog-content-panel_button-wrapper dialog-content-centered']/*[@class='submit-btn']");
    public SelenideElement inputLogin = $x("//*[@id='login-input']");
    public SelenideElement inputPassword = $x("//*[@id='password']");
    public SelenideElement buttonSubmit = $x("//button[@type='submit']");
    public SelenideElement inputPasswordFieldLogin = $x("//*[@id='passwordField_login']");
    public SelenideElement buttonConfirm = $x("//*[@class='ib-button-text']/span[text()='Подтвердить']");

    public void checkAuthorization() {
        buttonFalse.click();
        inputLogin.sendKeys("GRIBANOVA41");
        inputPassword.sendKeys("QW34er%^");
        buttonSubmit.click();
        inputPasswordFieldLogin.click();
        inputPasswordFieldLogin.sendKeys("12345");
        buttonConfirm.shouldBe(Condition.visible);
        buttonConfirm.click();
    }
}
