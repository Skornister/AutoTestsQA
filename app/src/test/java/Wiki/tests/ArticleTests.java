package Wiki.tests;

import org.junit.Assert;
import org.junit.Test;
import Wiki.lib.CoreTestCase;
import Wiki.lib.ui.ArticlePageObject;
import Wiki.lib.ui.SearchPageObject;
import Wiki.lib.ui.factories.ArticlePageObjectFactory;
import Wiki.lib.ui.factories.SearchPageObjectFactory;

//@Epic("Tests for articles")
public class ArticleTests extends CoreTestCase {
    @Test
    // @Features(value = {@Feature(value = "Search"),@Feature(value = "Article")})
    // @DisplayName("Compare article title with expected one")
    // @Description("Open 'Java' article and make sure the title is expected")
    // @Step("Starting test testCompareArticleTitle")
    // @Severity(value = SeverityLevel.BLOCKER)
    public void testCompareArticleTitle() //Проверка загрузилась ли правильная страница
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("зык программирования");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "===== We see unexpected title!",
                "Java",
                article_title
        );
    }
    @Test
    // @Features(value = {@Feature(value = "Search"),@Feature(value = "Article")})
    // @DisplayName("Swipe article to the footer")
    // @Description("Open the article and swipe it to the footer")
    // @Step("Starting test testSwipeArticle")
    // @Severity(value = SeverityLevel.MINOR)
    public void testSwipeArticle() //Проверка загрузилась ли правильная страница
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("зык программирования");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter(); //Свайп до нахождения элемента или ошибка
    }

    @Test
    //@DisplayName("EX 2: check text placeholder in search input")
    //@Description("Open search input and check text placeholder in search input")
    //@Severity(value = SeverityLevel.TRIVIAL)
    public void testTextPlaceholderInSearchInput()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.checkTextPlaceholderInSearchInput(); /* EX 2 */
    }

    /* EX 6 */
    @Test
    // @DisplayName("Ex6: Тест: assert title")
    // @Description("Написать тест, который открывает статью и убеждается, что у нее есть элемент title. Важно: тест не должен дожидаться появления title, проверка должна производиться сразу. Если title не найден - тест падает с ошибкой. Метод можно назвать assertElementPresent.")
    public void testArticleHaveTitle()
    {
        String search_line = "Java";
        String substring = "зык программирования";

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(substring);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.checkHaveTitleOnPage(); /* <- всё ради этого. ищем 'title' на странице  */
    } /* EX 6 */
}