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
  Description: The users can track the journey of a cargo
  
  Scenario: Client can view the information of a container for a journey
  Given that the client enters the ID 36836570081685 that exists in the memory
  When the client chooses to view the information of a container registered for a journey
  And the container with the ID 36941951964596 exists in the database
  And the client enters the journey ID 36941951970869 which matches the journey ID of the container
  Then the current location of the container, description of the cargo:"snacks" will be displayed for the client.
  
 	#Scenario: Client would like to find all their journey departing from a particular port
 	#Given that the client enters the ID 521601819167600 that exists in the memory
 	#When the client chooses to view the information of all containers standby at a port 
 	#And the client provides the port name "Gwadar"
 	#Then the client can view all the information for all the containers registered by the client 
 	
 	#Scenario: Client would like to find all the containers in a journey containing a particular cargo 
 	#Given that the client enters the ID 521601819167600 that exists in the memory
 	#When the client chooses to view the information of all containers transporting "Rice" 
 	#Then the client can view all the information for all those containers at different ports
