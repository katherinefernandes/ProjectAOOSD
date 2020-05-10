package simulation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.*;

import dataBase.DataBase;
import exceptions.ElementSelectionException;
import objects.*;

/**
 * This class does the work of generating random values. 
 * It implements the singleton pattern, to avoid problems with files containing words and names
 * @author simon
 *
 */
class RandomGenerator {
	private Random random;
	private RandomAccessFile firstNames;
	private RandomAccessFile lastNames;
	private RandomAccessFile words;
	private static int bytesInFirstNames = 35000;
	private static int bytesInLastNames = 91000;
	private static int bytesInWords = 49000;
	//more efficient to pull a selection of business objects at construction than every time a method is used
	private List<Long> randomClientSelection;
	private List<Long> randomContainerSelection;
	private List<Long> randomPortSelection;
	private static RandomGenerator instance;
	
	private RandomGenerator() {
		try {
			firstNames = new RandomAccessFile("storage/simulation/firstNames.txt","r");
			lastNames = new RandomAccessFile("storage/simulation/lastNames.txt","r");
			words = new RandomAccessFile("storage/simulation/words.txt","r");
		}catch(FileNotFoundException e){
			throw new Error(e);
		}
		random = new Random();
		
		pullRandomClients();
		pullRandomContainers();
		pullRandomPorts();
	}
	
	public static RandomGenerator getInstance() {
		if(instance == null) {
			instance = new RandomGenerator();
		}
		instance.pullRandomClients();
		instance.pullRandomContainers();
		instance.pullRandomPorts();
		return instance;
	}

	public String getRandomFirstName() {
		try {
			return getRandomLine(firstNames,bytesInFirstNames);
		} catch (IOException e) {
			throw new Error(e);
		}
	}

	public String getRandomLastName() {
		try {
			return getRandomLine(lastNames,bytesInLastNames);
		} catch (IOException e) {
			throw new Error(e);
		}
	}
	
	public String getRandomWord() {
		try {
			return getRandomLine(words,bytesInWords);
		} catch (IOException e) {
			throw new Error(e);
		}
	}
	
	public List<List<String>> generateRefrenceName() {
		List<List<String>> refrenceName = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			refrenceName.add(new ArrayList<String>());
		}
		int numberOfFirstNames = random.nextInt(2) + 1;
		int numberOfMiddleNames = random.nextInt(3);
		int numberOfLastNames = 1;
		
		for(int i = 0; i < numberOfFirstNames; i++) {
			refrenceName.get(0).add(getRandomFirstName());
		}
		for(int i = 0; i < numberOfMiddleNames; i++) {
			refrenceName.get(1).add(getRandomFirstName());
		}
		for(int i = 0; i < numberOfLastNames; i++) {
			refrenceName.get(2).add(getRandomLastName());
		}
		return refrenceName;
	}
	
	public String generateEmail() {
		String[] domains = {"gmail","hotmail","yahoo","outlook","student.dtu"};
		String[] tld = {"no","dk","jp","com","org","net","co.uk"};
		String email = getRandomFirstName();
		if(random.nextBoolean()) {
			email += "." + getRandomFirstName();
		}
		email += "@" + domains[random.nextInt(domains.length)];
		email += "." + tld[random.nextInt(tld.length)];
		return email;
	}
	
	public String generateCompanyName() {
		String[] companyTypes = {"Inc.", "Ltd.","LLC","Corp.","A/S","& Co"};
		String companyName = getRandomLastName() + "'s ";
		companyName += getRandomWord() + " ";
		companyName += companyTypes[random.nextInt(companyTypes.length)];
		return companyName;
	}
	
	public int generateCountryCode() {
		return random.nextInt(100);
	}
	
	public long generatePhoneNumber() {
		return (long) (1000000. + 998999999. * random.nextDouble());
	}
	
	public String generateStreetName() {
		String[] streetTypes = {"gade","street","vej","main","road","avenue","bypass","row","way","boulevard"};
		String streetName = "";
		if(random.nextBoolean()) {
			streetName += getRandomLastName();
		}else {
			streetName += getRandomWord();
		}
		streetName += "-" + streetTypes[random.nextInt(streetTypes.length)];
		return streetName;
	}
	
	public int generateHouseNumber() {
		return random.nextInt(300);
	}
	
	public String generateCity() {
		String[] cityTypes = {" town","ville","topia"," village"," city", "dale", "by", " borough"};
		String city = "";
		if(random.nextDouble() < 0.25){
			city += "New ";
		}
		if(random.nextBoolean()) {
			city += getRandomLastName();
		}else {
			city += getRandomWord();
		}
		city += cityTypes[random.nextInt(cityTypes.length)];
		return city;
	}
	
	public String generateZipCode() {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
		char[] numbers = "1234567890".toCharArray();
		String zipCode = "";
		int zipLength = 3 + random.nextInt(4);
		for(int i = 0; i < zipLength; i++) {
			if(random.nextDouble() < 0.33) {
				zipCode += alphabet[random.nextInt(alphabet.length)];
			}else {
				zipCode += numbers[random.nextInt(numbers.length)];
			}
		}
		return zipCode;
	}
	
	public float generateTemperature() {
		return random.nextFloat()*100F - 5F;
	}
	public float generateHumidity() {
		return random.nextFloat()*100F;
	}
	public float generateAtmosphere() {
		return random.nextFloat()*1F - 5F;
	}
	
	public String generateCargo() {
		String cargo = "";
		cargo += getRandomWord();
		if(random.nextBoolean()) {
			cargo += " and " + getRandomWord();
		}
		return cargo;
	}
	
	public String generateArriveBy() {
		LocalDate now = LocalDate.now();
		LocalDate arriveBy = now.plusDays(14 + random.nextInt(18)).plusMonths(random.nextInt(4));
		return arriveBy.toString();
	}
	
	public Client getRandomClient() {
		if(randomClientSelection.size() < 5 || random.nextDouble() < 0.075) {
			pullRandomClients();
		}
		long ID = randomClientSelection.get(random.nextInt(randomClientSelection.size()));
		try {
			return DataBase.getClient(ID);
		} catch (ElementSelectionException e) {
			throw new Error("Simulation contains client that's not in database", e);
		}
	}
	
	public Container getRandomContainer() {
		if(randomContainerSelection.size() < 5 || random.nextDouble() < 0.075) {
			pullRandomContainers();
		}
		long ID = randomContainerSelection.get(random.nextInt(randomContainerSelection.size()));
		try {
			return DataBase.getContainer(ID);
		} catch (ElementSelectionException e) {
			throw new Error("Simulation contains container that's not in database", e);
		}
	}
	
	public Port getRandomPort() {
		if(randomPortSelection.size() < 5 || random.nextDouble() < 0.075) {
			pullRandomPorts();
		}
		long ID = randomPortSelection.get(random.nextInt(randomPortSelection.size()));
		try {
			return DataBase.getPort(ID);
		} catch (ElementSelectionException e) {
			throw new Error("Simulation contains port that's not in database", e);
		}
	}
	
	public float changeTemperature(float temperature) {
		float newTemperature = temperature + (random.nextFloat() - 0.5F);
		newTemperature = Math.min(90F, newTemperature);
		return Math.max(-10F, newTemperature);
	}
	public float changeHumidity(float humidity) {
		float newHumidity = humidity + (random.nextFloat() - 0.5F);
		newHumidity = Math.min(100F, newHumidity);
		return Math.max(0F, newHumidity);
	}
	public float changeAtmosphere(float atmosphere) {
		float newAtmosphere = atmosphere + (random.nextFloat()*0.1F - 0.05F);
		newAtmosphere = Math.min(3F, newAtmosphere);
		return Math.max(0.5F, newAtmosphere);
	}
	
	public void addClientToSelection(Client client) {
		randomClientSelection.add(client.getID());
	}
	
	public void addPortToSelection(Port port) {
		randomPortSelection.add(port.getID());
	}
	
	public void addContainerToSelection(Container container) {
		randomContainerSelection.add(container.getID());
	}
	
	private String getRandomLine(RandomAccessFile file, int bytesInFile) throws IOException {
		int randomPosition = random.nextInt(bytesInFile);
		file.seek(randomPosition);
		file.readLine();
		return file.readLine();
	}
	
	private void pullRandomPorts() {
		randomPortSelection = new ArrayList<>();
		List<Port> allPorts = DataBase.searchPorts("");
		
		int transfered = 0;
		while(transfered < 100 && !allPorts.isEmpty()) {
			Port port = allPorts.remove(random.nextInt(allPorts.size()));
			addPortToSelection(port);
		}
	}
	private void pullRandomContainers() {
		randomContainerSelection = new ArrayList<>();
		List<Container> allContainers = DataBase.searchContainers("");
		
		int transfered = 0;
		while(transfered < 100 && !allContainers.isEmpty()) {
			Container container = allContainers.remove(random.nextInt(allContainers.size()));
			addContainerToSelection(container);
		}
	}

	private void pullRandomClients() {
		randomClientSelection = new ArrayList<>();
		List<Client> allClients = DataBase.searchClients("");
		
		int transfered = 0;
		while(transfered < 100 && !allClients.isEmpty()) {
			Client client = allClients.remove(random.nextInt(allClients.size()));
			addClientToSelection(client);
		}
	}
}
