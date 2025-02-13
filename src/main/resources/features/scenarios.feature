Feature: Interview project cases

  Scenario: Case 1 - Automate purchase process
    Given I am on the sauce inventory page
    And I log in with the credentials from the json
    When I select the Sauce Labs Backpack
    And I select the Sauce Labs Fleece Jacket
    Then validate that the number of the selected items is 2
    When I go through the check process
    Then validate that the checkout process was successful


  Scenario: Case 2 - Verify error messages for mandatory fields
    Given I am on the sauce inventory page
        #TODO: User
    When I log in as standard user
    And I scroll to the footer
    #TODO: Missing the scrolling
    #TODO: should I split it up to 2?
    Then validate that the footer message contains 2025
    Then validate that the footer message contains Terms of Service


  Scenario: Case 3 - Rich text Editor
    Given I am on the rich text editor page
    #TODO: wait for the editor
    When I type in the Automation Test Example to the editor
    And I select all the text in the editor
    And I apply bold formatting on the editor
    And I apply underline formatting on the editor
    Then validate that the formatted text is in the text editor

  Scenario: Case 4 - IFrame and tab handling
    Given I am on the guru99 home page
