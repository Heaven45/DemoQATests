package allure;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureTestSelenideOnly {

    @Test
    void githubTest() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("qa-guru/qa_guru_8_6");
        $(".header-search-input").submit();
        $(linkText("qa-guru/qa_guru_8_6")).click();
        $("[data-content='Issues']").shouldHave(text("Issue5s"));
    }
}
