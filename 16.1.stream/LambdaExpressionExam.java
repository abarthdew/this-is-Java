import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionExam {
  public static void main(String[] args) {

    List<Student161> list = Arrays.asList(
      new Student161("홍길동", 90),
      new Student161("2222", 92)
    );
    Stream<Student161> str = list.stream();
    str.forEach(s -> {
      String name = s.getName();
      int score = s.getScore();
      System.out.println(name + "-" + score);
            /*
            홍길동-90
            2222-92
            */
    });

  }
}
