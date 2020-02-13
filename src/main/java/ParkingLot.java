public class ParkingLot {

    private ParkedVehicle[] carDetails;
    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    public static ParkingLotEnum ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
    public static ParkingLotEnum securityStatus = ParkingLotEnum.NOT_FULL;

    public ParkingLot(ParkedVehicle[] carDetails) {
        this.carDetails = carDetails;
    }

    public ParkingLot(ParkedVehicle[] carDetails, ParkingLotRepository parkingLotRepository) {
        this.carDetails = carDetails;
        this.parkingLotRepository = parkingLotRepository;
    }

    public boolean getVehicleParkedUnparked(String... carNumber){
        if (carNumber.length == 0)
            return parkingLotRepository.getVehicleParked(carDetails);
        return parkingLotRepository.getVehicleUnparked(carNumber[0]);
    }
}