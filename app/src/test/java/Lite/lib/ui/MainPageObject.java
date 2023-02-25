package Lite.lib.ui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;
import Lite.lib.Platform;
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

    // 11. Ждать появление елемента, а если не найден за 5 сек - ошибка
    public WebElement waitForElementPresent(String locator, String error_message) {
        return waitForElementPresent(locator, error_message, 5);
    } // 11. Ждать появление елемента, а если не найден за 5 сек - ошибка
    // 11. Ждать появление елемента, а если не найден за 5 сек - ошибка
    public WebElement waitForElementPresent(String locator, String error_message, long timeWait_in_sec) {
        sleep(200);
        By by = this.get_LocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeWait_in_sec);
        wait.withMessage("\n" + "=====> " + error_message + "<=====" + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    } // 11. Ждать появление елемента, а если не найден за 5 сек - ошибка
    // 12. Ждать появление елемента + клик по нему
    public WebElement waitForElementAndClick(String locator, String error_message, long timeWait_in_sec) {
        WebElement element = waitForElementPresent(locator, error_message, timeWait_in_sec);
        element.click();
        return element;
    } // 12. Ждать появление елемента + клик по нему
    // 13. Ждать появление елемента + лонгтап по нему
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
            int middleY = (upperY + lowerY) / 2; //Поиск середины элемента по X и Y

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action
                    .longPress(PointOption.point(rightX, middleY)) //Удерживать елемент 3 сек
                    .release() //обязательно
                    .perform(); //обязательно
        } else {
            System.out.println("Метод longPress() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    } // 13. Ждать появление елемента + лонгтап по нему
    // 14. Ждать появление елемента + ввод key в него
    public WebElement waitForElementAndSentKeys(String locator, String sendKeys, String error_message, long timeWait_in_sec) {
        WebElement element = waitForElementPresent(locator, error_message, timeWait_in_sec);
        element.sendKeys(sendKeys);
        return element;
    }  // 14. Ждать появление елемента + ввод key в него
    // 15. Ждать появление елемента + чистка поля ввода
    public WebElement waitForElementAndClear(String locator, String error_message, long timeWait_in_sec) {
        WebElement element = waitForElementPresent(locator, error_message, timeWait_in_sec);
        element.clear();
        return element;
    } // 15. Ждать появление елемента + чистка поля ввода
    // 16. Ждать появление елемента + свайп его влево
    public void swipeElementToLeft(String locator, String error_message, int secodns) {
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

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action
                    .press(PointOption.point(rightX, middleY)) //Нажать на середину элемента
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(secodns))) //Время удержания во время свайпа
                    .moveTo(PointOption.point(leftX, middleY)) //Свайп влево
                    .release() //обязательно
                    .perform(); //обязательно
        } else {
            System.out.println("Метод swipeElementToLeft() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    } // 16. Ждать появление елемента + свайп его
    // 17. Ждать пропадание елемента //boolean - метод возвращает true or false
    public boolean waitForElementNotPresent(String locator, String error_message, long timeWait_in_sec) {
        sleep(200);
        By by = this.get_LocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeWait_in_sec);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    } // 17. Ждать пропадание елемента

    //Метод свайпа вверх
    public void swipeUp(int time_swipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver)driver);
            //узнать размер экрана
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2; //находим центр по горизонтали
            int startY = (int) (size.height * 0.8); //старт чуть ниже центра экрана по вертикали
            int endY = (int) (size.height * 0.2); //закончить чуть выше центра экрана по вертикали

            action
                    .press(PointOption.point(x, startY)) //Нажать
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(time_swipe))) //Время удержания во время свайпа
                    .moveTo(PointOption.point(x, endY))
                    .release() //обязательно
                    .perform(); //perform - отсылает все написанные действия на выполнение - обязательно
        } else {
            System.out.println("Метод swipeUp() не работает на платформе " + Platform.getInstance().getPlatformVar());
        }
    }
    //Быстрый свайп вверх
    public void swipeUPQuick() {
        swipeUp(200);
    }

    // 25. Скрол вниз до показа элемента на экране
    public void swipeUpToFindElement(String locator, String error_message, int количество_свайпов) {
        //В переменную записывается колличество реальных свайпов
        int already_swiped = 0;
        //Метод запускает цикл дейсвий до момента как найдет элемент
        By by = this.get_LocatorByString(locator);
        while (driver.findElements(by).size() == 0){
            //условие - ошибка, если элемент не найден после 'количество_свайпов'
            if(already_swiped > количество_свайпов){
                waitForElementPresent(locator, "Can't find element by swiping up\n" + error_message, 0);
                return;
            }
            swipeUPQuick();
            already_swiped++;
        }
    } // 25. Скрол вниз до показа элемента на экране

    // 31. Подсчитать кол элементов - если нужно посчитать количество элементов на экране
    public int get_КоличествоЭлементов(String locator) {
        By by = this.get_LocatorByString(locator);
        List elements = driver.findElements(by); //List создает некий список
        return elements.size(); //вернуть колличество элементов в List, которое нашлось драйвером
    } // 31. Подсчитать кол элементов

    // Проверить отсутствие элементов через get_КоличествоЭлементов
    public void check_ЭлементаНет(String locator, String error_message) {
        int количествоЭлементов = get_КоличествоЭлементов(locator); //Вычисляем количество элементов в поиске по переданному Xpath
        if (количествоЭлементов > 0) { //Если элементов больше 0, то мы формируем ошибку
            String defaultMessage = "An element '" + locator + "' supposed to be not present - Элемент '" + locator + "' предположительно отсутствует";
            throw new AssertionError(defaultMessage + " " + error_message);
        }
    }
    // 32. Поиск атрибута на экране
    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeWait_in_sec) {
        WebElement element = waitForElementPresent(locator, error_message, timeWait_in_sec);
        return element.getAttribute(attribute);
    } // 32. Поиск атрибута на экране

    // 50. Метод определения локаторов xpath id css
    private By get_LocatorByString(String locator_with_type) {
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
            throw new IllegalArgumentException("===== Cannot get typ of locator. Locator: " + locator_with_type);
        }
    } // 50. Метод определения локаторов xpath id

    //Ex2 Функция, которая проверяет наличие ожидаемого текста у элемента
    public void assertElementHasText(String locator, String value, String errorMessage) {
        Assert.assertEquals(
                "ElementText not equals expected value",
                waitForElementPresent(locator, errorMessage).getAttribute("text"),
                value
        );
    }
    //Ex3
    public List<WebElement> waitForAllElementsPresent(String locator, String error_message, long timeWait_in_sec) {
        sleep(200);
        By by = this.get_LocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeWait_in_sec);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    /* sleep in millis */
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
11. Ждать появление елемента ++
12. Ждать появление елемента + клик по нему ++
13. Ждать появление елемента + лонгтап по нему ++
14. Ждать появление елемента + ввод key в него ++
15. Ждать появление елемента + чистка поля ввода ++
16. Ждать появление елемента + свайп его ++
17. Ждать пропадание елемента ++

21. Свайп вверх
22. Свайп вниз
23. Свайп влево
24. Свайп вправо
25. Скрол вниз до показа элемента на экране ++
26. Скрол вверх до показа элемента на экране

31. Подсчитать кол элементов ++
32. Поиск атрибута на экране ++

50. Метод определения локаторов xpath id
*/