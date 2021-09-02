package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class BuyPage {

    private SelenideElement heading = $(withText("Оплата по карте"));

    public BuyPage () {
        heading.shouldBe(Condition.visible);
    }
}
