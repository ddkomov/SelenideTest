package letcode;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class InputPage {

    private final SelenideElement inputFullName = $x("//input[@placeholder='Enter first & last name']").shouldBe(visible);
    private final SelenideElement inputIAmGood = $x("//input[@value='I am good']").shouldBe(visible);
    private final SelenideElement inputOrtonikc = $x("//input[@id='getMe']").shouldBe(visible);
    private final SelenideElement inputClearMe = $x("//input[@id='clearMe']").shouldBe(visible);
    private final SelenideElement inputIsDisabled = $x("//input[@id='noEdit']").shouldBe(visible);
    private final SelenideElement inputNoEdit = $x("//input[@id='dontwrite']").shouldBe(visible);


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

    public InputPage clearMe() {
        inputClearMe.clear();
        Assertions.assertEquals("", inputClearMe.getValue());
        return new InputPage();
    }

    public InputPage checkIsDisabled() {
        Assertions.assertEquals(false, inputIsDisabled.isEnabled());
        return new InputPage();
    }

    public InputPage checkNoEdit() {
        try {
            inputNoEdit.sendKeys("This");
        } catch (RuntimeException e) {
            System.out.println("This text is readonly");
        }

        Assertions.assertEquals("This text is readonly", inputNoEdit.getValue());
        return new InputPage();
    }
}
