package guru.qa;

import org.junit.jupiter.api.Test;
import guru.qa.config.TestConfig;
import pages.RegistrationPage;

public class HW3WithPageObjectsTest extends TestConfig {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillInfoWithPageObjectsTest() {

        registrationPage.openPage()
                .setFirstName("Tia")
                .setLastName("Hawk")
                .setEmail("ssss@ddd.aaa")
                .setGender("Female")
                .setPhoneNumber("11111111111")
                .setDateOfBirth("31", "January", "2024")
                .setSubject("English").setSubject("Computer")
                .setHobbies("Reading").setHobbies("Music")
                .setPicture("LogoAvia.png")
                .setAddress("12345, Mars, 17")
                .setState("Haryana")
                .setCity("Karnal")
                .submit()

                .checkResult("Student Name", "Tia Hawk")
                .checkResult("Student Email", "ssss@ddd.aaa")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1111111111")
                .checkResult("Date of Birth", "31 January,2024")
                .checkResult("Subjects", "English, Computer Science")
                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "LogoAvia.png")
                .checkResult("Address", "12345, Mars, 17")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void minimalFillTest(){
        registrationPage.openPage()
                .setFirstName("Tia")
                .setLastName("Hawk")
                .setGender("Female")
                .setPhoneNumber("11111111111")
                .submit()


                .checkResult("Student Name", "Tia Hawk")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1111111111");
    }

    @Test
    void zeroFillTest(){
            registrationPage.openPage().submit().checkValidation();
        }
}