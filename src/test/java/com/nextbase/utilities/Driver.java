package com.nextbase.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private  Driver(){};

    private static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if(driverPool.get()==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());

                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());

                    break;
                default:
                    System.out.println("Unknown Browser Type " + browserType);
            }
            driverPool.get().manage().window().maximize();
            return driverPool.get();
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() !=null){
            driverPool.get().quit();//This terminates the session
            driverPool.remove();// reset driver value to null so It can always use only one and the same instance of the object.
        }
    }
}
