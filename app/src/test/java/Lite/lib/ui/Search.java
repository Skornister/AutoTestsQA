package Lite.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class Search extends MainPageObject {

    protected static String // protected - чтобы можно было использовать эти переменные в других классах
            КНОПКА_ПОИСК,
            ПОИСК_ПОЛЕ_ВВОДА,
            ПОИСК_УДАЛИТЬ_ЗАПРОС,
            ПОИСК_ВВОД_В_КАСТОМ_КЛАВИАТУРУ,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            KEY_Й,
            KEY_Ц,
            KEY_У,
            KEY_ПОИСК;

    public Search(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS - Метод шаблонов - заменяем какое-то значение по шаблону на другое */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS - Метод шаблонов - заменяем какое-то значение по шаблону на другое */

    public void появилась_кнопка_удаления_запроса_ПОИСК() {
        this.waitForElementPresent(ПОИСК_УДАЛИТЬ_ЗАПРОС, "Cannot find search cancel button!", 5);
    }

    public void скрылась_кнопка_удаления_запроса_ПОИСК() {
        this.waitForElementNotPresent(ПОИСК_УДАЛИТЬ_ЗАПРОС, "Search cancel button is still present!", 5);
    }

    public void удалить_запрос_ПОИСК() {
        this.waitForElementAndClick(ПОИСК_УДАЛИТЬ_ЗАПРОС, "Cannot find and click search cancel button", 5);
    }

    public void ввести_поисковой_запрос_ПОИСК(String поисковой_запрос) /* Вводим какое-то значение */ {
        this.waitForElementAndSentKeys(ПОИСК_ПОЛЕ_ВВОДА, поисковой_запрос, "Cannot find and type into search input", 5);
    }

    public void ждем_результат_поиского_запроса(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring,10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
            SEARCH_RESULT_ELEMENT,
            "Cannot find anything by the request ",
            15
        );
        return this.get_КоличествоЭлементов(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find result element.", 15);
    }

    public void assertThereIsNotResultsOfSearch() {
        this.check_ЭлементаНет(SEARCH_RESULT_ELEMENT, "We supposed not to find any result");
    }
}

/*
Поиск
    в списке каналов
    в Избранном
Поиск цифрами
    в списке каналов
    в Избранном
    на канале
    на другом экране
*/