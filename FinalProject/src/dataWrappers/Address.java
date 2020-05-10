package dataWrappers;
/**
 * Used to contain information about the address for a user
 * @author Mamuna
 *
 */
public class Address {
  private String streetName;
  private int houseNumber;
  private String city;
  private String zipCode;
  
  public Address(String streetname, int house, String city, String zip) {
	  this.streetName=streetname;
	  this.houseNumber=house;
	  this.city=city;
	  this.zipCode=zip;
	  
  }
   public String getStreetName() {
	  return streetName;
  }
   public String getCity() {
	  return city;
  }
   public int getHouseNumber() {
	  return houseNumber;
  }
   public String getZipCode() {
	  return zipCode;
  }
}
