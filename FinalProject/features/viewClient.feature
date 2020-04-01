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
Feature: Get Client information
	Description: The users can view the client information
	
Scenario: Logistic Company can view the Client information
	Given that the logistic Company is logged in
	When the logistic Company decides to view the Client information
	And provides a Client ID that is stored in the database
	Then the Client information is shown
	
Scenario: Logistic Company cannot view the Client information
	Given that the logistic Company is logged in
	When the logistic Company decides to view the Client information
	And provides a Client ID that is not stored in the database
	Then the client information is not shown 
	And the logistic company is asked to provide a new Client ID
	
Scenario: Client wants to view its own information
	Given that the Client is logged in
	When the client decides to view its own information
	And provides its own ID 
	Then the client information is shown
	
Scenario: Client tries to view another clients information
	Given that the Client is logged in 
	When the client decides to view its own information
	And provides a Client ID that is not its own ID
	Then the client information is not shown