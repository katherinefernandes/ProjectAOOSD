package dataWrappers;

/**
 * This class contains position data as well as methods for calculating distances and directions
 * @author simon
 *
 */
public class Location {
	private float latitude;
	private float longitude;
	public Location(float latitude, float longitude) {
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLatitude(float latitude) {
		this.latitude=latitude;
	}
	public void setLongitude(float longitude) {
		this.longitude=longitude;
	}
	
	/**
	 * This method returns the distance in kilometer per latitude degree
	 * @return the distance
	 */
	public float distancePerLatitudeDegreeKM() {
		return 111F;
	}
	
	/**
	 * This method returns the distance in kilometer per longitude degree
	 * @return the distance
	 */
	public float distancePerLongitudeDegreeKM() {
		return (float) (Math.cos(Math.toRadians(getLatitude()))*111F);
	}
	
	/**
	 * This method return an approximate direction vector towards a point.
	 * It calculates the vector so that if you were to move the given number of degrees in each 
	 * direction you would move a distance of 1 kilometre
	 * @param destination
	 * @return a direction vector
	 */
	public float[] directionVectorTowardsDestination(Location destination) {
		float[] vector = {0,0};
		double distanceInDegrees = distanceToPointInDegrees(destination);
		vector[0] = (float) ((destination.getLongitude() - getLongitude()) / distanceInDegrees);
		vector[1] = (float) ((destination.getLatitude() - getLatitude()) / distanceInDegrees);
		return vector;
	}
	
	/**
	 * This methods returns an approximate distance to another location
	 * @param destination - the other location
	 * @return the distance in kilometres
	 */
	public float distanceTo(Location position) {
		return (float) (Math.toRadians(distanceToPointInDegrees(position))*6378F);
	}
	
	private double distanceToPointInDegrees(Location destination) {
		double angle1 = Math.toRadians(90. - getLatitude());
		double angle2 = Math.toRadians(90. - destination.getLatitude());
		double angle3 = Math.toRadians(Math.abs(getLongitude() - destination.getLongitude()));
		double radians = Math.acos(Math.cos(angle1)*Math.cos(angle2) 
			 	  		 + Math.sin(angle1)*Math.sin(angle2)*Math.cos(angle3));
		double distanceInDegrees = Math.toDegrees(radians);
		return distanceInDegrees;
	}
}
