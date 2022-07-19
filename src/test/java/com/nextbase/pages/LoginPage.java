package com.nextbase.pages;

import com.nextbase.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    private WebElement usernameInput;

    @FindBy(name = "USER_PASSWORD")
    private WebElement passwordInput;

    @FindBy(css = ".login-btn")
    private WebElement loginBtn;

    @FindBy(className = "errortext")
    private WebElement errorText;

    @FindBy(id = "USER_REMEMBER")
    private WebElement rememberMeCheckBox;

    @FindBy(className = "login-link-forgot-pass")
    private WebElement forgotPasswordLink;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public WebElement getErrorText(){
        return errorText;
    }

    public void checkRememberMeBox(){
        rememberMeCheckBox.click();
    }

    public WebElement getRememberMeBox(){
        return rememberMeCheckBox;
    }

    public void clickForgotPassword(){
        forgotPasswordLink.click();
    }

}
