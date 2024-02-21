package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultPageComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    private final SelenideElement userForm = $("#userForm"),
                firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                emailInput = $("#userEmail"),
                genderInput = $("#genterWrapper"),
                phoneNumberInput = $("#userNumber"),
                calendarInput = $("#dateOfBirthInput"),
                subjectInput = $("#subjectsInput"),
                hobbiesInput = $("#hobbiesWrapper"),
                pictureInput = $("#uploadPicture"),
                addressInput = $("#currentAddress"),
                stateInput = $("#state"),
                cityInput = $("#city"),
                submitButton = $("#submit");

        CalendarComponent calendarComponent = new CalendarComponent();

        public RegistrationPage setFirstName(String value) {
            firstNameInput.setValue(value);
            return this;
        }

        public RegistrationPage setLastName(String value) {
            lastNameInput.setValue(value);
            return this;
        }

        public RegistrationPage setEmail(String value) {
            emailInput.setValue(value);
            return this;
        }

        public RegistrationPage setGender(String value) {
            genderInput.$(byText(value)).click();
            return this;
        }

        public RegistrationPage setPhoneNumber(String value) {
            phoneNumberInput.setValue(value);
            return this;
        }
        public RegistrationPage setDateOfBirth(String day, String month, String year) {
            calendarInput.click();
            calendarComponent.setDate(day, month, year);
            return this;
        }
         public RegistrationPage setSubject(String value) {
            subjectInput.setValue(value).pressEnter();
            return this;
        }

        public RegistrationPage setHobbies(String value) {
            hobbiesInput.$(byText(value)).click();
            return this;
    }

        public RegistrationPage setPicture(String filename) {
            pictureInput.uploadFromClasspath(filename);
            return this;
    }

        public RegistrationPage setAddress(String value) {
            addressInput.setValue(value);
            return this;
    }

        public RegistrationPage setState(String value) {
            stateInput.click();
            stateInput.$(byText(value)).click();
            return this;
    }
        public RegistrationPage setCity(String value) {
            cityInput.click();
            cityInput.$(byText(value)).click();
            return this;
    }

        public RegistrationPage submit() {
            submitButton.click();
            return this;
    }

ResultPageComponent resultPageComponent = new ResultPageComponent();

    public RegistrationPage checkResult(String fieldName, String value) {
       resultPageComponent.checkResultForm(fieldName, value);
        return this;
    }

    public void checkValidation() {
        String valueName = "border-color";
        String colorRed = "rgb(220, 53, 69)";
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue(valueName,colorRed));
        lastNameInput.shouldHave(cssValue(valueName,colorRed));
        genderInput.$("label[for='gender-radio-1']").shouldHave(cssValue(valueName,colorRed));
        genderInput.$("label[for='gender-radio-2']").shouldHave(cssValue(valueName,colorRed));
        genderInput.$("label[for='gender-radio-3']").shouldHave(cssValue(valueName,colorRed));
        phoneNumberInput.shouldHave(cssValue(valueName,colorRed));
    }
}
