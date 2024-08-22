package tests;

import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import page.RegistrationPage;
import randomValuesForTest.Users;
import static io.qameta.allure.Allure.step;

@Tag("All tests")
public class DemoQARegistrationTest extends TestBase {

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }

    RegistrationPage registrationPage = new RegistrationPage();
    Users user = new Users();
    @Test
    @Tag("Full test")
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
                .setState(user.randomState)
                .setCity(user.randomCity)
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
    @Tag("Necessary forms test")
    @DisplayName("Filling only necessary forms")
    void onlyNecessaryFormsRegistrationTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setName(user.firstName)
                .setSurname(user.lastName)
                .setGender(user.gender)
                .setNumber(user.userNumber)
                .setDate(user.day,user.month,user.year)
                .submitInfo()
                .checkResults("Student Name", user.firstName)
                .checkResults("Gender", user.gender)
                .checkResults("Mobile", user.userNumber)
                .checkResults("Date of Birth", user.day + " " + user.month + "," + user.year);
    }
    @Test
    @Tag("Wrong number test")
    @DisplayName("Adding wrong number")
    void negativeRegistrationTest(){
        registrationPage.openPage()
                .removeBanner ()
                .setName(user.firstName)
                .setSurname(user.lastName)
                .setGender(user.gender)
                .setNumber(user.wrongUserNumber)
                .setDate(user.day,user.month,user.year)
                .submitInfo()
                .checkErrors();
    }
}