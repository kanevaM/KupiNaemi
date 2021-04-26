@test
Feature: Header Menu tests https://kupinaemi.bg/
   #!!!!!!
  # DA NAPRAVIA PO PODROBNO TESTVANE NA BYRZA NAWIGACIA
  Background:
    Given kupinaemi page
    And kupinaemi home page

  Scenario: Website logo navigation
    When I click on the logo
    Then the page should be open at the main page with "САЙТ ЗА НЕДВИЖИМИ ИМОТИ" message

  Scenario: First header menu item nachalo
    When the first head nachalo is unclickable
    And I click to dobavi obiava
    Then item nachalo should be clickable
    And I click on item nachalo
    Then the page should be open at the main page with "САЙТ ЗА НЕДВИЖИМИ ИМОТИ" message

  Scenario: Header menu vsichki obiavi/ submenu kupi imot
    When I click on menu vsichki obiavi
    Then Submenu items should appear below
    When I click on Kupi imot from the submenu
    Then is loaded page with properties for sale with "Обяви за продажба на имоти" message

  Scenario: Header menu vsichki obiavi/ submenu naemi imot
    When I click on menu vsichki obiavi
    Then Submenu items should appear below
    When I click on naemi imot from the submenu
    Then is loaded page with properties for rent with "Обяви за имоти под наем" message

  Scenario: Header menu vsichki obiavi/ submenu nameri kupuvach
    When I click on menu vsichki obiavi
    Then Submenu items should appear below
    When I click on nameri kupuvach from the submenu
    Then is loaded page with buyers with "Обяви от купувачи на имоти" message

  Scenario: Header menu vsichki obiavi/ submenu nameri naematel
    When I click on menu vsichki obiavi
    Then Submenu items should appear below
    When I click on nameri naematel from the submenu
    Then is loaded page with tenants profiles with "Обяви от наематели на имоти" message

  Scenario: First header menu item Dobavi obiava
    When I click to dobavi obiava
    Then is loaded page with options to add obiava with "Добави обява на сайта" message

  Scenario: First header menu item specialni oferti
    When I click to specialni oferti
    Then is loaded page with special offers with "Специални оферти" message








