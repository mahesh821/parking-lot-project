package com.parking;

public class ParkingSpot {
	private ParkingSpotType type;
	private Vehicle vehicle;
	private boolean free;
	
	
	public ParkingSpot(ParkingSpotType type) {
		super();
		this.type = type;
	}


	public ParkingSpotType getType() {
		return type;
	}


	public void setType(ParkingSpotType type) {
		this.type = type;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public boolean isFree() {
		return free;
	}


	public void setFree(boolean free) {
		this.free = free;
	}
	
	
	
	
}
