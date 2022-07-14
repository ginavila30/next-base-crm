package com.nextbase.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class BrowserUtils {
    public static void verifyTitle(String expectedTitle) {
        new WebDriverWait(Driver.getDriver(),Constant.WAIT_TIME_OUTS).until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static void switchWindowAndVerify(String expectedUrl, String expectedTitle) {
        Set<String> allTabs = Driver.getDriver().getWindowHandles();
        for (String eahTab : allTabs) {
            Driver.getDriver().switchTo().window(eahTab);
            if (Driver.getDriver().getCurrentUrl().equals(expectedUrl)) {
                break;
            }
        }
        Assert.assertTrue(expectedTitle + " Title verification failed", Driver.getDriver().getTitle().contains(expectedTitle));
        Assert.assertTrue(expectedUrl + " Url verification failed", Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    public static void verifyURLContains(String expectdURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectdURL));
    }

    public static List<String> dropDownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement element : actualOptionsAsWebElement) {
            actualOptionsAsString.add(element.getText());
        }
        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                radioButton.click();
                break;
            }
        }

    }

    public static void goToURL(String URL) {
        Driver.getDriver().get(URL);
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible" + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found" + element);
        }
    }

    public static void verifyElementText(WebElement element, String expectedText) {
        new WebDriverWait(Driver.getDriver(),Constant.WAIT_TIME_OUTS).until(ExpectedConditions.textToBePresentInElement(element,expectedText));
        Assert.assertEquals(expectedText, element.getText());
    }

    //this method helps compare 2 List<String> if they look exactly alike
    public static boolean verify2ListsOfTextEqual(List<String> expectedList, List<String> actualList ){
        return Arrays.equals(expectedList.toArray(),actualList.toArray());
    }
}
