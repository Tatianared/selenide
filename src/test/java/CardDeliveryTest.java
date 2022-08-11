import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    public String generateDate(int days) {

        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    @Test
    void shouldRegisterCard() {
        open("http://localhost:9999");
        String planningDate = generateDate(4);
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Ирина Шарова");
        $("[data-test-id=phone] input").setValue("+79001112233");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $x("//*[contains(text(),'успешно')]").shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").
                shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }

}
