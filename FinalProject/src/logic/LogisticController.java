package logic;

import java.util.ArrayList;

import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import users.LogisticCompanyV2;

public class LogisticController {
	private LogisticCompanyV2 logistic;
	private String companyName;
	private String email;
	private ValidInput validate;
	private int cc;
	private Long phonenumber;
	private ArrayList<String> firstName;
	private ArrayList<String> middleName= new ArrayList<String>();
	private ArrayList<String> lastName;
	private String street;
	private String city;
	private Integer building;
	private String zipcode;
	
	public LogisticController(){
		logistic = new LogisticCompanyV2();
		validate = new ValidInput();
	}


	public boolean setCompanyName(String text) {
		// TODO Auto-generated method stub
		this.companyName=text;
		return true;
	}


	public boolean setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
		return validate.validateEmail(email);
	}


	public boolean setCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		try {
			cc = Integer.valueOf(countryCode);
			System.out.println("string is correct");
			return validate.validateCountryCode(cc);
		}catch(NumberFormatException e) {
			System.out.println("the countrycode is not valid");
			return false;
		}
	}


	public boolean setPhoneNumber(String phone) {
			try {
				phonenumber = Long.valueOf(phone);
				System.out.println("string is correct");
				return validate.validatePhone(phonenumber);
				}catch(NumberFormatException e) {
					System.out.println("the countrycode is not valid");
					return false;
				}
	}


	public boolean setFirstName(String name1) {
		// TODO Auto-generated method stub
		
		firstName = parseInput.parsingNames(name1);
		return validate.validateName(name1);
	}


	public boolean setMiddleName(String name2) {
		// TODO Auto-generated method stub
		middleName = parseInput.parsingNames(name2);
		return validate.validateName(name2);
	}


	public boolean setLastName(String name) {
		// TODO Auto-generated method stub
		lastName = parseInput.parsingNames(name);
		return validate.validateName(name);
	}


	public boolean setStreetName(String street) {
		// TODO Auto-generated method stub
		this.street=street;
		return true;
	}


	public boolean setCity(String text) {
		// TODO Auto-generated method stub
		this.city = text;
		return validate.validateName(text);
	}


	public boolean setBuilding(String text) {
		// TODO Auto-generated method stub
		try {
			this.building = Integer.valueOf(text);
			System.out.println("Building number is correct");
			return true;
			}catch(NumberFormatException e) {
				System.out.println("the building number is not valid");
				return false;
			}
	}


	public boolean setPostcode(String postcode) {
		// TODO Auto-generated method stub
		this.zipcode= postcode;
		return validate.validatePostCode(postcode);
	}


	public boolean addClient() {
		// TODO Auto-generated method stub
		logistic.addClient(email, companyName, cc, phonenumber, firstName, middleName, lastName, street, city, zipcode, building);
		return logistic.getAddNewClient();
	}
}
