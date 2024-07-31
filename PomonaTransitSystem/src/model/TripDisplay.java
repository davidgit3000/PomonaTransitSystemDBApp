package model;

public class TripDisplay {
	private int tripNumber;
	private String date;
	private String scheduledStartTime;
	private String scheduledArrivalTime;
	private String driverName;
	private String busId;
	
	public TripDisplay(String scheduledStartTime, String scheduledArrivalTime,
			String driverName, String busId) {
		this.scheduledStartTime = scheduledStartTime;
		this.scheduledArrivalTime = scheduledArrivalTime;
		this.driverName = driverName;
		this.busId = busId;
	}
	
	public TripDisplay(int tripNumber, String date, String scheduledStartTime, String scheduledArrivalTime,
			String driverName, String busId) {
		this.tripNumber = tripNumber;
		this.date = date;
		this.scheduledStartTime = scheduledStartTime;
		this.scheduledArrivalTime = scheduledArrivalTime;
		this.driverName = driverName;
		this.busId = busId;
	}
	
	public int getTripNumber() {
		return tripNumber;
	}

	public void setTripNumber(int tripNumber) {
		this.tripNumber = tripNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScheduledStartTime() {
		return scheduledStartTime;
	}
	public void setScheduledStartTime(String scheduledStartTime) {
		this.scheduledStartTime = scheduledStartTime;
	}
	public String getScheduledArrivalTime() {
		return scheduledArrivalTime;
	}
	public void setScheduledArrivalTime(String schduledArrivalTime) {
		this.scheduledArrivalTime = schduledArrivalTime;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
}
