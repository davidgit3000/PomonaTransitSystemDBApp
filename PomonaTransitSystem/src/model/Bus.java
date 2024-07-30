package model;

public class Bus {
	private String busId;
	private String model;
	private String year;
	
	public Bus(String id, String model, String year) {
		this.busId = id;
		this.model = model;
		this.year = year;
	}
	
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
