package guru.qa;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class HM3Test {
    @Test
    void FillInfoTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("[id=firstName]").setValue("Tia");
        $("[id=lastName]").setValue("Hawk");
        $("[id=userEmail]").setValue("some@mail.com");
        $("#genterWrapper").$(byText("Female")).click();// Очень интересно как выбрать другой чекбокс через $(".custom-control-label").click();
        $("[id=userNumber]").setValue("1111111111");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--010").click();
        $("[id=subjectsInput]").setValue("m").sendKeys(Keys.ENTER);
        $("label[for='hobbies-checkbox-1").click();
        $("label[for='hobbies-checkbox-2").click();
        $("label[for='hobbies-checkbox-3").click();
        $("[id=uploadPicture]").uploadFromClasspath("LogoAvia.png");
        $("[id=currentAddress]").setValue("12345, Mars, 17");
        $("[id=react-select-3-input]").setValue("Haryana").sendKeys(Keys.ENTER);
        $("[id=react-select-4-input]").setValue("Karnal").sendKeys(Keys.ENTER);
        $("[id=submit]").click();


        $(".modal-open").shouldBe(visible);
        $(".table").shouldHave(text("Tia Hawk"));
        $(".table").shouldHave(text("some@mail.com"));
        $(".table").shouldHave(text("1111111111"));
        $(".table").shouldHave(text("10 May,1996"));
        $(".table").shouldHave(text("Maths"));
        $(".table").shouldHave(text("Sports, Reading, Music"));
        $(".table").shouldHave(text("LogoAvia.png"));
        $(".table").shouldHave(text("12345, Mars, 17"));
        $(".table").shouldHave(text("Haryana Karnal"));

    }
}
