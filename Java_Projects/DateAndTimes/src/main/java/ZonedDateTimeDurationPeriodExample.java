import java.time.*;

public class ZonedDateTimeDurationPeriodExample {
    public static void main(String[] args) {
        ZonedDateTime overseasTime = ZonedDateTime.of(2023, 11, 21, 10, 0,0,0, ZoneId.of("Asia/Tokyo"));
        System.out.println(overseasTime);

        LocalTime start = LocalTime.of(9,0);
        LocalTime end = LocalTime.of(17,0);
        Duration duration = Duration.between(start, end);
        System.out.println(duration);

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023,12,31);
        Period period = Period.between(startDate, endDate);
        System.out.println(period);
    }
    }
