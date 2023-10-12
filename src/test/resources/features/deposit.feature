Feature: Deposit Money
  Scenario: Successful deposit
    Given I am logged in as customer number 1 with PIN 1234
    When I deposit $100
    Then my account balance should be $1100
