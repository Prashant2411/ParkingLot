import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    Map<String, Car> parkedCars = new HashMap<>();

    public boolean getVehicleParked(Car carDetails) {
        if(parkedCars.size()<=100) {
            parkedCars.put(carDetails.carNumber, carDetails);
            return true;
        }
        return false;
    }
}
