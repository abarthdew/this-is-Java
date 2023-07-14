import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionExam {
  public static void main(String[] args) {

    List<Student162> studentList = Arrays.asList(
      new Student162("홍길동1", 10),
      new Student162("홍길동2", 20),
      new Student162("홍길동3", 30)
    );
    Stream<Student162> stream = studentList.stream();
    stream.forEach(s -> System.out.println(s.getName()));
        /*
        홍길동1
        홍길동2
        홍길동3
         */
  }
}
