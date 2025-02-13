@ui
Feature: Open new account

  Scenario: Automate purchase Process
    Given I am on sauce inventory page
    And I log in with the credentials from the json
    When I select the Sauce Labs Backpack
    And I select the Sauce Labs Fleece Jacket
    Then validate that the number of the selected items is 2
    When I go through the check process
    Then validate that the checkout process was successful