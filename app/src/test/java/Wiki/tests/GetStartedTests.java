package Wiki.tests;

import org.junit.Test;
import Wiki.lib.CoreTestCase;
import Wiki.lib.Platform;
import Wiki.lib.ui.WelcomePageObject;

public class GetStartedTests extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW())) {return;} /* Тест завершается если Platform=Android или MW */
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.waitForLearnMoreLink();

        WelcomePageObject.clickNextButton();
        WelcomePageObject.waitForNewWayToExploreText();

        WelcomePageObject.clickNextButton();
        WelcomePageObject.waitForAddOrEditProfferedLangText();

        WelcomePageObject.waitForLearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();
    }
}