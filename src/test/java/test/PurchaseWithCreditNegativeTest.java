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
    public void buyTestEmptyCreditCardNumberField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.failedCreditCardNumberField();
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
    public void buyTestEmptyCreditCardHolderField() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getYear());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.emptyCardHolderFieldMessage();
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
    public void buyTestFakeCreditCardYearAbove() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getInvalidYearAbove());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardYearBefore() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getInvalidYearBefore());
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }




    @Test
    public void buyTestFakeCreditCardYearBeforeTESTESTTEST() {
        var buyWithCreditPage = purchasePage.buyWithCreditButtonClick();
        buyWithCreditPage.setCardNumber(DataHelper.getApproveCard());
        buyWithCreditPage.setMonth(DataHelper.getMonth());
        buyWithCreditPage.setCardHolder(DataHelper.getCardHolder());
        buyWithCreditPage.setCvc(DataHelper.getCvc());
        buyWithCreditPage.setYear(DataHelper.getyearTEST(-9));
        buyWithCreditPage.confirmButtonClick();
        buyWithCreditPage.wrongFormatMessage();
    }
}
