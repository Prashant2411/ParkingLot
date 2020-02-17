public class ParkingLotException extends RuntimeException {

    public enum ExceptionType{
        NO_SUCH_VEHICLE_NUMBER, VEHICLE_ALREADY_PARKED
    }

    ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
