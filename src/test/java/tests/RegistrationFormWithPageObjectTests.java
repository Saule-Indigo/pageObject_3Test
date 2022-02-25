package tests;

import org.junit.jupiter.api.Test;
import pages.TestBase;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmail = "ivan.ivanov@mail.ru";
    String userNumber = "1231231230";
    String userAddress = "Some address";
    String userSubjects = "Math";

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setUserAddress(userAddress)
                .setUserSubjects(userSubjects)
                .imgPicture()
                .setBirthDate("30", "July", "2008");
        registrationPage.typeGender();
        registrationPage.choiceHobbiesWrapper();
        registrationPage.choiceStateStateCity();
        registrationPage.choiceStateCityWrapperNCR();
        registrationPage.choiceStateCity();
        registrationPage.choiceStateCityWrapperNoida();
        registrationPage.clickSubmitButton();


        registrationPage.validateTextMatchesEnteredValues();
        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", "Other")
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", "30 July,2008")
                .checkForm("Subjects", userSubjects)
                .checkForm("Hobbies", "Sports")
                .checkForm("Address", userAddress)
                .checkForm("State and City", "NCR Delhi");
    }
}
