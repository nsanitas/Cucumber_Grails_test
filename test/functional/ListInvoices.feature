Feature: list my invoices    
	As a merchant    
	I want to list my invoices    
	so that I can look their amount
	
Scenario: list existing invoices   
	Given I have already created a EUR 12.2 invoice    
	When I view the invoice list    
	Then my book list contains the EUR 12.2 invoice