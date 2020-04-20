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

Feature: Search clients
Description: The Logistic Company should be able to search for clients.
 
Scenario: Logistic Company can search by client's name
Given that the logistic company enters the client's name "White notebook"
Then the list of clients with this name should appear

Scenario: Logistic Company can search by client's email
Given that the logistic company enters the client's email "whitenotebook@wn.com"
Then the list of clients with this email should appear

Scenario: Logistic Company can search by client's reference person
Given that the logistic company enters the client's reference person "muna" "" "azam"
Then the list of clients with this reference person should appear

Scenario: Logistic Company can search by client's phone
Given that the logistic company enters the client's phone 85665565
Then the list of clients with this phone should appear