package guru.qa;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class SelenideHoverTest {

    @Test

    void githubSolutionsHoverTest() {
        open("https://github.com/");
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $(".enterprise-center-until-medium").shouldHave(text("The enterprise-ready platform that developers know and love."));
    }
}
