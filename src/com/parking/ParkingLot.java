package com.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	List<CompactSpot> compactSpotList = new ArrayList<CompactSpot>();
	List<LargeSpot> largeSpotList = new ArrayList<LargeSpot>();
	List<BikeSpot> bikeSpotList = new ArrayList<BikeSpot>();
	
	
	int freeCompactSpots;
	int freeLargesSpots;
	int freeBikesports;
	
	public ParkingLot(int freeCompactSpots, int freeLargesSpots, int freeBikesports) {
		super();
		this.freeCompactSpots = freeCompactSpots;
		this.freeLargesSpots = freeLargesSpots;
		this.freeBikesports = freeBikesports;
	}
	
	public void parkVehicle(Vehicle vehicle) {
		
		System.out.println("We are about to park your Vehicle for Type: "+ vehicle.getVehicleType());
	
		if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
			if(freeLargesSpots > 0) {
				parkYourLargeVehicle(vehicle);
			}
			else {
				System.out.println("Sorry..! All Large Spots are Full");
			}
		}
		else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
			if(freeCompactSpots > 0) {
				parkYourCompactVehicle(vehicle);
			}
			else if(freeLargesSpots > 0){
				parkYourLargeVehicle(vehicle);
			}
			else {
				System.out.println("Sorry..! All Large and Compact Spots are Full");
			}
			
		}
		else if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
			if(freeBikesports > 0) {
				parkYourBikeVehicle(vehicle);
			}
			if(freeCompactSpots > 0) {
				parkYourCompactVehicle(vehicle);
			}
			else if(freeLargesSpots > 0){
				parkYourLargeVehicle(vehicle);
			}
			else {
				System.out.println("Sorry..! All Large, Compact and Bike Spots are Full");
			}
		}
	}
	
	private void parkYourLargeVehicle(Vehicle vehicle) {
		LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
		largeSpot.setFree(false);
		largeSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(largeSpot);
		
		largeSpotList.add(largeSpot);
		freeLargesSpots--;
		
		System.out.println("We are successfully parked your vehicle...! :)");
	}
	
	private void parkYourCompactVehicle(Vehicle vehicle) {
		CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
		compactSpot.setFree(false);
		compactSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(compactSpot);
		
		compactSpotList.add(compactSpot);
		freeCompactSpots--;
		
		System.out.println("We are successfully parked your vehicle...! :)");
	}
	
	private void parkYourBikeVehicle(Vehicle vehicle) {
		BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
		bikeSpot.setFree(false);
		bikeSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(bikeSpot);
		
		bikeSpotList.add(bikeSpot);
		freeBikesports--;
		
		System.out.println("We are successfully parked your vehicle...! :)");
	}
	
	// Unpacking
	public void unParkVehicle(Vehicle vehicle) {
		System.out.println("We are about to Unpark your Vehicle of Type: "+ vehicle.getVehicleType());
		
		ParkingSpot parkingSpot = vehicle.getParkingSpot();
		//parkingSpot.setFree(true);
		
		if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
			if(largeSpotList.remove(parkingSpot)) {
				System.out.println("We have successfully removed your Vehicle");
				freeLargesSpots++;
			} 
			else {
				System.out.println("You dont have your vehicle parked at this parkinglot");
			}
		}
		
		if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
			if(compactSpotList.remove(parkingSpot)) {
				System.out.println("We have successfully removed your Vehicle");
				freeCompactSpots++;
			} 
			else {
				System.out.println("You dont have your vehicle parked at this parkinglot");
			}
		}
		
		if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
			if(bikeSpotList.remove(parkingSpot)) {
				System.out.println("We have successfully removed your Vehicle");
				freeBikesports++;
			} 
			else {
				System.out.println("You dont have your vehicle parked at this parkinglot");
			}
		}
	}
	
	
	
}
