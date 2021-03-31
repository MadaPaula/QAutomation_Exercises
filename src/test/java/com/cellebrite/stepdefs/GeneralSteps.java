package com.cellebrite.stepdefs;

import com.cellebrite.SpringIntegrationTest;
import com.cellebrite.pom.GeneralPage;
import com.cellebrite.utils.properties.PropertiesManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigCache;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class GeneralSteps extends SpringIntegrationTest {

    PropertiesManager propertiesManager = ConfigCache.getOrCreate(PropertiesManager.class);

    @Autowired
    GeneralPage generalPage;

    @When("the visitor click on search button")
    public void clickOnSearchButton() {
        generalPage.clickOnSearch();
    }

    @When("the visitor click on search submit button")
    public void clickOnSearchSubmitButton() throws InterruptedException {
        generalPage.clickOnSearchSubmit();
        Thread.sleep(2000);
    }

    @When("the visitor click on search submit button from page")
    public void clickOnSearchSubmitButtonFromPage() throws InterruptedException {
        generalPage.clickOnSearchSubmitFromPage();
        Thread.sleep(2000);
    }

    @Then("the search form is displayed")
    public void searchFormIsDisplayed() {
        assertThat(generalPage.isSearchFormDisplayed())
                .as("The search form is displayed.")
                .isTrue();
    }

    @When("the input field contains the placeholder {string}")
    public void inputFieldContainsPlaceholder(String placeholder) {
        assertThat(generalPage.isPlaceholderForInputField(placeholder))
                .as("The field with placeholder " + placeholder + " is displayed.")
                .isTrue();
    }

    @When("the visitor enter the text {string} in search form")
    public void enterTextInSearchForm(String text) {
        generalPage.setValueToSearchForm(text);
    }

    @When("the visitor enter the text {string} in search form from page")
    public void enterTextInSearchFormPage(String text) {
        generalPage.setValueToSearchFormPage(text);
    }

    @When("is on page {string}")
    @And("is redirected to the page {string}")
    public void isRedirectedToPage(String title) {
        assertThat(generalPage.isRedirectedToPage(title))
                .as("The page " + title + " is displayed.")
                .isTrue();
    }

    @And("the title contains text {string}")
    public void titleContainsText(String text) {
        assertThat(generalPage.isRedirectedToPage(text))
                .as("The title contains text: " + text)
                .isTrue();
    }

    @And("each result contain the text {string}")
    @And("the results contain the text {string}")
    public void resultsDisplayedOnPage(String text) {
        SoftAssertions.assertSoftly(softly -> {
            Arrays.stream(text.split(" ")).forEach(word ->
                    assertThat(generalPage.areResultsDisplayedOnPage(word))
                            .as("Each result contains the word '" + word + "'.")
                            .isTrue());
        });
    }

    @And("the search form contains the text {string}")
    public void hasSearchFormText(String text) {
        assertThat(generalPage.hasSearchFormText(text))
                .as("The search form contains the text '" + text + "'.")
                .isTrue();
    }

    @And("is redirected to the error page {string}")
    public void isRedirectedToErrorPage(String codeError) {
        assertThat(generalPage.isRedirectedToErrorPage(codeError))
                .as("The error page display the error code " + codeError)
                .isTrue();
    }

    @When("the page is refreshed")
    public void refreshPage(){
        generalPage.refreshPage();
    }
}
