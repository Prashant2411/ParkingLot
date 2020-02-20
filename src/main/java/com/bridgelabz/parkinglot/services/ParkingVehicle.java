package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.DriverType;

import java.time.LocalDateTime;

public class ParkingVehicle {

    public LocalDateTime localDateTime;
    DriverType driverType;
    public String carColour = null;
    public String plateNumber, parkingAttendentName, modelName;

    public ParkingVehicle(DriverType driverType) {
        LocalDateTime formatDateTime = LocalDateTime.now();
        this.localDateTime = formatDateTime;
        this.driverType = driverType;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    @Override
    public String toString() {
        return "ParkingVehicle{" +
                "localDateTime='" + localDateTime + '\'' +
                ", driverType=" + driverType +
                ", carColour='" + carColour + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", parkingAttendentName='" + parkingAttendentName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
