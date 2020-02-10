public class ParkingLot {

    private Car carDetails;

    public ParkingLot(Car carDetails) {
        this.carDetails = carDetails;
    }

    public boolean parkVehicle() {
        return new ParkingLotRepository().getVehicleParked(carDetails);
    }
}
