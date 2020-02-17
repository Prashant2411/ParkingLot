public class AirportSecuritySystem implements ParkingLotObservers {

    public static boolean isParkingLotFull;

    @Override
    public void setParkingLotStatus(boolean parkingLotStatus) {
        this.isParkingLotFull=parkingLotStatus;
    }
}
