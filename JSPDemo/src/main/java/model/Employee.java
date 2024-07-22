package model;

public class Employee {
	private int eID;
	private String eName;
	private String eAddress;
	public int geteID() {
		return eID;
	}
	public void seteID(int eID) {
		this.eID = eID;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	
}
