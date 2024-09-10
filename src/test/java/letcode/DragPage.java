package letcode;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Action;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class DragPage {
    private final SelenideElement box = $x("//div[@id='sample-box']").should(exist);

    public DragPage dragContainerAround() {

        int x = $("div[id='sample-box']").getLocation().getX();
        int y = $("div[id='sample-box']").getLocation().getY();
        System.out.println(String.valueOf(x) + " " + String.valueOf(y));


        actions().dragAndDropBy(box, 300, 220).build().perform();
        sleep(1000);

        return this;
    }
}
