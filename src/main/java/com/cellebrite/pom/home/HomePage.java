package com.cellebrite.pom.home;


import com.cellebrite.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static org.awaitility.Awaitility.await;

@Component
public class HomePage {

    @FindBy(xpath = "//h1[@class='m-title']//parent::div[@class='sh-content']")
    private HtmlElement welcomeMessage;

    private String homePageMessage = "//ul[@id='hero_slider']//h1[@class='m-title']";

    private String menuButtonXPath = "//div[contains(@class,'prima-cta')]//a";

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
    }

    public boolean isWelcomePage() {
        try {
            await().ignoreExceptions().until(() -> welcomeMessage.exists());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasHomePageTitle(String title) {
        return DriverManager.getInstance().getWebDriver().findElement(By.xpath(homePageMessage)).getText().contains(title);
    }

    public boolean hasMenuButtonXPath(String name) {
        return DriverManager.getInstance().getWebDriver().findElement(By.xpath(menuButtonXPath)).getText().contains(name);
    }
}
