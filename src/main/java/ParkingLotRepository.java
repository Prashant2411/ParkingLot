import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    static Map<String, Car> parkedCars = new HashMap<>();

    public boolean getVehicleParked(Car[] carDetails) {
        for (int i = 0; i < carDetails.length; i++)
            if (parkedCars.size() < 100)
                parkedCars.put(carDetails[i].getCarNumber(), carDetails[i]);
            else {
                ParkingLot.ownerParkingLotStatus = ParkingLotEnum.FULL;
                ParkingLot.securityStatus = ParkingLotEnum.FULL;
            }
        return true;
    }

    public boolean getVehicleUnparked(String carNumber) {
        if (parkedCars.containsKey(carNumber)) {
            parkedCars.remove(carNumber);
            ParkingLot.ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
            ParkingLot.securityStatus = ParkingLotEnum.NOT_FULL;
            return true;
        }
        throw new ParkingLotException("Enter valid Car number", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }
}
