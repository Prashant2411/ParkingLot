public class ParkingLot {

    private Car[] carDetails;
    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    public static ParkingLotStatus parkingLotStatus = ParkingLotStatus.NOT_FULL;

    public enum ParkingLotStatus{
        NOT_FULL, FULL
    }

    public ParkingLot(Car[] carDetails) {
        this.carDetails = carDetails;
    }

    public ParkingLot(Car[] carDetails, ParkingLotRepository parkingLotRepository) {
        this.carDetails = carDetails;
        this.parkingLotRepository = parkingLotRepository;
    }

    public boolean getVehicleParkedUnparked(String... carNumber){
        if (carNumber.length == 0)
            return parkingLotRepository.getVehicleParked(carDetails);
        return parkingLotRepository.getVehicleUnparked(carNumber[0]);
    }
}