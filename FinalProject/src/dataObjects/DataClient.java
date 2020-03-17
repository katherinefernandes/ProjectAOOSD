package dataObjects;

public class DataClient {
	private int ClientId;
	private String name;
	private String phone;
	private String email;
	private String referenceName;
	
	public DataClient(int cl, String name, String phone, String email, String refname) {
		this.ClientId=cl;
		this.name=name;
		this.phone=phone;
		this.email=email;
		this.referenceName=refname;
	}
	public int getClientId() {
		return ClientId;
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getRefName() {
		return referenceName;
	}
}
