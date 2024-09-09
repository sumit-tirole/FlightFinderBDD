Feature: Login feature


  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username
    And user enters password
    And user clicks on Login button
    Then verify the page title
    And user clicks on account button
    Then user clicks on logout button


  Scenario: Login with incorrect credentials
    Given user is on login page
    When user enters username
    And user enters invalid password
    And user clicks on Login button
    Then user should get an error message


  Scenario: Login with Facebook
    Given user is on login page
    When user click on the Facebook sign-in button
    And user switch to the Facebook login window
    And user enter his Facebook email and password
    And user click on the Facebook login button
    And I switch back to the Reward Flight Finder window
    And user clicks on account button
    Then user clicks on logout button


  Scenario: Login with Google
    Given user is on login page
    When user click on the Google sign-in button
    And user switch to the Google login window
    And user enter his Google email and clicks on next
    And user enter his Google password and clicks on next
    And I switch back to the Reward Flight Finder window
    And user clicks on account button
    Then user clicks on logout button