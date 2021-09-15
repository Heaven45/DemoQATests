package allure;

import org.junit.jupiter.api.Test;

public class AllureTestAnnotated {

    private final static String MAIN_PAGE = "https://github.com";
    private final static String REPOSITORY = "qa-guru/qa_guru_8_6";

    @Test
    public void githubTest() {
        WebSteps steps = new WebSteps();

        steps.openMainPage(MAIN_PAGE);
        steps.findRepository(REPOSITORY);
        steps.clickOnRepositoryName(REPOSITORY);
        steps.checkIfPageContainsIssue();
    }
}
