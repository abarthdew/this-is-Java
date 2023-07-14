import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;

public class OptionalExam {
  public static void main(String[] args) {

    // 집계 시 빈 객체 처리

    List<Integer> list = new ArrayList<>(); // 빈 객체

    try {

      double avg = list.stream()
        .mapToInt(Integer::intValue)
        .average()
        .getAsDouble(); // 빈 값에 대한 평균을 구하면 예외 발생
      // Exception in thread "main" java.util.NoSuchElementException: No value present

    } catch (NoSuchElementException e) {
    }

    // 첫번째 방법
    OptionalDouble op = list.stream()
      .mapToInt(Integer::intValue)
      .average(); // 여기까지 리턴값을 OptionalDouble 타입으로 직접 받음
    // Optional 객체에 값이 있는지 검사
    if (op.isPresent()) {
      System.out.println(op.getAsDouble());
    } else {
      System.out.println("0.0");
    }
    // 0.0

    // 두번째 방법
    double avg2 = list.stream()
      .mapToInt(Integer::intValue)
      .average()
      .orElse(0.0);
    System.out.println(avg2); // 0.0

    // 세번째 방법
    list.stream()
      .mapToInt(Integer::intValue)
      .average() // 여기까지 결과값이 없으면
      .ifPresent(a -> System.out.println(a)); // 출력내용 없음
    // ifPresent()는 false로, ()안 내용을 실행하지 않고 끝남

    // 세번째 방법 - 값이 있을 경우 출력
    list.add(2);
    list.add(4);
    list.stream()
      .mapToInt(Integer::intValue)
      .average()
      .ifPresent(a -> System.out.println(a)); // 2, 4의 평균 = 3.0
  }
}
