package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.enumerate.VehicleType;

import java.time.LocalDateTime;

public class ParkingVehicle {

    public LocalDateTime localDateTime;
    VehicleType vehicleType;
    public String carColour = null;
    public String plateNumber, parkingAttendentName, modelName;

    public ParkingVehicle(VehicleType vehicleType) {
        LocalDateTime formatDateTime = LocalDateTime.now();
        this.localDateTime = formatDateTime;
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    @Override
    public String toString() {
        return "ParkingVehicle{" +
                "localDateTime='" + localDateTime + '\'' +
                ", driverType=" + vehicleType +
                ", carColour='" + carColour + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", parkingAttendentName='" + parkingAttendentName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
