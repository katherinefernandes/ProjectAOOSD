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
 
#Scenario: Logistic Company can register a new location for the container
#Given that the logistic company chooses to update the location
#When the logistic company enters the container id 747868023659900
#And the latitude 65.4
#And the longitude 45.85
#Then the location for the container is updated