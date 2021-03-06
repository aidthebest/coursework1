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


public class PurchaseBuyTestNegative {

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
    public void cleanBuyForm() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.confirmButtonClick();
        buyPage.wrongFormatMessage();
    }

    @Test
    public void buyTestDeclineCard() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getDeclineCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(16).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardNumberField();
        assertEquals("DECLINED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestRandomCardNumber() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getRandomCardNumber());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedMessage();
    }

    @Test
    public void buyTestFakeCardNumber() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getFakeCardNumber());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardNumberField();
    }

    @Test
    public void buyTestEmptyCardNumberField() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(12).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardNumberField();
    }

    @Test
    public void buyTestFakeCardHolder() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getFakeHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardHolderMessage();
    }

    @Test
    public void buyTestEmptyCardHolderField() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.emptyCardHolderFieldMessage();
    }

    @Test
    public void buyTestFakeCardCvc() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getFakeCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardCvcField();
    }

    @Test
    public void emptyCardCvcField() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardCvcField();
    }

    @Test
    public void cardMonthExpired() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(-1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(0).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardMonthField();
    }

    @Test
    public void fakeCardMonth() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth("13");
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(0).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardMonthField();
    }

    @Test
    public void cardZaroMonth() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth("00");
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(13).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardMonthField();
    }

    @Test
    public void cardEmptyMonthField() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(0).getYear());
        buyPage.confirmButtonClick();
        buyPage.wrongCardMonthField();
    }

    @Test
    public void creditCardYearAbove() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(85).getYear());
        buyPage.confirmButtonClick();
        buyPage.wrongCardYearField();
    }

    @Test
    public void cardYearExpired() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.generateDate(-60).getYear());
        buyPage.confirmButtonClick();
        buyPage.failedCardYearField();
    }

    @Test
    public void emptyeCreditCardYearField() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.confirmButtonClick();
        buyPage.emptyCardYearField();
    }

    @Test
    public void cleanAllFieldsWithErrors () {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getFakeCardNumber());
        buyPage.setYear(DataHelper.generateDate(-60).getYear());
        buyPage.setMonth(DataHelper.generateDate(-1).getMonth());
        buyPage.setCardHolder(DataHelper.getFakeHolder());
        buyPage.setCvc(DataHelper.getFakeCvc());
        buyPage.confirmButtonClick();
        buyPage.cleanAllFormFields();
        buyPage.withOutExaption();
    }

    @Test
    public void cleanAllFieldsWithoutErrors () {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setYear(DataHelper.generateDate(5).getYear());
        buyPage.setMonth(DataHelper.generateDate(3).getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.confirmButtonClick();
        buyPage.successMesage();
        buyPage.cleanAllFormFields();
        buyPage.withOutExaption();
    }
}
