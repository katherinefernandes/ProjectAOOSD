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
	Given the logistic Company enters the Client ID 897841664500
	When the Client ID is present in the database
	Then the Client information is shown that the company name is "random", the email is "random@random.com"


Scenario: Logistic Company cannot view the Client information
  Given the logistic Company enters the Client ID 897841664590
  When the Client ID is not present in the database
	Then the client information is not shown as that client doesnot exist

Scenario: Client can view its own information
	Given that the client enters the ID 897841664500 that exists in the memory
	When the client decides to view the client information
	Then the client information is shown that the company name is "random", the email is "random@random.com"
	And the phonenumber is countrycode 45 phone 23879091
	And the reference person is firstname "muna" lastname "azam" 
