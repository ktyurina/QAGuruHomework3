package guru.qa;

import org.junit.jupiter.api.Test;
import pages.components.BaseComponent;
import pages.RegistrationPage;

public class HW3WithPageObjectsTest extends BaseComponent {
    RegistrationPage registrationPage = new RegistrationPage();
    // Full test
    @Test
    void fillInfoWithPageObjectsTest() {

        registrationPage.openPage()
                .setFirstName("Tia")
                .setLastName("Hawk")
                .setEmail("ssss@ddd.aaa")
                .setGender("Female")
                .setNumber("11111111111")
                .setDateOfBirth("10", "May", "1996")
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
                .checkResult("Date of Birth", "10 May,1996")
                .checkResult("Subjects", "English, Computer Science")
                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "LogoAvia.png")
                .checkResult("Address", "12345, Mars, 17")
                .checkResult("State and City", "Haryana Karnal");
    }
    // Minimal Test
    @Test
    void minimalFillTest(){
        registrationPage.openPage()
                .setFirstName("Tia")
                .setLastName("Hawk")
                .setGender("Female")
                .setNumber("11111111111")
                .submit()


                .checkResult("Student Name", "Tia Hawk")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1111111111");
    }
    // Unsuccessful Test
    @Test
    void zeroFillTest(){
            registrationPage.openPage().submit().checkValidation();
        }
}