import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayExam {
  public static void main(String[] args) {

    String[] strArray = {"홍길동1", "홍길동2", "홍길동3"};
    Stream<String> strStream = Arrays.stream(strArray);
    strStream.forEach(a -> System.out.print(a + ",")); // 홍길동1,홍길동2,홍길동3,

    int[] intArray = {1, 2, 3, 4, 5};
    IntStream intStream = Arrays.stream(intArray);
    intStream.forEach(i -> System.out.print(i + ",")); // 1,2,3,4,5,

  }
}
