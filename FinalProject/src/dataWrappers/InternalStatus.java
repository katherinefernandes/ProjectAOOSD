package dataWrappers;
/**
 * Used to contain the information about the internal environment
 * @author Mamuna
 *
 */
public class InternalStatus  {
	private float Atmosphere;
	private float Temperature;
	private float Humidity;
	public InternalStatus(float a, float t, float h) {
		this.Atmosphere=a;
		this.Humidity=h;
		this.Temperature=t;
	}
	public float getAtmosphere() {
		return Atmosphere;
	}
	public float getTemperature() {
		return Temperature;
	}
	public float getHumidity() {
		return Humidity;
	}
	public void setAtmosphere(float atmosphere) {
		this.Atmosphere=atmosphere;
	}
	public void setTemperature(float temperature) {
		this.Temperature=temperature;
	}
	public void setHumidity(float humidity) {
		this.Humidity=humidity;
	}
	
}
