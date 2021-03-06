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
        buyWithCreditPage.setCardNumberField(DataHelper.getDeclineCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(16).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
        assertEquals("DECLINED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestRandomCreditCardNumber() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getRandomCardNumber());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedMessage();
    }

    @Test
    public void buyTestFakeCreditCardNumber() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getFakeCardNumber());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
    }

    @Test
    public void buyTestEmptyCreditCardNumberField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(12).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
    }

    @Test
    public void buyTestFakeCreditCardHolder() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getFakeHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardHolderMessage();
    }

    @Test
    public void buyTestEmptyCreditCardHolderField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.emptyCardHolderFieldMessage();
    }

    @Test
    public void buyTestFakeCreditCardCvc() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getFakeCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardCvcField();
    }

    @Test
    public void emptyCreditCardCvcField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardCvcField();
    }

    @Test
    public void creditCardMonthExpired() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(-1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(0).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardMonthField();
    }

    @Test
    public void fakeCreditCardMonth() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth("13");
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(0).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardMonthField();
    }

    @Test
    public void creditCardZaroMonth() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth("00");
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(13).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardMonthField();
    }

    @Test
    public void creditCardEmptyMonthField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(0).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wronwCreditCardMonthField();
    }

    @Test
    public void creditCardYearAbove() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(85).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongdCreditCardYearField();
    }

    @Test
    public void creditCardYearExpired() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(13).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(-60).getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardYearField();
    }

    @Test
    public void emptyeCreditCardYearField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.generateDate(1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.emptyCreditCardYearField();
    }

    @Test
    public void cleanAllFieldsWithErrors () {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getFakeCardNumber());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(-60).getYear());
        buyWithCreditPage.setMonth(DataHelper.generateDate(-1).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getFakeHolder());
        buyWithCreditPage.setCvc(DataHelper.getFakeCvc());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.cleanAllFormFields();
        buyWithCreditPage.withOutExaption();
    }

    @Test
    public void cleanAllFieldsWithoutErrors () {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumberField(DataHelper.getApproveCard());
        buyWithCreditPage.setYearfield(DataHelper.generateDate(5).getYear());
        buyWithCreditPage.setMonth(DataHelper.generateDate(3).getMonth());
        buyWithCreditPage.setCardHolderfield(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.successMesage();
        buyWithCreditPage.cleanAllFormFields();
        buyWithCreditPage.withOutExaption();
    }

}
