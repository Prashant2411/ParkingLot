import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

public class ParkingLotTest {

    Car carDetails;

    @Before
    public void setup() {
            carDetails = new Car()
                    .setCarNumber("ABC ")
                    .setColor("Black")
                    .setModelName("CarModel")
                    .setOwnerName("ABC's ")
                    .getCarDetails();
    }

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        ParkingLot parkingLot = new ParkingLot(carDetails);
        boolean carParkStatus = parkingLot.parkVehicle();
        Assert.assertTrue(carParkStatus);
    }
}
