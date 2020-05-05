package dataWrappers;

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
	public void setAtmosphere(float p) {
		this.Atmosphere=p;
	}
	public void setTemperature(float t) {
		this.Temperature=t;
	}
	public void setHumidity(float h) {
		this.Humidity=h;
	}
	
}
