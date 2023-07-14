import java.util.Arrays;
import java.util.List;

public class ReductionExam {
  public static void main(String[] args) {

    List<Student166> stdList = Arrays.asList(
      new Student166("홍길동1", 92),
      new Student166("홍길동2", 95),
      new Student166("홍길동3", 88)
    );
    int sum1 = stdList.stream() // 오리지널 스트림
      .mapToInt(Student166::getScore) // 점수로 매핑
      .sum(); // 전체 합

    int sum2 = stdList.stream()
      .mapToInt(Student166::getScore)
      .reduce((a, b) -> a + b) // 점수 2개를 매개값으로 받아 합(모든 점수 요소를 더함)
      .getAsInt();

    int sum3 = stdList.stream()
      .mapToInt(Student166::getScore)
      .reduce(0, (a, b) -> a + b); // 결과값이 없을 경우 0

    System.out.println(sum1); // 275
    System.out.println(sum2); // 275
    System.out.println(sum3); // 275

  }
}
