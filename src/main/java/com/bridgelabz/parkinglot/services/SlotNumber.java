package com.bridgelabz.parkinglot.services;

import java.util.Map;

public class SlotNumber {

    private Map<Integer, VehicleParkingDetails> parkedCars;
    public Integer noOfLots, lotStartPoint = 0, totalSize;
    private int count = 0, i = 1;

    public SlotNumber(Map<Integer, VehicleParkingDetails> parkedCars, Integer noOfLots, Integer totalSize) {
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
        this.parkedCars = parkedCars;
    }

    public Integer getNonHandicapSlotNumber() {
        int n = 0;
        this.getCounterReinitialized();
        count++;
        if (!(parkedCars.containsKey((i + lotStartPoint) % this.totalSize))) {
            n = checkPreviousSlots();
            if (n == 0)
                n = i + lotStartPoint % this.totalSize;
        }
        lotStartPoint += this.totalSize / noOfLots;
        if (n == 0)
            n = getNonHandicapSlotNumber();
        return n;
    }

    private void getCounterReinitialized() {
        if (count == noOfLots) {
            count = 0;
            i++;
        }
    }

    private int checkPreviousSlots() {
        for (int j = 1; j < i; j++)
            if (!(parkedCars.containsKey((j + lotStartPoint) % this.totalSize)))
                return (j + lotStartPoint % this.totalSize);
        return 0;
    }

    public Integer getHandicapSlotNumber() {
        int n = 0;
        for (int k = 1; k <= totalSize; k++) {
            if (!(parkedCars.containsKey(k))) {
                n = k;
                break;
            }
        }
        count++;
        return n;
    }

    public Integer getLargeVehicleSlotNumber() {
        int n = 0;
        this.getCounterReinitialized();
        count++;
        if (!(parkedCars.containsKey((i + lotStartPoint) % this.totalSize))
                && !(parkedCars.containsKey(((i + lotStartPoint) % this.totalSize) + 1))) {
            n = checkPreviousSlots();
            if (n == 0)
                n = i + lotStartPoint % this.totalSize;
        }
        lotStartPoint += this.totalSize / noOfLots;
        if (n == 0)
            n = getNonHandicapSlotNumber();
        return n;
    }
}