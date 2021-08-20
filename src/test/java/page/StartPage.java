package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement heading = $("[class=\"App_appContainer__3jRx1\"]");
    private SelenideElement buyButton = $(withText("Купить"));
    private SelenideElement buyWithCreditButton = $(withText("Купить в кредит"));

    public StartPage () {heading.shouldBe(Condition.visible);}
    public void buyButtonClick () {
        buyButton.click();
    }
    public void buyWithCreditButtonClick () {
        buyWithCreditButton.click();
    }
}
