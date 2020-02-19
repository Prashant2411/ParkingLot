package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.ParkingLot;

import java.util.Map;

public class ParkingLotStatus {

    Map<Integer, Object> parkedCars;
    ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    AirportSecuritySystem airportSecuritySystem = new AirportSecuritySystem();
    ParkingLotStatusNotifier parkingLotObserver = new ParkingLotStatusNotifier();

    public ParkingLotStatus(Map parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void parkingLotStatus() {
        parkingLotObserver.addObserver(airportSecuritySystem);
        parkingLotObserver.addObserver(parkingLotOwner);
        if (this.parkedCars.size() == ParkingLot.totalSize) {
            parkingLotObserver.notifyObservers(true);
        }
        if (airportSecuritySystem.isParkingLotFull == true && this.parkedCars.size() < ParkingLot.totalSize)
            parkingLotObserver.notifyObservers(false);
    }
}