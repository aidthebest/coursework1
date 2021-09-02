package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.DbInfo;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTest {
    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

//    @Test
//    public void BuyPageTest () {
//        StartPage startPage = new StartPage();
//        startPage.buyButtonClick();
//        BuyPage bp = new BuyPage();
//    }

    @Test
    public void cleanBuyForm () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestApproveCard () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.successMesage();
        assertEquals("APPROVED", DbInfo.getStatusDebitCard());
    }

    @Test
    public void buyTestDeclineDebitCard () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getDeclineCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.failedMessage();
        assertEquals("DECLINED", DbInfo.getStatusDebitCard());
    }

    @Test
    public void buyTestRandomDebitCard () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getRandomCardNumber());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.failedMessage();
    }

    @Test
    public void buyTestFakeDebitCardNumber () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getFakeValue());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardHolder () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getFakeValue());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardCvc () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getFakeCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardMonth () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getFakeValue());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeDebitCardYear () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getFakeValue());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void cleanBuyWithCreditForm () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestApproveCreditCard () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.successMesage();
        assertEquals("APPROVED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestDeclineCreditCard () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getDeclineCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.failedMessage();
        assertEquals("DECLINED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestRandomCreditCard () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getRandomCardNumber());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.failedMessage();
    }

    @Test
    public void buyTestFakeCreditCardNumber () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getFakeValue());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardHolder () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getFakeValue());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardCvc () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getFakeCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardMonth () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getFakeValue());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

    @Test
    public void buyTestFakeCreditCardYear () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getFakeValue());
        startPage.confirmButtonClick();
        startPage.wrongFormatMessage();
    }

}
