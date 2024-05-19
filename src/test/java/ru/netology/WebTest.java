package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WebTest {
    private WebDriver driver;

    //   @BeforeAll
//    static void setUpAll() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\YZhilina\\Documents\\Documents\\Lena\\OWN\\Netology\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//    }


    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");

    }


    @AfterEach
    void tesrDwn() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest() throws InterruptedException {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+77772100609");
        driver.findElement(By.cssSelector("[data-test-id=agreement] input")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success].input")).getText();
        assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

        Thread.sleep(10000);
    }
}


