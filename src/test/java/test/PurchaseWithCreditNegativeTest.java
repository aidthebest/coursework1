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

public class PurchaseWithCreditNegativeTest {

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
    public void cleanBuyWithCreditForm() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

    @Test
    public void buyTestDeclineCreditCard() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getDeclineCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(16).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
        assertEquals("DECLINED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestRandomCreditCardNumber() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getRandomCardNumber());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedMessage();
    }

    @Test
    public void buyTestFakeCreditCardNumber() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getFakeCardNumber());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
    }

    @Test
    public void buyTestEmptyCreditCardNumberField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(12).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
    }

    @Test
    public void buyTestFakeCreditCardHolder() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getFakeHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardHolderMessage();
    }

    @Test
    public void buyTestEmptyCreditCardHolderField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.emptyCardHolderFieldMessage();
    }

    @Test
    public void buyTestFakeCreditCardCvc() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getFakeCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardCvcField();
    }

    @Test
    public void buyTestFakeCreditCardMonth() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(-1).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(0).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardMonthField();
    }

    @Test
    public void buyTestFakeCreditCardYearAbove() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(85).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardYearField();
    }

    @Test
    public void buyTestFakeCreditCardYearBefore() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.generateDate(-60).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardYearField();
    }
}
