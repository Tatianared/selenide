import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class CardDeliveryTest {

    @Test
    void shouldRegisterByAccountNumber() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input").setValue("17.08.2022");
        $("[data-test-id=name] input").setValue("Ирина Шарова");
        $("[data-test-id=phone] input").setValue("+79001112233");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $x("//*[contains(text(),'успешно')]").shouldBe(visible, Duration.ofSeconds(15));

    }

    }
