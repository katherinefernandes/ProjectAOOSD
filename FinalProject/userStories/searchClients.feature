

Feature: Search clients
Description: The Logistic Company should be able to search for clients.
 
Scenario: Logistic Company can search by clients name
 Given that there exists a client with ID 555555555555
	And the client name is "White notebook"
	And the email is "whitenotebook@wn.com"
	And the phonenumber is countrycode 45 phone 85665565
	And the reference person is firstname "muna" middlename "" lastname "azam" 
  When that the logistic company enters the clients name "White notebook"
  Then the list of clients with this name should appear
  And the list should include the client with ID 555555555555

Scenario: Logistic Company can search by clients email
	Given that there exists a client with ID 555555555555
	And the client name is "White notebook"
	And the email is "whitenotebook@wn.com"
	And the phonenumber is countrycode 45 phone 85665565
	And the reference person is firstname "muna" middlename "" lastname "azam"
	When that the logistic company enters the clients email "whitenotebook@wn.com"
	Then the list of clients with this email should appear
	And the list should include the client with ID 555555555555

Scenario: Logistic Company can search by clients reference person
	Given that there exists a client with ID 555555555555
	And the client name is "White notebook"
	And the email is "whitenotebook@wn.com"
	And the phonenumber is countrycode 45 phone 85665565
	And the reference person is firstname "muna" middlename "" lastname "azam"
	When that the logistic company enters the clients reference person "muna" "" "azam"
	Then the list of clients with this reference person should appear
	And the list should include the client with ID 555555555555

Scenario: Logistic Company can search by clients phone
	Given that there exists a client with ID 555555555555
	And the client name is "White notebook"
	And the email is "whitenotebook@wn.com"
	And the phonenumber is countrycode 45 phone 85665565
	And the reference person is firstname "muna" middlename "" lastname "azam"
	When that the logistic company enters the clients phone 85665565
	Then the list of clients with this phone should appear
	And the list should include the client with ID 555555555555
	
	
	
