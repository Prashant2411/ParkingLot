import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    public Map<Integer, ParkingVehicle> parkedCars = new HashMap<>();
    private Integer noOfLots, lotStartPoint = 0, totalSize;
    private int count = 0, i = 1;

    public ParkingLotRepository(Integer totalSize, Integer noOfLots) {
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
    }

    public boolean getVehicleParked(ParkingVehicle parkedCar) {
        if (this.parkedCars.size() < this.totalSize && this.parkedCars.containsValue(parkedCar) == false) {
            this.parkedCars.put(getSlotNumber(parkedCar.isHandicap), parkedCar);
        } else if (this.parkedCars.containsValue(parkedCar) == true)
            throw new ParkingLotException("Vehicle Already Parked", ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED);
        return true;
    }

    private Integer getSlotNumber(boolean isHandicap) {
        int n = 0;
        if (isHandicap == true) {
            return getHandicapSlotNumber();
        } else if (isHandicap == false) {
            if (count == noOfLots) {
                count = 0;
                i++;
            }
            if (parkedCars.containsKey((i + lotStartPoint) % this.totalSize) == false)
                n = i + lotStartPoint % this.totalSize;
            else {
                lotStartPoint += this.totalSize / noOfLots;
                n = getSlotNumber(isHandicap);
            }
        }
        lotStartPoint += this.totalSize / noOfLots;
        count++;
        return n;
    }

    private Integer getHandicapSlotNumber() {
        int n = 0;
        for (int i = 1; i <= totalSize; i++) {
            if (parkedCars.containsKey(i) == false) {
                n = i;
                break;
            }
        }
        count++;
        return n;
    }

    public boolean getVehicleUnparked(ParkingVehicle unparkVehicle) {
        Integer isCarParked = isCarParked(unparkVehicle);
        if (isCarParked != null) {
            parkedCars.remove(isCarParked);
            return true;
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }

    public Integer isCarParked(ParkingVehicle unparkVehicle) {
        for (Map.Entry<Integer, ParkingVehicle> entry : parkedCars.entrySet())
            if (unparkVehicle.equals(entry.getValue()))
                return entry.getKey();
        return null;
    }

    public String getParkingTime(ParkingVehicle parkedVehicle) {
        Integer carSlotNumber = isCarParked(parkedVehicle);
        if (carSlotNumber != null) {
            return parkedCars.get(carSlotNumber)
                    .getLocalDateTime();
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_VEHICLE_NUMBER);
    }
}