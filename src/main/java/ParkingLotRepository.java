import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    public List parkedCars = new ArrayList<>();

    public boolean getVehicleParked(Object parkedCar) {
        if (this.parkedCars.size() < ParkingLot.totalSize) {
            this.parkedCars.add(parkedCar);
        }
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