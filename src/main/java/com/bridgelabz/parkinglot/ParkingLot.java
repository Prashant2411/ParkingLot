package com.bridgelabz.parkinglot;

import com.bridgelabz.parkinglot.services.ParkingLotOwner;
import com.bridgelabz.parkinglot.services.ParkingLotStatus;
import com.bridgelabz.parkinglot.services.ParkingSystem;
import com.bridgelabz.parkinglot.services.VehicleParkingDetails;

import java.time.LocalDateTime;
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

    public boolean getVehicleParked(VehicleParkingDetails parkedVehicle) {
        boolean parkingStatus = parkingSystem.getVehicleParked(parkedVehicle);
        parkingLotStatus.parkingLotStatus();
        return parkingStatus;
    }

    public boolean getVehicleUnparked(VehicleParkingDetails unparkVehicle) {
        this.getParkedTime(unparkVehicle);
        boolean unparkingStatus = parkingSystem.getVehicleUnparked(unparkVehicle);
        parkingLotStatus.parkingLotStatus();
        return unparkingStatus;
    }

    public Integer findVehicle(VehicleParkingDetails parkedVehicle) {
        return parkingSystem.isCarParked(parkedVehicle);
    }

    private void getParkedTime(VehicleParkingDetails unparkedVehicle) {
        LocalDateTime parkingTime = parkingSystem.getParkingTime(unparkedVehicle);
        new ParkingLotOwner().setVehicleParkingTime(parkingTime);
    }

    public Map<Integer, VehicleParkingDetails> findVehicleByAttribute(String... attribute) {
        return parkingSystem.findByAttribute(attribute);
    }

    public Map<Integer, VehicleParkingDetails> findVehicleByTime(int timeInMinutes) {
        return parkingSystem.findByTime(timeInMinutes);
    }

    public Map<Integer, VehicleParkingDetails> findVehiclesOfLot(String attribute, Integer... lotNumber) {
        return parkingSystem.findVehiclesOfLot(attribute, lotNumber);
    }
}