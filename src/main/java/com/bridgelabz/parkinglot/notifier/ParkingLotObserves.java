package com.bridgelabz.parkinglot.notifier;

import com.bridgelabz.parkinglot.notifier.ParkingLotObservers;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotObserves {
    List<ParkingLotObservers> parkingLotObserver = new ArrayList<>();

    public void addObserver(ParkingLotObservers parkingLotObserver){
        this.parkingLotObserver.add(parkingLotObserver);
    }

    public void notifyObservers(boolean parkingLotStatus) {
        for (ParkingLotObservers parkingLotObservers : this.parkingLotObserver)
            parkingLotObservers.setParkingLotStatus(parkingLotStatus);
    }
}
