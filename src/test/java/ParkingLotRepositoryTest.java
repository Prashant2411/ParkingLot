import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotRepositoryTest {

    Car[] carDetails = new Car[5];

    @Before
    public void setup() {
        for (int i = 0; i < 5; i++) {
            carDetails[i] = new Car()
                    .setCarNumber("ABC " + (i+1))
                    .setColor("Black")
                    .setModelName("CarModel " + i)
                    .setOwnerName("ABC's "+ i)
                    .getCarDetails();
        }
    }

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        ParkingLot parkingLot = new ParkingLot(carDetails);
        boolean carParkStatus = parkingLot.parkVehicle();
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        ParkingLot parkingLot = new ParkingLot(carDetails);
        boolean carParkStatus = parkingLot.parkVehicle();
        boolean carUnParkStatus = parkingLot.unparkVehicle("ABC 1");
        Assert.assertTrue(carUnParkStatus);
    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            ParkingLot parkingLot = new ParkingLot(carDetails);
            boolean carParkStatus = parkingLot.parkVehicle();
            boolean carUnParkStatus = parkingLot.unparkVehicle("ABC 12");
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER, e.type);
        }
    }
}
