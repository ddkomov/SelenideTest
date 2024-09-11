package letcode;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selectors.shadowDeepCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ShadowPage {
    private final SelenideElement fname = $(shadowDeepCss("input#fname"));
    private final String lname= "document.querySelector('my-web-component').myRoot.querySelector('#lname').value='Komov'";
    private final SelenideElement email = $(shadowDeepCss("input#email"));

    public ShadowPage fillFnameShadowOpen(){
        fname.setValue("Dmitry");
        return this;
    }
    public ShadowPage fillLnameShadowClosed(){

        executeJavaScript(lname);

        return this;
    }
    public ShadowPage fillEmail(){
        email.sendKeys("dmitry.komov@gmail.com");
        return this;
    }
}
