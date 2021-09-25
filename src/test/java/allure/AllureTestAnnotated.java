package allure;

import org.junit.jupiter.api.Test;

public class AllureTestAnnotated {

    WebSteps steps = new WebSteps();

    private final static String MAIN_PAGE = "https://github.com";
    private final static String REPOSITORY = "qa-guru/qa_guru_8_6";

    @Test
    public void githubTest() {

        steps.openMainPage(MAIN_PAGE);
        steps.clickOnSearchField();
        steps.typeRepositoryName(REPOSITORY);
        steps.submit();
        steps.clickOnRepositoryName(REPOSITORY);
        steps.checkIfPageContainsIssue();
    }
}
