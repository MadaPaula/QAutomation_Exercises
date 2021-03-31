package com.cellebrite.utils.properties;


import com.cellebrite.driver.Browser;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.properties")
public interface PropertiesManager extends Config {

    @Key("browser")
    Browser getBrowser();

    @Key("application_url")
    String getApplicationUrl();

    @Key("webdriver_location")
    String getWebDriverLocation();

}
