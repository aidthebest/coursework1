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
        var startPage = new StartPage();
        startPage.buyButtonClick();
        startPage.buyWithCreditButtonClick();
    }
}
