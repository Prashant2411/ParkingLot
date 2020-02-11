public class ParkingLotStatus extends Thread{
    public void run() {
        while (true){
            if (ParkingLotRepository.parkedCars.size() == 100){
                ParkingLot.ownerParkingLotStatus = ParkingLotEnum.FULL;
                ParkingLot.securityStatus = ParkingLotEnum.FULL;
            }
            if (ParkingLot.ownerParkingLotStatus == ParkingLotEnum.FULL){
                if (ParkingLotRepository.parkedCars.size() < 100){
                    ParkingLot.ownerParkingLotStatus = ParkingLotEnum.NOT_FULL;
                    ParkingLot.securityStatus = ParkingLotEnum.NOT_FULL;
                }
            }
        }
    }

    public void parkingLotStatus() throws InterruptedException {
        Thread parkingLot = new ParkingLotStatus();
        parkingLot.setDaemon(true);
        parkingLot.start();
        Thread.sleep(2000);
    }
}
