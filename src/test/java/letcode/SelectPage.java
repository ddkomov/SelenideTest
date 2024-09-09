package letcode;

import com.codeborne.selenide.SelenideElement;


import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;


public class SelectPage {
    public final SelenideElement fruits = $x("//select[@id='fruits']");
    public final SelenideElement subtitle1 = $x("//p[contains(text(), 'Apple')]");
    public final SelenideElement superheros = $x("//select[@id='superheros']");
    public final SelenideElement subtitle2 = $x("//p[contains(text(), 'Spider-Man')]");
    public final SelenideElement lang = $x("//select[@id='lang']");
    public final SelenideElement subtitle3 = $x("//p[contains(text(), 'Java')]");
    public final SelenideElement country = $x("//select[@id='country']");



    public SelectPage selectFruit() {
        fruits.selectOptionContainingText("Apple");
        subtitle1.shouldHave(text("Apple"));
        return new SelectPage();
    }
    public SelectPage selectSuperHero() {
        superheros.selectOptionContainingText("Spider-Man");
        subtitle2.shouldHave(text("Spider-Man"));
        return new SelectPage();
    }
    public SelectPage selectProgrammingLanguageAndPrintAll() {
        lang.selectOptionByValue("java");
        subtitle3.shouldHave(text("Java"));
        List<String> options = lang.getOptions().texts();
        for (String option : options) {
            System.out.println(option);
        }
        return new SelectPage();
    }
    public SelectPage selectCountryByIndexAndPrint() {
        country.selectOption(6);
        System.out.println(country.getSelectedOption().getText());
        return new SelectPage();
    }
}
