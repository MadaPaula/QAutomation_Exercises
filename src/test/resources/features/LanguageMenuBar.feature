@LanguageComponent
Feature: Scenarios E2E for language component

  Scenario: Change the language from current to ES
    Given a visitor access the home page
    When the visitor click on language button
    Then select the language "ES"
    And home page contains the button "Empezar" in menu
    And home page contains the title "Inteligencia digital para un mundo más seguro"

  Scenario: Change the language from current to FR
    Given a visitor access the home page
    When the visitor click on language button
    Then select the language "FR"
    And home page contains the button "Commencer" in menu
#    And home page contains the title "Du renseignement numérique pour un monde plus sûr."

  Scenario: Change the language from current to DE
    Given a visitor access the home page
    When the visitor click on language button
    Then select the language "DE"
    And home page contains the button "Erste Schritte" in menu
#    And home page contains the title "Im Mittelpunkt von allem"

  Scenario: Change the language from current to PT
    Given a visitor access the home page
    When the visitor click on language button
    Then select the language "PT"
    And home page contains the button "Começar" in menu
    And home page contains the title "Inteligência digital para um mundo mais seguro"
