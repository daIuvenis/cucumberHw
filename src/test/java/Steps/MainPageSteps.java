package Steps;

import Core.DriverFactory;
import Interfaces.ITempMail;
import Pages.TempMail;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class MainPageSteps extends Steps {
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

    }
}
