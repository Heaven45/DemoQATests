import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    // Вариант с использованием поиска
    @Test
    void softAssertionsTestOption1() {
        // Открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        // Вводим начало названия в строку поиска чтобы отфильтновать результаты
        $("#wiki-pages-filter").setValue("So");

        // Открываем страницу SoftAssertions. В данном случае текст уникален, т.к. пишется слитно
        $(byText("SoftAssertions")).click();

        // Проверяем что внутри есть пример кода для JUnit5
        $x(("//*[contains(text(),'Using JUnit5')]")).shouldBe(visible);
        $x(("//*[contains(text(),'ExtendWith')]")).shouldBe(visible);
    }

    // Вариант с открытием списка вручную
    @Test
    void softAssertionsTestOption2() {
        // Открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        // Раскрываем список кликом на Show more
        $(".wiki-more-pages-link button").click();

        // Открываем страницу SoftAssertions. В данном случае текст уникален, т.к. пишется слитно
        $(byText("SoftAssertions")).click();

        // Проверяем что внутри есть пример кода для JUnit5
        $x(("//*[contains(text(),'Using JUnit5')]")).shouldBe(visible);
        $x(("//*[contains(text(),'ExtendWith')]")).shouldBe(visible);
    }
}