package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import randomValuesForTest.Users;

public class DemoQARegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Users user = new Users();
    @Test
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
                .submitInfo()
                .checkResults("Student Name", user.firstName)
                .checkResults("Student Email", user.email)
                .checkResults("Gender", user.gender)
                .checkResults("Mobile", user.userNumber)
                .checkResults("Date of Birth", user.day + " " + user.month + "," + user.year)
                .checkResults("Subjects", user.randomSubject)
                .checkResults("Hobbies", user.hobby)
                .checkResults("Picture", user.pictureStatic)
                .checkResults("Address", user.userAddress)
                .checkResults("State and City", user.randomState + " " + user.randomCity);
    }
    @Test
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