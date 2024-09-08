package letcode;

import com.codeborne.selenide.Selenide;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;

public class LetCodeTest extends BaseSelenideTest {
    private static final String FULL_NAME = "Dmitry Komov";
    private static final String appendText = " at all";
    private static final String value = "ortonikc";
    private static final String URL = "https://letcode.in/test";

    @Test
    public void testInputPage() {
        Selenide.open(URL);
        new MainPage()
                .openInputPage()
                .enterFullName(FULL_NAME)
                .appendTextToIAmGoodAndTab(appendText)
                .checkValueAfterTab(value)
                .clearMe()
                .checkIsDisabled()
                .checkNoEdit();

    }
    @Test
    public void testButtonPage() {
        Selenide.open(URL);
        new MainPage()
                .openButtonPage()
                .checkGoToHome()
                .checkFindLocation()
                .checkMyColor()
                .checkTallFat()
                .checkDisableButton()
                .checkHoldButton();
    }
}
