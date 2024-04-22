
Feature: Car wash services
  


  Scenario: Listing the top car wash services and then listing gym categories
    Given user clicks on required location and lands on homepage
    When user searches for carwash services
    And lists all the top five car wash services whose ratings are greater than four
    And writes a review, shares on fb and twitter, and reports the service
    Then navigates back to homepage and clicks on freelisting 
    And captures the error message after providing credentials
    And navigates back and clicks on gym 
    And chooses all the gym sub-categories available
    
    


