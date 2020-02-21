package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.SearchKeywords;
import com.bridgelabz.parkinglot.exception.ParkingLotException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingSystem {

    public Map<Integer, VehicleParkingDetails> parkedCars = new HashMap<>();
    private Integer noOfLots, totalSize;

    public ParkingSystem(Integer totalSize, Integer noOfLots) {
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
    }

    public boolean parkVehicle(VehicleParkingDetails parkedCar) {
        SlotNumber slotNumber = new SlotNumber(parkedCars, noOfLots, totalSize);
        if (!(this.parkedCars.size() < this.totalSize && this.parkedCars.containsValue(parkedCar))) {
            this.parkedCars.put(parkedCar.driverType.getSlotNumber(slotNumber), parkedCar);
            this.setLotNumber(parkedCar);
        } else if (this.parkedCars.containsValue(parkedCar))
            throw new ParkingLotException("Vehicle Already Parked", ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED);
        return true;
    }

    public boolean unparkVehicle(VehicleParkingDetails unparkVehicle) {
        Integer isCarParked = isCarParked(unparkVehicle);
        if (isCarParked != null) {
            parkedCars.remove(isCarParked);
            return true;
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }

    public Integer isCarParked(VehicleParkingDetails unparkVehicle) {
        for (Map.Entry<Integer, VehicleParkingDetails> entry : parkedCars.entrySet())
            if (unparkVehicle.equals(entry.getValue()))
                return entry.getKey();
        return null;
    }

    public LocalDateTime getParkingTime(VehicleParkingDetails parkedVehicle) {
        Integer carSlotNumber = isCarParked(parkedVehicle);
        if (carSlotNumber != null) {
            return parkedCars.get(carSlotNumber)
                    .getLocalDateTime();
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }

    public Map<Integer, VehicleParkingDetails> findByAttribute(SearchKeywords... attribute) {
        return parkedCars.entrySet()
                .stream()
                .filter(values -> getFilter(values, attribute))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean getFilter(Map.Entry<Integer, VehicleParkingDetails> values, SearchKeywords... attribute) {
        for (SearchKeywords attribute1 : attribute) {
            if (!(parkedCars.get(values.getKey()).toString().toUpperCase().contains(attribute1.toString())))
                return false;
        }
        return true;
    }

    public Map<Integer, VehicleParkingDetails> findByTime(int timeInMinute) {
        return parkedCars.entrySet()
                .stream()
                .filter(values -> LocalDateTime.now().minusMinutes(timeInMinute).compareTo(parkedCars.get(values.getKey()).localDateTime) < 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, VehicleParkingDetails> findVehiclesOfLot(SearchKeywords attribute, Integer... lotNumber) {
        return findByAttribute(attribute).entrySet()
                .stream()
                .filter(values -> {
                    for (Integer lotNumber1 : lotNumber)
                        if (values.getValue().lotNumber == lotNumber1)
                            return true;
                    return false;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void setLotNumber(VehicleParkingDetails parkedCar) {
        parkedCars.entrySet()
                .stream()
                .filter(values -> values.getValue() == parkedCar)
                .forEach(values -> {
                    for (int j = 1; j <= noOfLots; j++)
                        if (values.getKey() <= j * (totalSize / noOfLots)) {
                            parkedCar.lotNumber = j;
                            break;
                        }
                });
    }
}