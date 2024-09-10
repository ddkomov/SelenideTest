package letcode;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SortPage {
    private final SelenideElement getToWork = $x("//*[contains(text(), ' Get to work')]");
    private final SelenideElement done = $x("//*[contains(text(), 'Done')]");

    public void dragAndDropFromToDoToDone() {
        switchTo().frame(0);
       actions().dragAndDrop(getToWork, done).perform();
       sleep(2000);
        actions().clickAndHold(getToWork).moveByOffset(200, 0).release().perform();
        sleep(2000);
    }
}
