package letcode;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class MainPage {
    private final SelenideElement input = $x("//a[contains(text(), 'Edit')]").shouldBe(visible);
    private final SelenideElement click = $x("//a[contains(text(), 'Click')]").shouldBe(visible);
    private final SelenideElement dropDown = $x("//a[contains(text(), 'Drop-Down')]").shouldBe(visible);
    private final SelenideElement dialog = $x("//a[contains(text(), 'Dialog')]").shouldBe(visible);
    private final SelenideElement frame = $x("//a[contains(text(), 'Inner HTML')]").shouldBe(visible);
    private final SelenideElement toggle = $x("//a[contains(text(), 'Toggle')]").shouldBe(visible);
    private final SelenideElement tabs = $x("//a[contains(text(), 'Tabs')]").shouldBe(exist);
    private final SelenideElement findElements = $x("//a[@href='/elements']").shouldBe(visible);
    private final SelenideElement AUI1 = $x("//a[contains(text(), 'AUI - 1')]").shouldBe(visible);
    private final SelenideElement AUI2 = $x("//a[contains(text(), 'AUI - 2')]").shouldBe(visible);
    private final SelenideElement AUI3 = $x("//a[contains(text(), 'AUI - 3')]").shouldBe(visible);
    private final SelenideElement AUI4 = $x("//a[contains(text(), 'AUI - 4')]").shouldBe(visible);
    private final SelenideElement AUI5 = $x("//a[contains(text(), 'AUI - 5')]").shouldBe(visible);
    private final SelenideElement simpleTable = $x("//a[contains(text(), 'Simple table')]").shouldBe(visible);
    private final SelenideElement file = $x("//a[contains(text(), 'File management')]").shouldBe(visible);
    private final SelenideElement DOM = $x("//a[contains(text(), 'DOM')]").shouldBe(visible);

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
    public WindowsPage openWindowsPage() {
        tabs.click();
        return new WindowsPage();
    }
    public ElementsPage openElementsPage() {
        actions().moveToElement(findElements).click().build().perform();
//        findElements.click();
        return new ElementsPage();
    }
    public DragPage openDragPage() {
        actions().moveToElement(AUI1).click().build().perform();
//        AUI1.click();
        return new DragPage();
    }
    public DropPage openDropPage() {
        actions().moveToElement(AUI2).click().build().perform();
        return new DropPage();
    }
    public SortPage openSortPage() {
        actions().moveToElement(AUI3).click().build().perform();
        return new SortPage();
    }
    public SelectablePage openSelectablePage() {
        actions().moveToElement(AUI4).click().build().perform();
//        AUI4.click();
        return new SelectablePage();
    }
    public SliderPage openSliderPage() {
        AUI5.click();
        return new SliderPage();
    }
    public TablePage openTablePage() {
        actions().moveToElement(simpleTable).click().build().perform();
        return new TablePage();
    }
    public FilePage openFilePage() {
        actions().moveToElement(file).click().build().perform();
        return new FilePage();
    }
    public ShadowPage openShadowPage() {
        actions().moveToElement(DOM).click().build().perform();
        return new ShadowPage();
    }
}
