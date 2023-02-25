package Wiki.lib.ui;

import Wiki.lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            NAME_TITLE_ARTICLE, /* EX 5 */
            FOOTER_ELEMENT,
            ADD_ARTICLE_TO_MY_LIST_FROM_OPTION, /* EX 5 */
            NAME_FOLDER_IN_LIST_FOLDERS, /* EX 5 */
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Cannot find article title on page!",15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open more options 'Ещё'",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'ПОНЯТНО' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of article folder",
                5
        );

        this.waitForElementAndSentKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    /* EX 5 */
    private static String getNameArticleFromSearchLine(String name_article) {
        return NAME_TITLE_ARTICLE.replace("{NAME_ARTICLE}", name_article);
    }
    private static String getNameFolderInListFolders(String name_folder) {
        return NAME_FOLDER_IN_LIST_FOLDERS.replace("{NAME_FOLDER}", name_folder);
    }

    public void addArticleToMyListFromSearch (String name_of_folder, String name_article) /* сохранить статью в избранное через longPress с возможностью пропуска блока первого сохранения */ {
        String article = getNameArticleFromSearchLine(name_article);
        this.longPress(article,"Cannot find Title element " + NAME_TITLE_ARTICLE);
        this.waitForElementAndClick(ADD_ARTICLE_TO_MY_LIST_FROM_OPTION, "Cannot find button add to my list in option menu", 10);
        try { /* чтобы не вызывало ошибку при сохранении второй статьи */ /* Вопрос: подобное лучше делать через if или и так норм? */
            this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY,"Cannot find 'ПОНЯТНО' tip overlay",5);
            this.waitForElementAndClear(MY_LIST_NAME_INPUT,"Cannot find input to set name of article folder",5);
            this.waitForElementAndSentKeys(MY_LIST_NAME_INPUT,name_of_folder,"Cannot put text into articles folder input",5);
            this.waitForElementAndClick(MY_LIST_OK_BUTTON,"Cannot press OK button",5);
        } catch (Exception e) {
            String folder = getNameFolderInListFolders(name_of_folder);
            this.waitForElementAndClick(folder,"Cannot find and click folder " + name_of_folder,5);
        }
    } /* EX 5 */

    public void addArticlesToMySaved() {
        if (Platform.getInstance().isMW()){
            this.removeArticleFromSavedIfAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

    public void removeArticleFromSavedIfAdded() {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }
    }

    public void closeArticle()
    {
        if (Platform.getInstance().isMW() || Platform.getInstance().isIOS()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot find title_text",
                    5
            );
        } else {
            System.out.println("Метод rotateScreenPortrait() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }

    /* EX 6 */
    public void checkHaveTitleOnPage() {
        this.assertElementPresent(TITLE, "Cannot find title element on page");
    } /* EX 6 */
}