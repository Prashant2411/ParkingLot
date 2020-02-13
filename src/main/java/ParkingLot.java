public class ParkingLot {

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    private ParkingLotStatus parkingLotStatus = new ParkingLotStatus(parkingLotRepository.parkedCars);
    public static Integer totalSize;

    public ParkingLot(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public ParkingLot(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public boolean getVehicleParked(Object parkedVehicle) {
        boolean parkingStatus = parkingLotRepository.getVehicleParked(parkedVehicle);
        parkingLotStatus.parkingLotStatus();
        return parkingStatus;
    }

    public boolean getVehicleUnparked(Object unparkVehicle) {
        boolean unparkingStatus = parkingLotRepository.getVehicleUnparked(unparkVehicle);
        parkingLotStatus.parkingLotStatus();
        return unparkingStatus;
    }
}