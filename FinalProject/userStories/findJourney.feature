Feature: Find a journey
  Description: The Client can track the journey of a container
  
  Scenario: Client can track the journey of a container by Journey ID
  Given there is a client with ID 36836570081685 
  And the client has a container with the journey ID 10849147913500 registered for a journey 
  And the start port of the container was "Gwadar"
  And the destination port is "Copenhagen"
  And the current location of the container is 26.11 latitude and 74.33 longitude
  And the container has cargo "snacks"
  And its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date is "23-06-2020"
  When that the client with the ID 36836570081685 is logged into the clientApplication
  And the client asks for the information of the container with the journey ID 10849147913500
  Then the current location of the container shown is 26.11 latitude and 74.33 longitude
  And it contains the cargo:"snacks" 
  And it will arrive by the date "23-06-2020"
  
  
  
 	Scenario: Client can track the containers starting journey from a Port
  Given there is a client with ID 36836570081685 
  And the client has a container with the journey ID 10849147913500 registered for a journey 
  And the start port of the container was "Gwadar"
  And the destination port is "Copenhagen"
  And the current location of the container is 26.11 latitude and 74.33 longitude
  And the container has cargo "snacks"
  And its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date is "23-06-2020"
  When that the client with the ID 36836570081685 is logged into the clientApplication
 	And the client provides the port name "Gwadar"
 	Then the client can view the information for his containers starting journey from the Port "Gwadar"
 	And those containers will include the container with the journey ID 10849147913500
 	
 	
 	Scenario: Client can track the containers containing a particular cargo
 	 Given there is a client with ID 36836570081685 
  And the client has a container with the journey ID 10849147913500 registered for a journey 
  And the start port of the container was "Gwadar"
  And the destination port is "Copenhagen"
  And the current location of the container is 26.11 latitude and 74.33 longitude
  And the container has cargo "snacks"
  And its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date is "23-06-2020"
  When that the client with the ID 36836570081685 is logged into the clientApplication
 	When the client provides the cargo type "snacks"
 	Then the client can view all the information for all those containers 
