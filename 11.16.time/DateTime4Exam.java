import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTime4Exam {
    public static void main(String[] args) {
        
        LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 9, 0, 0);
        System.out.println(startDateTime); // 2023-01-01T09:00

        LocalDateTime endDateTime = LocalDateTime.of(2024, 3, 31, 18, 0, 0);
        System.out.println(endDateTime); // 2024-03-31T18:00

        if (startDateTime.isBefore(endDateTime)) {
            System.out.println("진행 중입니다");
        } else if (startDateTime.isEqual(endDateTime)) {
            System.out.println("종료합니다");
        } else if (startDateTime.isAfter(endDateTime)) {
            System.out.println("종료했습니다");
        } // 진행 중입니다

        // 차 구하기
        System.out.println("종료까지 남은 시간");
        long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
        System.out.println("남은 해: " + remainYear); // 남은 해: 1
        long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
        System.out.println("남은 달: " + remainMonth); // 남은 달: 14
        long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
        System.out.println("남은 일: " + remainDay); // 남은 일: 455
        long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
        System.out.println("남은 시간: " + remainHour); // 남은 시간: 10929
        long remainMin = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
        System.out.println("남은 분: " + remainMin); // 남은 분: 655740
        long remainSec = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
        System.out.println("남은 초: " + remainSec); // 남은 초: 39344400

        // 차를 구하는 다른 방법
        remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
        System.out.println(remainYear); // 1
        remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
        System.out.println(remainMonth); // 14
        remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
        System.out.println(remainDay); // 455

        // Period의 between() 메서드는 매개값으로 LocalDate를 받으므로 변환
        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        System.out.println("남은 년도: " + period.getYears()); // 남은 년도: 1 (연도 차이가 맞음)
        System.out.println("남은 달: " + period.getMonths()); // 남은 달: 2 (전체 달이 아닌, 단순한 5-3=2, 달 끼리만 비교)
        System.out.println("남은 일: " + period.getDays()); // 남은 일: 30 (31-1=30로, 단순히 일 끼리만 비교)

        // Duration은 시간 정보를 담고 있는 클래스이므로 매개값을 toLocalTime으로 변환하는 게 좋음(강제x, 권장)
        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
        System.out.println("남은 시간: " + duration.toHours()); // 남은 시간: 9 (단순히 시간끼리만 계산, 18-9=9)
        System.out.println("남은 분: " + duration.toMinutes()); // 남은 분: 540 (단순히 분끼리만 계산, 9 * 60 = 540)
        System.out.println("남은 초: " + duration.getSeconds()); // 남은 초: 32400 (단순히 초끼리만 계산, 9 * 60 * 60 = 32400)

    }
}