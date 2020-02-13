import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

public class ParkingLotTest {

    Object[] parkedVehicle = new Object[101];

    @Before
    public void setup() {
        for (int i = 0; i < parkedVehicle.length; i++) {
            parkedVehicle[i] = new Object();
        }
    }

    @Mock
    ParkingLotRepository parkingLotRepository;

    @Rule
    public MockitoRule mockitoRule = new MockitoJUnit().rule();

    @Test
    public void whenVehicleArrives_shouldParkInLot() {
        ParkingLot parkingLot = new ParkingLot(parkedVehicle, parkingLotRepository);
        when(parkingLotRepository.getVehicleParked(parkedVehicle)).thenReturn(true);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        Assert.assertTrue(carParkStatus);
    }

    @Test
    public void whenDriverArrives_shouldUnparkVehicle() {
        ParkingLot parkingLot = new ParkingLot(parkedVehicle, parkingLotRepository);
        boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
        when(parkingLotRepository.getVehicleUnparked("ABC 1")).thenReturn(true);
        boolean carUnParkStatus = parkingLot.getVehicleParkedUnparked("ABC 1");
        Assert.assertTrue(carUnParkStatus);

    }

    @Test
    public void whenGivenInvalidCarNumber_shouldThrowException() {
        try {
            ParkingLot parkingLot = new ParkingLot(parkedVehicle, parkingLotRepository
            );
            boolean carParkStatus = parkingLot.getVehicleParkedUnparked();
            when(parkingLotRepository.getVehicleUnparked("ABC 12")).thenThrow(new ParkingLotException("Enter valid Car number", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER));
            boolean carUnParkStatus = parkingLot.getVehicleParkedUnparked("ABC 12");
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER, e.type);
        }
    }
}
