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
//        assertEquals("APPROVED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestApproveCard2 () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber(DataHelper.getDeclineCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.successMesage();
        assertEquals("DECLINED", DbInfo.getStatusCredit());
    }

    @Test
    public void buyTestDeclineCard () {
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
//
//    @Test
//    public void buyTestRandomCard () {
//        StartPage startPage = new StartPage();
//        startPage.buyWithCreditButtonClick();
//        startPage.setCardNumber(DataHelper.getRandomCardNumber());
//        startPage.setMonth(DataHelper.getMonth());
//        startPage.setCardHolder(DataHelper.getCardHolder());
//        startPage.setCvc(DataHelper.getCvc());
//        startPage.setYear(DataHelper.getYear());
//        startPage.confirmButtonClick();
//        startPage.failedMessage();
//    }
//
//    @Test
//    public void buyTestFakeCardNumber () {
//        StartPage startPage = new StartPage();
//        startPage.buyWithCreditButtonClick();
//        startPage.setCardNumber(DataHelper.getFakeValue());
//        startPage.setMonth(DataHelper.getMonth());
//        startPage.setCardHolder(DataHelper.getCardHolder());
//        startPage.setCvc(DataHelper.getCvc());
//        startPage.setYear(DataHelper.getYear());
//        startPage.confirmButtonClick();
//        startPage.wrongFormatMessage();
//    }
//
//    @Test
//    public void buyTestFakeCardHolder () {
//        StartPage startPage = new StartPage();
//        startPage.buyWithCreditButtonClick();
//        startPage.setCardNumber(DataHelper.getApproveCard());
//        startPage.setMonth(DataHelper.getMonth());
//        startPage.setCardHolder(DataHelper.getFakeValue());
//        startPage.setCvc(DataHelper.getCvc());
//        startPage.setYear(DataHelper.getYear());
//        startPage.confirmButtonClick();
//        startPage.wrongFormatMessage();
//    }
//
//    @Test
//    public void buyTestFakeCvc () {
//        StartPage startPage = new StartPage();
//        startPage.buyWithCreditButtonClick();
//        startPage.setCardNumber(DataHelper.getApproveCard());
//        startPage.setMonth(DataHelper.getMonth());
//        startPage.setCardHolder(DataHelper.getCardHolder());
//        startPage.setCvc("22");
//        startPage.setYear(DataHelper.getYear());
//        startPage.confirmButtonClick();
//        startPage.wrongFormatMessage();
//    }
//
//    @Test
//    public void buyTestFakeMonth () {
//        StartPage startPage = new StartPage();
//        startPage.buyWithCreditButtonClick();
//        startPage.setCardNumber(DataHelper.getApproveCard());
//        startPage.setMonth(DataHelper.getFakeValue());
//        startPage.setCardHolder(DataHelper.getCardHolder());
//        startPage.setCvc(DataHelper.getCvc());
//        startPage.setYear(DataHelper.getYear());
//        startPage.confirmButtonClick();
//        startPage.wrongFormatMessage();
//    }
//
//    @Test
//    public void buyTestFakeYear () {
//        StartPage startPage = new StartPage();
//        startPage.buyWithCreditButtonClick();
//        startPage.setCardNumber(DataHelper.getApproveCard());
//        startPage.setMonth(DataHelper.getMonth());
//        startPage.setCardHolder(DataHelper.getCardHolder());
//        startPage.setCvc(DataHelper.getCvc());
//        startPage.setYear(DataHelper.getFakeValue());
//        startPage.confirmButtonClick();
//        startPage.wrongFormatMessage();
//    }

}
