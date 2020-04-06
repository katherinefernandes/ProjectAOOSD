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

 
 
 # Scenario: Client can update its email address
  #  Given that the Client with the ID "897841664500" is logged in
  #  When the client chooses to update its email address 
   # And provides the new email address "newemail@email.com"
   # Then the current email "random@random.com" is replaced with the new email

  
  #Scenario: Client can update its phone number
  	#Given that the Client with the ID "897841664500" is logged in
  	#When the client chooses to update its phone number
  	#And provides the new country code "45" and the new phone number "45670912"
  	#Then the previous phone number and the country code are replaced with the new values.
  
  
  #Scenario: Client tries to update someone elses information
  # Given that the Client with the ID "897841664500" is logged in
  # When the client chooses to update its phone number 
  # And provides a wrong security code which does not match its ID
   #Then the error "Not allowed" is given