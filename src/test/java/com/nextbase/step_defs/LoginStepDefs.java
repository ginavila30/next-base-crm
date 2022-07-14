package com.nextbase.step_defs;

import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {

    @Given("User is on login page")
    public void user_is_on_login_page() {
        BrowserUtils.goToURL(ConfigurationReader.getProperty("url"));
    }

    @When("User enters valid {string} and valid {string} and clicks login button")
    public void user_enters_valid_and_valid_and_clicks_login_button(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Then("Title page should be {string}")
    public void title_page_should_be(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }
}
