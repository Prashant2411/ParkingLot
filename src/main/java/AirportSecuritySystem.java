public class AirportSecuritySystem implements ParkingLotObserver{

    private static boolean isParkingLotFull;

    @Override
    public boolean isParkingLotFull() {
        return this.isParkingLotFull;
    }

    @Override
    public void setParkingLotFull(boolean isParkingLotFull) {
        this.isParkingLotFull = isParkingLotFull;
    }
}
