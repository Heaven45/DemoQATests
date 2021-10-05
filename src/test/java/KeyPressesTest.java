import org.junit.jupiter.api.Test;
import pages.KeyPressesPage;

public class KeyPressesTest {
    private final KeyPressesPage keyPressesPage = new KeyPressesPage();

    @Test
    void correctDescriptionTest() {
        String description = "Key presses are often used to interact with a website (e.g., tab order, enter," +
                " escape, etc.). Press a key and see what you inputted.";
        keyPressesPage
                .openPage()
                .checkPageDescription(description);
    }

    @Test
    void pressTabTest() {
        keyPressesPage
                .openPage()
                .pressTab()
                .checkIfInputWasCorrect("TAB");
    }

    @Test
    void pressAltEscape() {
        keyPressesPage
                .openPage()
                .pressEscape()
                .checkIfInputWasCorrect("ESCAPE");
    }

    @Test
    void pressFTest() {
        keyPressesPage
                .openPage()
                .pressFToPayRespect()
                .checkIfInputWasCorrect("F");
    }
}
