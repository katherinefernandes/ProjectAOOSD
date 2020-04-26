
Feature: View All Active Journeys
 description: The logistic Company can view all the active Journeys

 Scenario: Logistic Company can view all the active Journeys
  Given there is a container with assigned ID 1084914791892
  And the container has the assigned journey ID 108492279189
 	And the container has the assigned client ID 112334891
  And the start port is assigned "Gwadar"
  And the destination port is assigned "Copenhagen"
  And the current location of the container assigned is 26.11 latitude and 74.33 longitude
  And the container has cargo assigned as  "snacks"
  And its optimal internal Status assigned is 1.0 atm 20.0 celsius 50.0 % humidity
  And its arrival date assigned is "23-06-2020"
	When the logistic company decides to view all the active Journeys
	Then all the active journey IDs are returned which also contains the Journey ID 108492279189