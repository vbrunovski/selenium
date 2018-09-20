package testovoeZadanie;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexTest {
    static WebDriver driver;
    private final static String URL = "http://yandex.ru";
    YandexPage yp = new YandexPage(driver);
    MarketPage mp = new MarketPage(driver);

    @BeforeClass
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /*
    1. Открыть браузер и развернуть на весь экран.
    2. Зайти на yandex.ru.
    3. В разделе маркет выбрать Сотовые телефоны.
    4. Зайти в расширенный поиск.
    5. Задать параметр поиска до 20000 рублей и Диагональ экрана от 3 дюймов.
    6. Выбрать не менее 5 любых производителей, среди популярных.
    7. Нажать кнопку Подобрать.
    8. Проверить, что элементов на странице 10.
    9. Запомнить первый элемент в списке.
    10. Изменить Сортировку на другую (популярность или новизна).
    11. Найти и нажать по имени запомненного объекта.
    12. Вывести цифровое значение его оценки.
    13. Закрыть браузер.
     */

    @Test
    public void testYandexMarket() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        yp.clickToMarket();
        mp.clickToMobileSection();
        mp.clickToPriceRange();
        //mp.checkElementCount();
        Thread.sleep(2000);
        mp.checkElementsCount();
        mp.saveFirstElementProduct();
        mp.changeSort();
        mp.clickOnFirstElementProduct();
    }


}
