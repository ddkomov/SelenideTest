package letcode;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class SliderPage {
    private final SelenideElement slider = $x("//*[@id='generate']");
    private final SelenideElement getCountries = $x("//*[contains(text(),'Get Countries')]");
    private final SelenideElement countryList = $x("//*[@class='has-text-primary-light']");

    public SliderPage clickSlideAndGetCountries() {
        actions().dragAndDropBy(slider, 500, 0).build().perform();
        getCountries.click();
        String countryString = countryList.getText();
        String[] countryListArray = countryString.split("-");
        for (String country : countryListArray)
            System.out.println(country);
        int countCounties = countryListArray.length;
        Assertions.assertEquals(50, countCounties);
        return this;
    }
}
