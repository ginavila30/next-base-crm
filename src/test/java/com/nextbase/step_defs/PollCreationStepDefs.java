package com.nextbase.step_defs;

import com.nextbase.pages.BasePageVytrack;
import com.nextbase.pages.LoginPage;
import com.nextbase.pages.PollPage;
import com.nextbase.utilities.BrowserUtils;
import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Constant;
import com.nextbase.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollCreationStepDefs {
    PollPage pollPage = new PollPage();
    BasePageVytrack basePageVytrack = new BasePageVytrack();

    @Given("User logged in nextBaseCRM with valid {string} and valid {string}")
    public void user_logged_in_vy_track_with_valid_and_valid(String username, String password) {
        BrowserUtils.goToURL(ConfigurationReader.getProperty("url.nextBaseCrm"));
        new LoginPage().login(username, password);
        BrowserUtils.waitForPageToLoad(10);
    }

    @When("User clicks on {string} link")
    public void userClicksOnLink(String btnLink) {
        basePageVytrack.selectFeedLink(btnLink);
    }

    @When("Fills out all required fields inputs {string} and send poll")
    public void fills_out_all_required_fields(String pollDescription) {
        BrowserUtils.switchToIframe(pollPage.getIframe());
        pollPage.pollDescriptionInputBox(pollDescription);
        BrowserUtils.switchToDefaultFrame();
        pollPage.createInputForPoll();
        pollPage.sendPoll();
    }

    @Then("User can see and verify poll created with {string}")
    public void userCanSeeAAndVerifyPollOnPageFeed(String createdPollDescription) {
        BrowserUtils.waitFor(3);
        new WebDriverWait(Driver.getDriver(), Constant.WAIT_TIME_OUTS).until(ExpectedConditions.visibilityOf(pollPage.getHome24CRMLink()));
        pollPage.verifyPollName(createdPollDescription);
    }

}
