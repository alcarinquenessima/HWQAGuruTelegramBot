package tests;

import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import page.RegistrationPage;
import randomValuesForTest.Users;
import static io.qameta.allure.Allure.step;

@Tag("AllTests")
public class DemoQARegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Users user = new Users();
    @Test
    @Tag("FullTest")
    @DisplayName("Filling all forms")
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setName(user.firstName)
                .setSurname(user.lastName)
                .setEmail(user.email)
                .setGender(user.gender)
                .setNumber(user.userNumber)
                .setDate(user.day,user.month,user.year)
                .setSubject(user.randomSubject)
                .setHobbies(user.hobby)
                .uploadPicture(user.pictureStatic)
                .setAddress(user.userAddress)
                .scrollToCityState()
                .setState(user.randomState)
                .setCity(user.randomCity)
                .scrollToSubmit()
                .submitInfo();
        step ("Checking results", () -> {
            registrationPage.checkResults("Student Name", user.firstName)
                    .checkResults("Student Email", user.email)
                    .checkResults("Gender", user.gender)
                    .checkResults("Mobile", user.userNumber)
                    .checkResults("Date of Birth", user.day + " " + user.month + "," + user.year)
                    .checkResults("Subjects", user.randomSubject)
                    .checkResults("Hobbies", user.hobby)
                    .checkResults("Picture", user.pictureStatic)
                    .checkResults("Address", user.userAddress)
                    .checkResults("State and City", user.randomState + " " + user.randomCity);
        });
    }
    @Test
    @Tag("NecessaryFormsTest")
    @DisplayName("Filling only necessary forms")
    void onlyNecessaryFormsRegistrationTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setName(user.firstName)
                .setSurname(user.lastName)
                .setGender(user.gender)
                .setNumber(user.userNumber)
                .setDate(user.day,user.month,user.year)
                .scrollToSubmit()
                .submitInfo()
                .checkResults("Student Name", user.firstName)
                .checkResults("Gender", user.gender)
                .checkResults("Mobile", user.userNumber)
                .checkResults("Date of Birth", user.day + " " + user.month + "," + user.year);
    }
    @Test
    @Tag("WrongNumberTest")
    @DisplayName("Adding wrong number")
    void negativeRegistrationTest(){
        registrationPage.openPage()
                .removeBanner ()
                .setName(user.firstName)
                .setSurname(user.lastName)
                .setGender(user.gender)
                .setNumber(user.wrongUserNumber)
                .setDate(user.day,user.month,user.year)
                .scrollToSubmit()
                .submitInfo()
                .checkErrors();
    }
}