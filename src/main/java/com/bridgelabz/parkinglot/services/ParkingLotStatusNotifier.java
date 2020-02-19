package com.bridgelabz.parkinglot.services;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotStatusNotifier {
    List<ParkingLotObservers> parkingLotObserver = new ArrayList<>();

    public void addObserver(ParkingLotObservers parkingLotObserver) {
        this.parkingLotObserver.add(parkingLotObserver);
    }

    public void notifyObservers(boolean parkingLotStatus) {
        for (ParkingLotObservers parkingLotObservers : this.parkingLotObserver)
            parkingLotObservers.setParkingLotStatus(parkingLotStatus);
    }
}
