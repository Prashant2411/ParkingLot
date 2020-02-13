import java.util.List;

public class ParkingLotStatus {

    List parkedCars;

    public ParkingLotStatus(List parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void run() {
            if (this.parkedCars.size() == ParkingLot.totalSize){
                new ParkingLotOwner().setParkingLotFull(true);
                new AirportSecuritySystem().setParkingLotFull(true);
            }
            if (new AirportSecuritySystem().isParkingLotFull() == true){
                if (this.parkedCars.size() < ParkingLot.totalSize){
                    new ParkingLotOwner().setParkingLotFull(false);
                    new AirportSecuritySystem().setParkingLotFull(false);
                }
        }
    }

    public void parkingLotStatus() {
        this.run();
    }
}
