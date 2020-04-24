
Feature: Get Client information
	Description: The users can view the client information
	
	
Scenario: Logistic Company can view the Client information
	Given there exists a client with ID 897841664500
	And the client name is "random"
	And the email is "random@random.com"
	And the phonenumber is countrycode 45 phone 23879091
	And the reference person is firstname "muna" lastname "azam" 
	When the logistic Company enters the Client ID 897841664500
	Then the Client information is shown that the client name is "random"
	And the email shown is "random@random.com"




Scenario: Client can view its own information
	Given there exists a client with ID 897841664500
	And the client name is "random"
	And the email is "random@random.com"
	And the phonenumber is countrycode 45 phone 23879091
	And the reference person is firstname "muna" lastname "azam" 
	And that the client with the ID 897841664500 is logged into the clientApplication
	When the client decides to view its own information
	Then the client sees that the company name is "random"
	And  that the email is "random@random.com"
	And that the phonenumber is countrycode 45 phone 23879091
	And that the reference person is firstname "muna" lastname "azam" 
