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
#

Feature: Get Client information
	Description: The users can view the client information
	
	
Scenario: Logistic Company can view the Client information
	Given that the logistic Company is logged in
	When the logistic Company decides to view the Client information
	And provides the client ID 36836570081685
	Then the Client information is shown that the company name is "Danielas quarantine snacks company", the email is "sacksarelife@gmail.com"


Scenario: Logistic Company cannot view the Client information
 Given that the logistic Company is logged in
	When the logistic Company decides to view the Client information
	And provides a Client ID 36836570081685
	Then the client information is not shown 

Scenario: Client can view its own information
	Given that the client is logged in
	And the ID 36836570081685 it entered exists in the memory
	When the client decides to view the client information
	Then the client information is shown that the company name is "Danielas quarantine snacks company", the email is "sacksarelife@gmail.com"
	And the phonenumber is countrycode 45 phone 95959697
	And the reference person is firstname "Daniela" lastname "Bahneanu" 
