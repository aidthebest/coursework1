package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    private SelenideElement heading = $("[class=\"Order_cardImage__Q69ii\"]");
    private SelenideElement buyButton = $(withText("Купить"));
    private SelenideElement buyWithCreditButton = $(withText("Купить в кредит"));
    private SelenideElement confirmButton = $(withText("Продолжить"));
    private SelenideElement cardNumber = $("[class=input__control]");
    private SelenideElement month = $$("[class=input__control]").get(1);
    private SelenideElement year = $$("[class=input__control]").get(2);
    private SelenideElement cardHolder = $$("[class=input__control]").get(3);
    private SelenideElement code = $$("[class=input__control]").get(4);



    public StartPage () {heading.shouldBe(Condition.visible);}
    public void buyButtonClick () {
        buyButton.click();
    }
    public void buyWithCreditButtonClick () {
        buyWithCreditButton.click();
    }
    public void confirmButtonClick () {
        confirmButton.click();
    }


    public void setCardNumber (String number) {
        cardNumber.setValue(number);
    }
    public void setMonth (String cardMonth) {
        month.doubleClick().sendKeys(Keys.DELETE);
        month.setValue(cardMonth);
    }
    public void setYear (String cardYear) {
        year.setValue(cardYear);
    }
    public void setCardHolder (String owner) {
        cardHolder.setValue(owner);
    }
    public void setCvc (String codeCvc) {
        code.setValue(codeCvc);
    }

    public void successMesage(){
        $("[class=notification__title]").shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Успешно"));
    }

    public void failedMessage(){
        $$("[class=notification__content]").get(1).shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Ошибка! Банк отказал в проведении операции."));
    }

    public void wrongFormatMessage () {
        $("[class=input__sub]").shouldBe(Condition.visible, Duration.ofSeconds(14));
    }

}
