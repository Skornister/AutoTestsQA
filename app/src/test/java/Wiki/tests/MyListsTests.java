package Wiki.tests;

import Wiki.lib.CoreTestCase;
import Wiki.lib.Platform;
import Wiki.lib.ui.ArticlePageObject;
import Wiki.lib.ui.AuthorizationPageObject;
import Wiki.lib.ui.MyListsPageObject;
import Wiki.lib.ui.NavigationUI;
import Wiki.lib.ui.SearchPageObject;
import Wiki.lib.ui.factories.ArticlePageObjectFactory;
import Wiki.lib.ui.factories.MyListsPageObjectFactory;
import Wiki.lib.ui.factories.NavigationUIPageObjectFactory;
import Wiki.lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static String name_of_folder = "Learning programming";
    private static String
            login = "Skornister",
            password = "147852!a";

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput(); //нажать иконку поиска в мобил версии - нет в большом окне
        SearchPageObject.typeSearchLine("Java"); //ввести в поиск
        SearchPageObject.clickByArticleWithSubstring("зык программирования"); //нажать на статью в поиске

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement(); //подождать открытие статьи
        String article_title = ArticlePageObject.getArticleTitle(); //в String вводим название статьи

        if (Platform.getInstance().isAndroid()) /* если андроид - использовать метод походящий для андроида */ {
        ArticlePageObject.addArticleToMyList(name_of_folder); // добавить статью в Избранное - андроид
        } else {
            ArticlePageObject.addArticlesToMySaved(); //сохранить статью в Избранное - НЕандроид
        }
        if (Platform.getInstance().isMW()) /* войти в аккаунт - web */ {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton(); //нажать Войти
            Auth.enterLoginData(login, password); //ввести логин/пароль
            Auth.submitForm(); //нажать Войти / подтвердить лог/пас
            this.openWebPageFromMobileWeb("https://ru.m.wikipedia.org/");

//            ArticlePageObject.waitForTitleElement(); /* проверить - после авторизации на экране есть елементы */
//            Assert.assertEquals("===== We are not on the same page after login.",
//                    article_title, //ищем название статьи из String
//                    ArticlePageObject.getArticleTitle() //еще раз зачем то ищем название статьи, но то что показывается на странице
//            );

//            ArticlePageObject.addArticlesToMySaved(); //добавить статью в Избранное - web
        }
        if (!Platform.getInstance().isMW()) {
            ArticlePageObject.closeArticle(); //закрыть статью
        }

        NavigationUI NavigationUI = NavigationUIPageObjectFactory.get(driver);
        NavigationUI.open_Navigation(); //открыть меню навигации
        NavigationUI.clickMyLists(); //клик - в Избранное

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder); //открыть папку Избранное - андроид
            MyListsPageObject.swipeByArticleToDelete(article_title); //свайп для удаления статьи из избранного
        }
    }

    @Test /* EX 5 */
    // @Features(value = {@Feature(value = "Article"),@Feature(value = "MyLists")})
    // @DisplayName("Ex5: Тест: сохранение двух статей")
    // @Description("1. Сохраняет две статьи в одну папку 2. Удаляет одну из статей 3. Убеждается, что вторая осталась 4. Переходит в неё и убеждается, что title совпадает")
    // @Step("Starting test testSwipeArticle")
    // @Severity(value = SeverityLevel.MINOR)
    public void testSave2ArticleAndDelOne() {
        String search_line1 = "Java";
        String search_line2 = "Kotlin";
        String name_of_folder = "folderWithArticle";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIPageObjectFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        /* 1. Сохраняет две статьи в одну папку */
        SearchPageObject.initSearchInput(); /* активировали поиск */
        SearchPageObject.typeSearchLine(search_line1); /* ищем статью 1 */
        ArticlePageObject.addArticleToMyListFromSearch(name_of_folder, search_line1); // добавить статью в Избранное - андроид
        SearchPageObject.clickCancelSearch(); /* отмена поиска */
        SearchPageObject.typeSearchLine(search_line2); /* ищем статью 2 */
        ArticlePageObject.addArticleToMyListFromSearch(name_of_folder, search_line2); /* добавить статью в Избранное - андроид */
        NavigationUI.clickBackButton(); /* нажать НАЗАД для выхода из поиска на главный экран */
        NavigationUI.clickMyLists(); /* клик - в Избранное */
        MyListsPageObject.openFolderByName(name_of_folder); /* открыть папку Избранное - андроид */
        /* 2. Удаляет одну из статей */
        MyListsPageObject.swipeByArticleToDelete(search_line2); /* свайп для удаления статьи из избранного */
        /* 3. Убеждается, что вторая осталась  */
        MyListsPageObject.checkTitleArticleInFolder(search_line1);
        /* 4. Переходит в неё и убеждается, что title совпадает */
        MyListsPageObject.openArticleByName(search_line1); /* открываем другую статью и убеждается, что title совпадает */
    } /* EX 5 */
}