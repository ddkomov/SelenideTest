package letcode;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;



import static com.codeborne.selenide.Selenide.$x;

public class RadioPage {
    private final SelenideElement selectAnyOne = $x("//div[@class='control']//label[1]//input[@id='yes']");
    private final SelenideElement onlyOneRadioButtonYES = $x("//div[@class='control']//label[1]//input[@name='one']");
    private final SelenideElement onlyOneRadioButtonNO = $x("//div[@class='control']//label[2]//input[@id='two']");
    private final SelenideElement bugNO = $x("//div[@class='control']//label[2]//input[@id='bug']");
    private final SelenideElement bugYES = $x("//div[@class='control']//label[1]//input[@id='nobug']");
    private final SelenideElement whichOneIsSelectedFoo = $x("//div[@class='control']//label[1]//input[@id='foo']");
    private final SelenideElement whichOneIsSelectedNotFoo = $x("//div[@class='control']//label[2]//input[@id='notfoo']");
    private final SelenideElement lastFieldDisabled = $x("//div[@class='control']//label[3]//input[@id='maybe']");
    private final SelenideElement rememberMeCheckBox = $x("//*[contains(text(), 'Remember me')]//input");
    private final SelenideElement termsAndConditionsBox = $x("//*[contains(text(), ' I agree to the ')]//input");

    public RadioPage clickYesOnSelectAnyOne() {
        selectAnyOne.click();
        return new RadioPage();
    }

    public RadioPage clickOnlyOneRadioButtonAndCheckSelected() {
        onlyOneRadioButtonYES.click();
        Assertions.assertTrue(onlyOneRadioButtonYES.isSelected());
        Assertions.assertFalse(onlyOneRadioButtonNO.isSelected());
        return new RadioPage();
    }

    public RadioPage findBug() {
        bugYES.click();
        bugNO.click();
        Assertions.assertTrue(bugYES.isSelected());
        Assertions.assertTrue(bugNO.isSelected());
        System.out.println("bug found");
        return new RadioPage();
    }

    public RadioPage whichOneIsSelected() {
        Assertions.assertNull(whichOneIsSelectedFoo.getAttribute("checked"), "Foo selected");
        Assertions.assertTrue(Boolean.parseBoolean(whichOneIsSelectedNotFoo.getAttribute("checked")), "Bar not selected");
        return new RadioPage();
    }

    public RadioPage lastFieldDisabled() {
        Assertions.assertFalse(lastFieldDisabled.isEnabled(), "last field enabled");
        return new RadioPage();
    }
    public RadioPage rememberMeCheckBox() {
        Assertions.assertTrue(rememberMeCheckBox.isSelected(), "remember me not checked");
        return new RadioPage();
    }
    public RadioPage termsAndConditionsBox() {
        Assertions.assertFalse(termsAndConditionsBox.isSelected(), "terms and conditions box selected");
        return new RadioPage();
    }
}
