package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PurchasePage {
    private SelenideElement buyButton = $(withText("Купить"));
    private SelenideElement buyWithCreditButton = $(withText("Купить в кредит"));
    private SelenideElement confirmButton = $(withText("Продолжить"));


    public PurchasePage () {
        buyButton.shouldBe(Condition.visible);
        buyWithCreditButton.shouldBe(Condition.visible);
        confirmButton.shouldBe(Condition.not(Condition.visible));
    }
    public void buyButtonClick () {
        buyButton.click();
    }
    public void buyWithCreditButtonClick () {
        buyWithCreditButton.click();
    }
}
