package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.DELETE;

public class BuyWithCreditPage {

    private SelenideElement confirmButton = $(withText("Продолжить"));
    private SelenideElement cardNumberField = $("[class=input__control]");
    private SelenideElement monthField = $$("[class=input__control]").get(1);
    private SelenideElement yearfield = $$("[class=input__control]").get(2);
    private SelenideElement cardHolderfield = $$("[class=input__control]").get(3);
    private SelenideElement codefield = $$("[class=input__control]").get(4);
    private SelenideElement heading = $(withText("Кредит по данным карты"));

    private SelenideElement cardNumberErrorField = $(withText("Номер карты")).parent().$("[class=input__sub]");
    private SelenideElement monthErrorField = $(withText("Месяц")).parent().$("[class=input__sub]");
    private SelenideElement yearErrorField = $(withText("Год")).parent().$("[class=input__sub]");
    private SelenideElement cvcErrorField = $(withText("CVC/CVV")).parent().$("[class=input__sub]");
    private SelenideElement cardHolderErrorfield = $(withText("Владелец")).parent().$("[class=input__sub]");


    private static SelenideElement exeptionMessage = $("[class=input__sub]");



    public BuyWithCreditPage() {
        heading.shouldBe(Condition.visible);
    }

    public void cleanAllFormFields () {
        cardNumberField.doubleClick().sendKeys(CONTROL + "A", DELETE);
        monthField.doubleClick().sendKeys(DELETE);
        yearfield.doubleClick().sendKeys(DELETE);
        cardHolderfield.doubleClick().sendKeys(CONTROL + "A", DELETE);
        codefield.doubleClick().sendKeys(DELETE);
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }

    public void setCardNumberField(String number) {
        cardNumberField.setValue(number);
    }

    public void setMonth(String cardMonth) {
        monthField.doubleClick().sendKeys(Keys.DELETE);
        monthField.setValue(cardMonth);
    }

    public void setYearfield(String cardYear) {
        yearfield.setValue(cardYear);
    }

    public void setCardHolderfield(String owner) {
        cardHolderfield.setValue(owner);
    }

    public void setCvc(String codeCvc) {
        codefield.setValue(codeCvc);
    }

    public void successMesage() {
        $("[class=notification__title]").shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Успешно"));
    }

    public void failedMessage() {
        $$("[class=notification__content]").get(1).shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Ошибка! Банк отказал в проведении операции."));
    }

    public void wrongFormatMessage() {
        $("[class=input__sub]").shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверный формат"));
    }

    public void emptyCardHolderFieldMessage() {
        cardHolderErrorfield.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void failedCreditCardHolderMessage () {
        cardHolderErrorfield.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверный формат"));
    }

    public void failedCreditCardNumberField() {
        cardNumberErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверный формат"));
    }

    public void failedCreditCardMonthField() {
        monthErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void wronwCreditCardMonthField() {
        monthErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверный формат"));
    }

    public void wrongdCreditCardYearField() {
        yearErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void failedCreditCardYearField() {
        yearErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Истёк срок действия карты"));
    }

    public void emptyCreditCardYearField() {
        yearErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверный формат"));
    }

    public void failedCreditCardCvcField() {
        cvcErrorField.shouldBe(Condition.visible, Duration.ofSeconds(14)).shouldHave(Condition.exactText("Неверный формат"));
    }

    public void withOutExaption () {
        assertFalse(cvcErrorField.isDisplayed());
        assertFalse(yearErrorField.isDisplayed());
        assertFalse(monthErrorField.isDisplayed());
        assertFalse(cardNumberErrorField.isDisplayed());
        assertFalse(cardHolderErrorfield.isDisplayed());

    }
}
