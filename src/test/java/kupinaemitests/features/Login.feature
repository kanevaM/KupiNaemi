@test @login
Feature: Customer Login tests https://kupinaemi.bg/potrebitelski-akaunt/vhod

  Background:
    Given user is at the Login page

  Scenario Outline: Valid Login
    And login page with title "Влезте с профила си" is loaded
    And I enter emailAddress "<emailAddress>"
    And I enter passWord "<password>"
    And check not robot for login page
    And I click on "Влез" button
    Then page with "Изход" button is loaded

    Examples:
      | emailAddress             | password
      | kaneva.marieta@gmail.com | wordToPass!

#  Scenario: Invalid Login