Feature: Run simulation
  Description: Use the simulation package to generate and develop business objects


 Scenario: The simulation can create a new client
    Given that the logistics company is logged in in logist bla bla bla
 		And that the simulation is activated with a speed of 6 hours/second
 		And that the logistics company is viewing all clients
    When the simulation decides to create a new client
    Then a new client is created
    And the new client is displayed

Scenario: The simulation can create a new journey
		Given that the logistics company is logged in
		And that the simulation is activated with a speed of 6 hours/second
		When the simulaiton decides to create a new journey
		Then a new journey is defined
		And a container is assigned to the journey
		And a the journey is assigned to a client
		And the journey is displayed in active journeys
		And the journey is displayed on the world map
		
Scenario: The simulation can develop a journey
		Given that the logistics company is logged in
		And that the simulation is activated with a speed of 6 hours/second
		And that the following ports are defined:
				| ID 			  | Country   | Port name     | Longitude | Latitude |
				| 123456789 | "Denmark" | "Nyhavn"      | 55.       | 12.      |
				| 987654321 | "China"   |"Tianjin port" | 39.				| 118.		 |
		And that the following containers are defined 
				| ID				  | ClientID    | JourneyID | StartPortID | LastVisitedPortID | DestinationPortID | Longitude | Latitude | Cargo   | Temperature | Humidity | Atmosphere |
				| 10238493181 | 12901394121 | 128938929 | 123456789   | 123456789					| 987654321					| 40.				| 80.			 | "Socks" | 23.	 			 | 24.			| 1.				 |
		When the simulation decides to update active journeys
		Then the container with ID=10238493181 is moved towards its destination port with speed=60km/hour
		And the temperature of the container with ID=10238493181 is changed from 23. by no more than 0.3 with max=90. and min=-10.
		And the humidity of the container with ID=10238493181 is changed from 24. by no more than 0.5 with max=100. and min=0.
		And the atmosphere of the container with ID=10238493181 is changed from 1. by no more than 0.05 with max=3. and min=0.5

Scenario: The simulation can finish a journey
		Given that the following ports are defined:
				| ID 			  | Country   | Port name     | Longitude | Latitude |
				| 123456789 | "Denmark" | "Nyhavn"      | 55.       | 12.      |
				| 987654321 | "China"   |"Tianjin port" | 39.				| 118.		 |
		And the port with ID=987654321 has the arrriving container 10238493181
		And that the following clients are defined:
				| ID				  | Company name | Phone number | Email		    | Refrence person name | Street name   | House number | City 			   | Zip code |
				| 12901394121 | "Sock co."   | 45 989128318 | "so@co.com" |	"John T. Smith"			 | "Long street" | 32						| "Copenhagen" | 2100			|
		And that the client with ID=12901394121 has the active journey with ID=128938929
		And that the following containers are defined 
				| ID				  | ClientID    | JourneyID | StartPortID | LastVisitedPortID | DestinationPortID | Longitude | Latitude | Cargo   | Temperature | Humidity | Atmosphere |
				| 10238493181 | 12901394121 | 128938929 | 123456789   | 123456789					| 987654321					| 39.05			| 117.95	 | "Socks" | 23.	 			 | 24.			| 1.				 |
		When the simulation checks for finished journeys
		Then the client with ID=12901394121 has the the finished journey with ID=128938929
		And the client with ID=12901394121 does not have the active journey with ID=128938929
		And the container with ID=10238493181 has journeyID=0
		And the container with ID=10238493181 has lastVisitedPortID=987654321
		And the container with ID=10238493181 has startPortID=987654321
		And the container with ID=10238493181 has cargo=" "
		And the port with ID=987654321 does not have the arrriving container 10238493181
		And the port with ID=987654321 has the stationed container 10238493181
		