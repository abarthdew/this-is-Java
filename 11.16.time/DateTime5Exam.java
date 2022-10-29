import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime5Exam {
    public static void main(String[] args) {

        DateTimeFormatter formatter;
        LocalDate localDate;
        
        // 1. parse: 문자열 -> 날짜, 시간
        localDate = LocalDate.parse("2024-05-21");
        System.out.println(localDate); // 2024-05-21
        
        // localDate = LocalDate.parse("2024*05*21");
        // System.out.println(localDate); // 예외 발생: 일반적인 형식일 경우에만 가능
        // Exception in thread "main" java.time.format.DateTimeParseException: Text '2024*05*21' could not be parsed at index 4

        formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        localDate = LocalDate.parse("2024-05-21", formatter);
        System.out.println(localDate); // 2024-05-21
        
        formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        localDate = LocalDate.parse("2024/05/21", formatter);
        System.out.println(localDate); // 2024-05-21
        
        formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        localDate = LocalDate.parse("2024.05.21", formatter);
        System.out.println(localDate); // 2024-05-21

        // 2. format: 날짜, 시간 -> 문자열
        formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formatTime = localDate.format(formatter);
        System.out.println(formatTime); // 20240521
        
        formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        formatTime = LocalDateTime.now().format(formatter);
        System.out.println(formatTime); // 2022년 10월 29일 오후 8시 7분

    }
}
