package test;

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
        startPage.setCardNumber("4444 4444 4444 4441");
        startPage.setMonth("08");
        startPage.setCardHolder("Mike");
        startPage.setCvc("800");
        startPage.setYear("22");
        startPage.confirmButtonClick();
        startPage.successMesage();
//        startPage.failedMessage();
    }

    @Test
    public void buyTest2 () {
        StartPage startPage = new StartPage();
        startPage.buyWithCreditButtonClick();
        startPage.setCardNumber("4444 4444 4444 4444");
        startPage.setMonth("08");
        startPage.setCardHolder("Mike");
        startPage.setCvc("800");
        startPage.setYear("22");
        startPage.confirmButtonClick();
        startPage.failedMessage();
    }
}
