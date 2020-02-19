package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.services.ParkingLotOwner;
import com.bridgelabz.parkinglot.services.ParkingLotStatus;
import com.bridgelabz.parkinglot.services.ParkingSystem;
import com.bridgelabz.parkinglot.services.ParkingVehicle;

import java.util.Map;

public class ParkingLot {

    private ParkingSystem parkingSystem;
    private ParkingLotStatus parkingLotStatus;
    public static Integer totalSize, noOfLots;

    public ParkingLot(Integer totalSize, Integer noOfLots) {
        this.totalSize = totalSize;
        this.noOfLots = noOfLots;
        parkingSystem = new ParkingSystem(totalSize, noOfLots);
        parkingLotStatus = new ParkingLotStatus(parkingSystem.parkedCars);
    }

    public boolean getVehicleParked(ParkingVehicle parkedVehicle) {
        boolean parkingStatus = parkingSystem.getVehicleParked(parkedVehicle);
        parkingLotStatus.parkingLotStatus();
        return parkingStatus;
    }

    public boolean getVehicleUnparked(ParkingVehicle unparkVehicle) {
        this.getParkedTime(unparkVehicle);
        boolean unparkingStatus = parkingSystem.getVehicleUnparked(unparkVehicle);
        parkingLotStatus.parkingLotStatus();
        return unparkingStatus;
    }

    public Integer findVehicle(ParkingVehicle parkedVehicle) {
        return parkingSystem.isCarParked(parkedVehicle);
    }

    private void getParkedTime(ParkingVehicle unparkedVehicle) {
        String parkingTime = parkingSystem.getParkingTime(unparkedVehicle);
        new ParkingLotOwner().setVehicleParkingTime(parkingTime);
    }

    public Map<Integer, ParkingVehicle> findVehicleByAttribute(String... attribute) {
        return parkingSystem.findVehicle(attribute);
    }
}