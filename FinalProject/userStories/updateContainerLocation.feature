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

Feature: Update Container Location
 Description: The Logistic Company should be able to update the container location.
 
Scenario: Logistic Company can register a new location for the container
	Given there is a container with the ID 10849147913500
  And the container has the journey ID 10849147913523  
  And the start port is given "Gwadar"
  And the destination port is given "Copenhagen"
  And the current location of the container given is 26.11 latitude and 74.33 longitude
  And the container has cargo given as  "snacks"
  And its optimal internal Status is given  1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date is given "23-06-2020"
	And that the logistic company enters the container ID 10849147913500
	When the latitude 65.4 is given
  And the longitude 45.85 is given
  Then the location for the container is updated
  And the new latitude is 65.4
  And the new longitude is 45.85