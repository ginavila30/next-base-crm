package com.nextbase.pages;

import com.github.javafaker.Faker;
import com.nextbase.utilities.BrowserUtils;
import com.nextbase.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PollPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Faker faker = new Faker();

    public PollPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//body[@contenteditable=\"true\"]")
    public WebElement descriptionInputBox;

    @FindBy(id = "question_0")
    private WebElement questionInputBox;

    @FindBy(id = "answer_0__0_")
    private WebElement answer1InputBox;

    @FindBy(id = "answer_0__1_")
    private WebElement answer2InputBox;

    @FindBy(id = "answer_0__2_")
    private WebElement answer3InputBox;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement iframe;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    private WebElement theRecentPoll;
    @FindBy(id = "logo_24_a")
    private WebElement home24CRMLogo;

    public void createInputForPoll() {
        wait.until(ExpectedConditions.visibilityOf(questionInputBox));

        questionInputBox.sendKeys(faker.address().country());
        answer1InputBox.sendKeys(faker.address().city());
        answer2InputBox.sendKeys(faker.address().city());
        wait.until(ExpectedConditions.visibilityOf(answer3InputBox));
    }

    public void sendPoll() {
        sendButton.click();
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void pollDescriptionInputBox(String descriptionOFThePoll) {
        descriptionInputBox.sendKeys(descriptionOFThePoll);
    }

    public void verifyPollName(String pollName) {
        wait.until(ExpectedConditions.visibilityOf(theRecentPoll));
        if (!theRecentPoll.isDisplayed()) {
            do {
                home24CRMLogo.click();
            } while (theRecentPoll.isDisplayed());
        }
        Assert.assertTrue(theRecentPoll.getText().contains(pollName));
    }

    public WebElement getHome24CRMLink() {
        return home24CRMLogo;
    }

}
