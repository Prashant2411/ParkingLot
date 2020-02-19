import com.bridgelabz.parkinglot.exception.ParkingLotException;
import com.bridgelabz.parkinglot.services.AirportSecuritySystem;
import com.bridgelabz.parkinglot.services.ParkingLotOwner;
import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.services.ParkingVehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ParkingSystemTest {

    ParkingVehicle parkedVehicle = null;
    ParkingLot parkingLot = null;

    @Before
    public void setup() {
        parkedVehicle = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        parkingLot = new ParkingLot(4, 2);
    }

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void givenSameCarToPark_thenReturnException() {
        try {
            boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
            boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle);
        } catch (ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED, e.type);
        }
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carUnParkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertTrue(carUnParkStatus);
    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
            boolean carUnParkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER, e.type);
        }
    }

    @Test
    public void whenMoreVehicleThenAvailableLotSize_shouldSetParkingLotStatusFull() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        ParkingVehicle parkedVehicle3 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus3 = parkingLot.getVehicleParked(parkedVehicle3);
        ParkingVehicle parkedVehicle4 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus4 = parkingLot.getVehicleParked(parkedVehicle4);
        Assert.assertTrue(new ParkingLotOwner().isParkingLotFull);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusFull() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        ParkingVehicle parkedVehicle3 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus3 = parkingLot.getVehicleParked(parkedVehicle3);
        ParkingVehicle parkedVehicle4 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus4 = parkingLot.getVehicleParked(parkedVehicle4);
        Assert.assertTrue(new AirportSecuritySystem().isParkingLotFull);
    }

    @Test
    public void whenMoreThen100Vehicle_ifAnyVehicleUnparked_shouldSetParkingLotStatusNotFull() {
        ParkingVehicle parkedVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        boolean carUnparkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertFalse(new ParkingLotOwner().isParkingLotFull);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusNotFull() throws InterruptedException {
        ParkingVehicle parkedVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        boolean carUnparkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertFalse(new AirportSecuritySystem().isParkingLotFull);
    }

    @Test
    public void whenGivenParkingVehicle_shouldReturnSlotNumber() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carParkStatus1 = parkingLot.getVehicleParked(new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL));
        boolean carParkStatus2 = parkingLot.getVehicleParked(new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL));
        Integer slotNumber = parkingLot.findVehicle(parkedVehicle);
        Assert.assertEquals("1", "" + slotNumber);
    }

    @Test
    public void whenGivenParkingVehicle_shouldReturnTimeParked() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        boolean carUnparkStatus = parkingLot.getVehicleUnparked(parkedVehicle);
        Assert.assertEquals(parkedVehicle.getLocalDateTime(), new ParkingLotOwner().getVehicleParkingTime());
    }

    @Test
    public void whenVehicleArrives_shouldParkInLotEvenly() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        Assert.assertEquals("1",""+parkingLot.findVehicle(parkedVehicle));
        Assert.assertEquals("3",""+parkingLot.findVehicle(parkedVehicle1));
        Assert.assertEquals("2",""+parkingLot.findVehicle(parkedVehicle2));
    }

    @Test
    public void givenHandicapDriver_whenVehicleToBeParked_thenParkToNearestSlot() {
        boolean carParkStatus = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkedVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean carParkStatus1 = parkingLot.getVehicleParked(parkedVehicle1);
        ParkingVehicle parkedVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        parkedVehicle2.isHandicap = true;
        boolean carParkStatus2 = parkingLot.getVehicleParked(parkedVehicle2);
        Assert.assertEquals("2",""+parkingLot.findVehicle(parkedVehicle2));
    }

    @Test
    public void givenLargeVehicle_whenVehicleToBeParked_thenParkVehicle() {
        ParkingVehicle parkingVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.LARGE);
        boolean vehicleParked = parkingLot.getVehicleParked(parkingVehicle1);
        Assert.assertTrue(vehicleParked);
    }

    @Test
    public void givenMultipleVehicle_whenOneLargeVehicle_thenParkVehicle() {
        boolean vehicleParked = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkingVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.LARGE);
        boolean vehicleParked1 = parkingLot.getVehicleParked(parkingVehicle1);
        ParkingVehicle parkingVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        boolean vehicleParked2 = parkingLot.getVehicleParked(parkingVehicle2);
        Assert.assertTrue(vehicleParked1);
    }

    @Test
    public void givenMultipleVehicle_whenAskedWhiteCarLocation_thenReturnWhiteCar() {
        boolean vehicleParked = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkingVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.LARGE);
        boolean vehicleParked1 = parkingLot.getVehicleParked(parkingVehicle1);
        ParkingVehicle parkingVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
        parkingVehicle2.carColour="White";
        boolean vehicleParked2 = parkingLot.getVehicleParked(parkingVehicle2);
        Map<Integer, ParkingVehicle> foundResult = parkingLot.findVehicleByAttribute("White");
        Assert.assertEquals("White",foundResult.get(2).carColour);
    }

    @Test
    public void givenMultipleVehicle_whenAskedMultipleAttributesForLocation_thenReturnSearchResult() {
        boolean vehicleParked = parkingLot.getVehicleParked(parkedVehicle);
        ParkingVehicle parkingVehicle1 = new ParkingVehicle(ParkingVehicle.VehicleSize.LARGE);
        boolean vehicleParked1 = parkingLot.getVehicleParked(parkingVehicle1);
        ParkingVehicle parkingVehicle2 = new ParkingVehicle(ParkingVehicle.VehicleSize.SMALL);
       parkingVehicle2.carColour="Blue";
        parkingVehicle2.modelName="Toyota";
        boolean vehicleParked2 = parkingLot.getVehicleParked(parkingVehicle2);
        Map<Integer, ParkingVehicle> foundResult = parkingLot.findVehicleByAttribute("Blue", "Toyota");
        Assert.assertEquals("Blue",foundResult.get(2).carColour);
        Assert.assertEquals("Toyota",foundResult.get(2).modelName);
    }
}