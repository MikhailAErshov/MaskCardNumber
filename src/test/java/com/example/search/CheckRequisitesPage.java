package com.example.search;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckRequisitesPage {
    public SelenideElement maskCardNumber = $x("//label[contains(text(), '** ****')]");
    public SelenideElement buttonNext = $x("//div[@class='ib-button-text']/span[text()='Далее']");
    public SelenideElement servicePayment = $x("//span[@class='ib-title-panel-text']");
}
