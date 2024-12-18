Feature: user should be able to login to the system
  Background: user go to login page
    Given user navigate to login page for reset

    #valid reset
  Scenario: user could reset password successfully
    When user click on forgetPassword
    Then user navigate to forgetPage and enter his email "leqaahani@example.com"
    And user click on Recovery Button
    And password will be reset
    #invald reset
  Scenario: user could reset password successfully
    When user click on forgetPassword
    Then user navigate to forgetPage and enter his email "user@example.com"
    And user click on Recovery Button
    And password will not be reset