package com.cellebrite.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.Set;

public class WebDriverDecorator implements WebDriver {

    private EventFiringWebDriver webDriver;

    public EventFiringWebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void get(String s) {
        this.webDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return this.webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return this.webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return this.webDriver.getPageSource();
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}
