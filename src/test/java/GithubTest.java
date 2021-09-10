import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    // Выносим элемент ссылки в переменную чтобы избежать дупликации кода
    WebElement softAssertionsLink = $(byText("Soft assertions"));

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionsTest() {
        // Открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убеждаемся, что в списке страниц (Pages) есть страница SoftAssertions
        softAssertionsLink.isDisplayed();

        // Открываем страницу SoftAssertions
        softAssertionsLink.click();

        // Проверяем что внутри есть пример кода для JUnit5
        $x(("//*[contains(text(),'Using JUnit5')]")).shouldBe(visible);
        $x(("//*[contains(text(),'ExtendWith')]")).shouldBe(visible);
    }
}
