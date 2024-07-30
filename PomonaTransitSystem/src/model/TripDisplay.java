package model;

public class TripDisplay {
	private String scheduledStartTime;
	private String scheduledArrivalTime;
	private String driverId;
	private String busId;
	
	public TripDisplay(String scheduledStartTime, String scheduledArrivalTime,
			String driverId, String busId) {
		this.scheduledStartTime = scheduledStartTime;
		this.scheduledArrivalTime = scheduledArrivalTime;
		this.driverId = driverId;
		this.busId = busId;
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
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
}
