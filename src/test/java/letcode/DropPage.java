package letcode;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DropPage {
    private final SelenideElement dragBox= $x("//div[@id='draggable']");
    private final SelenideElement dropTarget= $x("//div[@id='droppable']");

    public void dragAndDropToElement(){
        actions().dragAndDrop(dragBox,dropTarget).perform();
        $x("//*[contains(text(), 'Dropped!')]").shouldBe(visible);
    }

}
