package Interfaces;

import org.openqa.selenium.WebElement;

public interface ITempMail extends IPage {

    WebElement getRandomButton();

    WebElement getDropDownMenu();

    WebElement getRoverInfo();

    String rememberNameAddress();

    WebElement getButtonSettings();

    String textSecretAddress();

//    void buttonComposeIsDisplayed();

    WebElement getButtonClose();

    WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut);

    WebElement getTextWaitNewMessage();


    WebElement getButtonSend();

    WebElement getFormSendMessage();

    WebElement getSendTo();

    WebElement getTextFieldTheme();

    WebElement getTextFieldTextMessage();

    CharSequence textToSender();

    WebElement getButtonSubmit();

    WebElement getDivMessage();

    WebElement getEmailSender();

    WebElement getTextFieldThemeSender();

    WebElement getTextSenderMessage();

    WebElement getButtonReply();

    WebElement getFormReply();

    WebElement getButtonBackToMenu();

    WebElement getDivReTest();

    WebElement getTextMessageSenderSecond();

    WebElement getButtonDelete();

    WebElement getFormConfirmDelete();

    WebElement getButtonConfirmDelete();
}
