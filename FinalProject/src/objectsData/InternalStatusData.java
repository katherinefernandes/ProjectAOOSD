package objectsData;

public class InternalStatusData {
	private int pressure;
	private int temperature;
	private int humidity;
	public InternalStatusData(int p, int t, int h) {
		this.pressure=p;
		this.humidity=h;
		this.temperature=t;
	}
	public int getPressure() {
		return pressure;
	}
	public int getTemperature() {
		return temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setPressure(int p) {
		this.pressure=p;
	}
	public void setTemperature(int t) {
		this.temperature=t;
	}
	public void setHumidity(int h) {
		this.humidity=h;
	}
	
}
