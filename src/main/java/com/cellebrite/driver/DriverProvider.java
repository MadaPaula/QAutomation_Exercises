package com.cellebrite.driver;

import com.cellebrite.utils.properties.PropertiesManager;
import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
public class DriverProvider {

    PropertiesManager propertiesManager = ConfigCache.getOrCreate(PropertiesManager.class, System.getProperties(), System.getenv());

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", propertiesManager.getWebDriverLocation());
        return new ChromeDriver(DriverOptionsProvider.getChromeOptions());
    }

    private WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", propertiesManager.getWebDriverLocation());
        return new FirefoxDriver(DriverOptionsProvider.getFirefoxOptions());
    }

    WebDriver getDriver(Browser browser) {
        if (browser == Browser.FIREFOX) {
            return getFirefoxDriver();
        }
        return getChromeDriver();

    }
}
