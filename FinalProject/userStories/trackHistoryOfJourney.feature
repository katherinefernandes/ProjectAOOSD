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
	
	Scenario: The logistic Company should be able to update the internal status of the container
	Given there is a container with the ID 10849147913500
  And the container has the journey ID 10849147913523  
  And the start port is given "Gwadar"
  And the destination port is given "Copenhagen"
  And the current location of the container given is 26.11 latitude and 74.33 longitude
  And the container has cargo given as  "snacks"
  And its optimal internal Status is given  1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date is given "23-06-2020"
	And that the logistic company enters the container ID 10849147913500
	When the temperature value 38.0 are given
	And the humidity level value 98.0% are given
	And the pressure value 1.0atm are given 
	Then the internal status of the container is updated
	And the new temperature value is 38.0
	And the new humidity level is 98.0%
	And the new pressure value is 1.0atm 
	
	Scenario: The client should be able to view the internal status of the container
	Given there is a client with ID 14618447211200 
  And the client has a container with the journey ID 17027135462300 registered for a journey 
  And the start port of the container was "Gwadar"
  And the destination port is "Copenhagen"
  And the current location of the container is 26.11 latitude and 74.33 longitude
  And the container has cargo "snacks"
  And its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date is "23-06-2020"
  When that the client with the ID 14618447211200 is logged into the clientApplication
	And the client chooses to view the internal status of a container with the journeyID 17027135462300
 	Then the client can view the current internal status of the container which is temperature 20.0, pressure 1.0, humidity level 50.0



