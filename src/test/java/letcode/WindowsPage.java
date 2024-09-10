package letcode;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WindowsPage {
    private final SelenideElement openHomePageButton = $x("//*[contains(text(), 'Open Home Page')]").shouldBe(visible);
    private final SelenideElement openMultiplePageButton = $x("//*[contains(text(), 'Muiltiple windows')]").shouldBe(visible);



    public WindowsPage clickOpenHomePageGetTitleAndCloseWindows() {
        openHomePageButton.click();
        String title = switchTo().window(1).getTitle();
        System.out.println(title);
        switchTo().window(0).close();
        switchTo().window(0).close();
        return this;
    }
    public WindowsPage clickOpenMultiplePageGetAllTitlesAndCloseWindows() {
        openMultiplePageButton.click();
        String title1 = switchTo().window(0).getTitle();
        String title2 = switchTo().window(1).getTitle();
        System.out.println("Parent window title: " + title1);
        System.out.println("Child window title: " + title2);
        switchTo().window(0).close();
        switchTo().window(0).close();
        return this;
    }
}
