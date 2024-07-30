package model;

public class Driver {
	private String driverName;
	private String driverPhoneNumber;
	
	public Driver(String name, String phoneNumber) {
		driverName = name;
		driverPhoneNumber = phoneNumber;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}
	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}
}
