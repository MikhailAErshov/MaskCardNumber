package com.example.search;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ConfirmPage {
    public SelenideElement maskCardNumber = $x("//label[contains(text(), '** ****')]");
    public SelenideElement buttonPay = $x("//div[@class='ib-button-text']/span[contains(text(), 'Оплатить')]");
}
