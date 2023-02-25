package Wiki.tests;

import Wiki.lib.Platform;
import Wiki.lib.ui.SearchPageObject;
import Wiki.lib.ui.factories.ArticlePageObjectFactory;
import Wiki.lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import Wiki.lib.CoreTestCase;
import Wiki.lib.ui.ArticlePageObject;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
    public void testChangeScreenOrientationOnScreenResults()    {
        if (Platform.getInstance().isMW()) {
            return; /* завершить тест */
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Язык программирования");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "===== Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "===== Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }
    @Test
    public void testCheckSearchArticleInBackground() {
        if (Platform.getInstance().isMW()) {
            return; /* завершить тест */
        }
        String search_line = "Java";
        String substring = "Язык программирования";

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(substring);
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult(substring);
    }
}