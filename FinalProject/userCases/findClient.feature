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
@tag
Feature: Get Client information
	Description: The users can view the client information
	
@tag1	
Scenario: Logistic Company can view the Client information
	Given that the logistic Company is logged in
	When the logistic Company decides to view the Client information
	And provides the client ID "897841664500"
	Then the Client information is shown that the company name is "random", the email is "random@random.com"

@tag2	
#Scenario: Logistic Company cannot view the Client information
 #Given that the logistic Company is logged in
#	When the logistic Company decides to view the Client information
	#And provides a Client ID "897841664511"
	#Then the client information is not shown 
	#And the logistic company is asked to provide a new Client ID
