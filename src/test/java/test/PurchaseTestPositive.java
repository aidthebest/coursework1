package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.DbInfo;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTestPositive {

    PurchasePage purchasePage;

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
        purchasePage = new PurchasePage();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void buyTestApproveCard() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.successMesage();
        assertEquals("APPROVED", DbInfo.getStatusDebitCard());
    }

    @Test
    public void buyTestApproveCreditCard() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.successMesage();
        assertEquals("APPROVED", DbInfo.getStatusCredit());
    }
}
