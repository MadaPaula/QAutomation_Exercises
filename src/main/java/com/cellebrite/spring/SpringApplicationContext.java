package com.cellebrite.spring;

import com.cellebrite.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cellebrite.*"})
public class SpringApplicationContext {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringApplicationContext.class);
        builder.headless(false);
        builder.run(args);
    }

    @Bean
    public WebDriver getWebDriver() {
        return DriverManager.getInstance().getWebDriver();
    }

}
