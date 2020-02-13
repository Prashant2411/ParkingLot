import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    static Map<Integer, Object> parkedCars = new HashMap<>();

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
                parkedCars.put(i, carDetails[i]);
        return true;
    }

    public boolean getVehicleUnparked(String carNumber) {
        if (parkedCars.containsKey(carNumber)) {
            parkedCars.remove(carNumber);
            return true;
        }
        throw new ParkingLotException("Enter valid Car number", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }
}
