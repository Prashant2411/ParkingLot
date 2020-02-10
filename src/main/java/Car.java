import java.time.LocalDateTime;

public class Car {
    String carNumber;
    String ownerName;
    String color;
    String modelName;
    LocalDateTime parkingTime;
    int parkingLotNumber;

    public Car(Integer parkingLotNumber, String carNumber, String ownerName, String color, String modelName, LocalDateTime parkingTime) {
        this.carNumber = carNumber;
        this.ownerName = ownerName;
        this.color = color;
        this.modelName = modelName;
        this.parkingTime = parkingTime;
        this.parkingLotNumber = Integer.parseInt(String.valueOf(parkingLotNumber));
    }

    public Car() {
        this.parkingTime = LocalDateTime.now();
        this.parkingLotNumber = (int) (Math.random()*100);
    }

    public Car setCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public Car setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public Car setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Car getCarDetails() {
        return new Car(parkingLotNumber, carNumber, ownerName, color, modelName, parkingTime);
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
