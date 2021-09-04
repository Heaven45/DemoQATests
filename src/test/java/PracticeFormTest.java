import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    String subjects = "Computer Science";
    String currentAddress = "Moscow, Pushkina 12, apartment 345";
    String stateAndCity = "NCR Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1984");
        $x("//div[contains(@aria-label, \"Monday, April 9th, 1984\")]").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("images/test.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(fullName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(mobile));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("09 April,1984"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("test.png"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(stateAndCity));
    }
}