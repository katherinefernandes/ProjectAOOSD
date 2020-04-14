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
Feature: Track the history of the Journey
	Description: The history of how the internal status of the container changed over time
	
	#Scenario: The logistic Company should be able to update the internal status of the container
	#Given the logistic Company decides to update the internal status of the container
	#When the logistic Company enters the container ID 521664805370600
	#And the temperature value 38.0
	#And the humidity level value 98.0% 
	#And the pressure value 1atm
	#Then the internal status of the container is updated and the changes are displayed to the company
	
	#Scenario: The client should be able to view the internal status of the container
	#Given that the client enters the ID 521601819167600 that exists in the memory
	#When the client chooses to view the internal status of a container which is on a journey
	#And the container with the ID 36941951964596 exists in the database
  #And the client enters the journey ID 36941951970869 which matches the journey ID of the container
  #Then the client can view the internal status of the container.



