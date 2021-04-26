@test
Feature: Detailed Search tests https://kupinaemi.bg/tyrsene-na-obiava/predlagashta-imot

  Background:
    Given kupinaemi detailed search page


  Scenario: Detailed Search
    And I choose offer type
    And I select a place
    And I select property type
    And I select construction type
    And I select stage of completion

