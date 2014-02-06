Feature: list merchant
  As an admin    
  I want to list the merchants    
  so that I can look their profile

  Scenario Outline: list existing merchants
    Given I have already created a "<merchant>" merchant
    When I view the merchant list
    Then my merchant list contains the "<merchant>" merchant

    Examples: 
      | merchant |
      | McDo     |
      | Fischer  |
