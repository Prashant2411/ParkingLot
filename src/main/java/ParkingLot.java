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

    public boolean getVehicleParked(ParkingVehicle parkedVehicle) {
        boolean parkingStatus = parkingLotRepository.getVehicleParked(parkedVehicle);
        parkingLotStatus.parkingLotStatus();
        return parkingStatus;
    }

    public boolean getVehicleUnparked(ParkingVehicle unparkVehicle) {
        boolean unparkingStatus = parkingLotRepository.getVehicleUnparked(unparkVehicle);
        parkingLotStatus.parkingLotStatus();
        return unparkingStatus;
    }

    public Integer findVehicle(ParkingVehicle parkedVehicle) {
        return parkingLotRepository.isCarParked(parkedVehicle);
    }

    public void getParkedTime(ParkingVehicle unparkedVehicle) {
        String parkingTime = parkingLotRepository.getParkingTime(unparkedVehicle);
        new ParkingLotOwner().setVehicleParkingTime(parkingTime);
    }
}