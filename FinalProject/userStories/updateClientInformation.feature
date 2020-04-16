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

Feature: Update the information of the client
  description: The client can update parts of its own information

 
 
 Scenario: Client can update its phone number
	Given that the client enters the ID 828300261636100 that exists in the memory
	When the client decides to update its phone number
	And provides the new country code 45 which is of the valid length
	And provides the new phone number 45670912 which is also of the valid length
	Then the previous phone number and country code are replaced with the valid values
	
Scenario: Client can update its email number
	Given that the client enters the ID 828300261636100 that exists in the memory
	When the client decides to update its email
	And provides the new email "something@new.com" which is a valid email format
	Then the previous email is replaced with the new valid email
	
Scenario: Client can update its reference Person
	Given that the client enters the ID 828300261636100 that exists in the memory
	When the client decides to update its reference person
	And provides the new firstname "Fiza" which is valid
	And provides the new middlename "J" which is also valid 
	And provides the new lastname "Azam" which is also valid
	Then the previous reference person is replaced with the new information