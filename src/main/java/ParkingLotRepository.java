import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    public Map<Integer, ParkingVehicle> parkedCars = new HashMap<>();
    private static Integer noOfLots, lotStartPoint=0, totalSize;

    public ParkingLotRepository(Integer totalSize, Integer noOfLots) {
        this.noOfLots = noOfLots;
        this.totalSize = totalSize;
    }

    public boolean getVehicleParked(ParkingVehicle parkedCar) {
        if (this.parkedCars.size() < this.totalSize) {
            this.parkedCars.put(getSlotNumber(), parkedCar);
        }
        lotStartPoint += this.totalSize/noOfLots;
        return true;
    }

    private Integer getSlotNumber() {
        for (int i = 1 ; i <= this.totalSize/noOfLots ; i++)
            if (parkedCars.containsKey((i+lotStartPoint)%this.totalSize) == false){
                return (i+lotStartPoint)%this.totalSize;}
        return null;
    }

    public boolean getVehicleUnparked(ParkingVehicle unparkVehicle) {
        Integer isCarParked = isCarParked(unparkVehicle);
        if (isCarParked != null) {
            parkedCars.remove(isCarParked);
            return true;
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }

    public Integer isCarParked(ParkingVehicle unparkVehicle) {
        for (Map.Entry<Integer, ParkingVehicle> entry : parkedCars.entrySet())
            if (unparkVehicle.equals(entry.getValue()))
                return entry.getKey();
        return null;
    }

    public String getParkingTime(ParkingVehicle parkedVehicle) {
        Integer carSlotNumber = isCarParked(parkedVehicle);
        if(carSlotNumber != null) {
            return parkedCars.get(carSlotNumber)
                    .getLocalDateTime();
        }
        throw new ParkingLotException("Enter valid Car details", ParkingLotException.ExceptionType.NO_SUCH_CAR_NUMBER);
    }
}