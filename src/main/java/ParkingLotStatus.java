import java.util.List;
import java.util.Map;

public class ParkingLotStatus {

    Map<Integer, Object> parkedCars;

    public ParkingLotStatus(Map parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void run() {
        if (this.parkedCars.size() == ParkingLot.totalSize) {
            new ParkingLotOwner().setParkingLotFull(true);
            new AirportSecuritySystem().setParkingLotFull(true);
        }
        if (new AirportSecuritySystem().isParkingLotFull() == true) {
            if (this.parkedCars.size() < ParkingLot.totalSize) {
                new ParkingLotOwner().setParkingLotFull(false);
                new AirportSecuritySystem().setParkingLotFull(false);
            }
        }
    }

    public void parkingLotStatus() {
        this.run();
    }
}