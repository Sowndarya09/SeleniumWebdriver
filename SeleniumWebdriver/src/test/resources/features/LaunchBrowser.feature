#A sample file to launch browser

Feature: Launch Browser

  Scenario Outline: Launch Browser and open Google
    Given I want to launch a browser and open url
    And Validate whether page "<Title>" is launched successfully 
    
    Examples:
    |Title|
    |Google|
    