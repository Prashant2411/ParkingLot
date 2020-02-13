import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    static List<Object> parkedCars = new ArrayList<>();

    static {
        try {
            new ParkingLotStatus().parkingLotStatus();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getVehicleParked(Object[] carDetails) {
        for (int i = 0; i < carDetails.length; i++)
            if (parkedCars.size() < 100)
                parkedCars.add(carDetails[i]);
        return true;
    }

    public boolean getVehicleUnparked(Object unparkVehicle) {
        if (parkedCars.contains(unparkVehicle)) {
            parkedCars.remove(unparkVehicle);
            return true;
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }
}
