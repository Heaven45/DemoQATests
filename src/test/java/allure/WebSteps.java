package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Отркрываем главную")
    public void openMainPage(String mainPage) {
        open(mainPage);
    }

    @Step("Ищем репозиторий c названием {repository}")
    public void findRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void clickOnRepositoryName(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Проверяем, что в репозитории есть вкладка с текстом Issues")
    public void checkIfPageContainsIssue() {
        $("[data-content='Issues']").shouldHave(text("Issues"));
    }
}
