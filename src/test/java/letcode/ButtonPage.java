package letcode;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ButtonPage {

    private final SelenideElement goToButton = $x("//button[@id='home']").shouldBe(visible);
    private final String url = "https://letcode.in/";
    private final SelenideElement findLocation = $x("//button[@id='position']").shouldBe(visible);
    private final SelenideElement myColor = $x("//button[@id='color']").shouldBe(visible);
    private final SelenideElement tallFat = $x("//button[@id='property']").shouldBe(visible);
    private final SelenideElement disableButton = $x("//button[contains(text(), 'Disabled')]").shouldBe(visible);
    private final SelenideElement holdButton= $x("//h2[contains(text(), 'Button Hold!')]");
    private final SelenideElement holdButtonAfterClick= $x("//h2[contains(text(), 'Button has been long pressed')]");


    public ButtonPage checkGoToHome() {
        goToButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, currentUrl);
        WebDriverRunner.getWebDriver().navigate().back();
        goToButton.shouldBe(visible);
        return new ButtonPage();
    }
    public ButtonPage checkFindLocation() {
        findLocation.click();
        System.out.println(findLocation.getLocation());
        Assertions.assertEquals("(295, 338)", findLocation.getLocation().toString());
        return new ButtonPage();
    }
    public ButtonPage checkMyColor() {
        myColor.shouldHave(cssValue("background-color", "rgba(138, 77, 118, 1)"));
        String color = myColor.getCssValue("background-color");
        System.out.println(color);
        return new ButtonPage();
    }
    public ButtonPage checkTallFat() {
        Assertions.assertEquals("(176, 40)", tallFat.getSize().toString());
        return new ButtonPage();
    }
    public ButtonPage checkDisableButton() {
        disableButton.shouldBe(disabled);
        return new ButtonPage();
    }
    public ButtonPage checkHoldButton() {
        holdButton.shouldBe(visible);
        Selenide.actions().moveToElement(holdButton).clickAndHold().pause(3000).release().perform();
        holdButtonAfterClick.shouldBe(visible);
        return new ButtonPage();
    }
}
