package com.nextbase.step_defs;

import com.nextbase.pages.ForgotPasswordPage;
import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefs {

    @Given("User is on login page")
    public void user_is_on_login_page() {
        BrowserUtils.goToURL(ConfigurationReader.getProperty("url"));
    }

    @When("User enters valid {string} and valid {string} and clicks login button")
    public void user_enters_valid_and_valid_and_clicks_login_button(String username, String password) {
        new LoginPage().login(username, password);
    }

    @Then("Title page should be {string}")
    public void title_page_should_be(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("User enters invalid {string} and invalid {string} and clicks login button")
    public void user_enters_invalid_and_invalid_and_clicks_login_button(String username, String password) {
        new LoginPage().login(username, password);
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        BrowserUtils.verifyElementText(new LoginPage().getErrorText(), expectedMessage);
    }

    @When("User clicks on Remember me on this computer checkbox")
    public void user_clicks_on_remember_me_on_this_computer_checkbox() {
        new LoginPage().checkRememberMeBox();
    }

    @Then("Checkbox should be selected")
    public void checkbox_should_be_selected() {
        BrowserUtils.boxOrButtonIsSelected(new LoginPage().getRememberMeBox());
    }

    @When("User clicks on FORGOT YOUR PASSWORD? link")
    public void user_clicks_on_forgot_your_password_link(){
        new LoginPage().clickForgotPassword();
    }

    @Then("User should see {string} header and {string} Button")
    public void user_should_see_header_and_button(String expectedHeader, String expectedBtnText) {
        BrowserUtils.verifyElementText(new ForgotPasswordPage().getHeader(),expectedHeader);
        BrowserUtils.verifyElementText(new ForgotPasswordPage().getResetPasswordBtn(),expectedBtnText);
    }
}
