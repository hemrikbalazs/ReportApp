package utils;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bhemrik
 */
public class Converter {

    static final DateTimeFormatter formatter;

    static {
        formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss");
    }

    public static LocalDateTime toLocalDateTime(String timestamp) {
        return LocalDateTime.parse(timestamp, formatter);
    }

    public static Duration toDuration(String time) throws SQLException {
        String[] parts = time.split(" ");
        int days = Integer.parseInt(parts[0]);
        String[] timeParts = parts[1].split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        String[] secondParts = timeParts[2].split("\\.");
        int seconds = Integer.parseInt(secondParts[0]);
        int millis = secondParts[1].length() > 0 ? Integer.parseInt(
                secondParts[1]) : 0;
        Duration duration = Duration.ofDays(days)
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds)
                .plusMillis(millis);
        return duration;
    }

    public static boolean toBoolean(int num) {
        return 0 < num;
    }

    public static int toInt(Duration hoursWorked) {
        return (int) hoursWorked.getSeconds() / 3600;
    }

}
