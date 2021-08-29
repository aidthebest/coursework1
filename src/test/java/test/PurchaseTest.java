package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class PurchaseTest {
    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
    }


    @Test
    public void buyTest () {
        StartPage startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.setCardNumber(DataHelper.getApproveCard());
        startPage.setMonth(DataHelper.getMonth());
        startPage.setCardHolder(DataHelper.getCardHolder());
        startPage.setCvc(DataHelper.getCvc());
        startPage.setYear(DataHelper.getYear());
        startPage.confirmButtonClick();
        startPage.successMesage();
    }

    @Test
    public void buyTest2 () {
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
}
