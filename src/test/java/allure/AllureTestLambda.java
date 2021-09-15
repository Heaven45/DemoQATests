package allure;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTestLambda {
    @Test
    void githubTest() {

        step("Отркрываем главную", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("qa-guru/qa_guru_8_6");
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий", () -> {
            $(linkText("qa-guru/qa_guru_8_6")).click();
        });

        step("Проверяем, что в репозитории есть вкладка с текстом Issues", () -> {
            $("[data-content='Issues']").shouldHave(text("Issues"));
        });
    }
}
