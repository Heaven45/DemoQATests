package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownPage {

    String dropdownElement = "#dropdown";

    public DropdownPage openPage() {
        open("https://the-internet.herokuapp.com/dropdown");
        $("h3").shouldHave(text("Dropdown List"));
        return this;
    }

    public DropdownPage selectOption(int optionNumber) {
        $(dropdownElement).selectOption(optionNumber);
        return this;
    }

    public DropdownPage checkIfOptionIsSelected(String optionSelector) {
        assert ($(optionSelector).isSelected());
        return this;
    }
}
