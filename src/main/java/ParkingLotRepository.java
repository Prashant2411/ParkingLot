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

    public boolean getVehicleUnparked(String carNumber) {
        if (parkedCars.contains(carNumber)) {
            parkedCars.remove(carNumber);
            return true;
        }
        throw new ParkingLotException("Enter valid Car number", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }
}
