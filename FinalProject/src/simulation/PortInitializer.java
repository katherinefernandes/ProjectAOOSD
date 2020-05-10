package simulation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import objects.Port;

/**
 * This class generates ports from the json containing port data
 * @author simon
 *
 */
class PortInitializer {
	private Random random;
	private static PortInitializer instance;
	
	private PortInitializer() {
		random = new Random();
	}
	
	public static PortInitializer getInstance() {
		if(instance == null) {
			instance = new PortInitializer();
		}
		return instance;
	}
	
	public void generatePorts() {
		JSONObject portsJSON;
		FileReader fileReader;
		try {
			fileReader = new FileReader("storage/simulation/ports.json");
			portsJSON = (JSONObject) new JSONParser().parse(fileReader);
		} catch (IOException | ParseException e) {
			throw new Error(e);
		}
		Object[] keys = portsJSON.keySet().toArray();
		
		for(int i = 0; i < 15; i++) {
			try {
				Map portValues = (Map) portsJSON.get(keys[random.nextInt(keys.length)]);
				String country = (String) portValues.get("country");
				String name = (String) portValues.get("name");
				long ID = Math.abs(name.hashCode() * country.hashCode());
				JSONArray coordinates = (JSONArray) portValues.get("coordinates");
				
				float longitude;
				float latitude;
				if(coordinates.get(1).getClass() == Double.class) {
					latitude = (float) ((double) coordinates.get(1));
				}else {
					latitude = (float) ((long) coordinates.get(1));
				}
				if(coordinates.get(0).getClass() == Double.class) {
					longitude = (float) ((double) coordinates.get(0));
				}else {
					longitude = (float) ((long) coordinates.get(0));
				}
				
				Port port = new Port(ID, country, name,latitude,longitude);
				port.save();
			}catch(NullPointerException e) {
				//Skip port if fields are missing from json.
			}
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			throw new Error(e);
		}
		
	}
}
