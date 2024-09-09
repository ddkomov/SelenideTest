package letcode;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;

public class AlertPage {
    private final SelenideElement simpleAlertButton = $x("//button[@id='accept']");
    private final SelenideElement confirmAlertButton = $x("//button[@id='confirm']");
    private final SelenideElement promptAlertButton = $x("//button[@id='prompt']");
    private final SelenideElement myName = $x("//p[@id='myName']");
    private final SelenideElement modernAlertButton = $x("//button[@id='modern']");
    private final SelenideElement modernAlertTitle = $x("//p[@class='title']");
    private final SelenideElement modernAlertCloseButton = $x("//button[@aria-label='close']");
    private final String alertText = "Hey! Welcome to LetCode";
    private final String modernAlertText = "Modern Alert - Some people address me as sweet alert as well";

    public AlertPage clickSimpleAlertButtonCheckTextAndAccept() {
        simpleAlertButton.click();
        Assertions.assertEquals(alertText, switchTo().alert().getText());
        switchTo().alert().accept();
        return new AlertPage();
    }

    public AlertPage clickConfirmAlertButtonPrintAndDismiss() {
        confirmAlertButton.click();
        System.out.println(switchTo().alert().getText());
        switchTo().alert().dismiss();
        return new AlertPage();
    }

    public AlertPage clickPromptAlertButtonSendKeysAndCheckName() {
        promptAlertButton.click();
        switchTo().alert().sendKeys("Dmitry");
        switchTo().alert().accept();
        myName.shouldHave(text("Your name is: Dmitry"));
        return new AlertPage();
    }

    public AlertPage clickModernAlertButtonCheckTextAndClose() {
        modernAlertButton.click();
        Assertions.assertEquals(modernAlertText, modernAlertTitle.getText());
        modernAlertCloseButton.click();
        return new AlertPage();
    }
}
