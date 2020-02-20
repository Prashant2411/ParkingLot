package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.exception.ParkingLotException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingSystem {

    public Map<Integer, ParkingVehicle> parkedCars = new HashMap<>();
    private Integer noOfLots, totalSize;

    public ParkingSystem(Integer totalSize, Integer noOfLots) {
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
    }

    public boolean getVehicleParked(ParkingVehicle parkedCar) {
        SlotNumber slotNumber = new SlotNumber(parkedCars, noOfLots, totalSize);
        if (!(this.parkedCars.size() < this.totalSize && this.parkedCars.containsValue(parkedCar))) {
            this.parkedCars.put(parkedCar.driverType.getSlotNumber(slotNumber), parkedCar);
        } else if (this.parkedCars.containsValue(parkedCar))
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

    public LocalDateTime getParkingTime(ParkingVehicle parkedVehicle) {
        Integer carSlotNumber = isCarParked(parkedVehicle);
        if (carSlotNumber != null) {
            return parkedCars.get(carSlotNumber)
                    .getLocalDateTime();
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }

    public Map<Integer, ParkingVehicle> findByAttribute(String... attribute) {
        return parkedCars.entrySet()
                .stream()
                .filter(values -> getFilter(values, attribute))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean getFilter(Map.Entry<Integer, ParkingVehicle> values, String... attribute) {
        for (String attribute1 : attribute) {
            if (!(parkedCars.get(values.getKey()).toString().toLowerCase().contains(attribute1.toLowerCase())))
                return false;
        }
        return true;
    }

    public Map<Integer, ParkingVehicle> findByTime(int timeInMinute) {
        return parkedCars.entrySet()
                .stream()
                .filter(values -> LocalDateTime.now().minusMinutes(timeInMinute).compareTo(parkedCars.get(values.getKey()).localDateTime) < 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}