import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotRepositoryTest {

    Object[] parkedVehicle = new Object[1];

    @Before
    public void setup() {
        for (int i = 0; i < parkedVehicle.length; i++) {
            parkedVehicle[i] = new Object();
        }
    }

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        ParkingLot parkingLot = new ParkingLot(parkedVehicle);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        ParkingLot parkingLot = new ParkingLot(parkedVehicle);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        boolean carUnParkStatus = parkingLot.getVehicleParkedUnparked(parkedVehicle[0]);
        Assert.assertTrue(carUnParkStatus);
    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            ParkingLot parkingLot = new ParkingLot(parkedVehicle);
            boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
            boolean carUnParkStatus = parkingLot.getVehicleParkedUnparked(parkedVehicle[0]);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER, e.type);
        }
    }

    @Test
    public void whenMoreThen100Vehicle_shouldSetParkingLotStatusFull() {
        parkedVehicle[parkedVehicle.length-1] = new Object();
        ParkingLot parkingLot = new ParkingLot(parkedVehicle);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        Assert.assertEquals(ParkingLotEnum.FULL, ParkingLot.ownerParkingLotStatus);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusFull() {
        parkedVehicle[parkedVehicle.length-1] = new Object();
        ParkingLot parkingLot = new ParkingLot(parkedVehicle);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        Assert.assertEquals(ParkingLotEnum.FULL, ParkingLot.securityStatus);
    }

    @Test
    public void whenMoreThen100Vehicle_ifAnyVehicleUnparked_shouldSetParkingLotStatusNotFull() {
        parkedVehicle[parkedVehicle.length-1] = new Object();
        ParkingLot parkingLot = new ParkingLot(parkedVehicle);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        carParkStatus = parkingLot.getVehicleParkedUnparked(parkedVehicle[0]);
        Assert.assertEquals(ParkingLotEnum.NOT_FULL, ParkingLot.ownerParkingLotStatus);
    }

    @Test
    public void whenParkingLotStatusFull_shouldSetSecurityStaffStatusNotFull() {
        parkedVehicle[parkedVehicle.length-1] = new Object();
        ParkingLot parkingLot = new ParkingLot(parkedVehicle);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        carParkStatus = parkingLot.getVehicleParkedUnparked(parkedVehicle[0]);
        Assert.assertEquals(ParkingLotEnum.NOT_FULL, ParkingLot.securityStatus);
    }
}
