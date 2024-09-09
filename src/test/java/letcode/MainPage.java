package letcode;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement input = $x("//a[contains(text(), 'Edit')]").shouldBe(visible);
    private final SelenideElement click = $x("//a[contains(text(), 'Click')]").shouldBe(visible);
    private final SelenideElement dropDown = $x("//a[contains(text(), 'Drop-Down')]").shouldBe(visible);
    private final SelenideElement dialog = $x("//a[contains(text(), 'Dialog')]").shouldBe(visible);
    private final SelenideElement frame = $x("//a[contains(text(), 'Inner HTML')]").shouldBe(visible);
    private final SelenideElement toggle = $x("//a[contains(text(), 'Toggle')]").shouldBe(visible);

    public ButtonPage openButtonPage() {
        click.click();
        return new ButtonPage();
    }
    public InputPage openInputPage() {
        input.click();
        return new InputPage();
    }
    public SelectPage openSelectPage() {
        dropDown.click();
        return new SelectPage();
    }
    public AlertPage openAlertPage() {
        dialog.click();
        return new AlertPage();
    }
    public FramePage openFramePage() {
        frame.click();
        return new FramePage();
    }
    public RadioPage openRadioPage() {
        toggle.click();
        return new RadioPage();
    }
}
