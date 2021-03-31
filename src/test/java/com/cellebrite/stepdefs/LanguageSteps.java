package com.cellebrite.stepdefs;

import com.cellebrite.SpringIntegrationTest;
import com.cellebrite.pom.LanguagePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class LanguageSteps extends SpringIntegrationTest {

    @Autowired
    LanguagePage languagePage;

    @When("the visitor click on language button")
    public void clickOnLangageButton() {
        languagePage.clickOnLanguageButton();
    }

    @Then("select the language {string}")
    public void selectLanguageTo(String language){
        languagePage.changeCurrentLanguageTo(language);
    }
}
