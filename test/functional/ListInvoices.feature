Feature: list my invoices
  As a merchant    
  I want to list my invoices    
  so that I can look their amount

  Scenario Outline: list existing invoices
    Given I have already created a EUR <amount> invoice
    When I view the invoice list 
    Then my book list contains the EUR <amount> invoice

    Examples: 
      | amount | 
      | 12     | 
      | 14     | 
