Feature: new book entry
  As a merchant
  I want to be able to create invoices    
  so that my customer could pay with FLASHiZ

  Scenario Outline: new invoice
    Given I open the POS app
    When I add a EUR <amount> invoice
    Then I see <amount> invoice details

    Examples: 
      | amount |
      | 12     |
      | 14     |
