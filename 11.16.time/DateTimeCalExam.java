import java.time.LocalDateTime;

public class DateTimeCalExam {
    public static void main(String[] args) {
        
        LocalDateTime now = LocalDateTime.now(); // 현재시간
        System.out.println(now); // 2022-10-27T23:07:22.177

        LocalDateTime targetDateTime = now.plusYears(1); // 1년 추가
        System.out.println(targetDateTime); // 2023-10-27T23:07:22.177

        targetDateTime = targetDateTime.plusMonths(2); // 2개월 추가
        System.out.println(targetDateTime); // 2023-12-27T23:07:22.177

        targetDateTime = targetDateTime.plusDays(3); // 3일 추가
        System.out.println(targetDateTime); // 2023-12-30T23:07:22.177

        targetDateTime = targetDateTime.plusHours(4); // 4시간 추가
        System.out.println(targetDateTime); // 2023-12-31T03:07:22.177

        targetDateTime = targetDateTime.minusMinutes(5); // 5분을 뺀다
        System.out.println(targetDateTime); // 2023-12-31T03:02:22.177

        targetDateTime = targetDateTime.plusSeconds(6); // 6초 추가
        System.out.println(targetDateTime); // 2023-12-31T03:02:28.177

        // 한번에 하기
        targetDateTime = now
            .plusYears(1)
            .plusMonths(2)
            .plusDays(3)
            .plusHours(4)
            .minusMinutes(5)
            .plusSeconds(6);
        System.out.println(targetDateTime); // 2023-12-31T03:02:28.177

    }
}
