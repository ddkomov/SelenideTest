package letcode;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class FramePage {
    private final SelenideElement firstName = $x("//input[@name='fname']");
    private final SelenideElement lastName = $x("//input[@name='lname']");
    private final SelenideElement enteredText = $x("//p[@class='title has-text-info']");
    private final SelenideElement email = $x("//input[@name='email']");

    public FramePage setFirstAndLastNameAndCheck() {
        switchTo().frame($x("//iframe[@src='frameUI']"));
        firstName.sendKeys("Dmitry");
        lastName.sendKeys("Komov");
        enteredText.shouldHave(text("Dmitry Komov"));
        return new FramePage();
    }
    public FramePage setEmailAndCheck() {
        switchTo().frame($x("//iframe[@src='innerFrame']"));
        email.sendKeys("komov93@gmail.com");
        return new FramePage();
    }

}
