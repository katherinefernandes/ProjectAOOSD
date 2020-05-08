
Feature: Register a new Client 
  Description: Only the logistic company can register a new client

  
Scenario: Logistic Company registers a new client
	Given the logistic Company decides to add a new client
  When the client email is provided Whitney.Karlen@hotmail.com 
  And the client name is provided"Walther's fan A/S"
  And the client phone number is provided  45 , 2345678 
  And the reference person is provided "Yetty" "Patti" "Xylina"
  And the address is provided street: "Kirkpatrick-main" house number: 23 city: "record city" zipcode: "2345"
  Then a unique client ID is generated 


