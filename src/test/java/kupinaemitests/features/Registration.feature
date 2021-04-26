@test
Feature: Registration tests https://kupinaemi.bg/potrebitelski-akaunt/registraciq

  Background:
    Given user is at the Registration page

  Scenario Outline: Registration
    And page "Регистрация" is loaded
    And I enter firstname "<firstName>"
    And I enter middleName "<middleName>"
    And I enter surName "<surName>"
    And I enter email "<email>"
    And I enter phoneNumber "<phoneNumber>"
    And I enter otherNumber "<otherNumber>"
    And I enter password "<password>"
    And I enter confirmPassword "<confirmPassword>"
    And agree with terms and conditions
    And check not robot
    And I click to send data
    Then confirmation message is loaded "Системно съобщение"

    Examples:
      | firstName | middleName | surName | email                    | phoneNumber | otherNumber | password    | confirmPassword |
      | Marieta   | Yordanova  | Kaneva  | kaneva.marieta@gmail.com | 0883455124  | 6666        | wordToPass! | wordToPass!     |
      | name      | middleName | surName | email                    | phoneNumber | otherNumber | password    | confirmPassword |




