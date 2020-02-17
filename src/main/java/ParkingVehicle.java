import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingVehicle {
    private String localDateTime;
    public boolean isHandicap = false;

    public ParkingVehicle() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        this.localDateTime = formatDateTime;
    }

    public String getLocalDateTime() {
        return this.localDateTime;
    }
}
