import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

public class ParkingLotTest {

    Car carDetails;

    @Mock
    ParkingLotRepository parkingLotRepository;

    @Rule
    public MockitoRule mockitoRule = new MockitoJUnit().rule();

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
        ParkingLot parkingLot = new ParkingLot(carDetails, parkingLotRepository);
        when(parkingLotRepository.getVehicleParked(carDetails)).thenReturn(true);
        boolean carParkStatus = parkingLot.parkVehicle();
        Assert.assertTrue(carParkStatus);
    }
}
