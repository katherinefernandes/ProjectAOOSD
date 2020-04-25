
Feature: Update the last port visited by the container
 description: The logistic Company can update the last port visited by the container

Scenario: Logistic Company can update the port visited for the container
 Given there is a container with assigned ID 10849147913510
  And the container has the assigned journey ID 108491479189
 	And the container has the assigned client ID 897841664891
  And the start port is assigned "Gwadar"
  And the destination port is assigned "Copenhagen"
  And the current location of the container assigned is 26.11 latitude and 74.33 longitude
  And the container has cargo assigned as  "snacks"
  And its optimal internal Status assigned is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date assigned is "23-06-2020"
	And that the logistic company enters the container ID 10849147913510
	When the port name is given "Keppel"
  Then the port visited for the container is updated
  And the new port is "Keppel"
 
 Scenario: Logistic Company can update the port visited for the container
  Given there is a container with assigned ID 10849147913510
  And the container has the assigned journey ID 10849147913523  
 	And the container has the assigned client ID 897841664590
  And the start port is assigned "Gwadar"
  And the destination port is assigned "Copenhagen"
  And the current location of the container assigned is 26.11 latitude and 74.33 longitude
  And the container has cargo assigned as  "snacks"
  And its optimal internal Status assigned is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date assigned is "23-06-2020"
	And that the logistic company enters the container ID 10849147913510
	When the port name is given "Copenhagen"
  Then the port visited for the container is updated
  And the new port is "Copenhagen"
 
 
 
 
 
 
 
  
