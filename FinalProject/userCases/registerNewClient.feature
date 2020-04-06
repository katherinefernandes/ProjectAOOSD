#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag

Feature: Register a new Client 
  Description: Only the logistic company can register a new client

  @tag1
 # Scenario: Logistic Company registers a new client
 # Given that the logistic Company is logged in
#	When the logistic Company decides to add a new client "somecompany"
#	And the client email is "email@some.come" 
#	And the client phone number is "45" , "2345678" 
#	And the reference person is "Some" "random" "person"
#	And the address is street: "23" house number: "23" city: "Albertslund" zipcode: "2345"
#	Then a unique client ID is generated 
#	And displayed 
	
	@tag2
#	Scenario: Client tries to register another client
#	Given that the Client with the ID "897841664500" is logged in
#	When the Client tries to register a new client "Somecompany"
#	Then an error message "Wrong option" is generated
	
