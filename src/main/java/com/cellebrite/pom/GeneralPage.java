package com.cellebrite.pom;

import com.cellebrite.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

import static org.awaitility.Awaitility.await;

@Component
public class GeneralPage {

    @FindBy(id = "h_search")
    private HtmlElement searchButton;

    @FindBy(id = "searchform")
    private HtmlElement searchForm;

    @FindBy(id = "searchsubmit")
    private HtmlElement searchSubmitForm;

    private String inputFieldByPlaceholderXPath = "//input[@placeholder= '%s']";

    @FindBy(id = "h_search_input")
    private HtmlElement inputSearchForm;

    private String titlePageXPath = "//h2[@class='scl-h2']";

    private String searchResultsXPath = "//div[@class='scl-info']//h3";

    private String inputSearchFormPageXPath = "//section[@class='s-card-list']//*[@id='h_search_input']";

    private String searchSubmitFormPageXPath = "//section[@class='s-card-list']//*[@id='searchsubmit']";

    private String errorPageXPath = "//div[@class='error-title']";

    private String errorCodeXPath = "//div[@class='error-code']";

    public GeneralPage(WebDriver webDriver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
    }

    public void clickOnSearch() {
        searchButton.click();
    }

    public void clickOnSearchSubmit() {
        searchSubmitForm.click();
    }

    public void clickOnSearchSubmitFromPage() {
        DriverManager.getInstance().getWebDriver().findElement(By.xpath(searchSubmitFormPageXPath)).click();
    }

    public boolean isSearchFormDisplayed() {
        try {
            await().ignoreExceptions().until(() -> searchForm.exists());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPlaceholderForInputField(String placeholder) {
        return DriverManager.getInstance().getWebDriver().findElement(By.xpath(String.format(inputFieldByPlaceholderXPath, placeholder))).isDisplayed();
    }


    public void setValueToSearchForm(String text) {
        if (text.toLowerCase().contains("empty")) {
            inputSearchForm.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            inputSearchForm.clear();
        } else {
            inputSearchForm.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            inputSearchForm.sendKeys(text);
        }
    }

    public void setValueToSearchFormPage(String text) {
        WebElement webElement = DriverManager.getInstance().getWebDriver().findElement(By.xpath(inputSearchFormPageXPath));

        if (text.toLowerCase().contains("empty")) {
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            webElement.clear();
        } else {
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            webElement.sendKeys(text);
        }
    }

    public boolean isRedirectedToPage(String title) {
        return DriverManager.getInstance().getWebDriver().findElement(By.xpath(titlePageXPath)).getText().contains(title);
    }

    public boolean areResultsDisplayedOnPage(String text) {
        List<WebElement> webElements = DriverManager.getInstance().getWebDriver().findElements(By.xpath(searchResultsXPath));
        return webElements.stream().allMatch(webElement -> webElement.getText().toLowerCase().contains(text.toLowerCase()));

    }

    public boolean hasSearchFormText(String text) {
        return DriverManager.getInstance().getWebDriver().findElement(By.xpath(inputSearchFormPageXPath)).getAttribute("value").equals(text);
    }

    public boolean isRedirectedToErrorPage(String codeError) {
        return DriverManager.getInstance().getWebDriver().findElement(By.xpath(errorCodeXPath)).getText().contains(codeError)
                && DriverManager.getInstance().getWebDriver().findElement(By.xpath(errorPageXPath)).getText().contains("Access denied");
    }

    public void refreshPage() {
        DriverManager.getInstance().refreshPage();
    }
}
