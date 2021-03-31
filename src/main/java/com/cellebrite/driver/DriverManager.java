package com.cellebrite.driver;

import com.cellebrite.utils.properties.PropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;

@Slf4j
public class DriverManager {

    static PropertiesManager propertiesManager = ConfigCache.getOrCreate(PropertiesManager.class, System.getenv());

    private static DriverManager driverManagerInstance;

    private WebDriver webDriver;

    private DriverManager() {
        webDriver = DriverProvider.getDriver(propertiesManager.getBrowser());
    }

    public static synchronized DriverManager getInstance() {
        if (driverManagerInstance == null) {
            driverManagerInstance = new DriverManager();
        }
        return driverManagerInstance;

    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public void refreshPage() {
        this.webDriver.navigate().refresh();
    }

    public void quitWebDriver() {
        if (null != webDriver) {
            this.webDriver.quit();
        }
    }

}
