public class ParkingLot {

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    public static Integer totalSize;
    public static ParkingLotEnum ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
    public static ParkingLotEnum securityStatus = ParkingLotEnum.NOT_FULL;

    public ParkingLot(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public boolean getVehicleParked(Object parkedVehicle) {
        boolean parkingStatus = parkingLotRepository.getVehicleParked(parkedVehicle);
        new ParkingLotStatus(parkingLotRepository.parkedCars).parkingLotStatus();
        return parkingStatus;
    }

    public boolean getVehicleUnparked(Object unparkVehicle) {
        boolean unparkingStatus = parkingLotRepository.getVehicleUnparked(unparkVehicle);
        new ParkingLotStatus(parkingLotRepository.parkedCars).parkingLotStatus();
        return unparkingStatus;
    }
}