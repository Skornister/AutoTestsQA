package Wiki.tests;

import Wiki.lib.ui.SearchPageObject;
import Wiki.lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import Wiki.lib.CoreTestCase;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("зык программирования");
    }

    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test //Проверить, что количество элементов не >0
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Wikipedia app";
        SearchPageObject.typeSearchLine(search_line);
        //способ подсчета элементов на экране
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        ); //способ подсчета элементов на экране
    }

    @Test
    public void testAmountOfEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "qweasdqweasd123";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNotResultsOfSearch();
    }

    @Test /* Ex3 */
    //@Features(value = {@Feature(value = "Поиск"),@Feature(value = "Статья")})
    //@DisplayName("Ex3")
    //@Description("Тест ищет какое-то слово. Убеждается, что найдено несколько статей. Отменяет поиск. Убеждается, что результат поиска пропал")
    //@Step("Старт теста testSearchArticleAndCancelSearch")
    //@Severity(value = SeverityLevel.MINOR)
    public void testSearchArticleAndCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Wikipedia"; //Тест ищет слово 'Wikipedia'
        SearchPageObject.typeSearchLine(search_line);
        //способ подсчета элементов на экране
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue(
                "We found <2 results!",
                amount_of_search_results >= 2 // Убеждается, что найдено >2 статей
        );
        SearchPageObject.clickCancelSearch(); // клик на кнопку отмены поиска
        SearchPageObject.getAmountOfNotFoundArticles(); // Убеждается, что результат поиска пропал
    } /* Ex3 */

    @Test /* EX 4 */
    //@Features(value = {@Feature(value = "Поиск")})
    //@DisplayName("Ex4*: Тест: проверка слов в поиске")
    //@Description("Написать тест, который делает поиск по какому-то слову. Например, JAVA. Затем убеждается, что в каждом результате поиска есть это слово.
    // Внимание, прокручивать результаты выдачи поиска не надо. Это мы научимся делать на следующих занятиях. Пока надо работать только с теми результатами поиска, который видны сразу, без прокрутки.")
    //@Step("Старт теста testSearchArticleAndCancelSearch")
    //@Severity(value = SeverityLevel.MINOR)
    public void testCheckTextInSearchResults() {
        String value = "java";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput(); //Нашли поле поиска и нажали на него
        SearchPageObject.typeSearchLine(value); //Ввели текст из 'value' в поиск
        SearchPageObject.assertSearchResultWithText(value); /* убеждается, что в каждом результате поиска есть текст из 'value'. */
    } /* EX 4 */

    /* EX 9 */
    @Test
    //@DisplayName("Ex9*: Рефакторинг темплейта")
    //@Description("1. Подобрать локатор, который находит результат поиска одновременно по заголовку и описанию (если заголовок или описание отличается - элемент не находится).\n2. Добавить соответствующий метод в секцию TEMPLATES METHODS класса SearchPageObject.\n3. В этот же класс добавить метод waitForElementByTitleAndDescription(String title, String description). Он должен дожидаться результата поиска по двум строкам - по заголовку и описанию. Если такой элемент не появляется, тест должен упасть с читаемой и понятной ошибкой.\n4. Написать тест, который будет делать поиск по любому запросу на ваш выбор (поиск по этому слову должен возвращать как минимум 3 результата). Далее тест должен убеждаться, что первых три результата присутствуют в результате поиска.")
    public void testResultsSearch3More() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput(); //Нашли поле поиска и нажали на него
        String search_line = "lin";
        String title1 = "Linkin Park";
        String description1 = "Американская рок-группа";
        String title2 = "Linux";
        String description2 = "Семейство Unix";
        String title3 = "Linux Mint";
        String description3 = "Дистрибутив";
        SearchPageObject.typeSearchLine(search_line); //Ввели текст 'JAVA' в поиск
        SearchPageObject.waitForElementByTitleAndDescription(title1,description1);
        SearchPageObject.waitForElementByTitleAndDescription(title2,description2);
        SearchPageObject.waitForElementByTitleAndDescription(title3,description3);
    } /* Ex9 */
}