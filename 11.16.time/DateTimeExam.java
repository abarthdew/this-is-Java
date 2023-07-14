import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class DateTimeExam {
  public static void main(String[] args) throws InterruptedException {

    // 날짜 얻기
    LocalDate currDate = LocalDate.now();
    System.out.println(currDate); // 2022-10-26

    LocalDate targetDate = LocalDate.of(2024, 5, 10);
    System.out.println(targetDate); // 2024-05-10

    // 시간 얻기
    LocalTime currTime = LocalTime.now();
    System.out.println(currTime); // 22:26:20.477

    LocalTime targetTime = LocalTime.of(6, 30, 0, 0);
    System.out.println(targetTime); // 06:30

    // 날짜와 시간 얻기
    LocalDateTime currDateTime = LocalDateTime.now();
    System.out.println(currDateTime); // 2022-10-26T22:27:47.363

    LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 40);
    System.out.println(targetDateTime); // 2024-05-10T06:40

    // 협정 세계시와 시간존(time zone)
    ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC")); // 협정 세계시
    System.out.println(utcDateTime); // 2022-10-26T13:29:51.385Z[UTC]

    // 뉴욕의 시간
    ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
    System.out.println(ny); // 2022-10-26T09:31:33.023-04:00[America/New_York]

    // 시간 존의 종류
    String[] ids = TimeZone.getAvailableIDs();
    for (String id : ids) {
      System.out.println(id);
            /*
            Africa/Abidjan
            Africa/Accra
            Africa/Addis_Ababa
            Africa/Algiers
            Africa/Asmara
            .....
             */
    }

    // 특정 시점의 타임스탬프 얻기
    Instant instant1 = Instant.now();
    Thread.sleep(10); // 잠깐 쉬기
    Instant instant2 = Instant.now();
    // 시간 비교
    if (instant1.isBefore(instant2)) {
      System.out.println("instant1 이 빠름");
    } else if (instant1.isAfter(instant2)) {
      System.out.println("instant2 이 빠름");
    } else {
      System.out.println("동일한 시간");
    }
    // instant1 이 빠름

    // instant1과 2 사이의 차이
    System.out.println("차이(nanos, 나노초): " + instant1.until(instant2, ChronoUnit.NANOS)); // 차이(nanos, 나노초): 26000000

  }
}
