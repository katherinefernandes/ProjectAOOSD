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

Feature: Register Container
 Description: The Client can register containers for journeys

 
Scenario: Client can register a container for a journey
	Given there is a client with ID 36836570081685 
	When that the client with the ID 36836570081685 is logged into the clientApplication
	And the client provides a port name "Gwadar" from where the journey will start
	And provides a destination port name "Copenhagen" 
	And provides the name of the cargo "Mangoes" being transported
	And provides the optimal internal state for the cargo which is 10.0 temperature, 1.0 atm pressure and 90.0% humidity
	And provides the expected arrival date which is "30-04-2020"
  Then a container is registered for the journey and the client is provided with a journey ID to track the container. 

