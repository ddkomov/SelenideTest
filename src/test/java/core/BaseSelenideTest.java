package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseSelenideTest {

    @BeforeEach
    public void setUp(){
//        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}

