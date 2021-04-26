@test
Feature: Search Menu tests https://kupinaemi.bg/

  Background:
    Given kupinaemi page
    And kupinaemi home page

  Scenario: Test search kupi
    And the item kupi should be selected by default
    When I click on naemi and select the item
    Then the item kupi should be deselected
    When I click on kupi and select the item
    And I click on tyrsi
    Then is loaded page with properties for sale with "Обяви за продажба на имоти" message
    And an option for changing the searching

  Scenario: Test search naemi
    And the item kupi should be selected by default
    When I click on naemi and select the item
    And I click on tyrsi
    Then is loaded page with properties for rent with "Обяви за имоти под наем" message
    And an option for changing the searching

  Scenario: Test search nameri kupuvach
    And the item kupi should be selected by default
    When I click on nameri kupuvach and select the item
    And I click on tyrsi
    Then is loaded page with buyers with "Обяви от купувачи на имоти" message
    And an option for changing the searching

  Scenario: Test search nameri naematel
    And the item kupi should be selected by default
    When I click on nameri naematel and select the item
    And I click on tyrsi
    Then is loaded page with tenants profiles with "Обяви от наематели на имоти" message
    And an option for changing the searching

  Scenario: Test search kupi podrobno tyrsene
    And the item kupi should be selected by default
    When I click on naemi and select the item
    Then the item kupi should be deselected
    When I click on kupi and select the item
    And I click on podrobno tyrsene
    Then is loaded page with detail search and title "Подробно търсене на имот"

  Scenario: Test search naemi podrobno tyrsene
    And the item kupi should be selected by default
    When I click on naemi and select the item
    And I click on podrobno tyrsene
    Then is loaded page with detail search and title "Подробно търсене на имот"

  Scenario: Test search nameri kupuvach podrobno tyrsene
    And the item kupi should be selected by default
    When I click on nameri kupuvach and select the item
    And I click on podrobno tyrsene
    Then is loaded page with detail search and title "Подробно търсене на купувач или наемател"

  Scenario: Test search nameri naematel podrobno tyrsene
    And the item kupi should be selected by default
    When I click on nameri naematel and select the item
    And I click on podrobno tyrsene
    Then is loaded page with detail search and title "Подробно търсене на купувач или наемател"