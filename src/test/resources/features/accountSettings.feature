Feature: Account Settings


  Scenario: Update and Verify secondary email
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    And navigates to my account section
    And clicks on update email button
    Then deletes existing secondary email
    Then opens a new tab and navigates to emailondeck and fetch email address
    Then navigates back to RFF website and adds the email
    Then switch back to emailondeck and verifies email
    Then switch back to RFF and refresh the page
    And Checks if email is verified
    And user should be able to logout successfully


  Scenario: Change/update password
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    And navigates to my account section
    And clicks on change password button
    And enter old and new password and clicks save button
    Then user should see the successfull toast message
    And user should be able to logout successfully


  Scenario: Update Airline membership tier
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    And navigates to my account section
    And click on Airline Membership Tier button
    And selects any membership tier other than existing
    Then user should see the Airline tier updated successfully toast message
    And user should be able to logout successfully


  Scenario: Update SMS and Email notification settings
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    And navigates to my account section
    And click on Notification Settings button
    And click on disable sms alert notifications button
    Then sms notification disabled successfully toast message should be displayed
    And click on disable email alert notifications button
    Then email notification disabled successfully toast message should be displayed
    And click on enable sms alert notifications button
    Then sms notification enabled successfully toast message should be displayed
    And click on enable email alert notifications button
    Then email notification enabled successfully toast message should be displayed
    And user should be able to logout successfully


  Scenario: Update Personal info
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    And navigates to my account section
    And click on Personal Info button
    Then Updates first name
    Then Updates last name
    Then Updates Closest airport, Age Band and gender
    Then Updates Average flights and travel abroad plan
    And clicks on save changes button
    Then personal info updated successfully toast message should be displayed
    And user should be able to logout successfully