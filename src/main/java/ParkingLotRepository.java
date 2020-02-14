import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    public Map<Integer, Object> parkedCars = new HashMap<>();

    public boolean getVehicleParked(Object parkedCar) {
        if (this.parkedCars.size() < ParkingLot.totalSize) {
            this.parkedCars.put(getSlotNumber(), parkedCar);
        }
        return true;
    }

    private Integer getSlotNumber() {
        for (int i = 1 ; i <= ParkingLot.totalSize ; i++)
            if (parkedCars.containsKey(i) == false)
                return i;
        return null;
    }

    public boolean getVehicleUnparked(Object unparkVehicle) {
        Integer isCarParked = isCarParked(unparkVehicle);
        if (isCarParked != null) {
            parkedCars.remove(isCarParked);
            return true;
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }

    public Integer isCarParked(Object unparkVehicle) {
        for (Map.Entry<Integer, Object> entry : parkedCars.entrySet())
            if (unparkVehicle.equals(entry.getValue()))
                return entry.getKey();
        return null;
    }
}