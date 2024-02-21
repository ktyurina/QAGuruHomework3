package guru.qa;

import guru.qa.config.RandomCredentials;
import org.junit.jupiter.api.Test;
import guru.qa.config.TestConfig;
import pages.RegistrationPage;

public class HW3WithFakerTest extends TestConfig {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomCredentials randomCredentials = new RandomCredentials();

    @Test
    void fillInfoWithFakerCredTest() {

        registrationPage.openPage()
                .setFirstName(randomCredentials.firstName)
                .setLastName(randomCredentials.lastName)
                .setEmail(randomCredentials.email)
                .setGender(randomCredentials.gender)
                .setPhoneNumber(randomCredentials.phoneNumber)
                .setDateOfBirth(randomCredentials.birthDay, randomCredentials.birthMonth, randomCredentials.birthYear)
                .setSubject(randomCredentials.subject)
                .setHobbies(randomCredentials.hobbies)
                .setPicture(randomCredentials.picture)
                .setAddress(randomCredentials.address)
                .setState(randomCredentials.state)
                .setCity(randomCredentials.city)
                .submit()

                .checkResult("Student Name", randomCredentials.firstName + " "+ randomCredentials.lastName)
                .checkResult("Student Email", randomCredentials.email)
                .checkResult("Gender", randomCredentials.gender)
                .checkResult("Mobile", randomCredentials.phoneNumber)
                .checkResult("Date of Birth",  randomCredentials.birthDay + " " + randomCredentials.birthMonth + "," + randomCredentials.birthYear)
                .checkResult("Subjects", randomCredentials.subject)
                .checkResult("Hobbies", randomCredentials.hobbies)
                .checkResult("Picture", randomCredentials.picture)
                .checkResult("Address", randomCredentials.address)
                .checkResult("State and City", randomCredentials.state + " " + randomCredentials.city);
    }

    @Test
    void minimalFakerFillTest(){
        registrationPage.openPage()
                .setFirstName(randomCredentials.firstName)
                .setLastName(randomCredentials.lastName)
                .setGender(randomCredentials.gender)
                .setPhoneNumber(randomCredentials.phoneNumber)
                .submit()


                .checkResult("Student Name", randomCredentials.firstName + " "+ randomCredentials.lastName)
                .checkResult("Gender", randomCredentials.gender)
                .checkResult("Mobile", randomCredentials.phoneNumber);
    }
}