import java.time.*;

public class DateTime2Exam {
  public static void main(String[] args) {

    LocalDateTime now = LocalDateTime.now();
    System.out.println(now); // 2022-10-27T22:56:05.541

    String dateTime = now.getYear() + "년 ";
    dateTime += now.getMonthValue() + "월 ";
    dateTime += now.getDayOfMonth() + "일 ";
    dateTime += now.getDayOfWeek() + " ";
    dateTime += now.getHour() + "시 ";
    dateTime += now.getMinute() + "분 ";
    dateTime += now.getSecond() + "초 ";
    dateTime += now.getNano() + "나노초";
    System.out.println(dateTime); // 2022년 10월 27일 THURSDAY 22시 56분 5초 541000000나노초

    String dateTime2 = now.getYear() + "년 ";
    dateTime2 += now.getMonthValue() + "월 ";
    dateTime2 += now.getDayOfMonth() + "일 ";
    DayOfWeek dow = now.getDayOfWeek();
    if (dow == DayOfWeek.MONDAY) {
      dateTime2 += "월요일 ";
    } else if (dow == DayOfWeek.THURSDAY) {
      dateTime2 += "목요일 ";
    }
    dateTime2 += now.getHour() + "시 ";
    dateTime2 += now.getMinute() + "분 ";
    dateTime2 += now.getSecond() + "초 ";
    dateTime2 += now.getNano() + "나노초";
    System.out.println(dateTime2); // 2022년 10월 27일 목요일 22시 56분 5초 541000000나노초

    // 윤년 여부 확인
    LocalDate nowDate = now.toLocalDate();
    if (nowDate.isLeapYear()) {
      System.out.println("올해는 윤년: 2월은 29일 까지");
    } else {
      System.out.println("올해는 평년: 2월은 28일 까지");
    } // 올해는 평년: 2월은 28일 까지

    // zoned
    ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
    System.out.println("협정 세계시: " + utcDateTime); // 협정 세계시: 2022-10-27T13:56:05.549Z[UTC]

    ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    System.out.println("서울 타임존: " + seoulDateTime); // 서울 타임존: 2022-10-27T22:59:16.201+09:00[Asia/Seoul]

    ZoneId seoulZoneId = seoulDateTime.getZone();
    System.out.println("서울 존 아이디: " + seoulZoneId); // 서울 존 아이디: Asia/Seoul

    ZoneOffset seoulZoneOffSet = seoulDateTime.getOffset();
    System.out.println("서울 존 오프셋: " + seoulZoneOffSet); // 서울 존 오프셋: +09:00

  }
}