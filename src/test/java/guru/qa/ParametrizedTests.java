package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.By;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class ParametrizedTests {
    @BeforeEach
    void beforeEach() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.playstation.com/ru-ru/");
    }
    @DisplayName("Параметризованный тест с CsvFileSource аннотацией")
    @ParameterizedTest(name= "В колонке {0} должен быть текст {1}")
    @CsvFileSource(resources = "/test_data/checkMainButtonsTest.csv")

    void checkMainButtonsTest(String searchId, String expectedText){
    $(By.cssSelector(searchId)).shouldHave(text(expectedText));
    }

    @DisplayName("Параметризованный тест с CsvSource аннотацией")
    @ParameterizedTest(name= "В секции {0} должен быть текст {1}")
    @CsvSource( value = {
            "#accordion-section-1, Как изменить план подписки PlayStation®Plus",
            "#accordion-section-2, Как оформить подписку PlayStation Plus",
            "#accordion-section-3, Как отменить подписку PlayStation Plus"
        }
    )

    void checkSubscriptionInfoTest(String linkId, String linkValue) {
        $("a[href=\"/ru-ru/support/subscriptions/\"]").click();
        $(".tile__btn").shouldHave(text("PlayStation Plus")).click();
        $(By.cssSelector(linkId)).shouldHave(text(linkValue));
    }

    @DisplayName("Параметризованный тест с MethodSource аннотацией")
    @ParameterizedTest(name= "В секции {0} должен быть текст {1}")
    @MethodSource

    void checkSubscriptionWithArgumentsTest(String linkId, String linkValue) {
        $("a[href=\"/ru-ru/support/subscriptions/\"]").click();
        $(".tile__btn").shouldHave(text("PlayStation Plus")).click();
        $(By.cssSelector(linkId)).shouldHave(text(linkValue));
    }
    static Stream<Arguments>checkSubscriptionWithArgumentsTest(){
        return Stream.of(
                Arguments.of("#accordion-section-1", "Как изменить план подписки PlayStation®Plus"),
                Arguments.of("#accordion-section-2", "Как оформить подписку PlayStation Plus"),
                Arguments.of("#accordion-section-3", "Как отменить подписку PlayStation Plus")
        );
    }
}
