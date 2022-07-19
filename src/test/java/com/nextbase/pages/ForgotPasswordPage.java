package com.nextbase.pages;

import com.nextbase.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "log-popup-header")
    private WebElement header;

    @FindBy(className = "login-btn")
    private WebElement resetPasswordBtn;

    public WebElement getHeader(){
        return header;
    }

    public WebElement getResetPasswordBtn(){
        return resetPasswordBtn;
    }

    public void clickResetPasswordBtn(){
        resetPasswordBtn.click();
    }

}
