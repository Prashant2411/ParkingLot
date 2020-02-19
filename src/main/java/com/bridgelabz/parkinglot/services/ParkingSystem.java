package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.exception.ParkingLotException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingSystem {

    public Map<Integer, ParkingVehicle> parkedCars = new HashMap<>();
    public Integer noOfLots, totalSize;
    SlotNumber slotNumber;
    int q = 0;

    public ParkingSystem(Integer totalSize, Integer noOfLots) {
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
        slotNumber = new SlotNumber(parkedCars, this.noOfLots, this.totalSize);
    }

    public boolean getVehicleParked(ParkingVehicle parkedCar) {
        if (this.parkedCars.size() < this.totalSize && this.parkedCars.containsValue(parkedCar) == false) {
            this.parkedCars.put(slotNumber.getSlotNumber(parkedCar.isHandicap), parkedCar);
        } else if (this.parkedCars.containsValue(parkedCar) == true)
            throw new ParkingLotException("Vehicle Already Parked", ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED);
        return true;
    }

    public boolean getVehicleUnparked(ParkingVehicle unparkVehicle) {
        Integer isCarParked = isCarParked(unparkVehicle);
        if (isCarParked != null) {
            parkedCars.remove(isCarParked);
            return true;
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }

    public Integer isCarParked(ParkingVehicle unparkVehicle) {
        for (Map.Entry<Integer, ParkingVehicle> entry : parkedCars.entrySet())
            if (unparkVehicle.equals(entry.getValue()))
                return entry.getKey();
        return null;
    }

    public String getParkingTime(ParkingVehicle parkedVehicle) {
        Integer carSlotNumber = isCarParked(parkedVehicle);
        if (carSlotNumber != null) {
            return parkedCars.get(carSlotNumber)
                    .getLocalDateTime();
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }

    public Map<Integer, ParkingVehicle> findVehicle(String... attribute) {
        Map<Integer, ParkingVehicle> foundResult = parkedCars.entrySet()
                .stream()
                .filter(values -> {
                    for (String attribute1 : attribute) {
                        if (parkedCars.get(values.getKey()).toString().contains(attribute1) == false)
                            return false;
                    }
                    return true;
                })
                .collect(Collectors.toMap(values -> values.getKey(), values -> values.getValue()));
        return foundResult;
    }

    private int getCounter() {
        return q++;
    }
}