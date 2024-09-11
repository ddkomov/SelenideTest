package letcode;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FilePage {
    private final SelenideElement fileUpload = $x("//input[@type='file']").shouldBe(exist);
    private final SelenideElement downloadPDF= $x("//a[@download='sample.pdf']").shouldBe(exist);
    private final SelenideElement downloadTXT= $x("//a[@download='sample.txt']").shouldBe(exist);
    private final SelenideElement downloadExcel= $x("//a[@download='sample.xlsx']").shouldBe(exist);

    private final String filePath = "src/test/java/data/111.txt";

//    public void unhide( SelenideElement element) {
//        String script = "arguments[0].style.opacity=1;"
//                + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
//                + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
//                + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
//                + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
//                + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
//                + "return true;";
//        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript(script, element);
//    }

    public FilePage uploadFile() {
        fileUpload.uploadFile(new File(filePath));
        return this;
    }
    public FilePage downloadPDFFile() {
        downloadPDF.download();
        return this;
    }
    public FilePage downloadTXTFile() {
        downloadTXT.download();
        return this;
    }
    public FilePage downloadExcelFile() {
        downloadExcel.download();
        return this;
    }
}
