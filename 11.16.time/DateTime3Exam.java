import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateTime3Exam {
  public static void main(String[] args) {

    LocalDateTime now = LocalDateTime.now();
    System.out.println(now); // 2022-10-28T23:37:55.769

    // 직접 변경
    LocalDateTime targetDateTime = now.withYear(2024);
    targetDateTime = targetDateTime.withMonth(12);
    System.out.println(targetDateTime); // 2024-12-28T23:37:55.769

    targetDateTime = now
      .withYear(2024)
      .withMonth(12)
      .withDayOfMonth(5)
      .withHour(13)
      .withMinute(30)
      .withSecond(20);
    System.out.println(targetDateTime); // 2024-12-05T13:30:20.769

    // 상대 변경
    targetDateTime = now.with(TemporalAdjusters.firstDayOfYear()); // 올해의 첫 일
    // firstDayOfYear() 메서드의 리턴 타입은 TemporalAdjuster -> 올해의 첫 일을 리턴
    // ㄴ 이 객체를 with에 매개변수로 넣어 줌
    System.out.println(targetDateTime); // 2022-01-01T23:37:55.769

    targetDateTime = now.with(TemporalAdjusters.lastDayOfYear()); // 올해의 마지막 일
    System.out.println(targetDateTime); // 2022-12-31T23:38:58.379

    targetDateTime = now.with(TemporalAdjusters.firstDayOfNextYear()); // 다음 해의 첫 일
    System.out.println(targetDateTime); // 2023-01-01T23:42:14.473

    targetDateTime = now.with(TemporalAdjusters.firstDayOfMonth()); // 이번 달의 첫 일
    System.out.println(targetDateTime); // 2022-10-01T23:42:46.432

    targetDateTime = now.with(TemporalAdjusters.lastDayOfMonth()); // 이번 달의 마지막 일
    System.out.println(targetDateTime); // 2022-10-31T23:43:12.280

    targetDateTime = now.with(TemporalAdjusters.firstDayOfNextMonth()); // 다음 달의 첫 일
    System.out.println(targetDateTime); // 2022-11-01T23:45:09.405

    targetDateTime = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 이번 달의 첫 월요일
    System.out.println(targetDateTime); // 2022-10-03T23:45:09.405

    targetDateTime = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 현재 기준 다음 월요일
    System.out.println(targetDateTime); // 2022-10-31T23:45:09.405

    targetDateTime = now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)); // 현재 기준 지난 월요일
    System.out.println(targetDateTime); // 2022-10-24T23:45:09.405

  }
}