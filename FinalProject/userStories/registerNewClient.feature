
Feature: Register a new Client 
  Description: Only the logistic company can register a new client

  
Scenario: Logistic Company registers a new client
	Given the logistic Company decides to add a new client
  When the client email is provided "email@some.come" 
  And the client name is provided"client"
  And the client phone number is provided  45 , 2345678 
  And the reference person is provided "Some" "random" "person"
  And the address is provided street: "23" house number: 23 city: "Albertslund" zipcode: "2345"
  Then a unique client ID is generated 


