package dataWrappers;

import java.util.*;

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
	
	
	public Location moveTowardsPointByDistanceInKM(Location destination, float distance) {
		float[] direction = directionVectorTowardsDestination(destination);
		float newLongitude = longitude + direction[0]*distance/distancePerLongitudeDegreeKM();
		float newLatitude = latitude + direction[1]*distance/distancePerLatitudeDegreeKM();
		return new Location(newLongitude, newLatitude);
	}
	public float distanceTo(Location position) {
		return (float) (distanceToPointInDegrees(position)*6378F);
	}
	
	private float distancePerLatitudeDegreeKM() {
		return 111F;
	}
	private float distancePerLongitudeDegreeKM() {
		return (float) (Math.cos(latitude)*111F);
	}
	private float[] directionVectorTowardsDestination(Location destination) {
		float[] vector = {0,0};
		double distanceInDegrees = distanceToPointInDegrees(destination);
		vector[0] = (float) ((destination.getLongitude() - longitude) / distanceInDegrees);
		vector[1] = (float) ((destination.getLatitude() - latitude) / distanceInDegrees);
		return vector;
	}
	
	private double distanceToPointInDegrees(Location destination) {
		double angle1 = Math.toRadians(90. - latitude);
		double angle2 = Math.toRadians(90. - destination.getLatitude());
		double angle3 = Math.toRadians(Math.abs(longitude - destination.getLongitude()));
		double distanceInDegrees = Math.toDegrees(Math.acos(Math.cos(angle1)*Math.cos(angle2) 
											 	  + Math.sin(angle1)*Math.asin(angle2)*Math.cos(angle3)));
		return distanceInDegrees;
	}
}
