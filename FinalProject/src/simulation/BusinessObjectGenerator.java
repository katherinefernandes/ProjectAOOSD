package simulation;

import java.util.*;

import applications.ClientApplication;
import businessObjects.*;
import dataBase.DataBase;
import supportingClasses.Security;
import updateClientInformation.UpdateEmail;

public class BusinessObjectGenerator {
	private static RandomGenerator randomGenerator;
	
	private BusinessObjectGenerator(){};
	
	static void generateNewClient() {
		List<List<String>> refrencePersonName = randomGenerator.generateRandomRefrenceName();
		
		Client client = new Client(Security.generateIDFromSecureRandom(), 
							   	   randomGenerator.generateCompanyName(), randomGenerator.generateCountryCode(), 
								   randomGenerator.generatePhoneNumber(), randomGenerator.generateRandomEmail(),
								   refrencePersonName.get(0), refrencePersonName.get(1), refrencePersonName.get(2),
								   randomGenerator.generateStreetName(), randomGenerator.generateCity(),
								   randomGenerator.generateHouseNumber(), randomGenerator.generateZipCode());
		
		client.save();
		randomGenerator.addClientToSelection(client);
	}
	
	static void generateNewJourney() {
		Client client = randomGenerator.getRandomClient();
		Port startPort = randomGenerator.getRandomPort();
		Port destinationPort = randomGenerator.getRandomPort();
		float startTemperature = randomGenerator.generateTemperature();
		float startHumidity = randomGenerator.generateHumidity();
		float startAtmosphere = randomGenerator.generateAtmosphere();
		
	}
	
}
