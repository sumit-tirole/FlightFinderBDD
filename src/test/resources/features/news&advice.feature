Feature: Verify visibility of popular articles, topics, and blogs.


  Scenario: Check visibility of blogs on Home page
    Given navigate to the application URL
    And accept cookies
    When User click on the articles icon
    Then popular articles section should not be empty
    And popular topics section should not be empty
    And popular blogs section should not be empty