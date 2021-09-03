package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PurchasePage {
    private static SelenideElement buyButton = $(withText("Купить"));
    private SelenideElement buyWithCreditButton = $(withText("Купить в кредит"));
    private SelenideElement confirmButton = $(withText("Продолжить"));


    public PurchasePage() {
        buyButton.shouldBe(Condition.visible);
        buyWithCreditButton.shouldBe(Condition.visible);
        confirmButton.shouldBe(Condition.not(Condition.visible));
    }

    public BuyPage buyButtonClick() {
        buyButton.click();
        return new BuyPage();
    }

    public BuyWithCreditPage buyWithCreditButtonClick() {
        buyWithCreditButton.click();
        return new BuyWithCreditPage();
    }
}
