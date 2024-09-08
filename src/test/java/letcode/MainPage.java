package letcode;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement input = $x("//a[contains(text(), 'Edit')]").shouldBe(visible);
    private final SelenideElement click = $x("//a[contains(text(), 'Click')]").shouldBe(visible);

    public ButtonPage openButtonPage() {
        click.click();
        return new ButtonPage();
    }
    public InputPage openInputPage() {
        input.click();
        return new InputPage();
    }
}
