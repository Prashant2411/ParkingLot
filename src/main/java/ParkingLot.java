public class ParkingLot {

    private Car carDetails;
    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

    public ParkingLot(Car carDetails) {
        this.carDetails = carDetails;
    }

    public ParkingLot(Car carDetails, ParkingLotRepository parkingLotRepository) {
        this.carDetails = carDetails;
        this.parkingLotRepository = parkingLotRepository;
    }

    public boolean parkVehicle() {
        return parkingLotRepository.getVehicleParked(carDetails);
    }
}
