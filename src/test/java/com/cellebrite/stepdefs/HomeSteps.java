package com.cellebrite.stepdefs;

import com.cellebrite.SpringIntegrationTest;
import com.cellebrite.driver.DriverManager;
import com.cellebrite.pom.home.HomePage;
import com.cellebrite.utils.properties.PropertiesManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigCache;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@CucumberContextConfiguration
public class HomeSteps extends SpringIntegrationTest {

    PropertiesManager propertiesManager = ConfigCache.getOrCreate(PropertiesManager.class);

    @Autowired
    HomePage homePage;

    @Given("a visitor access the home page")
    public void accessHomePage() {
        DriverManager.getInstance().getWebDriver().get(propertiesManager.getApplicationUrl());
        assertThat(homePage.isWelcomePage())
                .as("The welcome page is displayed.")
                .isTrue();
    }

    @And("home page contains the title {string}")
    public void hasHomePageTitle(String title) {
        assertThat(homePage.hasHomePageTitle(title))
                .as("The home page contains the title " + title)
                .isTrue();
    }

    @And("home page contains the button {string} in menu")
    public void hasButtonInMenu(String name) {
        assertThat(homePage.hasMenuButtonXPath(name))
                .as("The home page contains the button " + name + " in menu.")
                .isTrue();
    }

}
