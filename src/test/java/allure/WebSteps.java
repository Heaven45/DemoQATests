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

    @Step("Жмём на строку поиска")
    public void clickOnSearchField() {
        $(".header-search-input").click();

    }

    @Step("Вводим \"{repository}\" в поле поиска")
    public void typeRepositoryName(String repository) {
        $(".header-search-input").sendKeys(repository);
    }

    @Step("Жмём найти")
    public void submit() {
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий \"{repository}\"")
    public void clickOnRepositoryName(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Проверяем, что в репозитории есть вкладка с текстом Issues")
    public void checkIfPageContainsIssue() {
        $("[data-content='Issues']").shouldHave(text("Issu4es"));
    }
}
