import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingVehicle {

    private String localDateTime;
    public boolean isHandicap = false;
    VehicleSize vehicleSize;

    public enum VehicleSize{
        LARGE, SMALL;
    }

    public ParkingVehicle(VehicleSize vehicleSize) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        this.localDateTime = formatDateTime;
        this.vehicleSize = vehicleSize;
    }

    public String getLocalDateTime() {
        return this.localDateTime;
    }
}
