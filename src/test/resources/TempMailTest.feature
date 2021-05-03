Feature: Temp mail scenario

  Scenario: Temp mail scenario
    Given I open Temp Mail page
    And I click button random
    And I open dropdown menu
    And I enter rover.info in dropdown menu
    And I remember name address and domain
    And I open settings
    And I remember secret address and close modal window
    And I check what modal window Settings is closed
    And i check what text "В ожидании новых писем..." is Displayed
    And I click to the button Send
    And I check what modal window Send message open
    Then I send text name address in the Field Send to
    Then I send text "Test" in the field Theme
    Then I send text secret address in the field text message
    And I click to the button Send message
    And I Wait for the new message
    And I click to the new message
    Then I check name sender
    Then I check text "Test" in theme sender
    Then I check text in tet field secret address
    And I click to the button Reply
    Then I check to visibility form Reply
    Then I send text "Test2" in text field message
    Then I click to the button Send message in  form Reply
    And I click to the button Back
    And I check that the message has come
    Then I open message Re: Test
    And I check text "Test2" in body text
    And I click to the button delete
    Then I wait opened modal window Confirm delete
    Then I confirm deletion
    And I check that there is no email with the subject "Re: Test"

#  Убедиться, что во входящих нет письма с темой "Re: Test"