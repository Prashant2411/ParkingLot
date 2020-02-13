import java.time.LocalDateTime;

public class ParkedVehicle {
    private String carNumber;
    private String ownerName;
    private String color;
    private String modelName;
    private LocalDateTime parkingTime;
    private int parkingLotNumber;

    public ParkedVehicle(Integer parkingLotNumber, String carNumber, String ownerName, String color, String modelName, LocalDateTime parkingTime) {
        this.carNumber = carNumber;
        this.ownerName = ownerName;
        this.color = color;
        this.modelName = modelName;
        this.parkingTime = parkingTime;
        this.parkingLotNumber = Integer.parseInt(String.valueOf(parkingLotNumber));
    }

    public ParkedVehicle() {
        this.parkingTime = LocalDateTime.now();
        this.parkingLotNumber = (int) (Math.random()*100);
    }

    public ParkedVehicle setCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public ParkedVehicle setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public ParkedVehicle setColor(String color) {
        this.color = color;
        return this;
    }

    public ParkedVehicle setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public ParkedVehicle getCarDetails() {
        return new ParkedVehicle(parkingLotNumber, carNumber, ownerName, color, modelName, parkingTime);
    }

    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", color='" + color + '\'' +
                ", modelName='" + modelName + '\'' +
                ", parkingTime=" + parkingTime +
                ", parkingLotNumber=" + parkingLotNumber +
                '}';
    }
}
