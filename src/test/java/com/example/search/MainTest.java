package com.example.search;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class MainTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    SearchServicePage searchServicePage = new SearchServicePage();
    ServicePaymentPage servicePaymentPage = new ServicePaymentPage();
    CheckRequisitesPage checkRequisitesPage = new CheckRequisitesPage();
    ConfirmPage confirmPage = new ConfirmPage();
    FinalPage finalPage = new FinalPage();

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://test04.rshb.ru/cas-auth/index";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "none";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("/");
        authorizationPage.checkAuthorization();
        sleep(5000);
        searchServicePage.searchService();
        sleep(3000);
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void checkMaskCardNumberWhenFilledPaymentDetails() {
        servicePaymentPage.inputRequisites();
        sleep(5000);
        checkRequisitesPage.maskCardNumber.shouldBe(visible);
        checkRequisitesPage.buttonNext.click();
        checkRequisitesPage.servicePayment.shouldBe(visible);

        confirmPage.maskCardNumber.shouldBe(visible);
        confirmPage.buttonPay.click();

        finalPage.statusPay.shouldBe(text("Выполняется"), visible);
        finalPage.maskCardNumber.shouldBe(visible);
    }
}
