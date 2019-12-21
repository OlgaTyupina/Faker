import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardSending {

    @Test
    @DisplayName("Должен все заполнять, потом все данные оставлять и менять только дату, затем переплонировать")

    void requestToDeliveryCard() {
        open("http://localhost:9999");
        $("[placeholder ='Город']").setValue(DataUse.getCity());
        DataUse.cleanUp();
        $("[placeholder='Дата встречи']").setValue(DataUse.getFormattedFutureDate());
        $("[data-test-id=name] input").setValue(DataUse.getName());
        $("[data-test-id=phone] input").setValue(DataUse.getPhone());
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 5000);
        $("[placeholder='Дата встречи']").setValue(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        DataUse.cleanUp();
        $("[placeholder='Дата встречи']").setValue(DataUse.getNewDate());
        $(".button__text").click();
        $("[data-test-id='replan-notification']").waitUntil(Condition.visible,
                5000);
        $(".button__text").click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);

    }

    }
