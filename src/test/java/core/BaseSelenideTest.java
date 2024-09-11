package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.FileDownloadMode.PROXY;

public class BaseSelenideTest {

    @BeforeEach
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        Configuration.pageLoadTimeout = 15000;
        Configuration.timeout = 15000;
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        Configuration.downloadsFolder = "build/downloads";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

