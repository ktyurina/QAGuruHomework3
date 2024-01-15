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
    void fillInfoTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
       // Configuration.holdBrowserOpen = true;

        $("#firstName").setValue("Tia");
        $("#lastName").setValue("Hawk");
        $("#userEmail").setValue("some@mail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("m").sendKeys(Keys.ENTER);
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        // $("label[for='hobbies-checkbox-1").click();
        // $("label[for='hobbies-checkbox-2").click();
        // $("label[for='hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("LogoAvia.png");
        $("#currentAddress").setValue("12345, Mars, 17");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        // $("#react-select-3-input").setValue("Haryana").pressEnter();
        // $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        // Проверка

        $(".modal-open").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Tia Hawk"));
        // $(".table").shouldHave(text("Tia Hawk"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("some@mail.com"));
        // $(".table").shouldHave(text("some@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1111111111"));
        // $(".table").shouldHave(text("1111111111"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("10 May,1996"));
        // $(".table").shouldHave(text("10 May,1996"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        // $(".table").shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        // $(".table").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("LogoAvia.png"));
        // $(".table").shouldHave(text("LogoAvia.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("12345, Mars, 17"));
        // $(".table").shouldHave(text("12345, Mars, 17"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
        // $(".table").shouldHave(text("Haryana Karnal"));
    }
}
