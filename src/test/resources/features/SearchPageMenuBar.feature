@SearchComponent
Feature: Scenarios E2E for search component

  Background:
    Given a visitor access the home page
    When the visitor click on search button
    Then the search form is displayed
    And the input field contains the placeholder "What are you looking for?"

  Scenario: Search by text "crime"
    When the visitor enter the text "crime" in search form
    And the visitor click on search submit button
    Then is redirected to the page "Search Results For:"
    And the title contains text "crime"
    And the results contain the text "crime"
    And the search form contains the text "crime"

  Scenario: Search by text "crime" with refresh page
    When the visitor enter the text "crime" in search form
    And the visitor click on search submit button
    Then is redirected to the page "Search Results For:"
    And the title contains text "crime"
    And the results contain the text "crime"
    And the search form contains the text "crime"
    When the page is refreshed
    Then the results contain the text "crime"
    And the search form contains the text "crime"

  Scenario: Search by text "industry endpoint"
    When the visitor enter the text "industry endpoint" in search form
    And the visitor click on search submit button
    Then is redirected to the page "Search Results For:"
    And the title contains text "industry endpoint"
    And each result contain the text "industry endpoint"
    And the search form contains the text "industry endpoint"

  Scenario: Search by null text
    When the visitor enter the text "" in search form
    And the visitor click on search submit button
    Then is redirected to the page "Search Results For:"
    And each result contain the text " "

  Scenario: Search by text "null or 1=1"
    When the visitor enter the text "null or 1=1" in search form
    And the visitor click on search submit button
    Then is redirected to the error page "Error 15"

  Scenario: Search two times by different text, "digital" and "industry"
    When the visitor enter the text "digital" in search form
    And the visitor click on search submit button
    Then is redirected to the page "Search Results For:"
    And the title contains text "digital"
    And each result contain the text "digital"
    And the search form contains the text "digital"
    Then the visitor enter the text "industry" in search form from page
    And the visitor click on search submit button from page
    Then is on page "Search Results For:"
    And the title contains text "industry"
    And each result contain the text "industry"
    And the search form contains the text "industry"






