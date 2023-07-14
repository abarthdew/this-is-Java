import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExam {
  private static List<Student146> list = Arrays.asList(
    new Student146("홍길동1", "여자", 95),
    new Student146("홍길동2", "여자", 96),
    new Student146("홍길동3", "남자", 82),
    new Student146("홍길동4", "남자", 83)
  );

  public static double avg(Predicate<Student146> predicate) { // 조건별 평균 구하기
    int count = 0, sum = 0;
    for (Student146 student : list) {
      if (predicate.test(student)) {
        count++;
        sum += student.getScore();
      }
    }
    return (double) sum / count;
  }

  public static void main(String[] args) {

    // 여자 평균 점수
    double avg1 = avg(t -> t.getSex().equals("여자"));
    System.out.println(avg1); // 95.5

    // 남자 평균 점수
    double avg2 = avg(t -> t.getSex().equals("남자"));
    System.out.println(avg2); // 82.5

  }
}
