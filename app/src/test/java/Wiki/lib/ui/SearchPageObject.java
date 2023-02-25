package Wiki.lib.ui;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.List;
import Wiki.lib.Platform;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT_mobile,
            SEARCH_INIT_ELEMENT_full,
            SEARCH_INPUT,
            SEARCH_INPUT2,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_SAVE_ARTICLE_BUTTON, /* EX 5 */
            SEARCH_RESULT_TITLE,  /* EX 4 */
            SEARCH_RESULT_TITLE_TPL, /* EX 9 */
            SEARCH_RESULT_DESCRIPTION_TPL; /* EX 9 */

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS - Метод шаблонов - заменяем какое-то значение по шаблону на другое */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS - Метод шаблонов - заменяем какое-то значение по шаблону на другое */

    /* EX 9 */
    private static String getResultTitle(String title) {
        return SEARCH_RESULT_TITLE_TPL.replace("{TITLE}", title);
    }
    private static String getResultDescription(String description) {
        return SEARCH_RESULT_DESCRIPTION_TPL.replace("{DESCRIPTION}", description);
    }
    public void waitForElementByTitleAndDescription(String title, String description) {
        String title_result = getResultTitle(title); /* в getResultSearchElementByTitleArticle в String подменяем {SUBSTRING} на substring, чтобы найти нужную статью в результатах поиска через waitForElementPresent */
        String description_result = getResultDescription(description); /* в getResultSearchElementByTitleArticle в String подменяем {SUBSTRING} на substring, чтобы найти нужную статью в результатах поиска через waitForElementPresent */
        this.waitForElementPresent(title_result, "Cannot find search result title " + title_result,15); /* ищем substring в результатах поиска */
        this.waitForElementPresent(description_result, "Cannot find search result description " + description_result); /* ищем substring в результатах поиска */
    } /* EX 9 */

    public void initSearchInput() /* Метод включения поиска */ {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(SEARCH_INIT_ELEMENT_full, "Cannot find text on screen 'Поиск по Википедии'", 5);
        } else {
            this.waitForElementAndClick(SEARCH_INIT_ELEMENT_mobile, "Cannot find text on screen 'Поиск по Википедии'", 5);
        }
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button!", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present!", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 15);
    }

    public void typeSearchLine(String search_line) /* Вводим какое-то значение */ {
        this.waitForElementAndSentKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 15);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    /* EX 4 */
    public void assertSearchResultWithText(String value) {
        List<WebElement> elements = waitForAllElementsPresent(
                SEARCH_RESULT_TITLE, /* создать List из всех SEARCH_RESULT_TITLE на экране  */
                "Cannot find '" + value + "' in search result  | Used locator: " + SEARCH_RESULT_TITLE,5
        );
        for (WebElement element : elements) { /* сделать действие с каждым елементом из List по-очереди */
            Assert.assertTrue(
                    "Some of search result not contains '" + value + "'",
                    element.getText().toLowerCase().contains(value)  /* toLowerCase() нижний регистр toUpperCase() верхний регистр */
            );
        }
    } /* EX 4 */

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring,10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
            SEARCH_RESULT_ELEMENT,
            "Cannot find anything by the request ",
            15
        ); //вернуть количество элементов
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    } /* Для использования в тест писать: int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles(); assertTrue("We found too few results!",amount_of_search_results > 0); //способ подсчета элементов на экране */

    public int getAmountOfNotFoundArticles() {
        this.waitForElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        ); //вернуть количество элементов
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find result element.", 15);
    }

    public void assertThereIsNotResultsOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any result");
    }

    /* EX 2 */
    public void checkTextPlaceholderInSearchInput() {
        assertElementNotHasText(SEARCH_INPUT, "Поиск по Википедии", "PLACEHOLDER not Поиск по Википедии!", 5);
        assertElementHasText(SEARCH_INPUT, "Поиск", "PLACEHOLDER not 'Поиск'!", 1);
    }/* EX 2 */
}