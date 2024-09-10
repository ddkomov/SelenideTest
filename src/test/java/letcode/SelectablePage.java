package letcode;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class SelectablePage {
    private final SelenideElement testNG = $x("//h3[contains(text(), 'TestNg')]").shouldBe(visible);
    private final SelenideElement selenium = $x("//h3[contains(text(), 'Selenium')]").shouldBe(visible);
    private final SelenideElement letCode = $x("//h3[contains(text(), 'LetCode')]").shouldBe(visible);

    public SelectablePage multiClick(){
        actions().keyDown(Keys.CONTROL).build().perform();
        testNG.click();
        selenium.click();
        letCode.click();
        actions().keyUp(Keys.CONTROL).build().perform();
        return this;
    }
}
