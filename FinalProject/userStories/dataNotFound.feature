

Feature: Data Not found
  Description: The data is not found in the database


 Scenario: Client can not be found in the database
    Given that the client ID 23456810892 is entered
    When the database is asked to return the client information
    Then error message "ElementNotFoundException" is given

  
  Scenario: Container can not be found in the database
    Given that the container ID 248047946 is entered
    When the database is asked to return the container information
    Then error message "ElementNotFoundException" is given
    
  Scenario: Port name is not valid
 	 Given that the port name "random" is entered
   When the database is asked to return the portID
   Then the ID 1 is returned which means that port name is not valid

	Scenario: Destination port doesnot exist
		Given that the portID 12789472 is entered
		When the database is asked to return the port data
		Then error message is returned
