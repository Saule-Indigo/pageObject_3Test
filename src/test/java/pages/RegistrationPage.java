package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            resultsTable = $(".table-responsive"),
            userNumberInput = $("#userNumber"),
            userAddressInput = $("#currentAddress"),
            userSubjectInput = $("#subjectsInput"),
            picture = $("#uploadPicture"),
            radio = $("#genterWrapper"),
            hobbies = $("#hobbiesWrapper"),
            stateStateCity = $("#state"),
            stateCityWrapperNCR = $("#stateCity-wrapper").$(byText("NCR")),
            stateCity = $("#city"),
            stateCityWrapperDelhi = $("#stateCity-wrapper").$(byText("Delhi")),
            SubmitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setUserSubjects(String userSubjects) {
        userSubjectInput.setValue(userSubjects).pressEnter();
        return this;
    }

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }

    public RegistrationPage imgPicture() {
        picture.uploadFile(new File("src/test/resources/1.png"));
        return this;
    }


    public RegistrationPage validateTextMatchesEnteredValues() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }


    public void typeGender(String gender) {
        radio.$(byText(gender)).click();
    }

    public void choiceHobbiesWrapper(String hobbies) {
        hobbies.$(byText(hobbies)).click();

    }

    public void choiceStateCityWrapperNCR() {
        stateStateCity.find(byText("NCR")).click();
    }

    public void choiceStateStateCity() {
        stateStateCity.scrollTo().click();
    }

    public void choiceStateCity() {
        stateCity.click();
    }

    public void choiceStateCityWrapperNoida() {
        stateCityWrapperDelhi.scrollTo().click();
    }

    public RegistrationPage typeAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public void scrollSubmitButton() {
        SubmitButton.scrollTo();
    }
}
