package com.example.search;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchServicePage {
    public SelenideElement buttonPaymentsAndTransfers = $x("//*[@id=\"nonsubmitImpl_5\"]");
    public SelenideElement searchField = $x("//*[@id=\"searchTextField\"]");
    public SelenideElement searchResult = $x("//label[contains(text(), 'HumoCard')]");
    public SelenideElement servicePayment = $x("//span[@class='ib-title-panel-text']");

    public void searchService() {
        buttonPaymentsAndTransfers.shouldBe(Condition.visible);
        buttonPaymentsAndTransfers.click();
        searchField.click();
        searchField.sendKeys("HumoCard");
        searchResult.shouldBe(Condition.visible);
        searchResult.click();
        servicePayment.shouldBe(Condition.visible);
    }
}
