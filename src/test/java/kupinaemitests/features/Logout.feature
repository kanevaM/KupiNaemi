@test @logout
Feature: Customer Login tests https://kupinaemi.bg

  Background:
    Given user is logged in

  Scenario: Logout
    When I click on exit button "Изход"
    Then the page should be open at the main page with "САЙТ ЗА НЕДВИЖИМИ ИМОТИ" message