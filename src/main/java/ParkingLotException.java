public class ParkingLotException extends RuntimeException {

    public enum ExceptionType{
        NO_SUCH_CAR_NUMBER
    }

    ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
