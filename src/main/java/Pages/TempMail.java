package Pages;

import Core.DriverFactory;
import Interfaces.ITempMail;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class TempMail implements ITempMail {

    public WebDriver driver;

    public TempMail() {
        PageFactory.initElements(DriverFactory.getDriver(), this);

    }

    @FindBy(css = "#pre_rand")
    private WebElement randomButton;

    @FindBy(css = "#domain")
    private WebElement dropDownMenu;

    @FindBy(css = "#pre_button")
    private WebElement inputNameAddress;

    public String rememberNameAddress() {
        return inputNameAddress.getAttribute("value") + dropDownMenu.getAttribute("textContent");
    }

    @FindBy(css = "#pre_form > div > div.dropdown.mb-30.mb-md-0.show > div > button:nth-child(6)")
    private WebElement roverInfo;

    @FindBy(css = "#pre_settings")
    private WebElement buttonSettings;

    @FindBy(css = "#secret-address")
    private WebElement textFieldSecretAddress;

    public String textSecretAddress() {
        waitForVisibility(textFieldSecretAddress, 10);
        return textFieldSecretAddress.getAttribute("textContent");
    }

    public String textToSender() {
        return textSecretAddress();
    }

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement buttonClose;

    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement textWaitNewMessage;

    @FindBy(css = "#compose")
    private WebElement buttonSend;

    @FindBy(css = "#modal-compose > div")
    private WebElement formSendMessage;

    public WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut) {
        WebElement webElement = null;
        int timeOfRevision = timeOfTryOut.length == 0
                ? 100
                : timeOfTryOut[0];
        try {
            webElement = new WebDriverWait(DriverFactory.getDriver(),
                    timeOfWait,
                    timeOfRevision
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

    @FindBy(css = "#to")
    private WebElement sendTo;

    @FindBy(css = "#subject")
    private WebElement textFieldTheme;

    @FindBy(css = "#text")
    private WebElement textFieldTextMessage;

    @FindBy(css = "#submit")
    private WebElement buttonSubmit;

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div")
    private WebElement divMessage;

    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement emailSender;

    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement textFieldThemeSender;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement textSenderMessage;

    @FindBy(css = "#form")
    private WebElement formReply;

    @FindBy(css = "#reply")
    private WebElement buttonReply;

    @FindBy(css = "#back")
    private WebElement buttonBackToMenu;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement textReTest2;

    @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.subj.col-12.col-md-7.px-md-3")
    private WebElement divReTest;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement textMessageSenderSecond;

    @FindBy(css = "#delete_mail")
    private WebElement buttonDelete;

    @FindBy(css = "#modal-destroy-mail > div > div > div")
    private WebElement formConfirmDelete;

    @FindBy(css = "#confirm_mail")
    private WebElement buttonConfirmDelete;
}