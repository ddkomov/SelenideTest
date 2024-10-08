package letcode;

import com.codeborne.selenide.Selenide;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class LetCodeTest extends BaseSelenideTest {
    private static final String FULL_NAME = "Dmitry Komov";
    private static final String appendText = " at all";
    private static final String value = "ortonikc";
    private static final String URL = "https://letcode.in/test";

    @Test
    public void testInputPage() {
        Selenide.open(URL);
        new MainPage()
                .openInputPage()
                .enterFullName(FULL_NAME)
                .appendTextToIAmGoodAndTab(appendText)
                .checkValueAfterTab(value)
                .clearMe()
                .checkIsDisabled()
                .checkNoEdit();

    }

    @Test
    public void testButtonPage() {
        Selenide.open(URL);
        new MainPage()
                .openButtonPage()
                .checkGoToHome()
                .checkFindLocation()
                .checkMyColor()
                .checkTallFat()
                .checkDisableButton()
                .checkHoldButton();
    }

    @Test
    public void testSelectPage() {
        Selenide.open(URL);
        new MainPage()
                .openSelectPage()
                .selectFruit()
                .selectSuperHero()
                .selectProgrammingLanguageAndPrintAll()
                .selectCountryByIndexAndPrint();

    }

    @Test
    public void testAlertPage() {
        Selenide.open(URL);
        new MainPage()
                .openAlertPage()
                .clickSimpleAlertButtonCheckTextAndAccept()
                .clickConfirmAlertButtonPrintAndDismiss()
                .clickPromptAlertButtonSendKeysAndCheckName()
                .clickModernAlertButtonCheckTextAndClose();

    }

    @Test
    public void testFramePage() {
        Selenide.open(URL);
        new MainPage()
                .openFramePage()
                .setFirstAndLastNameAndCheck()
                .setEmailAndCheck();

    }

    @Test
    public void testRadioPage() {
        Selenide.open(URL);
        new MainPage()
                .openRadioPage()
                .clickYesOnSelectAnyOne()
                .clickOnlyOneRadioButtonAndCheckSelected()
                .findBug()
                .whichOneIsSelected()
                .lastFieldDisabled()
                .rememberMeCheckBox()
                .termsAndConditionsBox();


    }

    @Test
    public void testWindowsPage() {
        Selenide.open(URL);
        new MainPage()
                .openWindowsPage()
                .clickOpenHomePageGetTitleAndCloseWindows();
        Selenide.open(URL);
        new MainPage()
                .openWindowsPage()
                .clickOpenMultiplePageGetAllTitlesAndCloseWindows();

    }

    @Test
    public void testElementsPage() {
        Selenide.open(URL);
        new MainPage()
                .openElementsPage()
                .setValueToSearchFieldAndClickButton()
                .userHasImage()
                .checkUserInfo()
                .checkUserReposLinks();

    }

    //    @Test
//    public void testDragPage() {
//        Selenide.open(URL);
//        new MainPage()
//                .openDragPage()
//                .dragContainerAround();
//
//    }
    @Test
    public void testDropPage() {
        Selenide.open(URL);
        new MainPage()
                .openDropPage()
                .dragAndDropToElement();

    }

    //    @Test
//    public void testSortPage() {
//        Selenide.open(URL);
//        new MainPage()
//                .openSortPage()
//                .dragAndDropFromToDoToDone();
//
//    }
    @Test
    public void testSelectablePage() {
        Selenide.open(URL);
        new MainPage()
                .openSelectablePage()
                .multiClick();
    }

    @Test
    public void testSliderPage() {
        Selenide.open(URL);
        new MainPage()
                .openSliderPage()
                .clickSlideAndGetCountries();
    }

    @Test
    public void testTabsPage() {
        Selenide.open(URL);
        new MainPage()
                .openTablePage()
                .addAllPricesAndAssertWithTotalPrice()
                .markRajAsPresent()
                .checkIfSortWorksCorrectly();

    }

    @Test
    public void testFilePage() {
        Selenide.open(URL);
        new MainPage()
                .openFilePage()
                .uploadFile()
                .downloadPDFFile()
                .downloadExcelFile()
                .downloadTXTFile();
    }

    @Test
    public void testShadowPage() {
        Selenide.open("https://letcode.in/shadow");
//        new MainPage()
//                .openShadowPage()
        new ShadowPage()
                .fillFnameShadowOpen()
                .fillLnameShadowClosed();
    }
}
