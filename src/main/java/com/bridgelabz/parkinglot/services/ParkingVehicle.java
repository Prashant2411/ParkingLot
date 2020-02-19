package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.VehicleSize;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingVehicle {

    private String localDateTime;
    public boolean isHandicap = false;
    VehicleSize vehicleSize;
    public String carColour = null;
    public String plateNumber, parkingAttendentName, modelName;

    public ParkingVehicle(VehicleSize vehicleSize) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        this.localDateTime = formatDateTime;
        this.vehicleSize = vehicleSize;
    }

    public String getLocalDateTime() {
        return this.localDateTime;
    }

    @Override
    public String toString() {
        return "com.bridgelabz.parkinglot.services.ParkingVehicle{" +
                "localDateTime='" + localDateTime + '\'' +
                ", isHandicap=" + isHandicap +
                ", vehicleSize=" + vehicleSize +
                ", carColour='" + carColour + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", parkingAttendentName='" + parkingAttendentName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
