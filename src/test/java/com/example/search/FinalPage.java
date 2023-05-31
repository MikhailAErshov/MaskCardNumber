package com.example.search;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FinalPage {
    public SelenideElement statusPay = $x("//span[@class='ib-send-operation-state-value']");
    public SelenideElement maskCardNumber = $x("//label[contains(text(), '** ****')]");
}
