Feature: Interview project cases

  Scenario: Case 1 - Automate purchase process
    Given I am on sauce inventory page
    And I log in with the credentials from the json
    When I select the Sauce Labs Backpack
    And I select the Sauce Labs Fleece Jacket
    Then validate that the number of the selected items is 2
    When I go through the check process
    Then validate that the checkout process was successful


  Scenario: Case 2 - Verify error messages for mandatory fields
    Given I am on sauce inventory page
    When I log in as standard user
    And I scroll to the footer
    Then validate that the footer message contains the mandatory texts
