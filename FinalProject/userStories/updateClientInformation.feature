

Feature: Update the information of the client
  description: The client can update parts of its own information

 
 
 Scenario: Client can update its phone number
  Given that there exists a client with ID 897841664500
	And the client name is "Nederhoff's limitations Inc."
	And the email is "Rici@outlook.jp"
	And the phonenumber is countrycode 45 phone 23879091
	And the reference person is firstname "Amandy" middlename "Mireille" lastname "Luna dela Rosa" 
	And that the client with the ID 897841664500 is logged into the clientApplication
	When the Client provides the new country code 45 which is of the valid length
	And provides the new phone number 45670912 which is also of the valid length
	Then the previous phone number and country code are replaced with the valid values
	
Scenario: Client can update its email number
 Given that there exists a client with ID 897841664500
	And the client name is "Nederhoff's limitations Inc."
	And the email is "Rici@outlook.jp"
	And the phonenumber is countrycode 45 phone 23879091
	And the reference person is firstname "Amandy" middlename "Mireille" lastname "Luna dela Rosa" 
	And that the client with the ID 897841664500 is logged into the clientApplication
	When the client provides the new email "Whitney.Karlen@hotmail.com" which is a valid email format
	Then the previous email is replaced with the new valid email
	
Scenario: Client can update its reference Person
	Given that there exists a client with ID 897841664500
	And the client name is "Nederhoff's limitations Inc."
	And the email is "Rici@outlook.jp"
	And the phonenumber is countrycode 45 phone 23879091
	And the reference person is firstname "Amandy" middlename "Mireille" lastname "Luna dela Rosa" 
	And that the client with the ID 897841664500 is logged into the clientApplication
	When the client provides the new firstname "Yetty" which is valid
	And provides the new middlename "Patti" which is also valid 
	And provides the new lastname "Xylina" which is also valid
	Then the previous reference person is replaced with the new information