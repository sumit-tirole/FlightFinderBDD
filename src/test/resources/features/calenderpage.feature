Feature: Calender search


  Scenario: Check scheduled flights availability
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When search for a destination
    And clicks on random date
    Then user should see the scheduled flights availability
    And user should be able to logout successfully


  Scenario: Check Seats availability on calender page
    Given navigate to the application URL
    And accept cookies
    And sign in with valid credentials
    When search for a destination
    And checks seats availability for complete next month
    Then colored circles indicating seats availability should be displayed.
    And user should be able to logout successfully