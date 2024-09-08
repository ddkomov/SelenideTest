package letcode;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement input = $x("//a[contains(text(), 'Edit')]").shouldBe(visible);


    public MainPage(){


    }
    public InputPage openInputPage() {
        input.click();
        return new InputPage();
    }
}
