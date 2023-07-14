import java.util.Date;

public class PrintfExam {
  public static void main(String[] args) {

    // 형식화된 문자열 + 값

    // %d: 정수
    System.out.printf("상품의 가격:%d원\n", 123); // 상품의 가격:123원
    // %6d: 자리 수 + 정수
    System.out.printf("상품의 가격:%6d원\n", 123); // 상품의 가격:   123원
    System.out.printf("상품의 가격:%-6d원\n", 123); // 상품의 가격:123   원
    System.out.printf("상품의 가격:%06d원\n", 123); // 상품의 가격:000123원

    // %10.2f: 전제 자리 수 10, 소수점 2, 실수 f
    System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, Math.PI * 10 * 10); // 반지름이 10인 원의 넓이:    314.16
    // %-10s: 10자리 확보 + 문자열 표시 s
    System.out.printf("%6d | %-10s | %10s\n", 1, "홍길동", "도적"); //      1 | 홍길동        |         도적

    Date now = new Date();
    // %tY: 연도, %tm: 월, %td: 일
    System.out.printf("오늘은 %tY년 %tm월 %td일 입니다\n", now, now, now); // 오늘은 2023년 05월 08일 입니다
    // %1$tY, %1$tm, %1$td: 첫번째 매개값의 순번 + 연월일
    System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 입니다\n", now); // 오늘은 2023년 05월 08일 입니다
    System.out.printf("현재 %1$tH시 %1$tM분 %1$tS초 입니다\n", now); // 현재 21시 26분 05초 입니다

  }
}
