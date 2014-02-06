Feature: new book entry    
	As a book owner
	I want to add books I own to the book tracker    
	so that I do not have to remember them by myself
	
Scenario: new book   
	Given I open the book tracker   
	When I add "<book_name>"    
	Then I see "<book_name>"s details
	
Examples:
| book_name					|
| Martine fait du Grails	|
| Martine aime Cucumber		|