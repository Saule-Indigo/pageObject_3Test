package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import pages.TestBase;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationFormWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmail = "ivan.ivanov@mail.ru";
    String userNumber = "7059034433";
    String userAddress = "Almaty";
    String userSubjects = "Math";
    String day = "25";
    String month = "February";
    String year = "2022";
    String gender = "Male";
    String hobbies = "Sports";


    @Test
    void successFillTest() {
        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.typeGender(gender);
        registrationPage.setUserNumber(userNumber);
        registrationPage.setBirthDate(day, month, year);
        registrationPage.setUserSubjects(userSubjects);
        registrationPage.imgPicture();
        registrationPage.typeAddress(userAddress);
        registrationPage.scrollSubmitButton();
        registrationPage.choiceHobbiesWrapper(hobbies);
        registrationPage.choiceStateStateCity();
        registrationPage.choiceStateCityWrapperNCR();
        registrationPage.choiceStateCity();
        registrationPage.choiceStateCityWrapperNoida();
        Selenide.executeJavaScript("document.body.style.zoom='67%'");
        Selenide.executeJavaScript("arguments[0].click()", $("#submit"));

        registrationPage.validateTextMatchesEnteredValues();
        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + month + year)
                .checkForm("Subjects", userSubjects)
                .checkForm("Hobbies", "Sports")
                .checkForm("Address", userAddress)
                .checkForm("State and City", "NCR Delhi");
    }
}
