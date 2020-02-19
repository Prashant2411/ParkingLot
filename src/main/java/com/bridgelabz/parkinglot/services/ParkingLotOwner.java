package com.bridgelabz.parkinglot.services;

public class ParkingLotOwner implements ParkingLotObservers {

    public static boolean isParkingLotFull;
    public static String vehicleParkingTime;

    public String getVehicleParkingTime() {
        return vehicleParkingTime;
    }

    public void setVehicleParkingTime(String vehicleParkingTime) {
        this.vehicleParkingTime = vehicleParkingTime;
    }

    @Override
    public void setParkingLotStatus(boolean parkingLotStatus) {
        this.isParkingLotFull = parkingLotStatus;
    }
}
