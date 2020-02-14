public class ParkingLotOwner implements ParkingLotObserver {

    private static boolean isParkingLotFull;
    private static String vehicleParkingTime;

    @Override
    public boolean isParkingLotFull() {
        return this.isParkingLotFull;
    }

    @Override
    public void setParkingLotFull(boolean isParkingLotFull) {
        this.isParkingLotFull = isParkingLotFull;
    }

    public String getVehicleParkingTime() {
        return vehicleParkingTime;
    }

    public void setVehicleParkingTime(String vehicleParkingTime) {
        this.vehicleParkingTime = vehicleParkingTime;
    }
}
