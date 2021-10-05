package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class KeyPressesPage {

    public KeyPressesPage openPage() {
        open("https://the-internet.herokuapp.com/key_presses?");
        $("h3").shouldHave(text("Key Presses"));
        return this;
    }

    public void checkPageDescription(String description) {
        $(".example p").shouldHave(text(description));
    }

    public KeyPressesPage pressTab() {
        $("#target").pressTab();
        return this;
    }

    public KeyPressesPage pressEscape() {
        $("#target").pressEscape();
        return this;
    }

    public KeyPressesPage pressFToPayRespect() {
        $("#target").sendKeys("F");
        return this;
    }

    public void checkIfInputWasCorrect(String value) {
        $("#result").shouldHave(text("You entered: " + value));
    }
}
