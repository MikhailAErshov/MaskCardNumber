package com.example.search;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;

public class ServicePaymentPage {
    public SelenideElement inputName = $x("//input[@class='enabled-field  ']");
    public SelenideElement inputCardnumber = $x("//input[@aria-label='Номер карты']");
    public SelenideElement inputSum = $x("//input[@aria-label='Сумма перевода']");
    public SelenideElement buttonNext = $x("//div[@class='ib-button-text']/span[text()='Далее']");
    public SelenideElement servicePayment = $x("//span[@class='ib-title-panel-text']");

    public void inputRequisites() {
        Random generator = new Random(System.currentTimeMillis());
        Long cardNum = generator.nextLong() % 1000000000000L;

        inputName.click();
        inputName.sendKeys("Check field");
        inputCardnumber.click();
        inputCardnumber.sendKeys(cardNum.toString());
        inputSum.click();
        inputSum.sendKeys("100.99");
        buttonNext.click();
        servicePayment.shouldBe(Condition.visible);
    }
}
