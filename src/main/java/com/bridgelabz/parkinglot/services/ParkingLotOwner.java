package com.bridgelabz.parkinglot.services;

import jdk.vm.ci.meta.Local;

import java.time.LocalDateTime;

public class ParkingLotOwner implements ParkingLotObservers {

    public static boolean isParkingLotFull;
    public static LocalDateTime vehicleParkingTime;

    public LocalDateTime getVehicleParkingTime() {
        return vehicleParkingTime;
    }

    public void setVehicleParkingTime(LocalDateTime vehicleParkingTime) {
        this.vehicleParkingTime = vehicleParkingTime;
    }

    @Override
    public void setParkingLotStatus(boolean parkingLotStatus) {
        this.isParkingLotFull = parkingLotStatus;
    }
}
