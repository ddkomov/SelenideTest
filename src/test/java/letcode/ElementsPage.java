package letcode;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ElementsPage {
    private final SelenideElement searchField = $x("//input[@name='username']");
    private final SelenideElement searchButton = $x("//button[contains(text(), 'Search')]");
    private final SelenideElement userImage = $x("//img[@class='is-rounded']");
    private final ElementsCollection userRepos = $$x("//a[@_ngcontent-serverapp-c51]");
    private final ElementsCollection userInfo = $$x("//span[@class='tag is-primary is-light' or @class='tag is-info']");
    private final SelenideElement countPublicRepos = $x("//div[@class='field is-grouped is-grouped-multiline']//div[1]//div[1]//span[2]");
    private final String username = "ddkomov";



    public ElementsPage setValueToSearchFieldAndClickButton() {
//        searchField.click();
//        searchField.clear();
        searchField.sendKeys(username);
        searchButton.click();
        System.out.println(searchField.getValue());
        return this;
    }

    public ElementsPage userHasImage() {
        Assertions.assertNotNull(userImage.getAttribute("src"), "Image not found");
        return this;
    }

    public ElementsPage checkUserInfo() {
        List<SelenideElement> list = userInfo.stream().toList();
        for (SelenideElement element : list) {
            System.out.println(element.getText());
        }
        return this;
    }

    public ElementsPage checkUserReposLinks() {
        List<SelenideElement> listUserRepos = userRepos.stream().toList();
        sleep(1500);
        int countRepos = Integer.parseInt(countPublicRepos.getText());
        sleep(1500);
        int countReposLinks = listUserRepos.size();
        sleep(2000);
        for (SelenideElement element : listUserRepos) {
            System.out.println(element.getAttribute("href"));
        }
        Assertions.assertEquals(countRepos, countReposLinks, "Number of repos is different");

        return this;
    }

}
