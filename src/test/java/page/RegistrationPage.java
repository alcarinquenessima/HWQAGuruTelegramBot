package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import page.components.CalendarComponent;
import page.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement nameInput = $("#firstName");
    private final SelenideElement surnameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderChoosing = $("#genterWrapper");
    private final SelenideElement numberInput =  $("#userNumber");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement hobbyChoosing = $("#hobbiesWrapper");
    private final SelenideElement subjectInput =  $("#subjectsInput");
    private final SelenideElement address = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultsTable = $(".table");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    private final SelenideElement dateInput = $("#dateOfBirthInput");

    @Step ("Removing ads")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step ("Opening demoqa link")
    public RegistrationPage openPage (){
        open("/automation-practice-form");
        return this;
    }
    @Step ("Filling Name")
    public RegistrationPage setName (String value) {
        nameInput.setValue(value);
        return this;
    }
    @Step ("Filling Surname")
    public RegistrationPage setSurname (String value) {
        surnameInput.setValue(value);
        return this;
    }

    @Step ("Filling emal")
    public RegistrationPage setEmail (String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step ("Choosing gender")
    public RegistrationPage setGender (String value){
        genderChoosing.$(byText(value)).click();
        return this;
    }

    @Step ("Filling number")
    public RegistrationPage setNumber (String value){
        numberInput.setValue(value);
        return this;
    }

    @Step ("Filling date of birth")
    public RegistrationPage setDate (String day, String month, String year){
        dateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step ("Uploading picture")
    public RegistrationPage uploadPicture (String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    @Step ("Choosing subject")
    public RegistrationPage setSubject (String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step ("Choosing hobby")
    public RegistrationPage setHobbies (String value){
        hobbyChoosing.$(byText(value)).click();
        return this;
    }

    @Step ("Filling address")
    public RegistrationPage setAddress (String value) {
        address.setValue(value);
        return this;
    }
    @Step ("Choosing state")
    public RegistrationPage setState (String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    @Step ("Choosing city")
    public RegistrationPage setCity (String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }
    @Step ("Submitting info")
    public RegistrationPage submitInfo() {
        submitButton.click();
        return this;
    }

    @Step ("Checking results")
    public RegistrationPage checkResults (String key, String value) {
        checkResultComponent.checkResults(key, value);
        return this;
    }

    @Step ("Checking errors")
    public void checkErrors () {
        resultsTable.shouldNotBe(visible);
    }

}