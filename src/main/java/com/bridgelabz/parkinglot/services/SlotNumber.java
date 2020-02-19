package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.DriverType;

import java.util.Map;

public class SlotNumber {

    private Map<Integer, ParkingVehicle> parkedCars;
    private Integer noOfLots, lotStartPoint = 0, totalSize;
    private int count = 0, i = 1;

    public SlotNumber(Map<Integer, ParkingVehicle> parkedCars, Integer noOfLots, Integer totalSize) {
        this.parkedCars = parkedCars;
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
    }

    public Integer getSlotNumber(DriverType driverType) {
        if (driverType == DriverType.HANDICAP_DRIVER)
            return getHandicapSlotNumber();
        return getNonHandicapSlotNumber();
    }

    private Integer getNonHandicapSlotNumber() {
        int n = 0;
        if (count == noOfLots) {
            count = 0;
            i++;
        }
        if (parkedCars.containsKey((i + lotStartPoint) % this.totalSize) == false)
            n = i + lotStartPoint % this.totalSize;
        else if (parkedCars.containsKey((i + lotStartPoint) % this.totalSize) == true) {
            lotStartPoint += this.totalSize / noOfLots;
            n = getNonHandicapSlotNumber();
        }
        lotStartPoint += this.totalSize / noOfLots;
        count++;
        return n;
    }

    private Integer getHandicapSlotNumber() {
        int n = 0;
        for (int i = 1; i <= totalSize; i++) {
            if (parkedCars.containsKey(i) == false) {
                n = i;
                break;
            }
        }
        count++;
        return n;
    }
}