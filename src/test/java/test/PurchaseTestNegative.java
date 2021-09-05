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


public class PurchaseTestNegative {

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
    public void buyTestDeclineDebitCard() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getDeclineCard());
        buyPage.setMonth(DataHelper.getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.getYear());
        buyPage.confirmButtonClick();
        buyPage.failedMessage();
        assertEquals("DECLINED", DbInfo.getStatusDebitCard());
    }

    @Test
    public void buyTestRandomDebitCard() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getRandomCardNumber());
        buyPage.setMonth(DataHelper.getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.getYear());
        buyPage.confirmButtonClick();
        buyPage.failedMessage();
    }

    @Test
    public void buyTestFakeDebitCardNumber() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getFakeCardNumber());
        buyPage.setMonth(DataHelper.getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.getYear());
        buyPage.confirmButtonClick();
        buyPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardHolder() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.getMonth());
        buyPage.setCardHolder(DataHelper.getFakeHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.getYear());
        buyPage.confirmButtonClick();
        buyPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardCvc() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getFakeCvc());
        buyPage.setYear(DataHelper.getYear());
        buyPage.confirmButtonClick();
        buyPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardMonth() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.getInvalidMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.getYear());
        buyPage.confirmButtonClick();
        buyPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardYear() {
        var buyPage = purchasePage.buyButtonClick();
        buyPage.setCardNumber(DataHelper.getApproveCard());
        buyPage.setMonth(DataHelper.getMonth());
        buyPage.setCardHolder(DataHelper.getCardHolder());
        buyPage.setCvc(DataHelper.getCvc());
        buyPage.setYear(DataHelper.getInvalidYearAbove());
        buyPage.confirmButtonClick();
        buyPage.wrongFormatMessage();
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
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedMessage();
        assertEquals("DECLINED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestRandomCreditCard() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getRandomCardNumber());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedMessage();
    }

    @Test
    public void buyTestFakeCreditCardNumber() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getFakeCardNumber());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardHolder() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getFakeHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardCvc() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getFakeCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardMonth() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getInvalidMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardYear() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getInvalidYearAbove());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

}
