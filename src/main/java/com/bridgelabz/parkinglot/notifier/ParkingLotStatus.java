package com.bridgelabz.parkinglot.notifier;

import com.bridgelabz.parkinglot.notifier.AirportSecuritySystem;
import com.bridgelabz.parkinglot.notifier.ParkingLotOwner;
import com.bridgelabz.parkinglot.services.ParkingLot;

import java.util.Map;

public class ParkingLotStatus {

    Map<Integer, Object> parkedCars;
    ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    AirportSecuritySystem airportSecuritySystem = new AirportSecuritySystem();
    ParkingLotObserves parkingLotObserver = new ParkingLotObserves();

    public ParkingLotStatus(Map parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void parkingLotStatus() {
        parkingLotObserver.addObserver(airportSecuritySystem);
        parkingLotObserver.addObserver(parkingLotOwner);
        if (this.parkedCars.size() == ParkingLot.totalSize) {
            parkingLotObserver.notifyObservers(true);
        }
        if (airportSecuritySystem.isParkingLotFull == true) {
            if (this.parkedCars.size() < ParkingLot.totalSize) {
                parkingLotObserver.notifyObservers(false);
            }
        }
    }
}