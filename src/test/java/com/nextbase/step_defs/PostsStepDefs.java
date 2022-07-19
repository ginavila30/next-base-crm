package com.nextbase.step_defs;

import com.nextbase.pages.ActivityStreamPage;
import com.nextbase.pages.LoginPage;
import com.nextbase.utilities.BrowserUtils;
import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Constant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class PostsStepDefs {
    LoginPage loginPage = new LoginPage();
    @Given("User {string} is logged in under {string} module")
    public void userIsLoggedInUnderModule(List<String> userRole, String moduleName) {

    }

    @When("User like a post")
    public void user_like_a_post() {

    }

    @Then("User should see a Like icon popup under the Like button")
    public void user_should_see_a_like_icon_popup_under_the_like_button() {

    }

    @When("User click Follow button under posts")
    public void user_click_follow_button_under_posts() {

    }

    @Then("User should see Unfollow text displayed")
    public void user_should_see_unfollow_text_displayed() {

    }

    @Then("User should see under a post, how many people viewed a post by the number right next to the View counter icon")
    public void user_should_see_under_a_post_how_many_people_viewed_a_post_by_the_number_right_next_to_the_view_counter_icon() {

    }

    @When("User click a star icon on the top right of a post")
    public void user_click_a_star_icon_on_the_top_right_of_a_post() {

    }

    @Then("User should see the post as favorite")
    public void user_should_see_the_post_as_favorite() {

    }

    @When("User add comment under a post")
    public void user_add_comment_under_a_post() {

    }

    @Then("User can send the comment")
    public void user_can_send_the_comment() {

    }

    @Then("User can cancel the comment")
    public void user_can_cancel_the_comment() {

    }

}
