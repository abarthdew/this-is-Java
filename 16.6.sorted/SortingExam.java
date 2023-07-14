import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExam {
  public static void main(String[] args) {

    // 올림차순 정렬
    IntStream intStream = Arrays.stream(new int[]{5, 3, 2, 1, 4});
    intStream
      .sorted()
      .forEach(n -> System.out.print(n + ",")); // 1,2,3,4,5,

    System.out.println();

    List<Student166> studentList = Arrays.asList(
      new Student166("홍길동1", 30),
      new Student166("홍길동2", 10),
      new Student166("홍길동3", 20)
    );
    studentList.stream()
      .sorted()
      .forEach(s -> System.out.print(s.getScore() + ",")); // 10,20,30,

    System.out.println();

    // 내림차순 정렬
    studentList.stream()
      .sorted(Comparator.reverseOrder())
      .forEach(s -> System.out.print(s.getScore() + ",")); // 30,20,10,

    System.out.println();
  }
}