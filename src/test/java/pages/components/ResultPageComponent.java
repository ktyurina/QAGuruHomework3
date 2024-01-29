package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.appear;

public class ResultPageComponent {
        public static void checkResultForm (String fieldName, String value) {
            $(".modal-dialog").should(appear);
            $(".table-responsive table").$(byText(fieldName)).parent().shouldHave(text(value));
        }
    }
