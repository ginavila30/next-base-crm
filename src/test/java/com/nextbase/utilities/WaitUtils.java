package com.nextbase.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public static WebDriverWait wait;

    public static void waitTitleContains(String titleContains, int timeOut) {
        wait = new WebDriverWait(Driver.getDriver(), timeOut);
        wait.until(ExpectedConditions.titleContains(titleContains));
    }

    public static void waitForInvisibilityOf(WebElement element, int timeOut) {
       wait = new WebDriverWait(Driver.getDriver(), timeOut);
       wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUrlContains(String urlContains, int timeOut) {
        wait = new WebDriverWait(Driver.getDriver(), timeOut);
        wait.until(ExpectedConditions.urlContains(urlContains));
    }


}
