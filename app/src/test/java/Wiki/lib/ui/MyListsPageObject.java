package Wiki.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wiki.lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

        protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON,
            NAME_TITLE_ARTICLE; /* EX 5 */

    private static String getFolderXpathByName(String name_of_folder) /* подмена значения в этот String через {FOLDER_NAME} */ {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle(String article_title) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }
    /* EX 5 */
    private static String getNameTitleArticle(String article_title) {
        return NAME_TITLE_ARTICLE.replace("{TITLE}", article_title);
    } /* EX 5 */

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }


    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getSavedArticleXpathByTitle(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }
    /* EX 5 */
    public void openArticleByName(String name_of_article) {
        String article_name_xpath_on_list = getRemoveButtonByTitle(name_of_article);
        this.waitForElementAndClick(article_name_xpath_on_list,"Cannot find article by name " + name_of_article,5);
        String article_name_xpath_on_page = getNameTitleArticle(name_of_article);
        this.waitForElementPresent(article_name_xpath_on_page,"Cannot find article by name " + article_name_xpath_on_page,15); /* убеждается, что title совпадает */
    }

    private static String getNameArticleFromSearchLine(String name_article) {
        return NAME_TITLE_ARTICLE.replace("{TITLE}", name_article);
    }
    public void checkTitleArticleInFolder(String name_article) {
        String article = getNameArticleFromSearchLine(name_article);
        this.waitForElementPresent(article, "title article wrong - " + name_article, 10);
    } /* EX 5 */

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath,"Cannot find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath,"Saved article still present with title " + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);

        if (Platform.getInstance().isMW() || Platform.getInstance().isIOS()) {
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article"
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.swipeElementToLeft(
                    remove_locator, "Article not del after swipe " + remove_locator
            );
        }

        if (Platform.getInstance().isIOS()) {
        this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(article_title);
    }
}