package Steps;

import Core.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class MainPageSteps extends Steps {
    public String SaveSecretAddress;
    public String SaveEmail;
    Actions action = new Actions(DriverFactory.getDriver());
    @Given("I open Temp Mail page")
    public void iOpenTempMailPage() {
        log.info("I open Temp Mail page");
        DriverFactory.getDriver().get("https://tempmail.plus/ru/");
    }

    @And("I click button random")
    public void IClickButtonRandom() {
        log.info("I click button random");
        iTempMail.getRandomButton().click();
    }

    @And("I open dropdown menu")
    public void iOpenDropdownMenu() {
        log.info("I open dropdown menu");
        iTempMail.getDropDownMenu().click();
    }


    @And("I enter rover.info in dropdown menu")
    public void iEnterRoverInfoInDropdownMenu() {
        log.info("I enter rover.info in dropdown menu");
        iTempMail.getRoverInfo().click();
    }

    @And("I remember name address and domain")
    public void iRememberNameAddressAndDomain() {
        log.info("I remember name address and domain");
        SaveEmail = iTempMail.rememberNameAddress();
    }

    @And("I open settings")
    public void iOpenSettings() {
        log.info("I open settings");
        iTempMail.getButtonSettings().click();
    }

    @And("I remember secret address and close modal window")
    public void iRememberSecretAddressAndCloseModalWindow() {
        log.info("I remember secret address and close modal window");
        iTempMail.textSecretAddress();
        SaveSecretAddress = iTempMail.textSecretAddress();
        iTempMail.waitForVisibility(iTempMail.getButtonClose(), 10);
        iTempMail.getButtonClose().isDisplayed();
        iTempMail.getButtonClose().click();
    }

    @And("I check what modal window Settings is closed")
    public void iCheckWhatModalWindowSettingsIsClosed() {
        log.info("I check what modal window is closed");
        iTempMail.waitForVisibility(iTempMail.getButtonSettings(), 10);
        Assertions.assertTrue(iTempMail.getButtonSettings().isDisplayed());
    }

    @And("i check what text {string} is Displayed")
    public void iCheckWhatTextIsDisplayed(String WaitNewMessage) {
        log.info("i check what text {string} is Displayed");
        Assertions.assertEquals(WaitNewMessage, iTempMail.getTextWaitNewMessage().getAttribute("textContent"));
    }

    @And("I click to the button Send")
    public void iClickToTheButtonSend() {
        log.info("I click to the button Send");
        iTempMail.getButtonSend().isDisplayed();
        iTempMail.getButtonSend().click();
    }

    @And("I check what modal window Send message open")
    public void iCheckWhatModalWindowSendMessageOpen() {
        log.info("I check what modal window Send message open");
        iTempMail.getFormSendMessage().isDisplayed();
    }

    @Then("I send text name address in the Field Send to")
    public void iSendTextNameAddressInTheFieldSendTo() {
        log.info("I send text name address in the Field Send to");
        iTempMail.getSendTo().sendKeys(iTempMail.rememberNameAddress());
    }

    @Then("I send text {string} in the field Theme")
    public void iSendTextInTheFieldTheme(String test) {
        log.info("I send text {string} in the field Theme");
        iTempMail.getTextFieldTheme().sendKeys(test);
    }

    @Then("I send text secret address in the field text message")
    public void iSendTextSecretAddressInTheFieldTextMessage() {
        log.info("I send text secret address in the field text message");
        iTempMail.getTextFieldTextMessage().sendKeys(SaveSecretAddress);
    }

    @And("I click to the button Send message")
    public void iClickToTheButtonSendMessage() {
        log.info("I click to the button Send message");
        iTempMail.waitForVisibility(iTempMail.getButtonSubmit(), 10);
        iTempMail.getButtonSubmit().click();
    }

    @And("I Wait for the new message")
    public void iWaitForTheNewMessage() {
        log.info("I Wait for the new message");
        iTempMail.waitForVisibility(iTempMail.getDivMessage(), 15);
    }

    @Then("I click to the new message")
    public void iClickToTheNewMessage() {
        log.info("I click to the new message");
        iTempMail.getDivMessage().click();
    }

    @And("I check name sender")
    public void iCheckNameSender() {
        log.info("I check name sender");
        iTempMail.waitForVisibility(iTempMail.getEmailSender(), 10);
        Assertions.assertEquals(SaveEmail, iTempMail.getEmailSender().getAttribute("textContent"));
    }

    @Then("I check text {string} in theme sender")
    public void iCheckTextInThemeSender(String text) {
        log.info("I check text {string} in theme sender");
        Assertions.assertEquals(text, iTempMail.getTextFieldThemeSender().getAttribute("textContent"));

    }

    @Then("I check text in tet field secret address")
    public void iCheckTextInTetFieldSecretAddress() {
        log.info("I check text in tet field secret address");
        Assertions.assertEquals(SaveSecretAddress,iTempMail.getTextSenderMessage().getAttribute("textContent"));
    }

    @And("I click to the button Reply")
    public void iClickToTheButtonReply() {
        log.info("I click to the button Reply");
        iTempMail.getButtonReply().click();
    }

    @Then("I check to visibility form Reply")
    public void iCheckToVisibilityFormReply() {
        log.info("I check to visibility form Reply");
        iTempMail.waitForVisibility(iTempMail.getFormReply(),10);
    }

    @Then("I send text {string} in text field message")
    public void iSendTextInTextFieldMessage(String text) {
        log.info("I send text {string} in text field message");
        iTempMail.getTextFieldTextMessage().sendKeys(text);
    }

    @Then("I click to the button Send message in  form Reply")
    public void iClickToTheButtonSendMessageInFormReply() {
        log.info("I click to the button Send message in  form Reply");
        iTempMail.getButtonSubmit().click();
    }

    @And("I click to the button Back")
    public void iClickToTheButtonBack() {
        log.info("I click to the button Back");
        iTempMail.waitForVisibility(iTempMail.getButtonBackToMenu(),10).click();
    }

    @And("I check that the message has come")
    public void iCheckThatTheMessageHasCome() {
        log.info("I check that the message has come");
        iTempMail.waitForVisibility(iTempMail.getDivReTest(),10);
        Assertions.assertTrue(DriverFactory.driver.getPageSource().contains("Re: Test"));
    }

    @Then("I open message Re: Test")
    public void iOpenMessageReTest() {
        log.info("I open message Re: Test");
        iTempMail.getDivReTest().click();
    }

    @And("I check text {string} in body text")
    public void iCheckTextInBodyText(String text) {
        log.info("I check text {string} in body text");
        iTempMail.waitForVisibility(iTempMail.getTextMessageSenderSecond(), 10);
        System.out.println(iTempMail.getTextMessageSenderSecond().getAttribute("textContent"));
        Assertions.assertEquals(text, iTempMail.getTextMessageSenderSecond().getAttribute("textContent"));
    }

    @And("I click to the button delete")
    public void iClickToTheButtonDelete() {
        log.info("I click to the button delete");
        iTempMail.getButtonDelete().click();

    }

    @Then("I wait opened modal window Confirm delete")
    public void iWaitOpenedModalWindowConfirmDelete() {
        log.info("I wait opened modal window Confirm delete");
        iTempMail.waitForVisibility(iTempMail.getFormConfirmDelete(), 10);
    }

    @Then("I confirm deletion")
    public void iConfirmDeletion() {
        log.info("I confirm deletion");
        iTempMail.getButtonConfirmDelete().click();
        action.moveByOffset(10, 10).click().build().perform();
    }

    @And("I check that there is no email with the subject {string}")
    public void iCheckThatThereIsNoEmailWithTheSubject(String text) {
        log.info("I check that there is no email with the subject {string}");
        iTempMail.waitForVisibility(iTempMail.getButtonSettings(), 10);
        Assertions.assertFalse(DriverFactory.driver.getPageSource().contains(text));
    }
}
