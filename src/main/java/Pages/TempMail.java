package Pages;

import Core.DriverFactory;
import Interfaces.ITempMail;
import lombok.Getter;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
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
    public WebElement randomButton;

    @FindBy(css = "#domain")
    private WebElement dropDownMenu;

    @FindBy(css = "#pre_button")
    private WebElement inputNameAddress;

    public String getNameAddress() {
        String nameAddress = inputNameAddress.getAttribute("value");
        String domainText = dropDownMenu.getAttribute("textContent");
        return nameAddress + domainText;
    }


    @FindBy(css = "#pre_form > div > div.dropdown.mb-30.mb-md-0.show > div > button:nth-child(6)")
    private WebElement roverInfo;

    @FindBy(css = "#pre_settings")
    private WebElement buttonSettings;

    @FindBy(css = "#secret-address")
    private WebElement textFieldSecretAddress;

    public String getTextSecretAddress() {
        return textFieldSecretAddress.getAttribute("textContent");
    }

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement buttonClose;

    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement textWaitNewMessage;

    public void getAssertTextInMenu() {
        String waitMessageText = textWaitNewMessage.getAttribute("textContent");
        Assertions.assertEquals("В ожидании новых писем...", waitMessageText);
    }

    @FindBy(css = "#compose")
    private WebElement buttonSend;

    public void buttonComposeIsDisplayed() {
        Assertions.assertTrue(buttonSend.isDisplayed());
    }

    public static WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut) {
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

    public void setTextInFieldText() {
        textFieldTextMessage.sendKeys(getTextSecretAddress());
    }

    public void setSecondTextInFieldText() {
        textFieldTextMessage.sendKeys("Test2");
    }


    @FindBy(css = "#submit")
    private WebElement buttonSubmit;

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div")
    private WebElement divMessage;


    public void clickToDivMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#container-body > div > div.inbox > div.mail > div")));
        divMessage.click();
    }

    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement emailSender;

    public String getTextInFieldEmailSender() {
        return emailSender.getAttribute("textContent");
    }

    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement textFieldThemeSender;

    public String getTextInFieldThemeSender() {
        return textFieldThemeSender.getAttribute("textContent");
    }

    public void assertThemeSender() {
        Assertions.assertEquals("Test", getTextInFieldEmailSender());
    }

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement textSenderMessage;

    public String getTextInFieldSenderMessage() {
        return textSenderMessage.getAttribute("textContent");
    }

    public void assertSecretAddress() {
        Assertions.assertEquals(getTextSecretAddress(), getTextInFieldSenderMessage());
    }

    @FindBy(css = "#reply")
    private WebElement buttonReply;

    @FindBy(css = "#back")
    private WebElement buttonBackToMenu;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement textReTest2;

    @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div")
    private WebElement divReTest;

    public String getTextReTest() {
        return textReTest2.getAttribute("textContent");
    }

    public void assertReTest() {
        Assertions.assertEquals("Re: Test", getTextReTest());
    }

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement textMessageSenderSecond;

    public void assertTestSecond() {
        String textMessageTest2 = textMessageSenderSecond.getAttribute("textContent");
        Assertions.assertEquals("Test2", textMessageTest2);
    }

    @FindBy(css = "#delete_mail")
    private WebElement buttonDelete;

    @FindBy(css = "#confirm_mail")
    private WebElement buttonConfirmDelete;

    public void findElementRe() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete")));
        Assertions.assertFalse(driver.getPageSource().contains("Re: Test"));
    }
}