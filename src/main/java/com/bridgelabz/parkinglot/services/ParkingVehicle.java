package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.DriverType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingVehicle {

    private String localDateTime;
    DriverType driverType;
    public String carColour = null;
    public String plateNumber, parkingAttendentName, modelName;

    public ParkingVehicle(DriverType driverType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        this.localDateTime = formatDateTime;
        this.driverType = driverType;
    }

    public String getLocalDateTime() {
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
