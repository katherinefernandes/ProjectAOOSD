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

Feature: Find a journey
  Description: The Client can track the journey of a container
  
  Scenario: Client can track the journey of a container by Container ID
  Given that the client enters the ID 897841664500 that exists in the memory
  When the client enters the container the ID 10849147913500 that exists in the database
  Then the current location of the container is 26.11 latitude and 74.33 longitude, it contains the cargo:"snacks" 
  And it will arrive by the year 2020 month 06 day 23 hour 12 minute 0
  
 	#Scenario: Client would like to find all their journey departing from a particular port
 	#Given that the client enters the ID 521601819167600 that exists in the memory
 	#When the client chooses to view the information of all containers standby at a port 
 	#And the client provides the port name "Gwadar"
 	#Then the client can view all the information for all the containers registered by the client 
 	
 	#Scenario: Client would like to find all the containers in a journey containing a particular cargo 
 	#Given that the client enters the ID 521601819167600 that exists in the memory
 	#When the client chooses to view the information of all containers transporting "Rice" 
 	#Then the client can view all the information for all those containers at different ports
