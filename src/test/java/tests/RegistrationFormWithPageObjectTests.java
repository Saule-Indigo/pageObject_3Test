package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import pages.TestBase;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationFormWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmail = "ivan.ivanov@mail.ru";
    String userNumber = "7059034433";
    String userAddress = "Some address";
    String userSubjects = "Math";

    @Test
    void successFillTest() {
        registrationPage.openPage();
        Selenide.executeJavaScript("document.body.style.zoom='50%'");
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.typeGender();
        registrationPage.setUserNumber(userNumber);
        registrationPage.setBirthDate("25", "February", "2022");
        registrationPage.setUserSubjects(userSubjects);
        registrationPage.imgPicture();
        registrationPage.setUserAddress(userAddress);
        registrationPage.scrollSubmitButton();
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
                .checkForm("Gender", "Male")
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", "25 February,2022")
                .checkForm("Subjects", userSubjects)
                .checkForm("Hobbies", "Sports")
                .checkForm("Address", userAddress)
                .checkForm("State and City", "NCR Delhi");
    }
}
