import java.util.List;

public class ParkingLotStatus {

    List parkedCars;

    public ParkingLotStatus(List parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void run() {
            if (this.parkedCars.size() == ParkingLot.totalSize){
                ParkingLot.ownerParkingLotStatus = ParkingLotEnum.FULL;
                ParkingLot.securityStatus = ParkingLotEnum.FULL;
            }
            if (ParkingLot.ownerParkingLotStatus == ParkingLotEnum.FULL){
                if (this.parkedCars.size() < ParkingLot.totalSize){
                    ParkingLot.ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
                    ParkingLot.securityStatus = ParkingLotEnum.NOT_FULL;
                }
        }
    }

    public void parkingLotStatus() {
        this.run();
    }
}
