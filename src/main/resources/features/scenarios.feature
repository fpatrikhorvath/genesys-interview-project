Feature: Interview project cases

  #TODO: Loggerization
  Scenario: Case 1 - Automate purchase process
    Given I am on the sauce inventory page
    #TODO: implement it
    And I log in with the credentials from the json
    When I select the backpack item
    And I select the jacket item
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
    Then validate that the footer message contains "2025"
    Then validate that the footer message contains "Terms of Service"


  Scenario: Case 3 - Rich text Editor
    Given I am on the rich text editor page
    #TODO: wait for the editor
    When I type in the "Automation Test Example" to the editor
    And I select all the text in the editor
    And I apply bold formatting on the editor
    And I apply underline formatting on the editor
    Then validate that the formatted text is in the text editor

  Scenario: Case 4 - iframe and tab handling
    When I am on the guru99 home page
    Then validate that the guru99 IFrame is visible
    When I click on the jmeter image
    And I close the newly opened tab
    Then validate that the email submission text is visible
    When I send the email submission
    Then I validate that the pop up message contains "Successfully"
    When I click on selenium dropdown and choose the tooltip option
    Then validate the tooltip page contains the download now button
