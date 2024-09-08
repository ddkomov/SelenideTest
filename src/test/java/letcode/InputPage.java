package letcode;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class InputPage {

    private final SelenideElement inputFullName = $x("//input[@placeholder='Enter first & last name']").shouldBe(visible);
    private final SelenideElement inputIAmGood = $x("//input[@value='I am good']").shouldBe(visible);
    private final SelenideElement inputOrtonikc = $x("//input[@id='getMe']");
    public InputPage(){}

    public InputPage enterFullName(String fullName) {
        inputFullName.setValue(fullName);
        Assertions.assertEquals(fullName, inputFullName.getValue());
        return new InputPage();
    }

    public InputPage appendTextToIAmGoodAndTab(String text) {
        inputIAmGood.sendKeys(text);
        Assertions.assertEquals("I am good at all", inputIAmGood.getValue());
        return new InputPage();
    }

    public InputPage checkValueAfterTab(String value) {
        Assertions.assertEquals(value, inputOrtonikc.getAttribute("value"));
        return new InputPage();

    }
}
