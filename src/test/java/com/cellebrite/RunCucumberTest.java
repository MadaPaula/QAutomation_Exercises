package com.cellebrite;

import com.cellebrite.driver.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"classpath:features/"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        glue = {"com.cellebrite.stepdefs"},
        tags = "")
@CucumberContextConfiguration
public class RunCucumberTest {

    @AfterClass
    public static void afterAll() {
        DriverManager.getInstance().quitWebDriver();
    }

}
