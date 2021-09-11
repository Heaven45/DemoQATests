import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    String firstName = "Ivan";
    String lastName = "Ivanov";
    String fullName = String.format("%s %s", firstName, lastName);
    String email = "test@test.com";
    String gender = "Male";
    String mobile = "1234567890";
    String day = "07";
    String month = "July";
    String year = "1984";
    String fullDate = "07 July,1984";
    String subjects = "Computer Science";
    String pathToImage = "images/test.png";
    String currentAddress = "Moscow, Pushkina 12, apartment 345";
    String stateAndCity = "NCR Delhi";

    RegistrationPage registrationPage = new RegistrationPage();

    // Мапа для метода .checkResult
    public Map<String, String> valuesToCheck = Map.of(
            "Student Name", fullName,
            "Student Email", email,
            "Gender", gender,
            "Mobile", mobile,
            "Date of Birth", fullDate,
            "Subjects", subjects,
            "Hobbies", "Music",
            "Picture", "test.png",
            "Address", currentAddress,
            "State and City", stateAndCity);

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .choseGender()
                .typeNumber(mobile)
                .pickDate(day, month, year)
                .typeSubject(subjects)
                .choseHobbies()
                .uploadPicture(pathToImage)
                .typeAddress(currentAddress)
                .choseStateAndCity("NCR", "Delhi")
                .submit()
                .checkResult(valuesToCheck);

//        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(fullName));
//        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
//        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
//        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(mobile));
//        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("09 April,1984"));
//        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subjects));
//        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
//        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("test.png"));
//        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
//        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(stateAndCity));
    }
}