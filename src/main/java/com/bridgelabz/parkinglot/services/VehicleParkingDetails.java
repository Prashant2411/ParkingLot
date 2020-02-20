package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.DriverType;

import java.time.LocalDateTime;

public class VehicleParkingDetails {

    public LocalDateTime localDateTime;
    public DriverType driverType;
    public String carColour = null;
    public String plateNumber, parkingAttendentName, modelName;
    public Integer lotNumber;

    public VehicleParkingDetails(DriverType driverType) {
        LocalDateTime formatDateTime = LocalDateTime.now();
        this.localDateTime = formatDateTime;
        this.driverType = driverType;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    @Override
    public String toString() {
        return "VehicleParkingDetails{" +
                "localDateTime=" + localDateTime +
                ", driverType=" + driverType +
                ", carColour='" + carColour + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", parkingAttendentName='" + parkingAttendentName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", lotNumber=" + lotNumber +
                '}';
    }
}
