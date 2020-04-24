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

Feature: Data Not found
  Description: The data is not found in the database


 # Scenario: Client can not be found in the database
 #   Given that the client ID 23456810892 is entered
 #   When the database is asked to return the client information
 #   Then error message "ElementNotFoundException" is given

  
 # Scenario: Container can not be found in the database
 #   Given that the container ID 248047946 is entered
 #   When the database is asked to return the container information
 #   Then error message "ElementNotFoundException" is given
    
 # Scenario: Port name is not valid
 #	 Given that the port name "random" is entered
 #  When the database is asked to return the portID
 #  Then the ID 1 is returned which means that port name is not valid

#	Scenario: Destination port doesnot exist
	#	Given that the portID 12789472 is entered
	#	When the database is asked to return the port data
	#	Then error message is returned
