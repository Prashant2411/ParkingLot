package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.enumeration.DriverType;
import com.bridgelabz.parkinglot.enumeration.SearchKeywords;
import com.bridgelabz.parkinglot.exception.ParkingLotException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

public class ParkingSystemTest {

    VehicleParkingDetails parkedVehicle = null;
    ParkingLot parkingLot = null;

    @Before
    public void setup() {
        parkingLot = new ParkingLot(4, 2);
        parkedVehicle = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
    }

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void givenSameCarToPark_thenReturnException() {
        try {
            boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
            boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle);
        } catch (ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED, e.type);
        }
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        boolean carUnParkStatus = parkingLot.unparkVehicle(parkedVehicle);
        Assert.assertTrue(carUnParkStatus);
    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
            boolean carUnParkStatus = parkingLot.unparkVehicle(parkedVehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER, e.type);
        }
    }

    @Test
    public void whenMoreVehicleThenAvailableLotSize_shouldSetParkingLotStatusFull() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkedVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle1);
        VehicleParkingDetails parkedVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus2 = parkingLot.parkVehicle(parkedVehicle2);
        VehicleParkingDetails parkedVehicle3 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus3 = parkingLot.parkVehicle(parkedVehicle3);
        VehicleParkingDetails parkedVehicle4 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus4 = parkingLot.parkVehicle(parkedVehicle4);
        Assert.assertTrue(ParkingLotOwner.isParkingLotFull);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusFull() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkedVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle1);
        VehicleParkingDetails parkedVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus2 = parkingLot.parkVehicle(parkedVehicle2);
        VehicleParkingDetails parkedVehicle3 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus3 = parkingLot.parkVehicle(parkedVehicle3);
        VehicleParkingDetails parkedVehicle4 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus4 = parkingLot.parkVehicle(parkedVehicle4);
        Assert.assertTrue(AirportSecuritySystem.isParkingLotFull);
    }

    @Test
    public void whenMoreThen100Vehicle_ifAnyVehicleUnparked_shouldSetParkingLotStatusNotFull() {
        VehicleParkingDetails parkedVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle1);
        boolean carUnparkStatus = parkingLot.unparkVehicle(parkedVehicle);
        Assert.assertFalse(ParkingLotOwner.isParkingLotFull);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusNotFull() throws InterruptedException {
        VehicleParkingDetails parkedVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle1);
        boolean carUnparkStatus = parkingLot.unparkVehicle(parkedVehicle);
        Assert.assertFalse(AirportSecuritySystem.isParkingLotFull);
    }

    @Test
    public void whenGivenParkingVehicle_shouldReturnSlotNumber() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        boolean carParkStatus1 = parkingLot.parkVehicle(new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER));
        boolean carParkStatus2 = parkingLot.parkVehicle(new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER));
        Integer slotNumber = parkingLot.findVehicle(parkedVehicle);
        Assert.assertEquals("1", "" + slotNumber);
    }

    @Test
    public void whenGivenParkingVehicle_shouldReturnTimeParked() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        boolean carUnparkStatus = parkingLot.unparkVehicle(parkedVehicle);
        Assert.assertEquals(parkedVehicle.getLocalDateTime(), new ParkingLotOwner().getVehicleParkingTime());
    }

    @Test
    public void whenVehicleArrives_shouldParkInLotEvenly() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkedVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle1);
        VehicleParkingDetails parkedVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus2 = parkingLot.parkVehicle(parkedVehicle2);
        Assert.assertEquals("1",""+parkingLot.findVehicle(parkedVehicle));
        Assert.assertEquals("3",""+parkingLot.findVehicle(parkedVehicle1));
        Assert.assertEquals("2",""+parkingLot.findVehicle(parkedVehicle2));
    }

    @Test
    public void givenHandicapDriver_whenVehicleToBeParked_thenParkToNearestSlot() {
        boolean carParkStatus = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkedVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean carParkStatus1 = parkingLot.parkVehicle(parkedVehicle1);
        VehicleParkingDetails parkedVehicle2 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean carParkStatus2 = parkingLot.parkVehicle(parkedVehicle2);
        Assert.assertEquals("2",""+parkingLot.findVehicle(parkedVehicle2));
    }

    @Test
    public void givenLargeVehicle_whenVehicleToBeParked_thenParkVehicle() {
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked = parkingLot.parkVehicle(parkingVehicle1);
        Assert.assertTrue(vehicleParked);
    }

    @Test
    public void givenMultipleVehicle_whenOneLargeVehicle_thenParkVehicle() {
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Assert.assertTrue(vehicleParked1);
    }

    @Test
    public void givenMultipleVehicle_whenAskedWhiteCarLocation_thenReturnWhiteCar() {
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.LARGE_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        parkingVehicle2.carColour="White";
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByAttribute(SearchKeywords.WHITE);
        Assert.assertEquals(1,foundResult.size());
    }

    @Test
    public void givenMultipleVehicle_whenAskedMultipleAttributesForLocation_thenReturnSearchResult() {
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        parkingVehicle2.carColour="Blue";
        parkingVehicle2.modelName="Toyota";
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByAttribute(SearchKeywords.BLUE, SearchKeywords.TOYOTA);
        Assert.assertEquals(1,foundResult.size());
    }

    @Test
    public void givenMultipleAttribute_whenGivenWrongAttributesForLocation_shouldReturnNoData() {
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        parkingVehicle2.carColour="Blue";
        parkingVehicle2.modelName="Toyota";
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByAttribute(SearchKeywords.MERCEDES);
        Assert.assertEquals(0,foundResult.size());
    }

    @Test
    public void givenVehicle_whenVehicleIsBMW_thenReturnSearchResult() {
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        parkingVehicle2.modelName="BMW";
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByAttribute(SearchKeywords.BMW);
        Assert.assertEquals(1,foundResult.size());
    }

    @Test
    public void givenVehicleInParkingLot_whenParkedInLast30Minutes_thenReturnSearchResult() {
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        parkingVehicle1.localDateTime= LocalDateTime.now().minusMinutes(15);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        parkingVehicle2.localDateTime= LocalDateTime.now().minusMinutes(45);
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByTime(30);
        Assert.assertEquals(2,foundResult.size());
    }

    @Test
    public void givenVehicleInParkingLot_whenNoVehicleParkedInLast30Minutes_shouldReturnNoData() {
        parkedVehicle.localDateTime= LocalDateTime.now().minusMinutes(31);
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        parkingVehicle1.localDateTime= LocalDateTime.now().minusMinutes(50);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        parkingVehicle2.localDateTime= LocalDateTime.now().minusMinutes(45);
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByTime(30);
        Assert.assertEquals(0,foundResult.size());
    }

    @Test
    public void givenVehicleInParkingLot_whenFindByLot_shouldReturnSearchResult() {
        parkingLot = new ParkingLot(8, 4);
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        VehicleParkingDetails parkingVehicle3 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked3 = parkingLot.parkVehicle(parkingVehicle3);
        VehicleParkingDetails parkingVehicle4 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked4 = parkingLot.parkVehicle(parkingVehicle4);
        VehicleParkingDetails parkingVehicle5 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked5 = parkingLot.parkVehicle(parkingVehicle5);
        VehicleParkingDetails parkingVehicle6 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked6 = parkingLot.parkVehicle(parkingVehicle6);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehiclesOfLot(SearchKeywords.HANDICAP_VEHICLE_DRIVER,2,4);
        Assert.assertEquals(3,foundResult.size());
    }

    @Test
    public void givenVehicleInParkingLot_whenNeedAllData_thenReturnSearchResult() {
        parkingLot = new ParkingLot(8, 4);
        boolean vehicleParked = parkingLot.parkVehicle(parkedVehicle);
        VehicleParkingDetails parkingVehicle1 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked1 = parkingLot.parkVehicle(parkingVehicle1);
        VehicleParkingDetails parkingVehicle2 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked2 = parkingLot.parkVehicle(parkingVehicle2);
        VehicleParkingDetails parkingVehicle3 = new VehicleParkingDetails(DriverType.SMALL_VEHICLE_DRIVER);
        boolean vehicleParked3 = parkingLot.parkVehicle(parkingVehicle3);
        VehicleParkingDetails parkingVehicle4 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked4 = parkingLot.parkVehicle(parkingVehicle4);
        VehicleParkingDetails parkingVehicle5 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked5 = parkingLot.parkVehicle(parkingVehicle5);
        VehicleParkingDetails parkingVehicle6 = new VehicleParkingDetails(DriverType.HANDICAP_VEHICLE_DRIVER);
        boolean vehicleParked6 = parkingLot.parkVehicle(parkingVehicle6);
        Map<Integer, VehicleParkingDetails> foundResult = parkingLot.findVehicleByAttribute();
        Assert.assertEquals(7,foundResult.size());
    }
}