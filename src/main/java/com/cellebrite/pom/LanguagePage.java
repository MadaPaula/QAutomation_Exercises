package com.cellebrite.pom;

import com.cellebrite.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


@Component
public class LanguagePage {

    private String currentLanguageXPath = "//div[@class='lang-switch']//div[@class='l-curr']";

    private String languageValueToChangeXPath = "//div[@class='lang-switch']//a[contains(@lang,'%s')]";

    public LanguagePage(WebDriver webDriver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
    }

    public void clickOnLanguageButton() {
        DriverManager.getInstance().getWebDriver().findElement(By.xpath(currentLanguageXPath)).click();
    }

    public void changeCurrentLanguageTo(String text) {
        DriverManager.getInstance().getWebDriver().findElement(By.xpath(String.format(languageValueToChangeXPath, text))).click();
    }

}
