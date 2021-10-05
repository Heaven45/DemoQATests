import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.DropdownPage;


public class DropdownTest {
    private DropdownPage dropdownPage = new DropdownPage();

    @CsvSource({
            "1, [value='1']",
            "2, [value='2']"
    })

    @ParameterizedTest
    void choseOption1FromDropdown(int option, String optionSelector) {
        dropdownPage.openPage()
                .selectOption(option)
                .checkIfOptionIsSelected(optionSelector);
    }
}

