import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CollectionExam {
    public static void main(String[] args) {
        
        List<Student161> studentList = Arrays.asList(
            new Student161("홍길동1", 10),
            new Student161("홍길동2", 20),
            new Student161("홍길동3", 30)
        );
        Stream<Student161> stream = studentList.stream();
        stream.forEach(s -> System.out.println(s.getName()));
        /*
        홍길동1
        홍길동2
        홍길동3
         */
    }
}
