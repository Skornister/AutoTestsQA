package Wiki.lib.ui;

import Wiki.lib.Platform;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    //Метод Поиск элемента, а если не найден за 5 сек - ошибка
    public WebElement waitForElementPresent(String locator, String error_message) {
        return waitForElementPresent(locator, error_message, 5);
    }

    //Метод Подождать появления элемента, а если не найден за 5 сек - ошибка
    public WebElement waitForElementPresent(String locator, String error_message, long timeOut_inSec) {
        sleep(100);
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut_inSec);
        wait.withMessage("\n=====> " + error_message + "<=====" + "\nUsed locator: " + locator + "\n");
        System.out.println("  |> waitForElementPresent() ...OK  | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //Метод Ждем пропадания элемента //boolean - метод возвращает true or false
    public boolean waitForElementNotPresent(String locator, String error_message, long timeOut_inSec) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut_inSec);
        wait.withMessage("\n=====> " + error_message + "<=====" + "\nUsed locator: " + locator + "\n");
        System.out.println("  |> waitForElementNotPresent() ...OK  | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Проверить отсутствие элементов
    public void assertElementNotPresent(String locator, String error_message) {
        int amount_of_elements = getAmountOfElements(locator); //Вычисляем количество элементов в поиске по переданному Xpath
        if (amount_of_elements > 0) { //Если элементов больше 0, то мы формируем ошибку
            String defaultMessage = " An element '" + locator + "' supposed to be not present";
            throw new AssertionError(defaultMessage + " " + error_message);
        } System.out.println("  |> assertElementNotPresent() ...OK  | Used locator: " + locator);
    }

    /* EX 4 */ /* проверка наличия элемента в массиве строк */
    public List<WebElement> waitForAllElementsPresent(String locator, String error_message, long timeOut_inSec) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut_inSec);
        wait.withMessage("\n=====> " + error_message + "<=====" + "\nUsed locator: " + locator);
        System.out.println("  |> waitForAllElementsPresent() ...OK  | Used locator: " + by);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    } /* проверка наличия элемента в массиве строк */ /* EX 4 */

    //Метод Подождать появление элемента, а затем клик по нему
    public WebElement waitForElementAndClick(String locator, String error_message, long timeOut_inSec) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut_inSec);
        element.click();
        System.out.println("  |> waitForElementAndClick() ...OK  | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
        return element;
    }

    //Метод Подождать появление элемента и value текста в него
    public WebElement waitForElementAndSentKeys(String locator, String value, String error_message, long timeOut_inSec) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut_inSec);
        element.sendKeys(value);
        System.out.println("  |> waitForElementAndSentKeys('" + value + "') ...OK  | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
        return element;
    }

    //Метод очистки элемента от текста
    public WebElement waitForElementAndClear(String locator, String error_message, long timeOut_inSec) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut_inSec);
        element.clear();
        System.out.println("  |> waitForElementAndClear() ...OK  | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
        return element;
    }

    /* EX 2 */
    public void assertElementHasText(String locator, String value, String errorMassage, long timeOut_inSec) /* Поиск наличия указанного текста в элементе */
    {
        WebElement element = waitForElementPresent(locator, errorMassage, timeOut_inSec);
        Assert.assertEquals(
                errorMassage + "\nNOW Actual element.getText = " + element.getText(),
                value,
                element.getText()
        );
        System.out.println("  |> assertElementHasText('" + value + "' && '" + element.getText() + "') ...OK | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
    }
    /* EX 2 */
    public void assertElementNotHasText(String locator, String value, String errorMassage, long timeOut_inSec) /* Поиск отсутствие указанного текста в элементе */
    {
        WebElement element = waitForElementPresent(locator, errorMassage, timeOut_inSec);
        Assert.assertNotEquals(
                errorMassage + "\nNOW Actual element.getText = " + element.getText(),
                value,
                element.getText()
        );
        System.out.println("  |> assertElementNotHasText('" + value + "' && '" + element.getText() + "') ...OK | Used locator: " + locator + " | timeOut_in_Sec: " + timeOut_inSec);
    } /* EX 2 */

    /* EX 6 */
    public void assertElementPresent(String locator, String errorMassage) {
        By by = this.getLocatorByString(locator);
        WebElement element = driver.findElement(by);
        Assert.assertEquals(
                errorMassage + "\nNOW Actual element.getText = " + element.getText(),
                element.getText());
        System.out.println("  |> assertElementPresent('" + element.getText() + "') ...OK  | Used locator: " + locator);
    } /* EX 6 */

    //Метод свайпа
    public void swipeUp(int time_swipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            //узнать размер экрана
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2; //находим центр по горизонтали
            int startY = (int) (size.height * 0.8); //старт чуть ниже центра экрана по вертикали
            int endY = (int) (size.height * 0.2); //закончить чуть выше центра экрана по вертикали

            action
                    .press(PointOption.point(x, startY)) //Нажать
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time_swipe))) //Время удержания во время свайпа
                    .moveTo(PointOption.point(x, endY))
                    .release() //обязательно
                    .perform(); //perform - отсылает все написанные действия на выполнение - обязательно
        } else {System.out.println("Метод swipeUp() не работает на платформе " + Platform.getInstance().getPlatformVar());}
        System.out.println("  |> swipeUp() " + time_swipe + " times ...OK");
    }

    //Быстрый свайп вверх
    public void swipeUPQuick(int time_swipe) {
        swipeUp(time_swipe);
    }

    public void scrollWebPageUP() /* местод свайва для web*/ {
        if (Platform.getInstance().isMW()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0, 400)");
        } else {
            System.out.println("Метод scrollWebPageUP() not work on platform не работает на платформе " + Platform.getInstance().getPlatformVar());
        } System.out.println("  |> scrollWebPageUP() ...OK");
    }

    public void scrollWebPageTillElementNotVisible(String locator, String error_message, int количество_свайпов) /* свайп до элемента на экране для web */ {
        int already_swipe = 0;

        WebElement element = this.waitForElementPresent(locator, error_message);

        while (!this.isElementLocatedOnTheScreen(locator)) /* восклицательный знак перед выражением - его отрицание */ {
            scrollWebPageUP();
            ++already_swipe;
            if (already_swipe > количество_свайпов) {
                Assert.assertTrue(error_message, element.isDisplayed());
            }
        } System.out.println("  |> scrollWebPageTillElementNotVisible() - scrollWebPageUP: " + already_swipe + "/" + количество_свайпов + " times ...OK  | Used locator: " + locator);
    }

    //Метод свайпа до нахождения элемента
    public void swipeUpToFindElement(String locator, String error_message, int количество_свайпов) {
        int already_swiped = 0; /* В переменную записывается колличество реальных свайпов */
        By by = this.getLocatorByString(locator); /* Метод запускает цикл дейсвий до момента как найдет элемент */
        while (driver.findElements(by).size() == 0){
            if(already_swiped > количество_свайпов) /* условие - ошибка, если элемент не найден после 'количество_свайпов' */{
                waitForElementPresent(locator, "Can't find element by swiping up\n" + error_message, 0);
                return;
            }
            swipeUPQuick(400);
            ++already_swiped;
        } System.out.println("  |> swipeUpToFindElement() - swipeUPQuick: " + already_swiped + "/" + количество_свайпов + " times ...OK  | Used locator: " + locator);
    }

    public void swipeUpTillElementAppear(String locator, String error_message, int количество_свайпов) /* Свайп до нахождения елемента на экране - web */{
        int already_swiped = 0;
        while (!this.isElementLocatedOnTheScreen(locator)) {
            if(already_swiped > количество_свайпов) {
                Assert.assertTrue(error_message, this.isElementLocatedOnTheScreen(locator));
            }
            swipeUPQuick(400);
            ++already_swiped;
        } System.out.println("  |> swipeUpTillElementAppear() - swipeUPQuick: " + already_swiped + "/" + количество_свайпов + " times ...OK  | Used locator: " + locator);
    }

    public boolean isElementLocatedOnTheScreen(String locator) /* Метод свайпа до нахождения элемента для iOS - для swipeUpTillElementAppear */ {
        int element_located_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 1).getLocation().getY(); /* находим элемент и получаем его расположение по оси Y */
        if (Platform.getInstance().isMW()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            Object js_result = JSExecutor.executeScript("return window.pageYOffset");
            element_located_by_y -= Integer.parseInt(js_result.toString()); /* результат скрипта переводим в String, затем парим его в Int и этот Int вычитаем из значения element_located_by_y */
        }
        int screen_size_by_y = driver.manage().window().getSize().getHeight(); /* Получаем длину всего экрана */
        System.out.println("  |> isElementLocatedOnTheScreen() ...OK  | Used locator: " + locator);
        return element_located_by_y < screen_size_by_y; /* когда доскролим до элемента возвращается true */
    }

    public void clickElementToTheRightUpperCorner(String locator, String error_message) /* Клик на правую часть элемента */ {
        if (driver instanceof AppiumDriver) {
        WebElement element = this.waitForElementPresent(locator + "/..", error_message); /* "/.." - переход на элемент выше */
        int rightX = element.getLocation().getX();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().height;
        int middleY = (upperY + lowerY) / 2;
        int width = element.getSize().getWidth();

        int point_to_clickX = (rightX + width) - 3;
        int point_to_clickY = middleY;

        TouchAction action = new TouchAction((AppiumDriver) driver);
        action.tap(PointOption.point(point_to_clickX, point_to_clickY)).perform();
        } else {
            System.out.println("Метод clickElementToTheRightUpperCorner() не работает на платформе " + Platform.getInstance().getPlatformVar());
        } System.out.println("  |> clickElementToTheRightUpperCorner() ...OK  | Used locator: " + locator);
    }

    //Поиск середины элемента по X и Y
    public void swipeElementToLeft(String locator, String error_message) {
        if (driver instanceof AppiumDriver) {
        WebElement element = waitForElementPresent(
                locator,
                error_message,
                15);
        int leftX = element.getLocation().x; //Поиск левой точки элемента
        int rightX = leftX + element.getSize().width; //Поиск правой точки элемента
        int upperY = element.getLocation().y; //Поиск верхней точки элемента
        int lowerY = upperY + element.getSize().height; //Поиск нижней точки элемента
        int  middleY = (upperY + lowerY) / 2; //Поиск середины элемента по X и Y

        TouchAction action = new TouchAction((AppiumDriver) driver);
        action.press(PointOption.point(rightX, middleY)); //Нажать на середину элемента
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))); //Время удержания во время свайпа

        if (Platform.getInstance().isAndroid()) {
            action.moveTo(PointOption.point(leftX, middleY)); //Свайп влево
        } else {
            int offset_x = (-1 * element.getSize().getHeight()); /* Получаем ширину элемента, умножаем на -1 */
            action.moveTo(PointOption.point(offset_x, 0)); /* Передвинуть к offset_x по оси X */
        }
        action.release(); //обязательно
        action.perform(); //обязательно
        } else {
            System.out.println("Метод swipeElementToLeft() не работает на платформе " + Platform.getInstance().getPlatformVar());
        } System.out.println("  |> swipeElementToLeft() ...OK  | Used locator: " + locator);
    }

    //longPress по элементу
    public void longPress(String locator, String error_message) {
        if (driver instanceof AppiumDriver) {
        WebElement element = waitForElementPresent(
                locator,
                error_message,
                15);

            int leftX = element.getLocation().x; //Поиск левой точки элемента
            int rightX = leftX + element.getSize().width; //Поиск правой точки элемента
            int upperY = element.getLocation().y; //Поиск верхней точки элемента
            int lowerY = upperY + element.getSize().height; //Поиск нижней точки элемента
            int  middleY = (upperY + lowerY) / 2; //Поиск середины элемента по X и Y

        TouchAction action = new TouchAction((AppiumDriver) driver);
        action
                .longPress(PointOption.point(rightX, middleY)) //Удерживать елемент
                .release() //обязательно
                .perform(); //обязательно
        } else {
            System.out.println("Метод longPress() не работает на платформе " + Platform.getInstance().getPlatformVar());
        } System.out.println("  |> longPress() ...OK  | Used locator: " + locator);
    }

    /* ждем мсек */
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } /* System.out.println("  |> sleep(millis: " + millis + ") ...OK"); */
    }

    //Для подсчета элементов
    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by); //List создает некий список
        System.out.println("  |> getAmountOfElements(elements: " + elements + ") ...OK  | Used locator: " + locator);
        return elements.size(); //вернуть колличество элементов в List, которое нашлось драйвером
    }

    public boolean isElementPresent(String locator) {
        return getAmountOfElements(locator) > 0;
    }

    public void tryClickElementWithFewAttempts(String locator, String error_message, int количество_попыток) /* кликать до ошибки или до заданного количество раз - для анимации появления елемента */ {
        int current_attempts = 0; /* сколько раз уже попробовали кликнуть на момент начала запуска - это 0 */
        sleep(200);
        boolean need_more_attempts = true; /* остановить клики если кликнули больше раз чем нужно */

        while (need_more_attempts) {
            try /* блок для обработки ошибок */ {
                this.waitForElementAndClick(locator, error_message, 5);
                need_more_attempts = false;
            } catch (Exception e) /* ловим ошибку */{
                if (current_attempts > количество_попыток) /* последняя попытка клика */ {
                    this.waitForElementAndClick(locator, error_message, 1);
                }
            }
            ++current_attempts; /* увеличивать на 1 при каждой попытке клика */
        } System.out.println("  |> tryClickElementWithFewAttempts('" + current_attempts + "' && '" + количество_попыток + "') ...OK  | Used locator: " + locator);
    }

    //Метод Проверка наличия атрибута на экране
    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeOut_inSec) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut_inSec);
        return element.getAttribute(attribute);
    }

    //Метод определения локаторов xpath id
    private By getLocatorByString(String locator_with_type)  // id:someid // xpath:somexpath
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("!*!*! Cannot get typ of locator. Locator: " + locator_with_type);
        }
    }

    public void clickElementOrOtherElement(String locator1, String locator2, String error_message, long timeOut_inSec) /* поиск элемента locator1 и клик на него, если не найден, поиск и клик на другой - locator2 */ {
        this.isElementPresent(locator1);
        if (this.isElementPresent(locator1)) {
            this.waitForElementAndClick(locator1, error_message, timeOut_inSec);
        } else {
            this.waitForElementAndClick(locator2, error_message, timeOut_inSec);
        }
    }

    public String takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot taken screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    //@Attachment
    public static byte[] screenshot(String path) {
        byte[]  bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }
}