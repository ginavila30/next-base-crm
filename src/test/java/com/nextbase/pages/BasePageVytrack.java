package com.nextbase.pages;

import com.nextbase.utilities.BrowserUtils;
import com.nextbase.utilities.Constant;
import com.nextbase.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageVytrack {
    public Actions actions = new Actions(Driver.getDriver());
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Constant.WAIT_TIME_OUTS);

    public BasePageVytrack() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='feed-add-post-form-tab']//script//preceding-sibling::span")
    private List<WebElement> feedLinks;

    @FindBy(tagName = "iframe")
    private WebElement iframe;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    private WebElement theRecentPoll;

    @FindBy(id = "logo_24_a")
    private WebElement home24CRMLogo;

    public void selectFeedLink(String option) {
        BrowserUtils.waitForPageToLoad(Constant.WAIT_TIME_OUTS);
        for (WebElement each : feedLinks) {
            if (each.getText().equalsIgnoreCase(option)) {
                each.click();
            }
        }
    }

}
