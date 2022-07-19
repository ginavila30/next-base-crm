package com.nextbase.pages;

import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Constant;
import com.nextbase.utilities.Driver;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public static final Logger LOG = LogManager.getLogger();

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

    public void login(String userRole) throws Throwable {
        switch (userRole.toLowerCase()){
            case Constant.HR:
                login(ConfigurationReader.getProperty("username_hr"));ConfigurationReader.getProperty("password");
                LOG.info("Logged in as HR User");
                break;
            case Constant.HELPDESK:
                login(ConfigurationReader.getProperty("username_helpdesk"),ConfigurationReader.getProperty("password"));
                LOG.info("Logged in as Helpdesk User");
                break;
            case Constant.MARKETING:
                login(ConfigurationReader.getProperty("username_marketing"),ConfigurationReader.getProperty("password"));
                LOG.info("Logged in as Marketing User");
                break;
            default:
                throw new Exception("This User Role does not exist"+userRole);
        }

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
